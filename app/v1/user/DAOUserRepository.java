package v1.user;

import net.jodah.failsafe.CircuitBreaker;
import net.jodah.failsafe.Failsafe;
import javax.inject.Inject;
import javax.inject.Singleton;

import play.db.Database;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;
import java.util.concurrent.CompletionStage;
import java.util.stream.Stream;
import java.util.ArrayList;

import static java.util.concurrent.CompletableFuture.supplyAsync;

import commons.ConnectionFactory;

@Singleton
public class DAOUserRepository implements UserRepository {

    private final UserExecutionContext ec;
    private final CircuitBreaker circuitBreaker = new CircuitBreaker().withFailureThreshold(1).withSuccessThreshold(3);
    private final Connection conn;

    @Inject
    public DAOUserRepository(UserExecutionContext ec, Database db) {
        this.ec = ec;
        this.conn = db.getConnection();
    }    

    @Override
    public CompletionStage<Stream<UserData>> list() {
        return supplyAsync(() -> select(), ec);
    }    

    @Override
    public CompletionStage<UserData> create(UserData userData) {
        return supplyAsync(() -> insert(userData), ec);
    }

    @Override
    public CompletionStage<Optional<UserData>> find(String username){
        return supplyAsync(() -> Failsafe.with(circuitBreaker).get(() -> lookup(username)), ec);
    }

    @Override
    public CompletionStage<Optional<UserData>> update(Long id, UserData userData){
        return supplyAsync(() -> Failsafe.with(circuitBreaker).get(() -> modify(id, userData)), ec);
    }    

    @Override
    public CompletionStage<Optional<UserData>> get(Long id) {
        return supplyAsync(() -> Failsafe.with(circuitBreaker).get(() -> lookup(id)), ec);
    }

    private Stream<UserData> select(){
        return new ArrayList<UserData>().stream();
    }

    private Optional<UserData> lookup(Long id){
        return Optional.ofNullable(new UserData());
    }

    private Optional<UserData> lookup(String username){
        UserData u = new UserData();
        try {
            PreparedStatement stmt = this.conn.prepareStatement("SELECT * FROM \"gen$empleado\" e WHERE e.ID_EMPLEADO = ?");
            stmt.setString(1, username);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()){
                u.setIdEmpleado(rs.getString("ID_EMPLEADO"));
            }

        } catch (SQLException e){
            e.printStackTrace();
        }
        return Optional.ofNullable(u);
    }

    private Optional<UserData> modify(Long id, UserData userData) throws InterruptedException {
        final UserData data = userData;
        return Optional.ofNullable(data);
    }

    private UserData insert(UserData userData) {
        return userData;
    }    

}