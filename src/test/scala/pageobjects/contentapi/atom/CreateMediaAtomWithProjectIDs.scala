package pageobjects.contentapi.atom

import io.gatling.core.Predef._
import io.gatling.http.Predef._

object CreateMediaAtomWithProjectIDs { //without content

  val headers = Map(
    "Accept" -> "*/*",
    "Content-Type" -> "application/json",
    "X-WPP-AUTH-TOKEN" -> "${token}"
  )

  def createMediaAtomWithProjectIDs ={
    exec(http("CPUB-R4-1 02 CPUB Create MediaAtom with project ids (without content)")
      .post("http://dcm-content-api-perf.aws.wiley.com:8080/api/v1/contents")
      .body(ElFileBody("src/test/resources/json/createMediaAtomWithProjectIds.json")).asJson
      .headers(headers)
      .check(status.is(201))
      .check(jsonPath("$.id").find.saveAs("mediaAtomID1"))
    )
  }

}