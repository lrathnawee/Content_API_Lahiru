package pageobjects.contentapi.contentcontroller

import io.gatling.core.Predef._
import io.gatling.http.Predef._

object GetContent {
  val researchmap = csv("./src/test/resources/testdata/researchmapid.csv").circular
  val productIds = csv("./src/test/resources/testdata/productid.csv").circular
  val learningObjectMapId = csv("./src/test/resources/testdata/learningobjectmapid.csv").circular
  val learningObjectAtomIDs = csv("./src/test/resources/testdata/learningobjectatomid.csv").circular
  val localizedLearningObjectAtomIDs = csv("./src/test/resources/testdata/localizedlearningobjectatomids.csv").circular


  val headers = Map (
    "Content-Type" -> "application/json",
    "Accept" -> "*/*",
    "X-WPP-AUTH-TOKEN" -> "${token}"
  )

  val headers1 = Map (
    "X-WPP-AUTH-TOKEN" -> "${token}"
  )

  def getReasreachMap = {

    feed(researchmap)
      .exec(http("01 Get content by id - ResearchMap")
        .get("/api/v1/contents/${research_map_id}")
        .headers(headers)
        .header("x-dynaTrace", "NA=01 Get content by id - ResearchMap;")
        .check(status.is(200))
      )
  }

  def getContentByProductID = {
    feed(productIds)
      .exec(http("23 Get contents by productId")
        .get("/api/v1/contents?productId=${product_id}")
        .check(bodyString.saveAs("responseBody"))
        .headers(headers)
        .header("x-dynaTrace", "NA=23 Get contents by productId")
        .check(status.is(200))
      )
  }

  def getContentMetadata_LearningObjectMap = {
    feed(learningObjectMapId)
      .exec(http("22.1 Get content metadata - LearningObjectMap")
        .get("/api/v1/contents/${learningObjectMap_id}")
        .headers(headers1)
        .header("x-dynaTrace", "NA=22.1 Get content metadata - LearningObjectMap")
        .check(status.is(200))
      )
  }

  def getContentMetadata_LearningObjectAtom = {
    feed(learningObjectAtomIDs)
      .exec(http("22.2 Get content metadata - LearningObjectAtom")
        .get("/api/v1/contents/${LearningObjectAtom_id}")
          .headers(headers1)
        .header("x-dynaTrace", "NA=22.2 Get content metadata - LearningObjectAtom")
        .check(regex("_links\\\":{\\\"self\\\":{\\\"href\\\":\\\"http://dcm-content-api-perf.aws.wiley.com:8080/api/v1/contents/versions/(.+?)\\\"").saveAs("LOA_version_id"))
        .check(status.is(200))
      )
  }

  def getContentMetadata_LocalizedLearningObjectAtom = {
    feed(localizedLearningObjectAtomIDs)
      .exec(http("22.3 Get content metadata - LocalizedLearningObjectAtom")
        .get("/api/v1/contents/${LocalizedLearningObjectAtom_id}")
        .header("x-dynaTrace", "NA=22.3 Get content metadata - LocalizedLearningObjectAtom")
        .headers(headers1)
        .check(regex("_links\\\":{\\\"self\\\":{\\\"href\\\":\\\"http://dcm-content-api-perf.aws.wiley.com:8080/api/v1/contents/versions/(.+?)\\\"").saveAs("LLOA_version_id"))
        .check(status.is(200))
      )
  }

  def getContentsVersions_LearningObjectAtom = {
    exec(http("41.1 Get contents versions - LearningObjectAtom")
      .get("/api/v1/contents/versions/${LOA_version_id}")
      .header("x-dynaTrace", "NA=41.1 Get contents versions - LearningObjectAtom")
      .check(status.is(200))
    )
  }

  def getContentsVersions_LocalizedLearningObjectAtom = {
    exec(http("41.2 Get contents versions - LocalizedLearningObjectAtom")
      .get("/api/v1/contents/versions/${LLOA_version_id}")
      .header("x-dynaTrace", "NA=41.2 Get contents versions - LocalizedLearningObjectAtom")
      .check(status.is(200))
    )
  }


}
