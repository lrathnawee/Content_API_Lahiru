package pageobjects.contentapi.patchcontentfiles

import io.gatling.core.Predef._
import io.gatling.http.Predef._

object GetContentByVersionId250To500 {

  val headers = Map(
    "Content-Type" -> "application/json",
    "Accept" -> "application/octet-stream",
    "X-WPP-AUTH-TOKEN" -> "${token}"
  )

  val csvFeeder4 = csv("src/test/resources/testdata/VersionIDMediaAtomTwo.csv")

  def getContentByVersionId250To500 = {
    feed(csvFeeder4)
      .exec(http("52 Get Content By Version ID (250MB - 500MB)")
      .get("http://dcm-content-api-perf.aws.wiley.com:8080/api/v1/contents/versions/${VersionIDMediaMediumTwo}?verbose=true&offset=0&size=10")
      .headers(headers)
      .check(status.is(200))
      )

  }
}
