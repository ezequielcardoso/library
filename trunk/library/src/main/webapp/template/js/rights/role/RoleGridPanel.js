Ext.ns('Library.rights.grid');

Library.rights.grid.RoleGridPanel = Ext.extend(Ext.grid.GridPanel, {

	id : 'roleGridPanel',
	
	initComponent : function(){
		
		// 列表工具条
		var tbar = new Ext.Toolbar({
			items : [{
				text : '查询角色',
				handler : function() {
					
				}
			}, {
				text : '增加角色',
				handler : function() {
					
				}
			}, {
				text : '修改角色',
				handler : function() {
					
				}
			},  {
				text : '删除角色',
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
		var colM = new Ext.grid.ColumnModel([new Ext.grid.RowNumberer(), {
				header : '角色名',
				dataIndex : 'roleName',
				sortable : true,
				width : 100,
				align : 'center'
			}, {
				header : '角色描述',
				dataIndex : 'roleDesc',
				width : 300,
				sortable : true,
				align : 'center'
			}
		]);
		
		Ext.apply(this, {
			width : 450,
//			height : document.documentElement.clientHeight * 0.82,
			height : 500,
			autoScroll : true,
			tbar : tbar,
			cm : colM,
			store : store,
			stripeRows : true,
			columnLines : true,
			frame : true,
			bbar : new Ext.Toolbar([new Ext.PagingToolbar({
					store : store,
					pageSize : 20,
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
		
		Library.rights.grid.RoleGridPanel.superclass.initComponent.call(this);
		
		//增加事件监听
		this.addListener('rowdblclick', function(){
			
		}, this);
		
		this.addListener('rowclick', function(){
			
		}, this);
		
	},
	
	addRole : function() {
		
	},
	
	updateRole : function(){
	
	},
	
	deleteRole : function() {
		
	}
	
	
});
