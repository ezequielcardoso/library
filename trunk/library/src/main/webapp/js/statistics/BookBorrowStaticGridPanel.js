Ext.ns('Library.book.statics.grid');

Library.book.statics.grid.BookStaticsGridPanel = Ext.extend(Ext.grid.GridPanel, {
	
	id : 'bookStaticsGridPanel',
	
	initComponent : function(){
		
		// 操作图书列表的工具条
		var tbar = new Ext.Toolbar({
			items : [{
				text : '导出Excel',
				iconCls : 'library-export-excel',
				handler : function() {
				  this.onExport();	
				},
				scope : this
			}/**,'-',{
				text : '图书标签',
				handler : function() {
					
				}
			},'-',{
				text : '打印条形码',
				handler : function() {
					
				}
			}*/,'-', {
				xtype : 'label',
				text : '借阅时间从：'
			}, '-',{
				xtype : 'datefield',
				width : 100,
				id : 'borrowedDate',
				format : 'Y-m-d'
			},'-', {
				xtype : 'label',
				text : '到：'
			}, '-',{
				xtype : 'datefield',
				width : 100,
				id : 'endBorrowedDate',
				format : 'Y-m-d'
			},'-',{
				xtype : 'label',
				text : '归还时间从：'
			},'-',{
				xtype : 'datefield',
				width : 100,
				id : 'realityReturndate',
				format : 'Y-m-d'
			},'-', {
				xtype : 'label',
				text : '到：'
			}, '-',{
				xtype : 'datefield',
				width : 100,
				id : 'endRealityReturnDate',
				format : 'Y-m-d'
			},'-',{
				text : '查询',
				iconCls : 'library-query',
				handler : function() {
					this.queryBorrowed();
				},
				scope:this
			},'-',{
				text : '刷新',
				iconCls : 'library-refresh',
				handler : function() {
					this.onRefresh();
				},
				scope:this
			} ]
		});
		
		var fields = [{
							name : 'id',
							type : 'int'
						}, {
							name : 'borrowedDate',
							type : 'date',
							dateFormat : 'm/d/Y'
						}, {
							name : 'duetoReturnDate',
							type : 'date',
							dateFormat : 'm/d/Y'
						}, {
							name : 'realityReturndate',
							type : 'date',
							dateFormat : 'm/d/Y'
						}, {
							name : 'overdueDays',
							type : 'int'
						}, {
							name : 'puniMoney',
							type : 'float'
						}, {
							name : 'isPay',
							type : 'int'
						}, {
							name : 'renewTimes',
							type : 'int'
						}, {
							name : 'borrowOperator',
							type : 'string'
						}, {
							name : 'returnOperator',
							type : 'string'
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
							type : 'string'
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
		
		var store = new Ext.data.JsonStore({
			url : contextPath + '/borrowReturn/findBorrowReturns.action',
			totalProperty : 'totalProperty',
			root : 'root',
			baseParams : {
				'borrowReturnView.isBook' : 1
			},
			storeInfo : {
				field : '列名',
				direction : 'ASC|DESC'
			},
			fields : fields
		});
		
	   var cm = new Ext.grid.ColumnModel([
					new Ext.grid.RowNumberer(),
					{
						header : '图书条形码',
						width : 100,
						sortable : true,
						align : 'center',
						editor : new Ext.form.TextField({
									allowBlank : false
								}),
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
						header : '借阅日期',
						width : 100,
						sortable : true,
						align : 'center',
						dataIndex : 'borrowedDate'
					}, {
						xtype : 'datecolumn',
						format: 'm/d/Y',
						header : '应还日期',
						width : 100,
						sortable : true,
						align : 'center',
						dataIndex : 'duetoReturnDate'
					}, {
						xtype : 'datecolumn',
						format: 'm/d/Y',
						header : '实还日期',
						width : 100,
						sortable : true,
						align : 'center',
						dataIndex : 'realityReturndate'
					}, {
						header : '超期天数',
						width : 100,
						sortable : true,
						align : 'center',
						dataIndex : 'overdueDays'
					}, {
						header : '罚金',
						width : 80,
						sortable : true,
						align : 'center',
						dataIndex : 'puniMoney'
					}, {
						header : '续借次数',
						width : 80,
						sortable : true,
						align : 'center',
						dataIndex : 'renewTimes'
					}, {
						header : '图书状态',
						width : 80,
						sortable : true,
						align : 'center',
						renderer : function(value){
							var html = "";
							if(value=="核审中"){
								html = "<font color='red'>" + value + "</font>";
								
							}else if(value=="预约中"){
								html = "<font color='blue'>" + value +"</font>";
								
							}else if(value=="借阅中"){
								html = "<font color='green'>" + value +"</font>";
								
							}else if(value=="逾期中"){
								html = "<font color='yellow'>" + value +"</font>";
								
							} else {
								html = value;
							}
							return html;
				},
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
					}, {
						header : '借阅操作员',
						width : 80,
						sortable : true,
						align : 'center',
						dataIndex : 'borrowOperator'
					}, {
						header : '归还操作员',
						width : 80,
						sortable : true,
						align : 'center',
						dataIndex : 'returnOperator'
					}]);

		
		Ext.apply(this, {
			width : 1250,
//			height : document.documentElement.clientHeight * 0.82,
			height : 450,
			autoScroll : true,
			tbar : tbar,
			cm : cm,
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
				})
			]),
			viewConfig : new Ext.grid.GridView({
				rowHeight : 23,
				scrollDelay : false,
				columnsText : '显示的列',
				scrollOffset : 30,
				sortAscText : '升序',
				sortDescText : '降序'
			})
		});
		
		Library.book.statics.grid.BookStaticsGridPanel.superclass.initComponent.call(this);
		
	},
	
	queryBorrowed : function(){
	   var readerBarCode = Ext.get('readerBarCode').getValue();
	   var readerName = Ext.get('readerName').getValue();
	   var unitName = Ext.get('unitName').getValue();
	   var bookBarCode = Ext.get('bookBarCode').getValue();
	   var bookName = Ext.get('bookName').getValue();
	   var firstCategoryName = Ext.get('firstCategoryName').getValue();
	   var borrowOperator = Ext.get('borrowOperator').getValue();
	   var returnOperator = Ext.get('returnOperator').getValue();
	   var bookStateName = Ext.get('bookStateName').getValue();
	   var borrowedDate = Ext.get('borrowedDate').getValue();
	   var endBorrowedDate = Ext.get('endBorrowedDate').getValue();
	   var realityReturndate = Ext.get('realityReturndate').getValue();
	   var endRealityReturnDate = Ext.get('endRealityReturnDate').getValue();
	   
	   this.getStore().baseParams = {
	       'borrowReturnView.readerBarCode' : readerBarCode,
	       'borrowReturnView.readerName' : readerName,
	       'borrowReturnView.unitName' : unitName,
	       'borrowReturnView.bookBarCode' : bookBarCode,
	       'borrowReturnView.bookName' : bookName,
	       'borrowReturnView.firstCategoryName' : firstCategoryName,
	       'borrowReturnView.borrowOperator' : borrowOperator,
	       'borrowReturnView.returnOperator' : returnOperator,
	       'borrowReturnView.bookStateName' : bookStateName,
	       'borrowReturnView.endBorrowedDate' : endBorrowedDate,
	       'borrowReturnView.realityReturndate' : realityReturndate,
	       'borrowReturnView.endRealityReturnDate' : endRealityReturnDate,
	       'borrowReturnView.isBook' : 1
	      
	   }
	   this.getStore().load({
	       params : {
				start : 0,
				limit : BooksPageSize
			}
	   });
	},
	
	onExport : function(){
	
	   var readerBarCode = Ext.get('readerBarCode').getValue();
	   var readerName = Ext.get('readerName').getValue();
	   var unitName = Ext.get('unitName').getValue();
	   var bookBarCode = Ext.get('bookBarCode').getValue();
	   var bookName = Ext.get('bookName').getValue();
	   var firstCategoryName = Ext.get('firstCategoryName').getValue();
	   var borrowOperator = Ext.get('borrowOperator').getValue();
	   var returnOperator = Ext.get('returnOperator').getValue();
	   var bookStateName = Ext.get('bookStateName').getValue();
	   var borrowedDate = Ext.get('borrowedDate').getValue();
	   var endBorrowedDate = Ext.get('endBorrowedDate').getValue();
	   var realityReturndate = Ext.get('realityReturndate').getValue();
	   var endRealityReturnDate = Ext.get('endRealityReturnDate').getValue();
	   
	   Ext.Ajax.request({
				url : contextPath+ '/borrowReturn/exportExcel.action',
				method : 'POST',
				params : {
					   'borrowReturnView.readerBarCode' : readerBarCode,
				       'borrowReturnView.readerName' : readerName,
				       'borrowReturnView.unitName' : unitName,
				       'borrowReturnView.bookBarCode' : bookBarCode,
				       'borrowReturnView.bookName' : bookName,
				       'borrowReturnView.firstCategoryName' : firstCategoryName,
				       'borrowReturnView.borrowOperator' : borrowOperator,
				       'borrowReturnView.returnOperator' : returnOperator,
				       'borrowReturnView.bookStateName' : bookStateName,
				       'borrowReturnView.endBorrowedDate' : endBorrowedDate,
				       'borrowReturnView.realityReturndate' : realityReturndate,
				       'borrowReturnView.endRealityReturnDate' : endRealityReturnDate,
				       'borrowReturnView.isBook' : 1
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
	onRefresh : function(){
	   
		this.getStore().baseParams={'borrowReturnView.isBook' : 1};
		
		this.getStore().load({
							params : {
								'start' : 0,
								'limit' : BooksPageSize
							}
						});
		
	}
});
