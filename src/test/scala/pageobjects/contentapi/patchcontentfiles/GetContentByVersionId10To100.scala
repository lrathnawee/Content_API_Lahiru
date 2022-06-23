package pageobjects.contentapi.patchcontentfiles

import io.gatling.core.Predef._
import io.gatling.http.Predef._

object GetContentByVersionId10To100 {

  val headers = Map(
    "Content-Type" -> "application/json",
    "Accept" -> "application/octet-stream",
    "X-WPP-AUTH-TOKEN" -> "${token}"
  )

  val csvFeeder2 = csv("src/test/resources/testdata/VersionIDMediaSmall.csv")

  def getContentByVersionId10To100 = {
    feed(csvFeeder2)
      .exec(http("52 Get Content By Version ID (10-100MB)")
        .get("http://dcm-content-api-perf.aws.wiley.com:8080/api/v1/contents/versions/${VersionIDMediaSmall}?verbose=true&offset=0&size=10")
        .headers(headers)
        .check(status.is(200))
      )
  }

}
