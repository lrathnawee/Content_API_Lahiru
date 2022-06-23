package pageobjects.contentapi.contentcontroller

import io.gatling.core.Predef._
import io.gatling.http.Predef._

object DeleteAssociateContentMapToContentMap {

  val headers = Map(
    "Content-Type" -> "application/json",
    "X-WPP-AUTH-TOKEN" -> "${token}",
    "contentMap1" -> "${contentMap1}",
    "contentMap" -> "${contentMap}"
  )

  def deleteAssociateContentMapToContentMap ={
    exec(http("05 CPUB Delete Associate ContentMap to Content Map")
      .delete("http://dcm-content-api-perf.aws.wiley.com:8080/api/v1/contentMaps/${contentMap1}/hasPart/${contentMap}")
      .headers(headers)
      .check(status.is(204))
    )
  }
}
