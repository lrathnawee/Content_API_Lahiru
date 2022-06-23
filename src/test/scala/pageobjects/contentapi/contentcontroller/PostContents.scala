package pageobjects.contentapi.contentcontroller

import io.gatling.core.Predef._
import io.gatling.http.Predef._

import scala.util.Random

object PostContents {


  val dataFeed = Iterator.continually(Map(
    "product_id" -> java.util.UUID.randomUUID.toString()
  ))

  val feeder = Iterator.continually(Map {
    "pFileName" -> ("Perf_tst_file_" + Random.between(10000, 90000).toString + Random.between(10000, 90000).toString + "." + Random.between(1000, 9000).toString)
  })

  val dataFeed1 = Iterator.continually(Map(
    "Author_ID" -> java.util.UUID.randomUUID.toString()
  ))

  val headers_1= Map(
    "Cache-Control" -> "no-cache",
    "Content-Type" -> "application/json",
    "X-WPP-AUTH-TOKEN" -> "${token}"
  )

  val multiheaders = Map(
    "Content-Type" -> "multipart/form-data; boundary=",
    "X-WPP-AUTH-TOKEN" -> "${token}"
  )

  val headers_2 = Map(
    "Content-Type" -> "application/merge-patch+json",
    "X-WPP-AUTH-TOKEN" -> "${token}"
  )

  val ck_patch_files = csv("./src/test/resources/testdata/ck_patch_files.csv").circular
  val metadata_files = csv("./src/test/resources/testdata/content_metadata.csv").circular
  val metadata_files_two = csv("./src/test/resources/testdata/content_metadata_two.csv").circular
  val locale = csv("./src/test/resources/testdata/locale.csv").circular
  val publisher = csv("./src/test/resources/testdata/publisher.csv").circular
  val mediaAtomFileNames = csv("./src/test/resources/testdata/mediaAtomFileNames.csv").circular

  def postContentLOM = {
    feed(dataFeed)
    .exec(http("17.1 Post contents-LOM")
      .post("/api/v1/contents")
      .headers(headers_1)
      .body(ElFileBody("json/postContentsLOM.json"))
      .header("x-dynaTrace", "NA=17.1 Post contents-LOM")
      .check(bodyString.saveAs("responseBody"))
      .check(status.is(201))
      .check(jsonPath("$.id").find.saveAs("LearningObjectMap_id"))
    )

  }

  def postContentMapsLearningObjectAtom = {
    exec(http("18 Post contentMaps_LearningObjectAtom")
      .post("/api/v1/contentMaps/${LearningObjectMap_id}/hasLearningObjectAtom")
      .headers(multiheaders)
      .bodyPart(RawFileBodyPart("metadata","./src/test/resources/json/metadataLOA.json"))
      .bodyPart(RawFileBodyPart("content","./src/test/resources/contents/035be44e-c8af-474e-8b27-c449097a206e.zip")
        .fileName("035be44e-c8af-474e-8b27-c449097a206e.zip")
        .transferEncoding("binary")).asMultipartForm
      .check(jsonPath("$.id").find.saveAs("LearningObjectAtom_id"))
      .header("x-dynaTrace","NA=18 Post contentMaps_LearningObjectAtom")
      .check(bodyString.saveAs("responseBody"))
      .check(status.is(201))
    )

  }

  def PostContentHasTranslation = {
    exec(http("19 Post contents_hasTranslation")
        .post("/api/v1/contents/${LearningObjectAtom_id}/hasTranslation")
        .headers(multiheaders)
      .bodyPart(RawFileBodyPart("metadata","./src/test/resources/json/metadataLLOA.json"))
      .bodyPart(RawFileBodyPart("content","./src/test/resources/contents/035be44e-c8af-474e-8b27-c449097a206e.zip")
        .fileName("035be44e-c8af-474e-8b27-c449097a206e.zip")
        .transferEncoding("binary")).asMultipartForm
      .check(jsonPath("$.id").find.saveAs("LocalizedLearningObjectAtom_id"))
      .header("x-dynaTrace","NA=19 Post contents_hasTranslation")
      .check(bodyString.saveAs("responseBody"))
      .check(status.is(201))
    )
  }

  def PatchCKContentFilesLOA = {
    feed(ck_patch_files)
    .exec(http("21.1 CK Patch contents-files - LOA")
        .patch("/api/v1/contents/${LearningObjectAtom_id}")
        .headers(multiheaders)
        .bodyPart(RawFileBodyPart("metadata","./src/test/resources/json/patchLearningObjectAtom.json"))
        .bodyPart(RawFileBodyPart("content","./src/test/resources/contents/${file_name}")
        .fileName("${file_name}")
        .transferEncoding("binary")).asMultipartForm
        .header("x-dynaTrace","NA=21.1 CK Patch contents-files - LOA")
        .check(bodyString.saveAs("responseBody"))
        .check(status.is(200))

    )
  }

  def PatchCKContentFilesLLOA = {
    feed(ck_patch_files)
      .exec(http("21.1 CK Patch contents-files - LLOA")
          .patch("/api/v1/contents/${LocalizedLearningObjectAtom_id}")
          .headers(multiheaders)
          .bodyPart(RawFileBodyPart("metadata","./src/test/resources/json/patchLocalizedLearningObjectAtom.json"))
          .bodyPart(RawFileBodyPart("content","./src/test/resources/contents/${file_name}")
          .fileName("${file_name}")
          .transferEncoding("binary")).asMultipartForm
          .header("x-dynaTrace","NA=21.1 CK Patch contents-files - LLOA")
          .check(bodyString.saveAs("responseBody"))
          .check(status.is(200))
      )

  }

  def patchContentMetadataAtom = {
    feed(feeder)
      .feed(dataFeed1)
      .feed(metadata_files)
      .feed(locale)
      .exec(http("21.2 Patch contents-metadata")
      .patch("/api/v1/contents/${LearningObjectAtom_id}")
      .headers(headers_2)
      .header("x-dynatrace", "NA=21.2 Patch contents-metadata")
      .body(RawFileBody("./src/test/resources/json/content_metadata/${json_file}.json"))
      .check(status.is(200))
      .check(bodyString.saveAs("responseBody"))
    )
      .exec { session => println(session("responseBody").as[String]); session }
  }

  def patchContentMetadataMap = {
    feed(feeder)
      .feed(publisher)
      .feed(dataFeed1)
      .feed(metadata_files_two)
      .feed(locale)
      .exec(http("21.2 Patch contents-metadata")
        .patch("/api/v1/contents/${LearningObjectMap_id}")
        .headers(headers_2)
        .header("x-dynatrace", "NA=21.2 Patch contents-metadata")
        .body(RawFileBody("./src/test/resources/json/content_metadata/${json_file}.json"))
        .check(status.is(200))
        .check(bodyString.saveAs("responseBody"))
      )
      .exec { session => println(session("responseBody").as[String]); session }
  }

  def postContentsMediaAtom = {
   feed(mediaAtomFileNames)
    .exec(http("17.2 Post contents-mediaAtom")
      .post("/api/v1/contents")
      .headers(multiheaders)
      .bodyPart(RawFileBodyPart("metadata","./src/test/resources/json/postContentsMediaAtom.json"))
      .bodyPart(RawFileBodyPart("content","./src/test/resources/contents/${mediaAtomFileName}")
        .fileName("${mediaAtomFileName}")
        .transferEncoding("binary")).asMultipartForm
      .header("x-dynaTrace", "NA=17.2 Post contents-mediaAtom")
      .check(status.is(201))
      .check(bodyString.saveAs("responseBody"))
    )
      .exec { session => println(session("responseBody").as[String]); session }
  }

}
