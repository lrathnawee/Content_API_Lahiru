package pageobjects.contentapi.contentcontroller

import io.gatling.core.Predef._
import io.gatling.http.Predef._

object DeleteAssociateMediaToContentMap {
  val headers = Map(
    "Content-Type" -> "application/json",
    "X-WPP-AUTH-TOKEN" -> "${ctoken}",
    "contentMap1" -> "${contentMap1}",
    "mediaAtomID1" -> "${mediaAtomID1}"
  )

    def deleteAssociateMediaToContentMap = {
      exec(http("05 CPUB Delete Associate Media to Content Map")
        .delete("http://dcm-content-api-perf.aws.wiley.com:8080/api/v1/contentMaps/${contentMap1}/hasMedia/${mediaAtomID1}")
        .headers(headers)
        .check(status.is(204))
      )
    }
}
