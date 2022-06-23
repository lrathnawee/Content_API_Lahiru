package pageobjects.contentapi.contentcontroller

import io.gatling.core.Predef._
import io.gatling.http.Predef._

object AssociateContentMapToContentMap {

  val headers = Map(
    "Content-Type" -> "application/json",
    "X-WPP-AUTH-TOKEN" -> "${ctoken}",
    "contentMap1" -> "${contentMap1}",
    "contentMap" -> "${contentMap}"
  )

  def associateContentMapToContentMap = {
    exec(http("04 Associate Content Map to Content Map CPUB")
      .post("http://dcm-content-api-perf.aws.wiley.com:8080/api/v1/contentMaps/${contentMap1}/hasPart/${contentMap}")
      .headers(headers)
    )
  }
}
