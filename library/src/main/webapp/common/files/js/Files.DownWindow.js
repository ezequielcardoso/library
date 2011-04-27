Ext.ns('Files');

Files.FileDownWindow = Ext.extend(Ext.Window,{

	id : 'FileDownWindow',
	
	initComponent : function(){
	
	
	   var sm = new Ext.grid.CheckboxSelectionModel();
		
		var cm = new Ext.grid.ColumnModel([new Ext.grid.RowNumberer(), sm, {
					header : '文件名',
					width : 100,
					sortable : true,
					align : 'center',
					dataIndex : 'attachmentName'
				}, {
					header : '存储路径',
					width : 100,
					sortable : true,
					align : 'center',
					dataIndex : 'attachmentSavePath'
				}, {
					header : '文件类型',
					width : 100,
					sortable : true,
					align : 'center',
					dataIndex : 'attachmentFileType'
				}, {
					header : '文件大小',
					width : 100,
					sortable : true,
					align : 'center',
					dataIndex : 'attachmentSize'
				}, {
					header : '上传日期',
					width : 100,
					sortable : true,
					align : 'center',
					xtype : 'datecolumn',
                    format : 'Y-m-d',
					dataIndex : 'attachmentUploadDate'
				}, {
					header : '上传人',
					width : 100,
					sortable : true,
					align : 'center',
					dataIndex : 'attachmentUploadMan'
				}]);

	var fields = [{
					name : 'attachmentId',
					type : 'int'
				}, {
					name : 'attachmentName',
					type : 'string'
				}, {
					name : 'attachmentSavePath',
					type : 'string'
				}, {
					name : 'attachmentFileType',
					type : 'string'
				}, {
					name : 'attachmentSize',
					type : 'int'
				}, {
					name : 'attachmentUploadDate',
					 type : 'date'
				}, {
					name : 'attachmentUploadMan',
					type : 'string'
				}];

		var store = new Ext.data.JsonStore({
					url : contextPath + '/book/findBookById.action',
//					root : 'root',
//					totalProperty : 'totalProperty',
//					baseParams : {
//						'start' : 0,
//						'limit' : PressesPageSize
//					},
					fields : fields,
					storeInfo : {
						field : '列名',
						direction : 'ASC|DESC'
					}
				});			
	 var gridPanel = new Ext.grid.GridPanel({   
           id : 'fileGridPanel',
           width : 650,
	       height : 350,
           autoScroll: false,
           sm : sm,
		   cm : cm,
		   store : store
		      })	
				
	  Ext.apply(this,{
	    title : '文件下载',
	  	width : 650,
	  	height : 400,
//	  	modal:true,
	  	items:[gridPanel],
		buttons:[
		{
		  xtype:'button',
		  text:'下载'
		},
		{
		  xtype:'button',
		  text:'关闭',
		  handler : this.onClose,
		  scope : this
		}]
	 })
	Files.FileDownWindow.superclass.initComponent.call(this);
//    this.gridPanel.store.load();
	}
});