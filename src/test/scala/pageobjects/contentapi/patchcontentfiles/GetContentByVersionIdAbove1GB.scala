package pageobjects.contentapi.patchcontentfiles

import io.gatling.core.Predef._
import io.gatling.http.Predef._

object GetContentByVersionIdAbove1GB {

  val headers = Map(
    "Content-Type" -> "application/json",
    "Accept" -> "application/octet-stream",
    "X-WPP-AUTH-TOKEN" -> "${token}"
  )

  val csvFeeder7 = csv("src/test/resources/testdata/VersionIDMediaAtomLarge.csv")

  def getContentByVersionIdAbove1GB = {
    feed(csvFeeder7)
      .exec(http("52 Get Content By Version ID (Above 1GB)")
      .get("http://dcm-content-api-perf.aws.wiley.com:8080/api/v1/contents/versions/${VersionIDMediaLarge}?verbose=true&offset=0&size=10")
      .headers(headers)
      .check(status.is(200))
      )

  }
}
