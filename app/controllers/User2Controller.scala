package controllers

import com.mohiva.play.silhouette.api.LoginInfo
import models.{User, User2}
import models.repository.UserRepository
import play.api.libs.json.{JsValue, Json}
import play.api.mvc.{Action, MessagesAbstractController, MessagesControllerComponents}

import javax.inject.Inject
import scala.concurrent.{ExecutionContext, Future}

class User2Controller @Inject()(userRepo: UserRepository, cc: MessagesControllerComponents)(implicit ec: ExecutionContext) extends MessagesAbstractController(cc) {

  def getUsersOauth(loginInfo: LoginInfo) = Action.async {
    val user = userRepo.retrieve(loginInfo)
    user.map { seq =>
      Ok(Json.toJson(seq))
    }
  }

  def getUserByEmail(email: String) = Action.async {
    val user = userRepo.getByEmail(email)
    user.map { seq =>
      Ok(Json.toJson(seq))
    }
  }

  def updateUserJson: Action[JsValue] = Action.async(parse.json) { request =>

    request.body.validate[User2].map {
      user =>
        userRepo.updateJson(user.id, User2(user.id, user.loginInfo, user.email, user.role, user.firstName, user.lastName)).map { res =>
          Ok(Json.toJson(res))
        }
    }.getOrElse(Future.successful(BadRequest("incorrect data")))
  }

}
