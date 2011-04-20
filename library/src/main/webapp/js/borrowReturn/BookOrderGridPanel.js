Ext.ns('Library.bookOrder.grid');

Library.bookOrder.grid.BookOrderGridPanel = Ext.extend(Ext.grid.GridPanel, {

	id : 'bookOrderGridPanel',

	initComponent : function() {

		// 操作图书列表的工具条
		var tbar = new Ext.Toolbar({
					items : [{
								text : '导出Excel',
								handler : function() {

								}
							}, '-', {
								text : '图书标签',
								handler : function() {

								}
							}, '-', {
								text : '打印条形码',
								handler : function() {

								}
							}, '->', {
								xtype : 'label',
								text : '预约时间从：'
							}, '-', {
								xtype : 'datefield',
								width : 100,
								id : 'preOrderDate',
								format : 'Y-m-d'
							}, '-', {
								xtype : 'label',
								text : '到：'
							}, '-', {
								xtype : 'datefield',
								width : 100,
								id : 'endPreOrderDate',
								format : 'Y-m-d'
							}, '-', {
								xtype : 'label',
								text : '到期时间从：'
							}, '-', {
								xtype : 'datefield',
								width : 100,
								id : 'preOrderEndDate',
								format : 'Y-m-d'
							}, '-', {
								xtype : 'label',
								text : '到：'
							}, '-', {
								xtype : 'datefield',
								width : 100,
								id : 'endPreOrderEndDate',
								format : 'Y-m-d'
							}, '-', {
								text : '查询',
								handler : function() {
									this.queryBookOrder();
								},
								scope : this
							}, '-', {
								text : '刷新',
								handler : function() {
									this.onRefresh();
								},
								scope : this
							}]
				});

		var fields = [{
							name : 'id',
							type : 'int'
						}, {
							name : 'preOrderDate',
							type : 'date',
							dateFormat : 'm/d/Y'
						}, {
							name : 'preOrderEndDate',
							type : 'date',
							dateFormat : 'm/d/Y'
						}, {
							name : 'bookId',
							type : 'int'
						}, {
							name : 'bookNo',
							type : 'string'
						}, {
							name : 'bookBarCode',
							type : 'string'
						}, {
							name : 'bookName',
							type : 'string'
						}, {
							name : 'location',
							type : 'int'
						}, {
							name : 'firstCategoryId',
							type : 'float'
						}, {
							name : 'firstCategoryCode',
							type : 'string'
						}, {
							name : 'firstCategoryName',
							type : 'string'
						}, {
							name : 'bookStateId',
							type : 'string'
						}, {
							name : 'bookStateName',
							type : 'int'
						}, {
							name : 'readerId',
							type : 'int'
						}, {
							name : 'readerName',
							type : 'string'
						}, {
							name : 'cardNo',
							type : 'string'
						}, {
							name : 'readerBarCode',
							type : 'string'
						}, {
							name : 'unitId',
							type : 'int'
						}, {
							name : 'unitCode',
							type : 'string'
						}, {
							name : 'unitName',
							type : 'string'
						}, {
							name : 'readerTypeId',
							type : 'int'
						}, {
							name : 'readerCateCode',
							type : 'string'
						}, {
							name : 'readerCateName',
							type : 'string'
						}];

		var selectModel = new Ext.grid.CheckboxSelectionModel({
				// singleSelect : true
				});

		var store = new Ext.data.JsonStore({
					url : contextPath + '/preOreder/findPreOrders.action',
					totalProperty : 'totalProperty',
					root : 'root',
					baseParams : {
						'preOrderView.isBook' : 1
					},
					storeInfo : {
						field : '列名',
						direction : 'ASC|DESC'
					},
					fields : fields
				});

		var cm = new Ext.grid.ColumnModel([
					new Ext.grid.RowNumberer(),
					selectModel,
					 {
						header : '图书条形码',
						width : 100,
						sortable : true,
						align : 'center',
						dataIndex : 'bookBarCode'
					},{
						header : '读者条形码',
						width : 100,
						sortable : true,
						align : 'center',
						dataIndex : 'readerBarCode'
					},{
						header : '读者姓名',
						width : 100,
						sortable : true,
						align : 'center',
						dataIndex : 'readerName'
					}, {
						header : '书名',
						width : 80,
						sortable : true,
						align : 'center',
						dataIndex : 'bookName'
					}, {
						xtype : 'datecolumn',
						format: 'm/d/Y',
						header : '预约日期',
						width : 100,
						sortable : true,
						align : 'center',
						dataIndex : 'preOrderDate'
					}, {
						xtype : 'datecolumn',
						format: 'm/d/Y',
						header : '预约到期日期',
						width : 100,
						sortable : true,
						align : 'center',
						dataIndex : 'preOrderEndDate'
					}, {
						header : '图书状态',
						width : 80,
						sortable : true,
						align : 'center',
						dataIndex : 'bookStateName'
					}, {
						header : '图书类别',
						width : 80,
						sortable : true,
						align : 'center',
						dataIndex : 'firstCategoryName'
					}, {
						header : '读者单位',
						width : 100,
						sortable : true,
						align : 'center',
						dataIndex : 'unitName'
					}, {
						header : '读者类别',
						width : 80,
						sortable : true,
						align : 'center',
						dataIndex : 'readerCateName'
					}, {
						header : '存放位置',
						width : 80,
						sortable : true,
						align : 'center',
						dataIndex : 'location'
					}]);

		Ext.apply(this, {
					width : 1250,
					// height : document.documentElement.clientHeight * 0.82,
					height : 450,
					autoScroll : true,
					tbar : tbar,
					cm : cm,
					selModel : selectModel,
					store : store,
					stripeRows : true,
					columnLines : true,
					frame : false,
					loadMask : '正在加载......',
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
							})]),
					viewConfig : new Ext.grid.GridView({
								rowHeight : 23,
								scrollDelay : false,
								columnsText : '显示的列',
								scrollOffset : 30,
								sortAscText : '升序',
								sortDescText : '降序'
							})
				});

		Library.bookOrder.grid.BookOrderGridPanel.superclass.initComponent.call(this);

	},

	queryBookOrder : function() {
	   var readerBarCode = Ext.get('readerBarCode').getValue();
	   var readerName = Ext.get('readerName').getValue();
	   var unitName = Ext.get('unitName').getValue();
	   var bookBarCode = Ext.get('bookBarCode').getValue();
	   var bookName = Ext.get('bookName').getValue();
	   var firstCategoryName = Ext.get('firstCategoryName').getValue();
	   var preOrderDate = Ext.get('preOrderDate').getValue();
	   var endPreOrderDate = Ext.get('endPreOrderDate').getValue();
	   var preOrderEndDate = Ext.get('preOrderEndDate').getValue();
	   var endPreOrderEndDate = Ext.get('endPreOrderEndDate').getValue();
	   
	   this.getStore().baseParams = {
	       'preOrderView.readerBarCode' : readerBarCode,
	       'preOrderView.readerName' : readerName,
	       'preOrderView.unitName' : unitName,
	       'preOrderView.bookBarCode' : bookBarCode,
	       'preOrderView.bookName' : bookName,
	       'preOrderView.firstCategoryName' : firstCategoryName,
	       'preOrderView.preOrderDate' : preOrderDate,
	       'preOrderView.endPreOrderDate' : endPreOrderDate,
	       'preOrderView.preOrderEndDate' : preOrderEndDate,
	       'preOrderView.endPreOrderEndDate' : endPreOrderEndDate,
		   'preOrderView.isBook' : 1

		}
		this.getStore().load({
					params : {
						start : 0,
						limit : BooksPageSize
					}
				});
	},

	onRefresh : function() {

		this.getStore().baseParams = {
			'preOrderView.isBook' : 1
		};

		this.getStore().load({
					params : {
						'start' : 0,
						'limit' : BooksPageSize
					}
				});
	}

});
