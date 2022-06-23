package pageobjects.contentapi.patchcontentfiles

import io.gatling.core.Predef._
import io.gatling.http.Predef._

object GetContentByVersionId500To750 {

  val headers = Map(
    "Content-Type" -> "application/json",
    "Accept" -> "application/octet-stream",
    "X-WPP-AUTH-TOKEN" -> "${token}"
  )

  val csvFeeder5 = csv("src/test/resources/testdata/VersionIDMediaAtomThree.csv")

  def getContentByVersionId500To750 = {
    feed(csvFeeder5)
      .exec(http("52 Get Content By Version ID (500MB - 750MB)")
        .get("http://dcm-content-api-perf.aws.wiley.com:8080/api/v1/contents/versions/${VersionIDMediaMediumThree}?verbose=true&offset=0&size=10")
        .headers(headers)
        .check(status.is(200))
      )
  }

}
