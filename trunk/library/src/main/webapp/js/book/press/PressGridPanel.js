Ext.ns('Library.press.grid');

Library.press.grid.PressGridPanel = Ext.extend(Ext.grid.EditorGridPanel, {

			id : 'pressGridPanel',

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
//											this.onMOdify();
										},
										scope : this
									}, {
										text : '删除',
										handler : function() {

										}
									}, {
										text : '增加',
										handler : function() {
                                           this.onAdd();   
										},
										scope:this
									}, {
										text : '导入',
										handler : function() {

										}
									}, {
										text : '导出Excel',
										handler : function() {

										}
									}, {
										text : '打印',
										handler : function() {
										}
									}]
						});

				var sm = new Ext.grid.CheckboxSelectionModel();

				var cm = new Ext.grid.ColumnModel([new Ext.grid.RowNumberer(),
						sm, {
							header : '代码',
							width : 100,
							sortable : true,
							editor : new Ext.form.TextField({
										allowBlank : true
									}),
							dataIndex : 'pressISBN'
						}, {
							header : '名称',
							width : 300,
							sortable : true,
							editor : new Ext.form.TextField({
									}),
							dataIndex : 'pressName'
						}, {
							header : '出版地',
							width : 300,
							sortable : true,
							editor : new Ext.form.TextField({}),
							dataIndex : 'pressAddress'
						}, {
							header : '邮编',
							width : 100,
							sortable : true,
							editor : new Ext.form.TextField({
									}),
							dataIndex : 'zipCode'
						}]);

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

				var store = new Ext.data.JsonStore({
							url : contextPath + '/book/findPresses.action',
							root : 'root',
							baseParams : {
								'start' : 0,
								'limit' : PressesPageSize
							},
							fields : fields,
							storeInfo : {
								field : '列名',
								direction : 'ASC|DESC'
							}
						});

				var bbar = new Ext.Toolbar([new Ext.PagingToolbar({
							store : store,
							pageSize : PressesPageSize,
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
						})]);

				Ext.apply(this, {
							width : 1000,
							height : 400,
							autoScroll : true,
							tbar : tbar,
							sm : sm,
							cm : cm,
							store : store,
							stripeRows : true,
							columnLines : true,
							frame : true,
							bbar : bbar,
							clicksToEdit: 1,
							viewConfig : new Ext.grid.GridView({
										rowHeight : 23,
										scrollDelay : false,
										columnsText : '显示的列',
										scrollOffset : 30,
										sortAscText : '升序',
										sortDescText : '降序'
									})
						});

				Library.press.grid.PressGridPanel.superclass.initComponent
						.call(this);

				this.on('afteredit', function() {

//							Ext.Msg.alert('提示','添加成功');

				});
			},
			onQuery : function() {

			},

			onMOdify : function() {
				
				
				
			},

			onDelete : function() {

			},
			onAdd : function() {
				var Press = this.getStore().recordType;
				var p = new Press({
							pressISBN : 'A23455',
							pressName : '电子工业出版社',
							pressAddress : '武汉协会',
							zipCode : '121212'
						});
				this.stopEditing();
				this.store.insert(0, p);
				this.startEditing(0, 0);
			},
			onImport : function() {

			},
			onExport : function() {

			},
			onPrint : function() {

			}

		});
