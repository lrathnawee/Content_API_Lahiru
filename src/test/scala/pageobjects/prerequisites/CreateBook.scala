package pageobjects.prerequisites

import io.gatling.core.Predef._
import io.gatling.http.Predef._

import scala.util.Random

object CreateBook {

  val headers = Map(
    "Content-Type" -> "application/json",
    "X-WPP-AUTH-TOKEN" -> "${ctoken}"
  )

  val feeder = Iterator.continually(Map {
    "isbn" -> ("1" + Random.between(100000, 900000).toString + Random.between(100000, 900000).toString)
    //random isbn number
  })

  def createBook = {
    feed(feeder)
      .exec(http("00 Create Book")
        .post("http://ctpm-product-api-perf.aws.wiley.com:8080/v1/products")
        .body(ElFileBody("src/test/resources/json/createBook.json")).asJson
        .headers(headers)
        .check(jsonPath("$.id").find.saveAs("bookid1"))
        .check(jsonPath("$.isbn").find.saveAs("isbn")) //isbn that comes through with response body
      )
  }
}
