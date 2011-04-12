Ext.ns('Library.book.grid.child.statics');

Library.book.grid.child.statics.StaticsStoreBookGridPanel = Ext.extend(Library.book.grid.BookGridPanel,{

	id : 'staticsStoreBookGridPanel',
	
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
			},'->', {
				xtype : 'label',
				text : '入库时间从：'
			}, {
				xtype : 'textfield',
				width : 100,
				id : 'pressISBN'
			},'-', {
				xtype : 'label',
				text : '到：'
			}, {
				xtype : 'textfield',
				width : 100,
				id : 'xxx'
			},'-',{
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
		
		var selectModel = new Ext.grid.CheckboxSelectionModel({
//			singleSelect : true
		});
		
		
		
		var cm = new Ext.grid.ColumnModel([
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
			}]);
			
			Ext.apply(this, {
			width : 1250,
//			height : document.documentElement.clientHeight * 0.82,
			height : 450,
			autoScroll : true,
			tbar : this.tbar,
			cm : this.cm,
			selModel: selectModel,
//			store : store,
			stripeRows : true,
			columnLines : true,
			frame : false,
			bbar : new Ext.Toolbar([new Ext.PagingToolbar({
//					store : store,
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
		
		Library.book.grid.child.statics.StaticsStoreBookGridPanel.superclass.initComponent.call(this);
		
	
	}
	
});