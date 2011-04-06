Ext.ns('Library.readerType.grid');

Library.readerType.grid.ReaderTypeGridPanel = Ext.extend(
		Ext.grid.EditorGridPanel, {

			id : 'readerTypeGridPanel',

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
											// this.onMOdify();
										},
										scope : this
									}, {
										text : '删除',
										handler : function() {
											// this.onDelete();
										},
										scope : this
									}, {
										text : '增加',
										handler : function() {
											// this.onAdd();
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
										text : '打印',
										handler : function() {
										}
									}]
						});

				var sm = new Ext.grid.CheckboxSelectionModel();

				var cm = new Ext.grid.ColumnModel([new Ext.grid.RowNumberer(),
						sm, {
							header : '类别编码',
							width : 120,
							sortable : true,
							align : 'center',
							editor : new Ext.form.TextField({
										allowBlank : true
									}),
							dataIndex : 'pressISBN'
						}, {
							header : '类别名称',
							width : 300,
							sortable : true,
							align : 'center',
							editor : new Ext.form.TextField({
										allowBlank : false
									}),
							dataIndex : 'pressName'
						}, {
							header : '借阅天数',
							width : 120,
							sortable : true,
							align : 'center',
							editor : new Ext.form.TextField({
										allowBlank : false
									}),
							dataIndex : 'pressAddress'
						}, {
							header : '借阅数量',
							width : 120,
							sortable : true,
							align : 'center',
							editor : new Ext.form.TextField({
										allowBlank : false
									}),
							dataIndex : 'zipCode'
						}, {
							header : '租金',
							width : 120,
							sortable : true,
							align : 'center',
							editor : new Ext.form.TextField({
										allowBlank : false
									}),
							dataIndex : 'zipCode'
						}]);

				var fields = [{
							name : 'id',
							type : 'int'
						}, {
							name : 'readerCateCode',
							type : 'string'
						}, {
							name : 'readerCateName',
							type : 'string'
						}, {
							name : 'borrowDays',
							type : 'int'
						}, {
							name : 'borrowedQuantity',
							type : 'int'
						}, , {
							name : 'rent',
							type : 'float'
						}];

				var store = new Ext.data.JsonStore({
							url : contextPath + '/book/findReaderTypes.action',
							root : 'root',
							totalProperty : 'totalProperty',
							baseParams : {
								'start' : 0,
								'limit' : ReaderTypesPageSize
							},
							fields : fields,
							storeInfo : {
								field : '列名',
								direction : 'ASC|DESC'
							}
						});

				var bbar = new Ext.Toolbar([new Ext.PagingToolbar({
							store : store,
							pageSize : ReaderTypesPageSize,
							afterPageText : '/ {0}',
							beforePageText : '页',
							displayInfo : true,
							firstText : '第一页',
							prevText : '前一页',
							nextText : '后一页',
							lastText : '最后一页',
							refreshText : '刷新',
							displayMsg : '显示第 {0}-{1}条  共{2}条 ',
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
							loadMask : '正在加载......',
							clicksToEdit : 1,
							viewConfig : new Ext.grid.GridView({
										rowHeight : 23,
										scrollDelay : false,
										columnsText : '显示的列',
										scrollOffset : 30,
										sortAscText : '升序',
										sortDescText : '降序'
									})
						});

				Library.readerType.grid.ReaderTypeGridPanel.superclass.initComponent
						.call(this);
			}
		});