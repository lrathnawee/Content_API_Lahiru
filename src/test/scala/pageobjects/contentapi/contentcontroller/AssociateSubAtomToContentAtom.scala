package pageobjects.contentapi.contentcontroller

import io.gatling.core.Predef._
import io.gatling.http.Predef._

object AssociateSubAtomToContentAtom {

  val headers = Map(
    "Content-Type" -> "application/json",
    "X-WPP-AUTH-TOKEN" -> "${ctoken}",
    "contentMap1" -> "${contentMap1}",
    "narrativeAtomID1" -> "${narrativeAtomID1}"
  )

  def associateSubAtomToContentAtom ={
    exec(http("04 CPUB Associate SubAtom to Content Map")
    .post("http://dcm-content-api-perf.aws.wiley.com:8080/api/v1/contentMaps/${contentMap1}/hasSubAtom/${narrativeAtomID1}")
    )
  }

}
