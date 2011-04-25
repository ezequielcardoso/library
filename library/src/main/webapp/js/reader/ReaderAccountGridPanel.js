Ext.ns('Library.readerAccount.grid');

Library.readerAccount.grid.ReaderAccountGridPanel = Ext.extend(Ext.grid.GridPanel, {

	id : 'readerAccountGridPanel',

	initComponent : function() {

		// 操作图书列表的工具条
		var tbar = new Ext.Toolbar({
					items : [{
								text : '导出Excel',
								iconCls : 'library-export-excel',
								handler : function() {
                                  this.onExport();
								},
								scope : this
							}/**, '-', {
								text : '图书标签',
								handler : function() {

								}
							}, '-', {
								text : '打印条形码',
								handler : function() {

								}
							}*/, '-', {
								xtype : 'label',
								text : '收费时间从：'
							}, '-', {
								xtype : 'datefield',
								width : 100,
								id : 'operatorDate',
								format : 'Y-m-d'
							}, '-', {
								xtype : 'label',
								text : '到：'
							}, '-', {
								xtype : 'datefield',
								width : 100,
								id : 'endOperatorDate',
								format : 'Y-m-d'
							}, '-', {
								text : '查询',
								iconCls : 'library-query',
								handler : function() {
									this.queryReaderAccount();
								},
								scope : this
							}, '-', {
								text : '刷新',
								iconCls : 'library-refresh',
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
							name : 'punishMoney',
							type : 'float'
						}, {
							name : 'eventsDesc',
							type : 'string'
						}, {
							name : 'operatorDate',
							type : 'date'
//							dateFormat : 'm/d/Y'
						},  {
							name : 'operator',
							type : 'string'
						}, {
							name : 'chargeId',
							type : 'string'
						}, {
							name : 'chargeName',
							type : 'string'
						}, {
							name : 'readerId',
							type : 'int'
						}, {
							name : 'readerName',
							type : 'string'
						}, {
							name : 'readerBarCode',
							type : 'string'
						},{
							name : 'unitId',
							type : 'int'
						}, {
							name : 'unitName',
							type : 'string'
						}, {
							name : 'readerTypeId',
							type : 'int'
						}, {
							name : 'readerCateName',
							type : 'string'
						}];

		var store = new Ext.data.JsonStore({
					url : contextPath + '/punishment/findPunishments.action',
					totalProperty : 'totalProperty',
					root : 'root',
					storeInfo : {
						field : '列名',
						direction : 'ASC|DESC'
					},
					fields : fields
				});

		var cm = new Ext.grid.ColumnModel([
					new Ext.grid.RowNumberer(),
					 {
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
					},{
						header : '读者部门',
						width : 100,
						sortable : true,
						align : 'center',
						dataIndex : 'unitName'
					},{
						header : '读者类别',
						width : 200,
						sortable : true,
						align : 'center',
						dataIndex : 'readerCateName'
					}, {
						header : '罚金',
						width : 100,
						sortable : true,
						align : 'center',
						dataIndex : 'punishMoney'
					},{
						header : '收费项目',
						width : 80,
						sortable : true,
						align : 'center',
						dataIndex : 'chargeName'
					}, {
						xtype : 'datecolumn',
						format: 'Y-m-d',
						header : '操作日期',
						width : 100,
						sortable : true,
						align : 'center',
						dataIndex : 'operatorDate'
					},  {
						header : '操作员',
						width : 100,
						sortable : true,
						align : 'center',
						dataIndex : 'operator'
					},{
						header : '收费描述',
						width : 200,
						sortable : true,
						align : 'center',
						dataIndex : 'eventsDesc'
					}]);

		Ext.apply(this, {
					width : 1250,
					// height : document.documentElement.clientHeight * 0.82,
					height : 450,
					autoScroll : true,
					tbar : tbar,
					cm : cm,
					store : store,
					stripeRows : true,
					columnLines : true,
					frame : false,
					loadMask : '正在加载......',
					bbar : new Ext.Toolbar([new Ext.PagingToolbar({
								store : store,
								pageSize : ReaderAccountsPageSize,
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

		Library.readerAccount.grid.ReaderAccountGridPanel.superclass.initComponent.call(this);

	},

	queryReaderAccount : function() {
	   var readerBarCode = Ext.get('readerBarCode').getValue();
	   var readerName = Ext.get('readerName').getValue();
	   var unitName = Ext.get('unitName').getValue();
	   var chargeName = Ext.get('chargeName').getValue();
	   var operator = Ext.get('operator').getValue();
	   var readerCateName = Ext.get('readerCateName').getValue();
	   var operatorDate = Ext.get('operatorDate').getValue();
	   var endOperatorDate = Ext.get('endOperatorDate').getValue();
	   
	   this.getStore().baseParams = {
	       'punishmentView.readerBarCode' : readerBarCode,
	       'punishmentView.readerName' : readerName,
	       'punishmentView.unitName' : unitName,
	       'punishmentView.chargeName' : chargeName,
	       'punishmentView.operator' : operator,
	       'punishmentView.readerCateName' : readerCateName,
	       'punishmentView.operatorDate' : operatorDate,
	       'punishmentView.endOperatorDate' : endOperatorDate
		}
		this.getStore().load({
					params : {
						start : 0,
						limit : ReaderAccountsPageSize
					}
				});
	},

	onExport : function(){
	 
	   var readerBarCode = Ext.get('readerBarCode').getValue();
	   var readerName = Ext.get('readerName').getValue();
	   var unitName = Ext.get('unitName').getValue();
	   var chargeName = Ext.get('chargeName').getValue();
	   var operator = Ext.get('operator').getValue();
	   var readerCateName = Ext.get('readerCateName').getValue();
	   var operatorDate = Ext.get('operatorDate').getValue();
	   var endOperatorDate = Ext.get('endOperatorDate').getValue();
	   
	   Ext.Ajax.request({
				url : contextPath+ '/punishment/exportExcel.action',
				method : 'POST',
				params : {
				   'punishmentView.readerBarCode' : readerBarCode,
			       'punishmentView.readerName' : readerName,
			       'punishmentView.unitName' : unitName,
			       'punishmentView.chargeName' : chargeName,
			       'punishmentView.operator' : operator,
			       'punishmentView.readerCateName' : readerCateName,
			       'punishmentView.operatorDate' : operatorDate,
			       'punishmentView.endOperatorDate' : endOperatorDate
				},
				success : function(resp) {
					var respText = resp.responseText;
					var obj = Ext.util.JSON.decode(respText);
					if (obj.success) {
						window.location.href = contextPath + "/file/downloadFile.action?fileName=" + obj.data;
					} else {
						Ext.Msg.alert('提示',obj.msg);
					}
				},
				failure : function() {
					Ext.Msg.alert('提示', '服务器异常');
				}
			});

	   
	
	}
	,
	onRefresh : function() {

		this.getStore().baseParams = {};

		this.getStore().load({
					params : {
						'start' : 0,
						'limit' : ReaderAccountsPageSize
					}
				});
	}

});
