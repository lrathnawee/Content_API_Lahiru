package pageobjects.contentapi.patchcontentfiles

import io.gatling.core.Predef._
import io.gatling.http.Predef._

object GetContentByVersionId100To250 {

  val headers = Map(
    "Content-Type" -> "application/json",
    "Accept" -> "application/octet-stream",
    "X-WPP-AUTH-TOKEN" -> "${token}"
  )

  val csvFeeder3 = csv("src/test/resources/testdata/VersionIDMediaMediumOne.csv")

  def getContentByVersionId100To250 = {
    feed(csvFeeder3)
      .exec(http("52 Get Content By Version ID (100MB - 250MB)")
      .get("http://dcm-content-api-perf.aws.wiley.com:8080/api/v1/contents/versions/${VersionIDMediaMediumOne}?verbose=true&offset=0&size=10")
      .headers(headers)
      .check(status.is(200))
      )
  }

}
