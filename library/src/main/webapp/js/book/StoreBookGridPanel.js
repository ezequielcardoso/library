Ext.ns('Library.book.store');

Library.book.store.StoreGridPanel = Ext.extend(Ext.grid.GridPanel, {
	
	id : 'storeGridPanel',
	
	initComponent : function(){
		
		// 操作图书列表的工具条
		var tbar = new Ext.Toolbar({
			items : [{
				text : '增加',
				handler : function() {
					this.addBook();
				},
				scope:this
			},'-', {
				text : '删除',
				handler : function() {
					this.deleteBook();
				},
				scope:this
			},'-',{
				text : '修改',
				handler : function() {
					this.updateBook();
				},
				scope:this
			},'-',{
				text : '导入',
				handler : function() {
					
				}
			},'-',{
				text : '导出Excel',
				handler : function() {
					
				}
			},'-',{
				text : '图书标签',
				handler : function() {
					
				}
			},'-',{
				text : '打印条形码',
				handler : function() {
					
				}
			},'->',{
				text : '查询',
				handler : function() {
					this.queryBook();
				},
				scope:this
			},'-',{
				text : '刷新',
				handler : function() {
					this.onRefresh();
				},
				scope:this
			} ]
		});
		
		var fields = [{
			name : 'bookId',
			type : 'int'
		}, {
			name : 'barCode',
			type : 'string'
		}, {
			name : 'bookName',
			type : 'string'
		}, {
			name : 'bookDesc',
			type : 'string'
		}, {
			name : 'donator',
			type : 'string'
		}, {
			name : 'author',
			type : 'string'
		}, {
			name : 'translator',
			type : 'string'
		}, {
			name : 'ISBN',
			type : 'string'
		}, {
			name : 'ISSN',
			type : 'string'
		}, {
			name : 'emailNo',
			type : 'string'
		}, {
			name : 'stage',
			type : 'string'
		}, {
			name : 'allStage',
			type : 'string'
		}, {
			name : 'pages',
			type : 'int'
		}, {
			name : 'price',
			type : 'float'
		}, {
			name : 'publisherDate',
			type : 'string'
		}, {
			name : 'quantity',
			type : 'int'
		}, {
			name : 'location',
			type : 'string'
		}, {
			name : 'revision',
			type : 'int'
		}, {
			name : 'searchBookId',
			type : 'string'
		}, {
			name : 'speciesId',
			type : 'string'
		}, {
			name : 'spell',
			type : 'string'
		}, {
			name : 'storeDate',
			type : 'string'
		}, {
			name : 'bookNo',
			type : 'string'
		}, {
			name : 'isBook',
			type : 'boolean'
		}, {
			name : 'firstCategoryId',
			type : 'string'
		}, {
			name : 'firstCategoryName',
			type : 'string'
		}, {
			name : 'firstCategoryCode',
			type : 'string'
		}, {
			name : 'secondCategoryId',
			type : 'string'
		}, {
			name : 'secondCategoryName',
			type : 'string'
		}, {
			name : 'secondCategoryCode',
			type : 'string'
		}, {
			name : 'thirdCategoryId',
			type : 'string'
		}, {
			name : 'thirdCategoryName',
			type : 'string'
		}, {
			name : 'thirdCategoryCode',
			type : 'string'
		}, {
			name : 'hasAttachment',
			type : 'string'
		}, {
			name : 'bookStateId',
			type : 'string'
		}, {
			name : 'bookStateName',
			type : 'string'
		}, {
			name : 'bookLevelId',
			type : 'string'
		}, {
			name : 'bookLevelName',
			type : 'string'
		}, {
			name : 'bookSecurityId',
			type : 'string'
		}, {
			name : 'bookSecurityName',
			type : 'string'
		}, {
			name : 'currencyId',
			type : 'string'
		}, {
			name : 'pressId',
			type : 'string'
		}, {
			name : 'pressName',
			type : 'string'
		}, {
			name : 'bookSourceId',
			type : 'string'
		}, {
			name : 'bookSourceName',
			type : 'string'
		}];
		
		var selectModel = new Ext.grid.CheckboxSelectionModel({
//			singleSelect : true
		});
		
		var store = new Ext.data.JsonStore({
			url : contextPath + '/book/findBooks.action',
			totalProperty : 'totalProperty',
			root : 'root',
			baseParams : {
				'bookView.isBook' : 1
			},
			storeInfo : {
				field : '列名',
				direction : 'ASC|DESC'
			},
			fields : fields
		});
		
		var colM = new Ext.grid.ColumnModel([
			new Ext.grid.RowNumberer(),
		    selectModel,
		   {
				header : '编号',
				dataIndex : 'bookNo',
				sortable : true,
				width : 80,
				align : 'center'
			}, {
				header : '条形码',
				dataIndex : 'barCode',
				width : 80,
				sortable : true,
				align : 'center'
			}, {
				header : '名称',
				dataIndex : 'bookName',
				width : 200,
				sortable : true,
				align : 'center'
			}, {
				header : '分类',
				dataIndex : 'firstCategoryName',
				width : 150,
				sortable : true,
				align : 'center'
			}, {
				header : '分类号',
				dataIndex : 'firstCategoryCode',
				width : 80,
				sortable : true,
				align : 'center'
			}, {
				header : '种次号',
				dataIndex : 'speciesId',
				width : 80,
				sortable : true,
				align : 'center'
			}, {
				header : '存放位置',
				dataIndex : 'location',
				width : 80,
				sortable : true,
				align : 'center'
			}, {
				header : '数量',
				dataIndex : 'quantity',
				width : 50,
				sortable : true,
				align : 'center'
			}, {
				header : '价格',
				dataIndex : 'price',
				width : 60,
				sortable : true,
				align : 'center'
			}, {
				header : '入库时间',
				dataIndex : 'storeDate',
				width : 100,
				sortable : true,
				align : 'center'
			}, {
				header : '出版社',
				dataIndex : 'pressName',
				width :150,
				sortable : true,
				align : 'center'
			}, {
				header : '作者',
				dataIndex : 'author',
				width : 80,
				sortable : true,
				align : 'center'
			}, {
				header : '译者',
				dataIndex : 'translator',
				width : 80,
				sortable : true,
				align : 'center'
			}, {
				header : '出版时间',
				dataIndex : 'publisherDate',
				width : 100,
				sortable : true,
				align : 'center'
			}, {
				header : '页数',
				dataIndex : 'pages',
				width : 50,
				sortable : true,
				align : 'center'
			}, {
				header : 'ISBN',
				dataIndex : 'ISBN',
				width : 80,
				sortable : true,
				align : 'center'
			}, {
				header : '版次',
				dataIndex : 'revision',
				width : 50,
				sortable : true,
				align : 'center'
			}, {
				header : '密级',
				dataIndex : 'bookSecurityName',
				width : 60,
				sortable : true,
				align : 'center'
			}, {
				header : '状态',
				dataIndex : 'bookStateName',
				width : 60,
				sortable : true,
				align : 'center'
			}, {
				header : '附件',
				dataIndex : 'hasAttachment',
				width : 60,
				sortable : true,
				align : 'center',
				renderer : function(value){
					
				}
			}
		]);
		
		Ext.apply(this, {
			width : 1250,
//			height : document.documentElement.clientHeight * 0.82,
			height : 450,
			autoScroll : true,
			tbar : tbar,
			cm : colM,
			selModel: selectModel,
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
		
		Library.book.store.StoreGridPanel.superclass.initComponent.call(this);
		
		//增加事件监听
		this.addListener('rowdblclick', function(){
			this.updateBook();
		}, this);
		
		this.addListener('rowclick', function(){
			//显示图书详细信息
			
			
		}, this);
		
		this.store.baseParams = {
			'bookView.isBook' : 1
		}
		
	},
	
	queryBook : function(){
	   var barCode = Ext.get('barCode').getValue();
	   var bookName = Ext.get('bookName').getValue();
	   var bookState = Ext.get('bookState').getValue();
	   var press = Ext.get('press').getValue();
	   var location = Ext.get('location').getValue();
	   var bookNo = Ext.get('bookNo').getValue();
	   var searchBookId = Ext.get('searchBookId').getValue();
	   var speciesId = Ext.get('speciesId').getValue();
	   var firstCategory = Ext.get('firstCategory').getValue();
	   var secondCategory = Ext.get('secondCategory').getValue();
	   var author = Ext.get('author').getValue();
	   var operator = Ext.get('operator').getValue();
	   this.getStore().baseParams = {
	       'bookView.barCode' : barCode,
	       'bookView.bookName' : bookName,
	       'bookView.bookStateName' : bookState,
	       'bookView.pressName' : press,
	       'bookView.location' : location,
	       'bookView.bookNo' :bookNo,
	       'bookView.searchBookId' : searchBookId,
	       'bookView.speciesId' : speciesId,
	       'bookView.firstCategoryName' : firstCategory,
	       'bookView.thirdCategoryName' : secondCategory,
	       'bookView.author' : author,
	       'bookView.operator' : operator,
	       'bookView.isBook' : 1
	      
	   }
	   this.getStore().load({
	       params : {
				start : 0,
				limit : BooksPageSize
			}
	   });
	},
	
	onRefresh : function(){
	   
		this.getStore().baseParams={'bookView.isBook' : 1};
		
//		this.getStore().baseParams={};
		
		this.getStore().load({
							params : {
								'start' : 0,
								'limit' : BooksPageSize
							}
						});
		
	},
	
	addBook : function() {
		window.location = contextPath + '/book/showSaveBook.action';
	},
	
	updateBook : function(){
		var sm = this.getSelectionModel();
		if(sm.hasSelection()){
			var record = sm.getSelected();
			var bookId = record.get('bookId');
			window.location = contextPath + '/book/showSaveBook.action?bookView.bookId=' + bookId;				
		} else {
			Ext.Msg.alert('提示', '请选择一个图书!');
		}
	},
	
    deleteBook : function() {
		var sm = this.getSelectionModel();
		if (sm.hasSelection()) {
			Ext.MessageBox.confirm('提示', '你确定要删除记录吗？', function(btn, text) {
                   	if (btn == 'yes') {
							var records = sm.getSelections();
							for (var i = 0; i < records.length; i++) {
								var record = records[i];
								var bookId = record.get('bookId');
								var thiz = this;
								Ext.Ajax.request({
											url : contextPath
													+ '/book/remove.action',
											method : 'POST',
											params : {
												'bookView.bookId' : bookId
											},
											success : function(resp) {
												var respText = resp.responseText;
												var obj = Ext.util.JSON
														.decode(respText);
												if (obj.success == true) {
													Ext.Msg
															.alert('提示',
																	obj.msg);
													thiz.getStore().reload();
												} else {
													Ext.Msg
															.alert('提示',
																	obj.msg);
												}
											},
											failure : function() {
												Ext.Msg.alert('提示', '服务器异常');
											}
										});
							}
						} else {
							return false;
						}

					}, this);

		} else {
			Ext.Msg.alert('提示', '请选择你要删除的记录');
		}
	}	
});
