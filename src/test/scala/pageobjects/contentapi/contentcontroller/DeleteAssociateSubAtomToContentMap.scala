package pageobjects.contentapi.contentcontroller

import io.gatling.core.Predef._
import io.gatling.http.Predef._

object DeleteAssociateSubAtomToContentMap {

  val headers = Map(
    "Content-Type" -> "application/json",
    "X-WPP-AUTH-TOKEN" -> "${ctoken}",
    "contentMap1" -> "${contentMap1}",
    "narrativeAtomID1" -> "${narrativeAtomID1}"
  )

  def deleteAssociateSubAtomToContentMap = {
    exec(http("05 CPUB Delete Associate SubAtom to Content Map")
      .delete("http://dcm-content-api-perf.aws.wiley.com:8080/api/v1/contentMaps/${contentMap1}/hasSubAtom/${narrativeAtomID1}")
      .headers(headers)
      .check(status.is(204))
    )
  }
}
