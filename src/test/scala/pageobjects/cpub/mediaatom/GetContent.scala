package pageobjects.cpub.mediaatom

import io.gatling.core.Predef._
import io.gatling.http.Predef._

object GetContent {
  val Low_Resolution_RenditionId_Largefeeder = csv("./src/test/resources/testdata/cpub/Low_Resolution_RenditionId_Large.csv").random
  val Low_Resolution_RenditionId_Large1feeder = csv("./src/test/resources/testdata/cpub/Low_Resolution_RenditionId_Large1.csv").random
  val Low_Resolution_RenditionId_Smallfeeder = csv("./src/test/resources/testdata/cpub/Low_Resolution_RenditionId_Small.csv").random
  val Low_Resolution_RenditionId_Smallerfeeder = csv("./src/test/resources/testdata/cpub/Low_Resolution_RenditionId_Smaller.csv").random
  val MediaAtomMediumOnefeeder = csv("./src/test/resources/testdata/cpub/MediaAtomMediumOne.csv").random
  val MediaAtomMediumTwofeeder = csv("./src/test/resources/testdata/cpub/MediaAtomMediumTwo.csv").random
  val MediaAtomSmallfeeder = csv("./src/test/resources/testdata/cpub/MediaAtomSmall.csv").random
  val MediaAtomSmallerfeeder = csv("./src/test/resources/testdata/cpub/MediaAtomSmaller.csv").random
  val mediaatomsmallerfeeder = csv("./src/test/resources/testdata/cpub/MediaAtomSmaller.csv").random
  val Original_Resolution_RenditionId_Largefeeder = csv("./src/test/resources/testdata/cpub/Original_Resolution_RenditionId_Large.csv").random
  val Original_Resolution_RenditionId_Large1feeder = csv("./src/test/resources/testdata/cpub/Original_Resolution_RenditionId_Large1.csv").random
  val Original_Resolution_RenditionId_Smallfeeder = csv("./src/test/resources/testdata/cpub/Original_Resolution_RenditionId_Small.csv").random
  val Original_Resolution_RenditionId_Smallerfeeder = csv("./src/test/resources/testdata/cpub/Original_Resolution_RenditionId_Smaller.csv").random
  val MediaAtomMediumThreefeeder= csv("./src/test/resources/testdata/cpub/MediaAtomMediumThree.csv").random
  val MediaAtomMediumFourfeeder= csv("./src/test/resources/testdata/cpub/MediaAtomMediumFour.csv").random
  val MediaAtomLargefeeder=csv("./src/test/resources/testdata/cpub/MediaAtomLarge.csv").random

  val headers = Map (
    "Content-Type" -> "application/json",
    "Accept" -> "*/*",
    "X-WPP-AUTH-TOKEN" -> "${token}"
  )

  def cpubmediaatom0_10mb = {
    feed(mediaatomsmallerfeeder)
      .exec(http("CPUB Get MediaAtom 0-10MB")
        .get("/api/v1/contents/${MediaAtomSmaller}")
        .headers(headers)
        .header("x-dynaTrace", "NA=CPUB Get MediaAtom 0-10MB;")
        .check(status.is(200))
      )
  }

  def cpubmediaatomdownload0_10mb = {
    feed(Original_Resolution_RenditionId_Smallerfeeder)
      .exec(http("CPUB Get Contents by original_Resolution_RenditionId_0-10MB")
        .get("/api/v1/contents/${Original_Resolution_RenditionId_Smaller}")
        .headers(headers)
        .header("x-dynaTrace", "NA=CPUB Get Contents by original_Resolution_RenditionId_0-10MB;")
        .header("Accept", "application/octet-stream")
        .check(status.is(200))
      )
  }
  def cpubmediaatomdownloadsmall0_10mb = {
    feed(Low_Resolution_RenditionId_Smallerfeeder)
      .exec(http("CPUB Get Contents by low_resolution_RendtionId_0-10MB")
        .get("/api/v1/contents/${Low_Resolution_RenditionId_Smaller}")
        .headers(headers)
        .header("x-dynaTrace", "NA=CPUB Get Contents by low_resolution_RendtionId_0-10MB;")
        .header("Accept", "application/octet-stream")
        .check(status.is(200))
      )
  }

  def cpubmediaatom10_100mb = {
    feed(MediaAtomSmallfeeder)
      .exec(http("CPUB Get MediaAtom 10-100MB")
        .get("/api/v1/contents/${MediaAtomSmall}")
        .headers(headers)
        .header("x-dynaTrace", "NA=CPUB Get MediaAtom 10-100MB;")
        .check(status.is(200))
      )
  }

  def cpubmediaatomdownload10_100mb = {
    feed(Original_Resolution_RenditionId_Smallfeeder)
      .exec(http("CPUB Get Contents by Original_Resolution_RenditionId_10-100MB")
        .get("/api/v1/contents/${Original_Resolution_RenditionId_Small}")
        .headers(headers)
        .header("x-dynaTrace", "NA=CPUB Get Contents by Original_Resolution_RenditionId_10-100MB;")
        .header("Accept", "application/octet-stream")
        .check(status.is(200))
      )
  }
  def cpubmediaatomdownloadsmall10_100mb = {
    feed(Low_Resolution_RenditionId_Smallfeeder)
      .exec(http("CPUB Get Contents by Low_resolution_RendtionId_10-100MB")
        .get("/api/v1/contents/${Low_Resolution_RenditionId_Small}")
        .headers(headers)
        .header("x-dynaTrace", "NA=CPUB Get Contents by Low_resolution_RendtionId_10-100MB;")
        .header("Accept", "application/octet-stream")
        .check(status.is(200))
      )
  }

  def cpubmediaatom100_250mb = {
    feed(MediaAtomMediumOnefeeder)
      .exec(http("CPUB Get MediaAtom 100-250MB")
        .get("/api/v1/contents/${MediaAtomMediumOne}")
        .headers(headers)
        .header("x-dynaTrace", "NA=CPUB Get MediaAtom 100-250MB;")
        .check(status.is(200))
      )
  }

  def cpubmediaatomdownload100_250mb = {
    feed(Original_Resolution_RenditionId_Largefeeder)
      .exec(http("CPUB Get Contents by Original_Resolution_RenditionId_100-250MB")
        .get("/api/v1/contents/${Original_Resolution_RenditionId_Large}")
        .headers(headers)
        .header("x-dynaTrace", "NA=CPUB Get Contents by Original_Resolution_RenditionId_100-250MB;")
        .header("Accept", "application/octet-stream")
        .check(status.is(200))
      )
  }
  def cpubmediaatomdownloadsmall100_250mb = {
    feed(Low_Resolution_RenditionId_Largefeeder)
      .exec(http("CPUB Get Contents by Low_resolution_RendtionId_100-250MB")
        .get("/api/v1/contents/${Low_Resolution_RenditionId_Large}")
        .headers(headers)
        .header("x-dynaTrace", "NA=CPUB Get Contents by Low_resolution_RendtionId_100-250MB;")
        .header("Accept", "application/octet-stream")
        .check(status.is(200))
      )
  }

  def cpubmediaatom250_500mb = {
    feed(MediaAtomMediumTwofeeder)
      .exec(http("CPUB Get MediaAtom 250-500MB")
        .get("/api/v1/contents/${MediaAtomMediumTwo}")
        .headers(headers)
        .header("x-dynaTrace", "NA=CPUB Get MediaAtom 250-500MB;")
        .check(status.is(200))
      )
  }

  def cpubmediaatomdownload250_500mb = {
    feed(Original_Resolution_RenditionId_Large1feeder)
      .exec(http("CPUB Get Contents by Original_Resolution_RenditionId_250-500MB")
        .get("/api/v1/contents/${Original_Resolution_RenditionId_Large1}")
        .headers(headers)
        .header("x-dynaTrace", "NA=CPUB Get Contents by Original_Resolution_RenditionId_250-500MB;")
        .header("Accept", "application/octet-stream")
        .check(status.is(200))
      )
  }
  def cpubmediaatomdownloadsmall250_500mb = {
    feed(Low_Resolution_RenditionId_Large1feeder)
      .exec(http("CPUB Get Contents by Low_resolution_RendtionId_250-500MB")
        .get("/api/v1/contents/${Low_Resolution_RenditionId_Large1}")
        .headers(headers)
        .header("x-dynaTrace", "NA=CPUB Get Contents by Low_resolution_RendtionId_250-500MB;")
        .header("Accept", "application/octet-stream")
        .check(status.is(200))
      )
  }


  def cpubmediaatom500_750mb = {
    feed(MediaAtomMediumThreefeeder)
      .exec(http("CPUB Get MediaAtom 500-750MB")
        .get("/api/v1/contents/${MediaAtomMediumThree}")
        .headers(headers)
        .header("x-dynaTrace", "NA=CPUB Get MediaAtom 500-750MB;")
        .check(status.is(200))
      )
  }

  def cpubmediaatom750_1GB = {
    feed(MediaAtomMediumFourfeeder)
      .exec(http("CPUB Get MediaAtom 750mb-1GB")
        .get("/api/v1/contents/${MediaAtomMediumFour}")
        .headers(headers)
        .header("x-dynaTrace", "NA=CPUB Get MediaAtom 750mb-1GB;")
        .check(status.is(200))
      )
  }

  def cpubmediaatom1GBAbove = {
    feed(MediaAtomLargefeeder)
      .exec(http("CPUB Get MediaAtom 1GB-Above")
        .get("/api/v1/contents/${MediaAtomLarge}")
        .headers(headers)
        .header("x-dynaTrace", "NA=CPUB Get MediaAtom 1GB-Above;")
        .check(status.is(200))
      )
  }

}
