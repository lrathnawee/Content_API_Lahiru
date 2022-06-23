package pageobjects.cpub.interactivity

import io.gatling.core.Predef._
import io.gatling.http.Predef._

object PostAndPatch { //without content

  val headers = Map (
    "Content-Type" -> "application/json",
    "Accept" -> "*/*",
    "X-WPP-AUTH-TOKEN" -> "${ctoken}"
  )

  def createInteractivity0_10MB ={
    exec(http("T01_Create_InteractivityType - 0Mb - 10 Mb")
      .post("/api/v1/contents")
      .header("x-dynaTrace", "NA=T01_Create_InteractivityType - 0Mb - 10 Mb;")
      .formParam("metadata","src/test/resources/json/cpub/interactivity/test/smallJson.json")
      .formParam("content", "src/test/resources/json/cpub/interactivity/test/0-10MB.html")
      .check(jsonPath("$.id").find.saveAs("interactivityID"))
      .headers(headers)
    )
  }

  def updateInteractivity0_10MB ={
    exec(http("T01_Update_InteractivityType - 0Mb - 10 Mb")
      .patch("/api/v1/contents")
      .header("x-dynaTrace", "NA=T01_Update_InteractivityType - 0Mb - 10 Mb;")
      .formParam("metadata","src/test/resources/json/cpub/interactivity/test/smallJson.json")
      .formParam("content", "src/test/resources/json/cpub/interactivity/test/0-10MB.html")
      .check(jsonPath("$.id").find.saveAs("interactivityID"))
      .headers(headers)
    )
  }

  def createInteractivity10_100MB ={
    exec(http("T02_Create_InteractivityType - 10Mb - 100Mb")
      .post("/api/v1/contents")
      .header("x-dynaTrace", "NA=T02_Create_InteractivityType - 10Mb - 100Mb;")
      .formParam("metadata","src/test/resources/json/cpub/interactivity/test/mediumJson.json")
      .formParam("content", "src/test/resources/json/cpub/interactivity/test/FileNameMedium")
      .check(jsonPath("$.id").find.saveAs("interactivityID"))
      .headers(headers)
    )
  }

  def updateInteractivity10_100MB ={
    exec(http("T02_Update_InteractivityType - 10Mb - 100Mb")
      .patch("/api/v1/contents")
      .header("x-dynaTrace", "NA=T02_Update_InteractivityType - 10Mb - 100Mb;")
      .formParam("metadata","src/test/resources/json/cpub/interactivity/test/mediumJson.json")
      .formParam("content", "src/test/resources/json/cpub/interactivity/test/FileNameMedium")
      .check(jsonPath("$.id").find.saveAs("interactivityID"))
      .headers(headers)
    )
  }

  def createInteractivity100_300MB ={
    exec(http("T03_Create_InteractivityType - 100Mb - 300Mb")
      .post("/api/v1/contents")
      .header("x-dynaTrace", "NA=T03_Create_InteractivityType - 100Mb - 300Mb;")
      .formParam("metadata","src/test/resources/json/cpub/interactivity/test/mediumJson.json")
      .formParam("content", "src/test/resources/json/cpub/interactivity/test/FileNameMedium")
      .check(jsonPath("$.id").find.saveAs("interactivityID"))
      .headers(headers)
    )
  }

  def updateInteractivity100_300MB ={
    exec(http("T03_Update_InteractivityType - 100Mb - 300Mb")
      .patch("/api/v1/contents")
      .header("x-dynaTrace", "NA=T03_Update_InteractivityType - 100Mb - 300Mb;")
      .formParam("metadata","src/test/resources/json/cpub/interactivity/test/mediumJson.json")
      .formParam("content", "src/test/resources/json/cpub/interactivity/test/FileNameMedium")
      .check(jsonPath("$.id").find.saveAs("interactivityID"))
      .headers(headers)
    )
  }

  def postassociationIsPartof ={
    exec(http("Create_InteractivityId to contentId")
      .post("/api/v1/contents/${interactivityID}/isPartOf/${cpub_contentId}")
      .header("x-dynaTrace", "NA=Create_InteractivityId to contentId;")
      .headers(headers)
    )
  }
  def deleteassociationIsPartof ={
    exec(http("Delete_InteractivityId to contentId")
      .delete("/api/v1/contents/${interactivityID}/isPartOf/${cpub_contentId}")
      .header("x-dynaTrace", "NA=Delete_InteractivityId to contentId;")
      .headers(headers)
    )
  }

  def postassociationHasMedia ={
    exec(http("Create_contentMapId to InteractivityId")
      .post("/api/v1/contents/${interactivityID}/hasMedia/${cpub_contentId}")
      .header("x-dynaTrace", "NA=Create_contentMapId to InteractivityId;")
      .headers(headers)
    )
  }
  def deleteassociationHasMedia ={
    exec(http("Delete_contentMapId to InteractivityId")
      .delete("/api/v1/contents/${interactivityID}/hasMedia/${cpub_contentId}")
      .header("x-dynaTrace", "NA=Delete_contentMapId to InteractivityId;")
      .headers(headers)
    )
  }
}
