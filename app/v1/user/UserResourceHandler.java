package v1.user;

import com.palominolabs.http.url.UrlBuilder;
import play.libs.concurrent.HttpExecutionContext;
import play.mvc.Http;

import javax.inject.Inject;
import java.nio.charset.CharacterCodingException;
import java.util.Optional;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Stream;

/**
 * Handles presentation of User resources, which map to JSON.
 */
public class UserResourceHandler {

    private final UserRepository repository;
    private final HttpExecutionContext ec;

    @Inject
    public UserResourceHandler(UserRepository repository, HttpExecutionContext ec) {
        this.repository = repository;
        this.ec = ec;
    }

    public CompletionStage<Stream<UserResource>> find() {
        return repository.list().thenApplyAsync(userDataStream -> {
            return userDataStream.map(data -> new UserResource(data));
        }, ec.current());
    }

    public CompletionStage<Optional<UserResource>> find(String username) {
        return repository.find(username).thenApplyAsync(optionalData -> {
            return optionalData.map(op -> new UserResource(op));
        }, ec.current());
    }

    public CompletionStage<UserResource> create(UserResource resource) {
        final UserData data = new UserData();
        return repository.create(data).thenApplyAsync(savedData -> {
            return new UserResource(savedData);
        }, ec.current());
    }

    public CompletionStage<Optional<UserResource>> lookup(String id) {
        return repository.get(Long.parseLong(id)).thenApplyAsync(optionalData -> {
            return optionalData.map(data -> new UserResource(data));
        }, ec.current());
    }

    public CompletionStage<Optional<UserResource>> update(String id, UserResource resource) {
        final UserData data = new UserData();
        return repository.update(Long.parseLong(id), data).thenApplyAsync(optionalData -> {
            return optionalData.map(op -> new UserResource(op));
        }, ec.current());
    }

    private String link(UserData data) {
        // Make a point of using request context here, even if it's a bit strange
        final Http.Request request = Http.Context.current().request();
        final String[] hostPort = request.host().split(":");
        String host = hostPort[0];
        int port = (hostPort.length == 2) ? Integer.parseInt(hostPort[1]) : -1;
        final String scheme = request.secure() ? "https" : "http";
        try {
            return UrlBuilder.forHost(scheme, host, port)
                    .pathSegments("v1", "users", data.getIdEmpleado())
                    .toUrlString();
        } catch (CharacterCodingException e) {
            throw new IllegalStateException(e);
        }
    }
}
