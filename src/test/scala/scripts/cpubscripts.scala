package scripts

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import pageobjects._

object cpubscripts {
  object authObject {
    def GetAuthTokenCPUB = {
      exec(Auth.GetAuthenticationTokenCPUBUser.getAuthenticationToken)
    }
  }

  object renditioncontentObject {
    def getcontentsmaller = {
      exec(cpub.mediaatom.GetContent.cpubmediaatom0_10mb)
      .exec(cpub.mediaatom.GetContent.cpubmediaatomdownload0_10mb)
        .exec(cpub.mediaatom.GetContent.cpubmediaatomdownloadsmall0_10mb)
    }
    def getcontentsmall = {
      exec(cpub.mediaatom.GetContent.cpubmediaatom10_100mb)
        .exec(cpub.mediaatom.GetContent.cpubmediaatomdownload10_100mb)
        .exec(cpub.mediaatom.GetContent.cpubmediaatomdownloadsmall10_100mb)
    }
    def getcontentmedium1 = {
      exec(cpub.mediaatom.GetContent.cpubmediaatom100_250mb)
        .exec(cpub.mediaatom.GetContent.cpubmediaatomdownload100_250mb)
        .exec(cpub.mediaatom.GetContent.cpubmediaatomdownloadsmall100_250mb)
    }
    def getcontentmedium2 = {
      exec(cpub.mediaatom.GetContent.cpubmediaatom250_500mb)
        .exec(cpub.mediaatom.GetContent.cpubmediaatomdownload250_500mb)
        .exec(cpub.mediaatom.GetContent.cpubmediaatomdownloadsmall250_500mb)
    }
    def getcontentmedium3 = {
      exec(cpub.mediaatom.GetContent.cpubmediaatom500_750mb)
    }
    def getcontentmedium4 = {
      exec(cpub.mediaatom.GetContent.cpubmediaatom750_1GB)
    }
    def getcontentlarge = {
      exec(cpub.mediaatom.GetContent.cpubmediaatom1GBAbove)
    }
  }

  object iteractivity {
    def createmediaatomandcontentmap = {
      exec(cpub.interactivity.Testdata.createmediaatom)
        .exec(cpub.interactivity.Testdata.createmediaatom)
    }
    def postandpachsmall = {
      exec(cpub.interactivity.PostAndPatch.createInteractivity0_10MB).
        exec(cpub.interactivity.PostAndPatch.updateInteractivity0_10MB)
    }
    def postandpachmedium = {
      exec(cpub.interactivity.PostAndPatch.createInteractivity10_100MB).
        exec(cpub.interactivity.PostAndPatch.updateInteractivity10_100MB)
    }
    def postandpachlarge = {
      exec(cpub.interactivity.PostAndPatch.createInteractivity100_300MB).
        exec(cpub.interactivity.PostAndPatch.updateInteractivity100_300MB)
    }

    def getcontentsmall = {
      exec(cpub.interactivity.GetContent.cpubmediaatom0_10mb)
    }
    def getcontentmedium = {
      exec(cpub.interactivity.GetContent.cpubmediaatom10_100mb)
    }
    def getcontentlarge = {
      exec(cpub.interactivity.GetContent.cpubmediaatom100_300mb)
    }

    def postassociationispartof = {
      exec(cpub.interactivity.PostAndPatch.postassociationIsPartof)
    }
    def deleteassociationispartof = {
      exec(cpub.interactivity.PostAndPatch.deleteassociationIsPartof)
    }
    def postassociationhasmedia = {
      exec(cpub.interactivity.PostAndPatch.postassociationHasMedia)
    }
    def deleteassociationhasmedia = {
      exec(cpub.interactivity.PostAndPatch.deleteassociationHasMedia)
    }
  }

  def renditionflow(paceValue: Integer,duration: Integer) = scenario("rendtionflow")
    .exec(authObject.GetAuthTokenCPUB)
    .exec(addCookie(Cookie("WPP_AUTH_TOKEN", "${X-WPP-AUTH-TOKEN}")))
    .during(duration.minutes) {
      pace(paceValue.seconds)
        .exec(renditioncontentObject.getcontentsmall)
        .exec(renditioncontentObject.getcontentsmaller)
        .exec(renditioncontentObject.getcontentmedium1)
        .exec(renditioncontentObject.getcontentmedium2)
        .exec(renditioncontentObject.getcontentmedium3)
        .exec(renditioncontentObject.getcontentmedium4)
        .exec(renditioncontentObject.getcontentlarge)
    }
  def interactivity(paceValue: Integer,duration: Integer) = scenario("interactivity")
    .exec(authObject.GetAuthTokenCPUB)
    .exec(addCookie(Cookie("WPP_AUTH_TOKEN", "${X-WPP-AUTH-TOKEN}")))
    .during(duration.minutes) {
      pace(paceValue.seconds)
        .exec(iteractivity.createmediaatomandcontentmap)
        .exec(iteractivity.postandpachsmall)
        .exec(iteractivity.postandpachmedium)
        .exec(iteractivity.postandpachlarge)
        .exec(iteractivity.getcontentsmall)
        .exec(iteractivity.getcontentmedium)
        .exec(iteractivity.getcontentlarge)
        .exec(iteractivity.postassociationispartof)
        .exec(iteractivity.deleteassociationispartof)
        .exec(iteractivity.postassociationhasmedia)
        .exec(iteractivity.deleteassociationhasmedia)
    }
}
