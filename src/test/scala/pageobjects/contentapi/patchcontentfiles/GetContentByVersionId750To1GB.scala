package pageobjects.contentapi.patchcontentfiles

import io.gatling.core.Predef._
import io.gatling.http.Predef._

object GetContentByVersionId750To1GB {

  val headers = Map(
    "Content-Type" -> "application/json",
    "Accept" -> "application/octet-stream",
    "X-WPP-AUTH-TOKEN" -> "${token}"
  )

  val csvFeeder6 = csv("src/test/resources/testdata/VersionMediaAtomFour.csv")

  def getContentByVersionId750To1GB = {
    feed(csvFeeder6)
      .exec(http("52 Get Content By Version ID (750MB - 1GB)")
      .get("http://dcm-content-api-perf.aws.wiley.com:8080/api/v1/contents/versions/${VersionIDMediaMediumFour}?verbose=true&offset=0&size=10")
      .headers(headers)
      .check(status.is(200))
      )

  }
}
