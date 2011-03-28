Ext.ns('Library.book.grid');

Library.book.grid.BookGridPanel = Ext.extend(Ext.grid.GridPanel, {

	id : 'bookGridPanel',
	
	initComponent : function(){
		
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
					
				}
			}, {
				text : '删除',
				handler : function() {
					this.deleteBook();
				},
				scope:this
			},  {
				text : '导入',
				handler : function() {
					
				}
			},  {
				text : '导出Excel',
				handler : function() {
					
				}
			},  {
				text : '图书标签',
				handler : function() {
					
				}
			},  {
				text : '打印条形码',
				handler : function() {
					
				}
			}]
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
			name : 'secondCategoryId',
			type : 'string'
		}, {
			name : 'secondCategoryName',
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
			name : 'securityId',
			type : 'string'
		}, {
			name : 'securityName',
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
			name : 'resourceId',
			type : 'string'
		}, {
			name : 'resourceName',
			type : 'string'
		}];
		
		var selectModel = new Ext.grid.CheckboxSelectionModel();
		
		var store = new Ext.data.JsonStore({
			url : contextPath + '/books/findBooks.action',
			totalProperty : 'totalProperty',
			root : 'root',
			storeInfo : {
				field : '列名',
				direction : 'ASC|DESC'
			},
			fields : fields
		});
		
		
		
		var colM = new Ext.grid.ColumnModel([new Ext.grid.RowNumberer(),
		        selectModel,
		   {
				header : '编号',
				dataIndex : 'bookNo',
				sortable : true,
				width : 80,
				align : 'center'
			}, {
				header : '名称',
				dataIndex : 'bookName',
				width : 80,
				sortable : true,
				align : 'center'
			}, {
				header : '分类号',
				dataIndex : 'firstCategoryName',
				width : 80,
				sortable : true,
				align : 'center'
			}, {
				header : '作者',
				dataIndex : 'author',
				width : 80,
				sortable : true,
				align : 'center'
			}, {
				header : '种次号',
				dataIndex : 'speciesName',
				width : 80,
				sortable : true,
				align : 'center'
			}, {
				header : '数量',
				dataIndex : 'quantity',
				width : 80,
				sortable : true,
				align : 'center'
			}, {
				header : '入库时间',
				dataIndex : 'storeDate',
				width : 80,
				sortable : true,
				align : 'center'
			}, {
				header : '页数',
				dataIndex : 'pages',
				width : 80,
				sortable : true,
				align : 'center'
			}, {
				header : '附件',
				dataIndex : 'hasAttachment',
				width : 80,
				sortable : true,
				align : 'center'
			}, {
				header : '状态',
				dataIndex : 'bookStateName',
				width : 80,
				sortable : true,
				align : 'center'
			}
		]);
		
		Ext.apply(this, {
			width : 1000,
//			height : document.documentElement.clientHeight * 0.82,
			height : 500,
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
			])
//			view : new Ext.ux.grid.BufferView({
//				rowHeight : 23,
//				scrollDelay : false,
//				columnsText : '显示的列',
//				scrollOffset : 30,
//				sortAscText : '升序',
//				sortDescText : '降序'
//			})
		});
		
		Library.book.grid.BookGridPanel.superclass.initComponent.call(this);
		
		//增加事件监听
		this.addListener('rowdblclick', function(){
			
		}, this);
		
		this.addListener('rowclick', function(){
			
		}, this);
		
	},
	
	addBook : function() {
		
	},
	
	updateBook : function(){
	  
	},
	
    deleteBook : function() {
		var sm = this.getSelectionModel();
		alert(sm);
		var thiz = this;
		if(sm.hasSelection()){
			var record = sm.getSelected();
			var bookId = record.get('bookId');
			alert(bookId);
			Ext.Ajax.request({
				url : contextPath + '/books/deleteBook.action',
				method : 'POST',
				params : {
					bookId : bookId
				},
				success : function(resp){
					alert('成功从服务器返回');
					var respText = resp.responseText;
					var obj = Ext.util.JSON.decode(respText);
				    alert(obj);
				},
				failure : function(){
					alert('服务器异常');
				}
			});
		}
	}	
});
