package v1.user;

import com.fasterxml.jackson.databind.JsonNode;
import play.libs.Json;
import play.libs.concurrent.HttpExecutionContext;
import play.mvc.*;

import javax.inject.Inject;
import java.util.List;
import java.util.concurrent.CompletionStage;
import java.util.stream.Collectors;


@With(UserAction.class)

public class UserController extends Controller {
    private HttpExecutionContext ec;
    private UserResourceHandler handler;

    @Inject
    public UserController(HttpExecutionContext ec, UserResourceHandler handler) {
        this.ec = ec;
        this.handler = handler;
    }

    public CompletionStage<Result> list() {
        return handler.find().thenApplyAsync(users -> {
            final List<UserResource> userList = users.collect(Collectors.toList());
            return ok(Json.toJson(userList));
        }, ec.current());
    }

    public CompletionStage<Result> identify(String username){
        return handler.find(username).thenApplyAsync(optionalResource -> {
            return optionalResource.map(r ->
                ok(Json.toJson(r))
            ).orElseGet(() ->
                notFound()
            );
        }, ec.current());
    }

    public Result validate(String username, String password){
        return ok();
    }    
    
}