Ext.ns('Library.readerCard.grid');

Library.readerCard.grid.ReaderCardGridPanel = Ext.extend(Ext.grid.GridPanel, {
	
	id : 'readerCardGridPanel',
	
	initComponent : function(){
		
		// 操作图书列表的工具条
		var tbar = new Ext.Toolbar({
			items : [{
				text : '查询',
				handler : function() {
				}
			},'-', {
				text : '修改',
				handler : function() {
					this.updateBook();
				},
				scope:this
			},'-', {
				text : '增加',
				handler : function() {
					this.addReaderCard();
				},
				scope:this
			},'-', {
				text : '删除',
				handler : function() {
					this.deleteBook();
				},
				scope:this
			},'-', {
				text : '导入',
				handler : function() {
					
				}
			},'-',  {
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
			},'-',{
				text : '上传图片',
				handler : function() {
					
				}
			}]
		});
		
		var fields = [{
			name : 'id',
			type : 'int'
		}, {
			name : 'readerCardCode',
			type : 'string'
		}, {
			name : 'password',
			type : 'string'
		}, {
			name : 'barCode',
			type : 'string'
		}, {
			name : 'entyDate',
			type : 'string'
		}, {
			name : 'effectiveDate',
			type : 'string'
		}, {
			name : 'readerPic',
			type : 'string'
		}, {
			name : 'readerCardDesc',
			type : 'string'
		}, {
			name : 'cardState',
			type : 'string'
		}, {
			name : 'readerId',
			type : 'int'
		}, {
			name : 'readerName',
			type : 'string'
		}, {
			name : 'readerUnitsId',
			type : 'int'
		}, {
			name : 'readerUnitsName',
			type : 'string'
		}];
		
		var selectModel = new Ext.grid.CheckboxSelectionModel({
			singleSelect : true
		});
		
		var store = new Ext.data.JsonStore({
			url : contextPath + '/book/findBooks.action',
			totalProperty : 'totalProperty',
			root : 'root',
			baseParams : {
				"bookView.isBook" : ''
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
				header : '条形码',
				dataIndex : 'barCode',
				sortable : true,
				width : 80,
				align : 'center'
			}, {
				header : '借阅证号',
				dataIndex : 'readerCardCode',
				width : 80,
				sortable : true,
				align : 'center'
			}, {
				header : '密码',
				dataIndex : 'password',
				width : 200,
				sortable : true,
				align : 'center'
			}, {
				header : '办证日期',
				dataIndex : 'entyDate',
				width : 150,
				sortable : true,
				align : 'center'
			}, {
				header : '有效日期',
				dataIndex : 'effectiveDate',
				width : 80,
				sortable : true,
				align : 'center'
			}, {
				header : '状态',
				dataIndex : 'cardState',
				width : 80,
				sortable : true,
				align : 'center'
			},{
				header : '读者姓名',
				dataIndex : 'readerName',
				width : 80,
				sortable : true,
				align : 'center'
			}, {
				header : '所属单位',
				dataIndex : 'readerUnitsName',
				width : 80,
				sortable : true,
				align : 'center'
			}
		]);
		
		Ext.apply(this, {
			width : 1000,
//			height : document.documentElement.clientHeight * 0.82,
			height : 480,
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
					pageSize : ReaderCardPageSize,
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
		
		Library.readerCard.grid.ReaderCardGridPanel.superclass.initComponent.call(this);
		
		//增加事件监听
		this.addListener('rowdblclick', function(){
			this.updateBook();
		}, this);
		
		this.addListener('rowclick', function(){
			//显示图书详细信息
			
			
		}, this);
		
		this.store.baseParams = {
			"bookView.isBook" : 1
		}
		
	},
	
	addReaderCard : function() {
		window.location = contextPath + '/reader/showSaveReaderCard.action';
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
		if(sm.hasSelection()){
			var record = sm.getSelected();
			var bookId = record.get('bookId');
			var thiz = this;
			Ext.Ajax.request({
				url : contextPath + '/book/deleteBook.action',
				method : 'POST',
				params : {
					'bookView.bookId' : bookId
				},
				success : function(resp){
					var respText = resp.responseText;
					var obj = Ext.util.JSON.decode(respText);
					if(obj.success==true){
						Ext.Msg.alert('提示', obj.msg);
						thiz.getStore().reload();
					} else {
						Ext.Msg.alert('提示', obj.msg);
					}
				},
				failure : function(){
					Ext.Msg.alert('服务器异常');
				}
			});
		}
	}	
});
