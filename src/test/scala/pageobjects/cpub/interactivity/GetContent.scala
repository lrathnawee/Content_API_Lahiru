package pageobjects.cpub.interactivity

import io.gatling.core.Predef._
import io.gatling.http.Predef._
object GetContent {

  val headers = Map (
    "Content-Type" -> "application/json",
    "Accept" -> "*/*",
    "X-WPP-AUTH-TOKEN" -> "${token}"
  )

  def cpubmediaatom0_10mb = {
      exec(http("T01 Get interactivityContents- 0Mb - 10 Mb")
        .get("/api/v1/contents/${interactivityID}")
        .headers(headers)
        .header("x-dynaTrace", "NA=T01 Get interactivityContents- 0Mb - 10 Mb;")
        .check(status.is(200))
      )
  }

  def cpubmediaatom10_100mb = {
    exec(http("T02 Get interactivityContents- 10Mb - 100Mb")
      .get("/api/v1/contents/${interactivityID}")
      .headers(headers)
      .header("x-dynaTrace", "NA=T02 Get interactivityContents- 10Mb - 100Mb;")
      .check(status.is(200))
    )
  }

  def cpubmediaatom100_300mb = {
    exec(http("T03 Get interactivityContents- 100Mb - 300Mb")
      .get("/api/v1/contents/${interactivityID}")
      .headers(headers)
      .header("x-dynaTrace", "NA=T03 Get interactivityContents- 100Mb - 300Mb;")
      .check(status.is(200))
    )
  }

}
