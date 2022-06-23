package pageobjects.cpub.interactivity

import io.gatling.core.Predef._
import io.gatling.http.Predef._

object Testdata { //without content

  val headers = Map (
    "Content-Type" -> "application/json",
    "Accept" -> "*/*",
    "X-WPP-AUTH-TOKEN" -> "${ctoken}"
  )

  def createmediaatom ={
    exec(http("02 CPUB Create Content")
      .post("/api/v1/contents")
      .header("x-dynaTrace", "NA=02 CPUB Create Content;")
      .body(ElFileBody("src/test/resources/json/cpub/interactivity/MediaContentMap.json")).asJson
      .check(jsonPath("$.id").find.saveAs("cpub_contentId"))
      .headers(headers)
    )
  }
  def createcontentmap ={
    exec(http("02 CPUB Create ContentMap")
      .post("/api/v1/contents")
      .header("x-dynaTrace", "NA=02 CPUB Create ContentMap;")
      .body(ElFileBody("src/test/resources/json/cpub/interactivity/contentMap.json")).asJson
      .check(jsonPath("$.id").find.saveAs("cpub_contentId"))
      .headers(headers)
    )
  }
}
