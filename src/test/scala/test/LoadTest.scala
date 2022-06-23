package test

import io.gatling.core.Predef._
import scripts._

import scala.concurrent.duration.DurationInt


class LoadTest() extends BaseTest("loadTest") {
  setUp(
//    scripts.Content_API_CPUBTest(getPace("Content_API_CPUBTest"))
//      .inject(rampUsers(getUsers("Content_API_CPUBTest")) during
//        rampDurationLong.minutes),

//    scripts.get_contents_by_product_id(getPace("get_contents_by_product_id"))
//      .inject(rampUsers(getUsers("get_contents_by_product_id")) during
//        rampDurationLong.minutes),

//    scripts.content_api_patch_content_files_cpub(getPace("content_api_patch_content_files_cpub"))
//      .inject(rampUsers(getUsers("content_api_patch_content_files_cpub")) during
//        rampDurationLong.minutes),

//    scripts.content_api_get_metadata_ck_objects(getPace("content_api_get_metadata_ck_objects"))
//      .inject(rampUsers(getUsers("content_api_get_metadata_ck_objects")) during
//        rampDurationLong.minutes),

//    scripts.content_api_patch_contents_files(getPace("content_api_patch_contents_files"))
//      .inject(rampUsers(getUsers("content_api_patch_contents_files")) during
//        rampDurationLong.minutes),

//    scripts.content_api_patch_metadata(getPace("content_api_patch_metadata"))
//      .inject(rampUsers(getUsers("content_api_patch_metadata")) during
//        rampDurationLong.minutes),

      scripts.content_api_post_contents_media_atom(getPace("content_api_post_contents_media_atom"))
        .inject(rampUsers(getUsers("content_api_post_contents_media_atom")) during
          rampDurationLong.minutes)



  ).maxDuration(testDuration.minutes).protocols(httpProtocol)
// This is sample changes done for workspace

}
