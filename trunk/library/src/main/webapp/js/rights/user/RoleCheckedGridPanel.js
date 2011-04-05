Ext.ns('Library.rights.grid');

Library.rights.grid.RoleCheckedGridPanel = Ext.extend(Ext.grid.GridPanel, {

	id : 'roleCheckedGridPanel',
	
	initComponent : function(){
		
		// 列表工具条
		var tbar = new Ext.Toolbar({
			items : [{
				text : '查询角色',
				handler : function() {
					
				}
			}]
		});
		
		var fields = [{
			name : 'roleId',
			type : 'string'
		}, {
			name : 'roleName',
			type : 'string'
		}, {
			name : 'roleDesc',
			type : 'string'
		}];
		
		var rolesArr = [
			['1', '超级管理员', 'fsffsfsfs'],
			['2', '图书管理员', 'lifewfwfsi'],
			['3', '图书入库员', 'wafesfewfewngwu'],
			['4', '借阅管理员', 'zhafseffesoliu']
		];
		
		var store = new Ext.data.ArrayStore({
			data : rolesArr,
			fields : fields
		});
		
//		var store = new Ext.data.JsonStore({
//			url : 'rights/findRoles.action',
//			totalProperty : 'results',
//			root : 'rows',
//			storeInfo : {
//				field : '列名',
//				direction : 'ASC|DESC'
//			},
//			fields : fields
//		});
		
		var sm = new Ext.grid.CheckboxSelectionModel();
		
		var colM = new Ext.grid.ColumnModel([
		new Ext.grid.RowNumberer(), sm, {
			header : '角色名',
			dataIndex : 'roleName',
			sortable : true,
			width : 80,
			align : 'center'
		}, {
			header : '角色描述',
			dataIndex : 'roleDesc',
			width : 100,
			sortable : true,
			align : 'center'
		}]);
		
		Ext.apply(this, {
			width : 240,
//			height : document.documentElement.clientHeight * 0.82,
			height : 500,
			autoScroll : true,
			sm : sm,
			tbar : tbar,
			cm : colM,
			store : store,
			stripeRows : true,
			columnLines : true,
			frame : false,
			bbar : new Ext.Toolbar([new Ext.PagingToolbar({
					store : store,
					pageSize : 40,
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
		
		Library.rights.grid.RoleCheckedGridPanel.superclass.initComponent.call(this);
		
//		//增加事件监听
//		this.addListener('rowclick', function(){
////			alert('rowclick');
//		}, this);
//		
//		//增加事件监听
//		this.addListener('rowdblclick', function(){
////			alert('rowdblclick');
//		}, this);
		
		sm.addListener('selectionchange', function(){
//			alert('selectionchange');
			if(this.hasSelection()){
				alert('Y');
			} else {
				alert('N');
			}
			
		}, sm);
		
//		sm.addListener('rowdeselect', function(){
//			alert('rowdeselect');
//		});
//		
//		sm.addListener('beforerowselect', function(){
//			alert('beforerowselect');
//		});
//		
//		sm.addListener('rowselect', function(){
//			alert('rowselect');
//		});
		
	},
	
	findRoles : function() {
		
	}
	
	
});
