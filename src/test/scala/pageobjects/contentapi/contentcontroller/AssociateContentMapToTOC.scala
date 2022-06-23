package pageobjects.contentapi.contentcontroller

import io.gatling.core.Predef._
import io.gatling.http.Predef._

object AssociateContentMapToTOC {

  val headers = Map(
    "Content-Type" -> "application/json",
    "X-WPP-AUTH-TOKEN" -> "${token}",
    "contentMap1" -> "${contentMap1}",
    "toc_id" -> "${toc_id}"
  )

  def associateContentMapToTOC = {
    exec(http("04 Associate Content Map to TOC CPUB")
      .post("http://dcm-content-api-perf.aws.wiley.com:8080/api/v1/contentMaps/${toc_id}/hasPart/${contentMap1}")
      .headers(headers)
    )
  }

}
