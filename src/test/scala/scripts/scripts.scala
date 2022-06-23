package scripts

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import pageobjects._

object scripts {
  object authObject {
    def GetAuthtoken = {
      exec(Auth.GetAuthenticationToken.getAuthenticationToken)
    }

    def GetAuthTokenCPUB = {
      exec(Auth.GetAuthenticationTokenCPUBUser.getAuthenticationToken)
    }
  }

  object contentObject {
    def GetContent = {
      exec(contentapi.contentcontroller.GetContent.getReasreachMap)
    }

    def CreateContentMap = {
      exec(contentapi.contentcontroller.CreateContentMap.createContentMap)
    }

    def CreateAnotherContentMap = {
      exec(contentapi.contentcontroller.CreateAnotherContentMap.createAnotherContentMap)
    }

    def AssociateContentMapToContentMap = {
      exec(contentapi.contentcontroller.AssociateContentMapToContentMap.associateContentMapToContentMap)
    }

    def AssociateContentMapToTOC = {
      exec(contentapi.contentcontroller.AssociateContentMapToTOC.associateContentMapToTOC)
    }

    def AssociateMediaToContentMap = {
      exec(contentapi.contentcontroller.AssociateMediaToContentMap.associateMediaToContentMap)
    }

    def AssociateSubAtomToContentMap ={
      exec(contentapi.contentcontroller.AssociateSubAtomToContentAtom.associateSubAtomToContentAtom)
    }

    def DeleteAssociateContentMapToContentMap = {
      exec(contentapi.contentcontroller.DeleteAssociateContentMapToContentMap.deleteAssociateContentMapToContentMap)
    }

    def DeleteAssociateSubAtomToContentMap = {
      exec(contentapi.contentcontroller.DeleteAssociateSubAtomToContentMap.deleteAssociateSubAtomToContentMap)
    }

    def DeleteAssociateMediaToContentMap = {
      exec(contentapi.contentcontroller.DeleteAssociateMediaToContentMap.deleteAssociateMediaToContentMap)
    }

    def DeleteAssociateContentMapToTOC = {
      exec(contentapi.contentcontroller.DeleteAssociateContentMapToTOC.deleteAssociateContentMapToTOC)
    }

    def GetContentByProductID = {
      exec(contentapi.contentcontroller.GetContent.getContentByProductID)
    }

    def GetContentMetadataByLearningObjectMapID = {
      exec(contentapi.contentcontroller.GetContent.getContentMetadata_LearningObjectMap)
    }

    def GetContentMetadataLearningObjectAtom = {
      exec(contentapi.contentcontroller.GetContent.getContentMetadata_LearningObjectAtom)
    }

    def GetContentMetadataLocalizedLearningObjectAtom = {
      exec(contentapi.contentcontroller.GetContent.getContentMetadata_LocalizedLearningObjectAtom)
    }

    def GetContentVersionByLearningObjectAtom = {
      exec(contentapi.contentcontroller.GetContent.getContentsVersions_LearningObjectAtom)
    }

    def GetContentVersionsLocalizedLearningObjectAtom = {
      exec(contentapi.contentcontroller.GetContent.getContentsVersions_LocalizedLearningObjectAtom)
    }

    def PostContentLOM = {
      exec(contentapi.contentcontroller.PostContents.postContentLOM)
    }

    def PostContentMapLearningObjectAtom = {
      exec(contentapi.contentcontroller.PostContents.postContentMapsLearningObjectAtom)
    }

    def PostContentsHasTranslation = {
      exec(contentapi.contentcontroller.PostContents.PostContentHasTranslation)
    }

    def PatchCKContentFilesLOA = {
      exec(contentapi.contentcontroller.PostContents.PatchCKContentFilesLOA)
    }

    def PatchCKContentFilesLLOA = {
      exec(contentapi.contentcontroller.PostContents.PatchCKContentFilesLLOA)
    }

    def PatchContentMetadataAtom = {
      exec(contentapi.contentcontroller.PostContents.patchContentMetadataAtom)
    }

    def PatchContentMetadataMap = {
      exec(contentapi.contentcontroller.PostContents.patchContentMetadataMap)
    }

    def CreateContentMediaAtom = {
      exec(contentapi.contentcontroller.PostContents.postContentsMediaAtom)
    }

  }





  object prerequisitesObjects {
    def CreateBook = {
      exec(prerequisites.CreateBook.createBook)
    }

    def CreateProject = {
      exec(prerequisites.CreateProject.createProject)
    }

    def CreateEdPubProject = {
      exec(prerequisites.CreateEdPubProject.createEcPubProject)
    }
  }

  object tocObject {
    def CreateTOC = {
      exec(toc.CreateTOC.createTOC)
    }

//    def PostContentTOC = {
//      exec(toc.PostContentsTOC.postContentsTOC)
//    }
//
//    def PatchTOCUpdate = {
//      exec(toc.PatchTOCUpdate.patchTOCUpdate)
//    }
  }

  object atomObject {

    def CreateMediaAtomWithProjectIDs = {
      exec(contentapi.atom.CreateMediaAtomWithProjectIDs.createMediaAtomWithProjectIDs)
    }

    def CreateAnotherMediaAtomWithProjectIDs ={
      exec(contentapi.atom.CreateAnotherMediaAtomWithProjectIDs.createAnotherMediaAtomWithProjectIDs)
    }

    def CreateNarrativeAtom = {
      exec(contentapi.atom.CreateNarrativeAtom.createNarrativeAtom)
    }
  }

  object patchContentObject {
    def GetContentByVersionId0To10 ={
      exec(contentapi.patchcontentfiles.GetContentByVersionId0To10.getContentByVersionId0To10)
    }

    def GetContentByVersionId10To100 = {
      exec(contentapi.patchcontentfiles.GetContentByVersionId10To100.getContentByVersionId10To100)
    }

    def GetContentByVersion100To250 = {
      exec(contentapi.patchcontentfiles.GetContentByVersionId100To250.getContentByVersionId100To250)
    }

    def GetContentByVersion250To500 = {
      exec(contentapi.patchcontentfiles.GetContentByVersionId250To500.getContentByVersionId250To500)
    }

    def GetContentByVersion500To750 = {
      exec(contentapi.patchcontentfiles.GetContentByVersionId500To750.getContentByVersionId500To750)
    }

    def GetContentByVersion750To1GB = {
      exec(contentapi.patchcontentfiles.GetContentByVersionId750To1GB.getContentByVersionId750To1GB)
    }

    def GetContentByVersionIdAbove1GB = {
      exec(contentapi.patchcontentfiles.GetContentByVersionIdAbove1GB.getContentByVersionIdAbove1GB)
    }

//    def PostContentMapsTOCHasContentPart = {
//      exec(contentapi.patchcontentfiles.PostContentMapsTOCHasContentPart.postContentMapsTOCHasContentPart)
//    }
//
//    def PostContentMapsCollateralMapsHasCollateral = {
//      exec(contentapi.patchcontentfiles.PostContentMapsCollateralMapsHasCollateral.postContentMapsCollateralMapsHasCollateral)
//    }
//
//    def PostContentMapsTOCHasRendition = {
//      exec(contentapi.patchcontentfiles.PostContentMapsTOCHasRendition.postContentMapsTOCHasRendition)
//    }
//
//    def PatchContentRendition = {
//      exec(contentapi.patchcontentfiles.PatchContentRendition.patchContentRendition)
//    }
  }

  def Content_API_CPUBTest(paceValue: Integer) = scenario("Content_API_CPUBTest")
      .exec(authObject.GetAuthtoken)
      .exec(authObject.GetAuthTokenCPUB)
      .exec(prerequisitesObjects.CreateBook)
      .exec(prerequisitesObjects.CreateProject)
      .exec(prerequisitesObjects.CreateEdPubProject)
      .exec(addCookie(Cookie("WPP_AUTH_TOKEN", "${X-WPP-AUTH-TOKEN}")))
        .forever()
        {
         pace(paceValue.seconds)
           .exec(tocObject.CreateTOC)
           .exec(atomObject.CreateMediaAtomWithProjectIDs)
           .exec(atomObject.CreateNarrativeAtom)
           .exec(contentObject.CreateContentMap)
           .exec(contentObject.CreateAnotherContentMap)
           .exec(contentObject.AssociateContentMapToContentMap)
           .exec(contentObject.AssociateContentMapToTOC)
           .exec(contentObject.AssociateMediaToContentMap)
           .exec(contentObject.AssociateSubAtomToContentMap)
           .exec(contentObject.DeleteAssociateContentMapToContentMap)
           .exec(contentObject.DeleteAssociateContentMapToTOC)
           .exec(contentObject.DeleteAssociateMediaToContentMap)
           .exec(contentObject.DeleteAssociateSubAtomToContentMap)

         }

  def content_api_patch_content_files_cpub(paceValue:Integer) = scenario("content_api_patch_content_files_cpub")
    .exec(authObject.GetAuthtoken)
    .exec(addCookie(Cookie("WPP_AUTH_TOKEN", "${X-WPP-AUTH-TOKEN}")))
    .forever(){
      pace(paceValue.seconds)
        .repeat("2")
        {
           exec(patchContentObject.GetContentByVersion100To250)
          .exec(patchContentObject.GetContentByVersion250To500)
          .exec(patchContentObject.GetContentByVersion500To750)
          .exec(patchContentObject.GetContentByVersion750To1GB)
        }
        .repeat("3")
        {
          exec(patchContentObject.GetContentByVersionId10To100)
        }
        .repeat("5")
        {
          exec(patchContentObject.GetContentByVersionId0To10)
        }
        .exec(patchContentObject.GetContentByVersionIdAbove1GB)

    }

    def get_contents_by_product_id(paceValue: Integer) = scenario("get_contents_by_product_id")
      .exec(authObject.GetAuthtoken)
//      .exec(addCookie(Cookie("WPP_AUTH_TOKEN", "${X-WPP-AUTH-TOKEN}")))
      .forever(){
        pace(paceValue.seconds)
          .exec(contentObject.GetContentByProductID)
      }

  //Content API_Get_metadata_CK_objects
    def content_api_get_metadata_ck_objects(paceValue:Integer) = scenario("content_api_get_metadata_ck_objects")
      .exec(authObject.GetAuthtoken)
      .forever(){
        pace(paceValue.seconds)
          .exec(contentObject.GetContentMetadataByLearningObjectMapID)
          .exec(contentObject.GetContentMetadataLearningObjectAtom)
          .exec(contentObject.GetContentMetadataLocalizedLearningObjectAtom)
          .exec(contentObject.GetContentVersionByLearningObjectAtom)
          .exec(contentObject.GetContentVersionsLocalizedLearningObjectAtom)
      }

     def content_api_patch_contents_files(paceValue:Integer) = scenario("content_api_patch_contents_files")
       .exec(authObject.GetAuthtoken)
       .exec(contentObject.PostContentLOM)
       .exec(contentObject.PostContentMapLearningObjectAtom)
       .exec(contentObject.PostContentsHasTranslation)
       .forever(){
         pace(paceValue.seconds)
           .exec(contentObject.PatchCKContentFilesLOA)
           .exec(contentObject.PatchCKContentFilesLLOA)
       }

     def content_api_patch_metadata(paceValue:Integer) = scenario("content_api_patch_metadata")
       .exec(authObject.GetAuthtoken)
       .exec(contentObject.PostContentLOM)
       .exec(contentObject.PostContentMapLearningObjectAtom)
       .forever(){
         pace(paceValue.seconds)
           .exec(contentObject.PatchContentMetadataAtom)
           .exec(contentObject.PatchContentMetadataMap)
       }

     def content_api_post_contents_media_atom(paceValue:Integer) = scenario("content_api_post_contents_media_atom")
       .exec(authObject.GetAuthtoken)
       .forever(){
         pace(paceValue.seconds)
           .exec(contentObject.CreateContentMediaAtom)
       }

//  def samplescenario(paceValue: Integer) = scenario("samplescenario")
//    .exec(authObject.GetAuthtoken)
//    .exec(addCookie(Cookie("WPP_AUTH_TOKEN", "${X-WPP-AUTH-TOKEN}")))
//    .forever() {
//      pace(paceValue.seconds)
//        .exec(prerequisitesObjects.CreateBook)
//        .exec(prerequisitesObjects.CreateProject)
//        .exec(prerequisitesObjects.CreateEdPubProject)
//        .exec(tocObject.CreateTOC)
//        .exec(atomObject.CreateMediaAtomWithProjectIDs)
//        .exec(atomObject.CreateAnotherMediaAtomWithProjectIDs)
//        .exec(atomObject.CreateNarrativeAtom)
//        .exec(contentObject.GetContent)
//        .exec(contentObject.CreateContentMap)
//        .exec(contentObject.CreateAnotherContentMap)
//        .exec(contentObject.AssociateContentMapToContentMap)
//        .exec(contentObject.AssociateContentMapToTOC)
//        .exec(contentObject.AssociateMediaToContentMap)
//        .exec(contentObject.AssociateSubAtomToContentMap)
//        .exec(contentObject.DeleteAssociateContentMapToContentMap)
//        .exec(contentObject.DeleteAssociateContentMapToTOC)
//        .exec(contentObject.DeleteAssociateMediaToContentMap)
//        .exec(contentObject.DeleteAssociateSubAtomToContentMap)
//        .exec(patchContentObject.GetContentByVersionId0To10)
//        .exec(patchContentObject.GetContentByVersionId10To100)
//        .exec(patchContentObject.GetContentByVersion100To250)
//        .exec(patchContentObject.GetContentByVersion250To500)
//        .exec(patchContentObject.GetContentByVersion500To750)
//        .exec(patchContentObject.GetContentByVersion750To1GB)
//        .exec(patchContentObject.GetContentByVersionIdAbove1GB)
//    }

}
