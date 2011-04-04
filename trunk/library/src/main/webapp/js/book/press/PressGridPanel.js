Ext.ns('Library.press.grid');

Library.press.grid.PressGridPanel = Ext.extend(Ext.grid.EditorGridPanel, {

			id : 'pressGridPanel',

			initComponent : function() {

				Ext.grid.EditorGridPanel.superclass.initComponent.call(this);

				// 操作图书列表的工具条
				var tbar = new Ext.Toolbar({
							items : [{
										text : '查询',
										handler : onQuery
									}, {
										text : '修改',
										handler : onMOdify
									}, {
										text : '删除',
										handler : onDelete
									}, {
										text : '增加',
										handler : onAdd
									}, {
										text : '导入',
										handler : onImport
									}, {
										text : '导出Excel',
										handler : onExport
									}, {
										text : '打印',
										handler : onPrint
									}]
						});

				var cm = new Ext.grid.ColumnModel([{
							header : "代码",
							width : 60,
							sortable : true,
							dataIndex :''
						},{
							header : "名称",
							width : 60,
							sortable : true,
							dataIndex :''
						},{
							header : "出版地",
							width : 60,
							sortable : true,
							dataIndex :''
						},{
							header : "邮编",
							width : 60,
							sortable : true,
							dataIndex :''
						}]);
				
				var store = new Ext.data.JsonStore({
					    url: 'get-images.php',
					    storeId: 'myStore',
					    // reader configs
					    root: 'images',
					    idProperty: 'name',
					    fields: fields

				});		
						
				Ext.apply(this, {

							width : 1000,
							// height : document.documentElement.clientHeight *
							// 0.82,
							height : 300,
							autoScroll : true,
							tbar : tbar,
							cm : cm,
                            store:store 
						});

			}

		});