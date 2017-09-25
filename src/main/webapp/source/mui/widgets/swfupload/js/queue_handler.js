/**
 * SWFUpload 已上传成功数量控制   插件
 * 功能说明:
 *        对已上传成功的文件数量进行控制
 * 作   者: Alfa.wu
 * 版   本: 1.0
 * 日   期: 2014-05-15
 * 依   赖: swfupload 2.5
 * 示   例: 
 *        var swf = new SWFUpload(settings);
 *      swf.subUploadedCount(1); // 递减 一个已经上传成功的数量;
 *      swf.plusUploadedCount(1); // 加 一个已经上传成功的数量;
 *      swf.resetUploadedCount(); // 重置 已经上传成功的数量,即为0;
 */

var SWFUpload;
if (typeof(SWFUpload) === "function") {

    //     减 上传成功的文件总数
    //    @param optCount 要移除的数量
    //    @auhtor WUYF
    SWFUpload.prototype.subUploadedCount = function(optCount){
          var stats = this.getStats();
          stats.successful_uploads = stats.successful_uploads - optCount;
          if(stats.successful_uploads < 0){
              stats.successful_uploads = 0;
          }
          this.setStats(stats);
    };
    
    //     加 上传成功的文件总数
    //    @param optCount 要添加的数量
    //    @auhtor WUYF
    SWFUpload.prototype.plusUploadedCount = function(optCount){
          var stats = this.getStats();
          stats.successful_uploads = stats.successful_uploads + optCount;
          this.setStats(stats);
    };
    
    //     重置 上传成功的文件总数
    //    @auhtor WUYF
    SWFUpload.prototype.resetUploadedCount = function(){
          var stats = this.getStats();
          stats.successful_uploads = 0;
          this.setStats(stats);
    };
}