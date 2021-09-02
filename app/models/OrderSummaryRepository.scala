package models

import play.api.db.slick.DatabaseConfigProvider
import slick.driver.JdbcProfile

import java.util.Date
import javax.inject.{Inject, Singleton}
import scala.concurrent.{ExecutionContext, Future}

@Singleton
class OrderSummaryRepository @Inject() (dbConfigProvider: DatabaseConfigProvider)(implicit ec: ExecutionContext) {
  val dbConfig = dbConfigProvider.get[JdbcProfile]

  import dbConfig._
  import profile.api._

  implicit val JavaUtilDateMapper =
    MappedColumnType .base[java.util.Date, java.sql.Timestamp] (
      d => new java.sql.Timestamp(d.getTime),
      d => new java.util.Date(d.getTime))

  class OrderSummaryTable(tag: Tag) extends Table[OrderSummary](tag, "orderSummary") {
    def id = column[Long]("id", O.PrimaryKey, O.AutoInc)
    def userId = column[Long]("userId")
    def createdAt = column[Date]("createdAt")
    def price = column[Double]("price")
    def * = (id, userId, createdAt, price) <> ((OrderSummary.apply _).tupled, OrderSummary.unapply)
  }

  val cart = TableQuery[OrderSummaryTable]

  def getByUserId(userid: Long): Future[Seq[OrderSummary]] = db.run {
    cart.filter(_.userId === userid).result
  }

  def create(userId: Long, createdAt: Date, price: Double): Future[OrderSummary] = db.run {
    (cart.map(el => (el.userId, el.createdAt, el.price))
      returning cart.map(_.id)
      into {case ((userId, createdAt, price),id) => OrderSummary(id, userId, createdAt, price)}
      ) += (userId, createdAt, price)
  }

}
