package pageobjects.contentapi.patchcontentfiles

import io.gatling.core.Predef._
import io.gatling.http.Predef._

object GetContentByVersionId0To10 {

  val headers = Map(
    "Content-Type" -> "application/json",
    "Accept" -> "application/octet-stream",
    "X-WPP-AUTH-TOKEN" -> "${token}"
  )

  val csvFeeder1 = csv("src/test/resources/testdata/VersionIDMediaSmaller.csv").circular

  def getContentByVersionId0To10 = {
    feed(csvFeeder1)
      .exec(http("52 Get Content By Version ID (0-10MB)")
        .get("http://dcm-content-api-perf.aws.wiley.com:8080/api/v1/contents/versions/${VersionIDMediaSmaller}?verbose=true&offset=0&size=10")
        .headers(headers)
        .check(status.is(200))
      )
  }
}
