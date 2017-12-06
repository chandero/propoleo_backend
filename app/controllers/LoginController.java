package controllers;

import play.mvc.*;
import play.libs.Json;

public class LoginController extends Controller {

    public Result identify(String username){
        return ok();
    }

    public Result validate(String username, String password){
        return ok();
    }

}