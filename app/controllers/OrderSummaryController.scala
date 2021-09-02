package controllers

import models.OrderSummaryRepository
import play.api.libs.json.{JsValue, Json}
import play.api.mvc.{Action, MessagesAbstractController, MessagesControllerComponents}

import java.util.Date
import javax.inject.{Inject, Singleton}
import scala.concurrent.{ExecutionContext, Future}

case class CreateOrderSummaryForm(userId: Long, price: Double)
object CreateOrderSummaryForm {
  implicit val createCreateCartFormat = Json.format[CreateOrderSummaryForm]
}

@Singleton
class OrderSummaryController @Inject()(repo: OrderSummaryRepository, cc: MessagesControllerComponents)(implicit ec: ExecutionContext) extends MessagesAbstractController(cc) {

  def addOrder: Action[JsValue] = Action.async(parse.json) { implicit request =>
    request.body.validate[CreateOrderSummaryForm].map {
      c =>
        repo.create(c.userId, new Date(), c.price).map { res =>
          Ok(Json.toJson(res))
        }
    }.getOrElse(Future.successful(BadRequest("incorrect data")))
  }

  def getOrders(userId: Long) = Action.async {
    val cart = repo.getByUserId(userId)
    cart.map { seq =>
      Ok(Json.toJson(seq))
    }
  }

}
