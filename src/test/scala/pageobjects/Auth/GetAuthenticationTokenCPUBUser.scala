package pageobjects.Auth

import io.gatling.core.Predef._
import io.gatling.http.Predef._

object GetAuthenticationTokenCPUBUser {
  val headers = Map(
    "Content-Type" -> "application/json"
  )

  def getAuthenticationToken = {
    exec(http("00 Get Authentication token for CPUB User")
      .post("http://wpp-auth-svc-wperf.aws.wiley.com:8080/v1/auth/authenticate/system")
      .body(ElFileBody("src/test/resources/json/authToken02.json"))
      .headers(headers)
      .check(header("X-WPP-AUTH-TOKEN").saveAs("ctoken"))
    )
  }
}
