package models

import play.api.libs.json.Json

import java.util.Date

case class OrderSummary(id: Long, userId: Long, createdAt: Date, price: Double)

object OrderSummary {
  implicit val orderSummaryFormat = Json.format[OrderSummary]
}