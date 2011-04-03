Ext.ns('Library.magazine.grid');

Library.magazine.grid.MagazineGridPanel = Ext.extend(Ext.grid.GridPanel, {

			id : 'magazineGridPanel',

			initComponent : function() {

				// 操作图书列表的工具条
				var tbar = new Ext.Toolbar({
							items : [{
										text : '查询',
										handler : function() {

										}
									}, {
										text : '修改',
										handler : function() {

										}
									}, {
										text : '增加',
										handler : function() {
											this.addMagazine();
										},
										scope : this
									}, {
										text : '删除',
										handler : function() {
											this.deleteMagazine();
										},
										scope : this
									}, {
										text : '导入',
										handler : function() {

										}
									}, {
										text : '导出Excel',
										handler : function() {

										}
									}, {
										text : '图书标签',
										handler : function() {

										}
									}, {
										text : '打印条形码',
										handler : function() {

										}
									}]
						});

				var fields = ["name1", "name2", "name3", "name4", "name5",
						"name6", "name7", "name8", "name9", "name10"];
				/*
				 * [{ name : 'magazineId', type : 'int' }, { name : 'barCode',
				 * type : 'string' }, { name : 'magazineName', type : 'string' }, {
				 * name : 'magazineDesc', type : 'string' }, { name : 'donator',
				 * type : 'string' }, { name : 'author', type : 'string' }, {
				 * name : 'translator', type : 'string' }, { name : 'ISBN', type :
				 * 'string' }, { name : 'ISSN', type : 'string' }, { name :
				 * 'emailNo', type : 'string' }, { name : 'stage', type :
				 * 'string' }, { name : 'allStage', type : 'string' }, { name :
				 * 'pages', type : 'int' }, { name : 'price', type : 'float' }, {
				 * name : 'publisherDate', type : 'string' }, { name :
				 * 'quantity', type : 'int' }, { name : 'location', type :
				 * 'string' }, { name : 'revision', type : 'int' }, { name :
				 * 'searchMagazineId', type : 'string' }, { name : 'speciesId',
				 * type : 'string' }, { name : 'spell', type : 'string' }, {
				 * name : 'storeDate', type : 'string' }, { name : 'MagazineNo',
				 * type : 'string' }, { name : 'isMagazine', type : 'boolean' }, {
				 * name : 'firstCategoryId', type : 'string' }, { name :
				 * 'firstCategoryName', type : 'string' }, { name :
				 * 'secondCategoryId', type : 'string' }, { name :
				 * 'secondCategoryName', type : 'string' }, { name :
				 * 'hasAttachment', type : 'string' }, { name :
				 * 'magazineStateId', type : 'string' }, { name :
				 * 'magazineStateName', type : 'string' }, { name :
				 * 'magazineLevelId', type : 'string' }, { name :
				 * 'magazineLevelName', type : 'string' }, { name :
				 * 'securityId', type : 'string' }, { name : 'securityName',
				 * type : 'string' }, { name : 'currencyId', type : 'string' }, {
				 * name : 'pressId', type : 'string' }, { name : 'pressName',
				 * type : 'string' }, { name : 'resourceId', type : 'string' }, {
				 * name : 'resourceName', type : 'string' }];
				 */

				var selectModel = new Ext.grid.CheckboxSelectionModel();
				var mydata = [[1, 1, 1, 1, 1, 1, 1, 1, 1, 1],
						[2, 2, 2, 2, 2, 2, 2, 2, 2, 2],
						[3, 3, 3, 3, 3, 3, 3, 3, 3, 3],
						[4, 4, 4, 4, 4, 4, 4, 4, 4, 4],
						[5, 5, 5, 5, 5, 5, 5, 5, 5, 5],
						[5, 5, 5, 5, 5, 5, 5, 5, 5, 5],
						[6, 6, 6, 6, 6, 6, 6, 6, 6, 6],
						[7, 7, 7, 7, 7, 7, 7, 7, 7, 7],
						[8, 8, 8, 8, 8, 8, 8, 8, 8, 8],
						[9, 9, 9, 9, 9, 9, 9, 9, 9, 9],
						[10, 10, 10, 10, 10, 10, 10, 10, 10, 10]];
				var store = new Ext.data.SimpleStore({
							/*
							 * url : contextPath + '/book/findBooks.action',
							 * totalProperty : 'totalProperty', root : 'root',
							 * baseParams : { "bookView.isBook" : 0 }, storeInfo : {
							 * field : '列名', direction : 'ASC|DESC' },
							 */

							fields : fields,
							data : mydata
						});

				var colM = new Ext.grid.ColumnModel([
						new Ext.grid.RowNumberer(), selectModel, {
							header : '编号',
							dataIndex : 'name1',
							sortable : true,
							width : 80,
							align : 'center'
						}, {
							header : '名称',
							dataIndex : 'name2',
							width : 80,
							sortable : true,
							align : 'center'
						}, {
							header : '分类号',
							dataIndex : 'name3',
							width : 80,
							sortable : true,
							align : 'center'
						}, {
							header : '作者',
							dataIndex : 'name4',
							width : 80,
							sortable : true,
							align : 'center'
						}, {
							header : '种次号',
							dataIndex : 'name5',
							width : 80,
							sortable : true,
							align : 'center'
						}, {
							header : '数量',
							dataIndex : 'name6',
							width : 80,
							sortable : true,
							align : 'center'
						}, {
							header : '入库时间',
							dataIndex : 'name7',
							width : 80,
							sortable : true,
							align : 'center'
						}, {
							header : '页数',
							dataIndex : 'name8',
							width : 80,
							sortable : true,
							align : 'center'
						}, {
							header : '附件',
							dataIndex : 'name9',
							width : 80,
							sortable : true,
							align : 'center'
						}, {
							header : '状态',
							dataIndex : 'name10',
							width : 80,
							sortable : true,
							align : 'center'
						}]);

				Ext.apply(this, {
					width : 1140,
					// height : document.documentElement.clientHeight * 0.82,
					height : 300,
					autoScroll : true,
					tbar : tbar,
					cm : colM,
					selModel : selectModel,
					store : store,
					stripeRows : true,
					columnLines : true,
					frame : false,
					bbar : new Ext.Toolbar([new Ext.PagingToolbar({
								store : store,
								pageSize : BooksPageSize,
								afterPageText : '/ {0}',
								beforePageText : '页',
								displayInfo : true,
								firstText : '第一页',
								prevText : '前一页',
								nextText : '后一页',
								lastText : '最后一页',
								refreshText : '刷新',
								displayMsg : '显示第 {0}-{1}条 共{2}条 ',
								emptyMsg : '没有数据'
							})])
						// view : new Ext.ux.grid.BufferView({
						// rowHeight : 23,
						// scrollDelay : false,
						// columnsText : '显示的列',
						// scrollOffset : 30,
						// sortAscText : '升序',
						// sortDescText : '降序'
						// })
					});

				Library.magazine.grid.MagazineGridPanel.superclass.initComponent
						.call(this);

				// 增加事件监听
				this.addListener('rowdblclick', function() {
							// alert("dadas");
							// alert(123);
							var win = new Ext.Window({
										title : '详细信息',
										width : 350,
										height : 500,
										autoScroll : true,
										
										// html:'<div>dadsa</div>'
										items : [
											new Ext.form.FormPanel({
											    bodyStyle: 'padding:15px',
											    autoWidth:true ,
											    frame:true,
											    border : false,
											    autoHeight:true,
											    //height:433,
											    items: [{
											    		xtype:'textfield',
											            fieldLabel: '期刊编号',
											            name: 'first',
											            height:30,
											            allowBlank: false
											            //labelSeparator: ':' // override labelSeparator layout config
											        },{
											            xtype:'textfield',
											            fieldLabel: '期刊编号',
											            name: 'first',
											            height:30,
											            allowBlank: false
											        },{
											            xtype:'textfield',
											            fieldLabel: '期刊编号',
											            name: 'first',
											            height:30,
											            allowBlank: false
											        },{
											            xtype:'textfield',
											            fieldLabel: '期刊编号',
											            name: 'first',
											            height:30,
											            allowBlank: false
											        },{
											            xtype:'textfield',
											            fieldLabel: '期刊编号',
											            name: 'first',
											            height:30,
											            allowBlank: false
											        },{
											            xtype:'textfield',
											            fieldLabel: '期刊编号',
											            name: 'first',
											            height:30,
											            allowBlank: false
											        },{
											            xtype:'textfield',
											            fieldLabel: '期刊编号',
											            name: 'first',
											            height:30,
											            allowBlank: false
											        },{
											            xtype:'textfield',
											            fieldLabel: '期刊编号',
											            name: 'first',
											            height:30,
											            allowBlank: false
											        },{
											            xtype:'textfield',
											            fieldLabel: '期刊编号',
											            name: 'first',
											            height:30,
											            allowBlank: false
											        },{
											            xtype:'textfield',
											            fieldLabel: '期刊编号',
											            name: 'first',
											            height:30,
											            allowBlank: false
											        },{
											            xtype:'textfield',
											            fieldLabel: '期刊编号',
											            name: 'first',
											            height:30,
											            allowBlank: false
											        },{
											            xtype:'textfield',
											            fieldLabel: '期刊编号',
											            name: 'first',
											            height:30,
											            allowBlank: false
											        },{
											            xtype:'textfield',
											            fieldLabel: '期刊编号',
											            name: 'first',
											            height:30,
											            allowBlank: false
											        },{
											            xtype:'textfield',
											            fieldLabel: '期刊编号',
											            name: 'first',
											            height:30,
											            allowBlank: false
											        },{
											            xtype:'textfield',
											            fieldLabel: '期刊编号',
											            name: 'first',
											            height:30,
											            allowBlank: false
											        },{
											            xtype:'textfield',
											            fieldLabel: '期刊编号',
											            name: 'first',
											            height:30,
											            allowBlank: false
											        },{
											            xtype:'textfield',
											            fieldLabel: '期刊编号',
											            name: 'first',
											            height:30,
											            allowBlank: false
											        },{
											            xtype:'textfield',
											            fieldLabel: '期刊编号',
											            name: 'first',
											            height:30,
											            allowBlank: false
											        },{
											            xtype:'textfield',
											            fieldLabel: '期刊编号',
											            name: 'first',
											            height:30,
											            allowBlank: false
											        },{
											            xtype:'textarea',
											            fieldLabel: '期刊编号',
											            name: 'first',
											            height:30,
											            width:70,
											            allowBlank: false
											        }
											    ]
											})
										],
										buttons : [{
													text : "确定"
												}, {
													text : "取消",
													handler : function() {
														_window.hide();
													}
												}]
									});
							win.show();

						}, this);

				this.addListener('rowclick', function() {

						}, this);

			},

			addMagazine : function() {
				window.location = contextPath + '/book/showSaveMagazine.action';
			},

			updateMagazine : function() {

			},

			deleteMagazine : function() {
				var sm = this.getSelectionModel();
				alert(sm);
				var thiz = this;
				if (sm.hasSelection()) {
					var record = sm.getSelected();
					var magazineId = record.get('magazineId');
					alert(magazineId);
					Ext.Ajax.request({
								url : contextPath + '/book/deleteBook.action',
								method : 'POST',
								params : {
									bookId : magazineId
								},
								success : function(resp) {
									alert('成功从服务器返回');
									var respText = resp.responseText;
									var obj = Ext.util.JSON.decode(respText);
									alert(obj);
								},
								failure : function() {
									alert('服务器异常');
								}
							});
				}
			}
		});
function showAll() {
	var inner = new Ext.Panel({
				title : 'Same panel as above with preventBodyReset: false',
				normal : false,
				// renderTo: 'panel-reset-false',
				width : 400,
				html : '<div>dadsd</div>'
			});
}
