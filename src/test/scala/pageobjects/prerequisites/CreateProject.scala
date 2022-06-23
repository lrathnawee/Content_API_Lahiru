package pageobjects.prerequisites

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import scala.util.Random

object CreateProject {
  val headers = Map(
    "Content-Type" -> "application/json",
    "X-WPP-AUTH-TOKEN" -> "${ctoken}"
  )

  val feeder = Iterator.continually(Map{
    "randNum4" -> (Random.between(1000,9000).toString)
  })

  def createProject ={
    feed(feeder)
      .exec(http("00 Create Project")
        .post("http://ctpm-product-api-perf.aws.wiley.com:8080/v1/products")
        .body(ElFileBody("src/test/resources/json/createProject.json"))
        .headers(headers)
        .check(status.is(201))

      )
  }

}
