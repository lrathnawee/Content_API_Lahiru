package pageobjects.contentapi.atom

import io.gatling.core.Predef._
import io.gatling.http.Predef._

object CreateNarrativeAtom { //without content

  val headers = Map (
    "Content-Type" -> "application/json",
    "Accept" -> "*/*",
    "X-WPP-AUTH-TOKEN" -> "${ctoken}"
  )

  def createNarrativeAtom ={
    exec(http("CPUB-R4-1 02 CPUB Create NarrativeAtom (without content)")
      .post("http://dcm-content-api-perf.aws.wiley.com:8080/api/v1/contents")
      .body(ElFileBody("src/test/resources/json/createNarrativeAtom.json")).asJson
      .check(jsonPath("$.id").find.saveAs("narrativeAtomID1"))
      .headers(headers)
//      .check(status.is(201))
    )
  }

}
