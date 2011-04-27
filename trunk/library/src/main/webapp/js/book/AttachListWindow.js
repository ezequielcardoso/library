Ext.ns('Library.book.window');

Library.book.window.AttachListWindow = Ext.extend(Ext.Window, {

	grid : null,

	bookId : null,
	
	initComponent : function() {

		this.grid = new Ext.grid.GridPanel({
			id : 'fileGridPanel',
			width : 650,
			height : 350,
			autoScroll : false,
			cm : new Ext.grid.ColumnModel([ new Ext.grid.RowNumberer(), {
				header : '文件名',
				width : 100,
				sortable : true,
				align : 'center',
				dataIndex : 'attachmentName'
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
			} ]),
			store : new Ext.data.JsonStore({
				url : contextPath + '/attach/findByBookId.action',
				fields : [ {
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
				} ],
				storeInfo : {
					field : '列名',
					direction : 'ASC|DESC'
				}
			}),
			tbar : [{
				xtype : 'label',
				text : '双击下载文件'
			}]
		})

		Ext.apply(this, {
			title : '查看附件',
			width : 650,
			height : 400,
			items : [ this.grid ],
			buttons : [{
				text : '关闭',
				handler : function(){
					this.close();
				},
				scope : this
			} ]
		})
		Library.book.window.AttachListWindow.superclass.initComponent.call(this);
		
		this.grid.on('rowdblclick', function(){
			var record = this.getSelectionModel().getSelected();
			window.open(contextPath + "/attach/downLoadAttach.action?attachView.attachmentId=" + encodeURIComponent(record.get('attachmentId')));
		}, this.grid);
		
		this.grid.getStore().baseParams = {
			"attachView.bookId" : this.bookId
		};
		
		this.grid.getStore().load();
	}
});