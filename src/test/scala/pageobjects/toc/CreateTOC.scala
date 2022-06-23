package pageobjects.toc

import io.gatling.core.Predef._
import io.gatling.http.Predef._

object CreateTOC {

  val headers = Map(
    "Content-Type" -> "application/json",
    "Accept" -> "*/*",
    "eduID" -> "eduID",
    "X-WPP-AUTH-TOKEN" -> "${token}"
  )

  def createTOC = {
    exec(http("01 Create TOC CPUB")
      .post("http://dcm-content-api-perf.aws.wiley.com:8080/api/v1/contents")
      .body(ElFileBody("src/test/resources/json/createTOC.json")).asJson
      .headers(headers)
      .check(status.is(201))
      .check(jsonPath("$.id").find.saveAs("toc_id"))
    )
  }
}
