package commons;

import java.sql.Connection;
import java.sql.SQLException;

import javax.inject.Singleton;
import javax.inject.Inject;

import play.db.Database;

@Singleton
public class ConnectionFactory {


    @Inject
    public static Connection getConnection(Database db){
        return db.getConnection();
    }
}