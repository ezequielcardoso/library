Ext.ns('Library.book.press');

Library.book.press.PressGridPanel = Ext.extend(Ext.grid.GridPanel, {

    id:'pressGridPanel',
	
	initComponent : function() {
		
		var tbar = new Ext.Toolbar({
					items : [{
								text : '查询',
								handler : function() {

								}
							}, {
								text : '删除',
								handler : function() {
								}
							}, {
								text : '修改',
								handler : function() {
								}
							}, {
								text : '增加',
								handler : function() {
								},
								scope : this
							}, {
								text : '批量导入',
								handler : function() {
								}
							}, {
								text : '导出excel',
								handler : function() {
								}
							}, {
								text : '打印',
								handler : function() {
								}
							}]
				});

		var data = [[1, '7-5336', '安徽教育出版社', '合肥', '230063'],
				[2, '7-5337', '安徽科学技术出版社', '合肥', '230063'],
				[3, '7-5398', '安徽美术出版社', '合肥', '230063']];

		var fields = [{
					name : 'pressId',
					type : 'int'
				}, {
					name : 'pressISBN',
					type : 'string'
				}, {
					name : 'pressName',
					type : 'string'
				}, {
					name : 'pressAddress',
					type : 'string'
				}, {
					name : 'zipCode',
					type : 'string'
				}];

		var store = new Ext.data.SimpleStore({
					data : data,
					fields : fields
				});
		
		var cm = new Ext.grid.ColumnModel({
			header:'id',
			dataIndex:'pressId'
		},{
			header:'出版社代码',
			dataIndex:'pressISBN'
		},{
			header:'名称',
			dataIndex:'pressName'
		},{
			header:'出版地',
			dataIndex:'pressAddress'
		},{
			header:'邮编',
			dataIndex:'zipCode'
		});		

		Ext.apply(this, {
//					title : '出版社列表',
			height : 600,
					width : 300,
					tbar : tbar,
					store : store,
					cm :cm
//					re
				});
				
		Library.book.press.PressGridPanel.superclass.initComponent.call(this);
	}
});