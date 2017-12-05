package controllers

import javax.inject.Inject

import play.api.mvc._
import play.api.libs.json._

import services._

/**
  * A very small controller that renders a home page.
  */
class LoginController @Inject()(cc: ControllerComponents, userService: UserService) extends AbstractController(cc) {

  def signin(username: String) = Action {
     var user = userService.findByUsername(username)
     val json = Json.toJson(user)
     Ok(json)
    }.getOrElse(NotFound)
}