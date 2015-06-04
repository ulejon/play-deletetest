package controllers

import play.api._
import play.api.mvc._

class Application extends Controller {

  def index = Action {
    Ok(views.html.index("Your new application is ready."))
  }

  def delete = Action { implicit request =>
    request.body.asJson.fold {
        Logger.warn("No json body found!")
        NotFound("No json body found!")
    } { json =>
        val someProp = (json \ "someprop").as[String]
        Ok(s"Prop is: $someProp")
    }
  }

}
