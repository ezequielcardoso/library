Ext.ns('Files');

Files.SelectPanel = Ext.extend(Ext.Panel, {
	
	id: 'Files_SelectPanel',
	files: [],

	name: null,
	fileType: null,
	uploadPath: null,
	buttonText: null,
	buttonHidden: false,//是否隐藏添加文件按钮
	fileTypes: null,//要选择上传的文件类型
	fileTypesDescription: null,//要选择上传的文件类型的描述
	
	modelId: null,//有实体ID时查询显示附件文件
	
	initComponent: function(){
		this.files = [];
		Ext.applyIf(this, {
            layout: 'hbox',
        	border: false,
        	autoHeight: true,
            layoutConfig: {
                align: 'top'
            },
            style: (this.fieldLabel) ? '' : 'margin-left: 70px;',
            items: [new Ext.Panel({
            	border: false,
            	width: (this.buttonText) ? (this.buttonText.length*15+10) : 70,
            	height: (this.fieldLabel) ? 'auto' : 26,
        		items: [{
        			xtype: 'button',
        			text: (this.buttonText) ? this.buttonText : '添加附件',
        			hidden: this.buttonHidden,
        			handler: function(){
        				this.addFile();
        			},
        			scope: this
        		}, {
        			hidden: true,
        			xtype: 'textfield',
        			id: 'files_select_oids',
        			name: this.name
        		}]
            }),  new Ext.Panel({
            	border: false,
            	defaults: {anchor:'98%'},
            	autoHeight: true,
        		html: '<div id="files_select_names"></div>'
            })]
        });
        Files.SelectPanel.superclass.initComponent.apply(this, arguments);
        
        if(this.modelId){
        	this.loadAttach();
        }
	},
	
	//添加附件
    addFile: function(){
    	var dialog = new Files.UploadWindow({
			uploadUrl : contextPath + '/files/uploadFiles.do',
			fileTypes : (this.fileTypes) ? this.fileTypes : '*.*', // 在这里限制文件类型:'*.jpg,*.png,*.gif'
			fileTypesDescription : (this.fileTypesDescription) ? this.fileTypesDescription : '所有文件',
			listeners : {
				'allfileuploaded' : function(p, f, jsonData){
					if(!this.files)this.files = [];
					for(var i=0; i<jsonData.length; i++){
						this.files.push(jsonData[i]);
					}
					setFilesName();
				},
				scope: this
			}
		})
		dialog.show();
    },
    
    //显示已有的附件文件
    loadAttach: function(){
		var store = new Ext.data.JsonStore({
			url : contextPath + 'common/files/listFiles.do?modelId=' + this.modelId,
			fields : ['oid', 'oldFileName', 'fileName', 'oldFilePath', 'contentType', 'fileSize']
		});	
		store.on('load', function(s, records, options){
			var count = store.getCount();
			if(count > 0){
				if(!this.files)this.files = [];
				for(var i=0; i<count; i++){
					var data = store.getAt(i).data;
					this.files.push(data);
				}
				setFilesName();
			}
		}, this);
		store.on("loadexception", function(obj, options, response, e) {});			
		store.load();
	}
});
Ext.reg('fileselectpanel', Files.SelectPanel);
//设置显示附件名称
function setFilesName(){
	var fileIds = [];
	var form = Ext.getCmp('Files_SelectPanel');
	var text = '';
	for(var i=0; i<form.files.length; i++){
		var data = form.files[i];
		fileIds.push(data.oid);
		text += "<p class='boa-attach' style='width:100%; height:18px;'>&nbsp;&nbsp;&nbsp;"+data.oldFileName+"&nbsp;&nbsp;" +
				"<a onclick=deletefile('"+data.oid+"')>删除</a>" +
				"</p>";
	}
    var el = Ext.fly('files_select_names');
    el.update(text);
    form.doLayout();
    Ext.getCmp('files_select_oids').setValue(fileIds);
}
//删除已经添加的附件
function deletefile(oid){
	var form = Ext.getCmp('Files_SelectPanel');
	for(var i=0; i<form.files.length; i++){
		var data = form.files[i];
		if(data.oid == oid){
			form.files.remove(data);
			break;
		}
	}
	setFilesName();
}
