package pageobjects.contentapi.contentcontroller

import io.gatling.core.Predef._
import io.gatling.http.Predef._

object AssociateMediaToContentMap {

  val headers = Map(
    "Content-Type" -> "application/json",
    "X-WPP-AUTH-TOKEN" -> "${token}",
    "contentMap1" -> "${contentMap1}",
    "mediaAtomID1" -> "${mediaAtomID1}"
  )

  def associateMediaToContentMap = {
    exec(http("04 CPUB Associate Media to Content Map")
      .post("http://dcm-content-api-perf.aws.wiley.com:8080/api/v1/contentMaps/${contentMap1}/hasMedia/${mediaAtomID1}")
      .headers(headers)
    )
  }
}
