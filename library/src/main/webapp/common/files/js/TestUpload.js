/**
 * 测试上传文件
 * 
 * 测试时引入该js即可
 * 
 * 同时要引入以下文件
 * /files/css/UploadPanel.css
 * /files/swfu/swfupload.js
 * /files/js/Files.UploadWindow.js
 */
Ext.onReady(function(){
	Ext.BLANK_IMAGE_URL = contextPath + '/common/extjs3.2/resources/images/default/s.gif';
	Ext.QuickTips.init();
	Ext.form.Field.prototype.msgTarget = 'side';

	var dialog = new Files.UploadWindow({
		fileSize : '500 MB',
		uploadUrl : contextPath + '/files/uploadFiles.action',
		fileTypes : '*.doc', // 在这里限制文件类型:'*.jpg,*.png,*.gif'
		fileTypesDescription : 'Word文件',
		listeners : {
			'allfileuploaded' : function(p, f, jsonData){
				for(var i=0; i<jsonData.length; i++){
					var data = jsonData[i];
					alert('新名称：'+data.fileName);
				}
			},
			'allfileoid': function(allfileoid){
				for(var i=0; i<allfileoid.length; i++){
					alert('文件['+(i+1)+']ID：'+allfileoid[i]);
				}
			}
		}
	})
	dialog.show();

});