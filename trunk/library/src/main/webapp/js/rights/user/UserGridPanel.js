Ext.ns('Library.rights.grid');

Library.rights.grid.UserGridPanel = Ext.extend(Ext.grid.GridPanel, {

	id : 'userGridPanel',
	
	initComponent : function(){
		
		// 列表工具条
		var tbar = new Ext.Toolbar({
			items : [{
				text : '查询用户',
				handler : function() {
					
				}
			}, {
				text : '增加用户',
				handler : function() {
					
				}
			}, {
				text : '修改用户',
				handler : function() {
					
				}
			},  {
				text : '删除用户',
				handler : function() {
					
				}
			}]
		});
		
		var fields = [{
			name : 'userId',
			type : 'string'
		}, {
			name : 'userAccount',
			type : 'string'
		}, {
			name : 'userName',
			type : 'string'
		}, {
			name : 'createDate',
			type : 'string'
		}, {
			name : 'password',
			type : 'string'
		}, {
			name : 'userActive',
			type : 'string'
		}, {
			name : 'depteName',
			type : 'string'
		}, {
			name : 'deptId',
			type : 'string'
		}];
		
		var store = new Ext.data.JsonStore({
			url : contextPath + '/rights/userList.action',
			totalProperty : 'totalProperty',
			root : 'root',
			storeInfo : {
				field : '列名',
				direction : 'ASC|DESC'
			},
			fields : fields
		});
		var colM = new Ext.grid.ColumnModel([new Ext.grid.RowNumberer(), {
				header : '账号',
				dataIndex : 'userAccount',
				sortable : true,
				width : 90,
				align : 'center'
			}, {
				header : '姓名',
				dataIndex : 'userName',
				width : 80,
				sortable : true,
				align : 'center'
			}, {
				header : '密码',
				dataIndex : 'password',
				width : 60,
				sortable : true,
				align : 'center'
			}, {
				header : '创建时间',
				dataIndex : 'createDate',
				width : 80,
				sortable : true,
				align : 'center'
			}, {
				header : '激活',
				dataIndex : 'userActive',
				width : 50,
				sortable : true,
				align : 'center'
			}, {
				header : '部门',
				dataIndex : 'deptName',
				width : 100,
				sortable : true,
				align : 'center'
			}
		]);
		
		Ext.apply(this, {
			width : 500,
//			height : document.documentElement.clientHeight * 0.82,
			height : 500,
			autoScroll : true,
			tbar : tbar,
			cm : colM,
			store : store,
			stripeRows : true,
			columnLines : true,
			frame : false,
			bbar : new Ext.Toolbar([new Ext.PagingToolbar({
					store : store,
					pageSize : 50,
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
		
		Library.rights.grid.UserGridPanel.superclass.initComponent.call(this);
		
		//增加事件监听
		this.addListener('rowdblclick', function(){
			
		}, this);
		
		this.addListener('rowclick', function(){
			
		}, this);
		
	},
	
	addUser : function() {
		
	},
	
	updateUser : function(){
	
	},
	
	deleteUser : function() {
		
	}

});
