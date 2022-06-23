package pageobjects.contentapi.contentcontroller

import io.gatling.core.Predef._
import io.gatling.http.Predef._

object DeleteAssociateContentMapToTOC {
  val headers = Map(
    "Content-Type" -> "application/json",
    "X-WPP-AUTH-TOKEN" -> "${token}",
    "contentMap1" -> "${contentMap1}",
    "toc_id" -> "${toc_id}"
  )

  def deleteAssociateContentMapToTOC={
    exec(http("05 CPUB Delete Associate ContentMap to TOC")
      .delete("http://dcm-content-api-perf.aws.wiley.com:8080/api/v1/contentMaps/${toc_id}/hasPart/${contentMap1}")
      .headers(headers)
      .check(status.is(200))
    )
  }
}
