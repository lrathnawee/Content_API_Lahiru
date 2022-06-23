package pageobjects.contentapi.contentcontroller

import io.gatling.core.Predef._
import io.gatling.http.Predef._

object CreateAnotherContentMap {

  val headers = Map(
    "Content-Type" -> "application/json",
    "Accept" -> "*/*",
    "X-WPP-AUTH-TOKEN" -> "${token}"
  )

  def createAnotherContentMap = {
    exec(http("02 Create Another Content Map CPUB")
      .post("http://dcm-content-api-perf.aws.wiley.com:8080/api/v1/contents")
      .body(ElFileBody("src/test/resources/json/createContentMap.json")).asJson
      .headers(headers)
      .check(jsonPath("$.id").find.saveAs("contentMap"))
    )
  }
}
