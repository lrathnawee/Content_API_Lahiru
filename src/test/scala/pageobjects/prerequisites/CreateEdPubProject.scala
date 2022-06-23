package pageobjects.prerequisites

import io.gatling.core.Predef._
import io.gatling.http.Predef._

import scala.util.Random

object CreateEdPubProject {

  val headers = Map(
    "Content-Type" -> "application/json",
    "X-WPP-AUTH-TOKEN" -> "${ctoken}"
  )

  val feeder = Iterator.continually(Map {
    "randNum4" -> (Random.between(1000, 9000).toString)
  })

  def createEcPubProject = {
    feed(feeder)
      .exec(http("06 Create EdPUB Project")
        .post("http://cpub-integration-service-perf.aws.wiley.com:8080/api/v1/project")
        .body(ElFileBody("src/test/resources/json/createEdPubProject.json"))
        .headers(headers)
        .check(jsonPath("$.id").find.saveAs("eduID"))
        .check(status.is(201))
      )
  }
}
