Ext.ns('Library.rights.grid');

Library.rights.grid.UserGrid = Ext.extend(Ext.grid.GridPanel, {

	id : null,
	
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
				iconCls : 'zoom',
				handler : function() {
					
				}
			}]
		});
		
		var store = new Ext.data.JsonStore({
			url : 'rights/findUsers.action',
			totalProperty : 'results',
			root : 'rows',
			storeInfo : {
				field : '列名',
				direction : 'ASC|DESC'
			},
			fields : [{
					name : 'userId',
					type : 'string'
				}, {
					name : 'userAccount',
					type : 'string'
				}, {
					name : 'userName',
					type : 'string'
				}, {
					name : 'password',
					type : 'string'
				}, {
					name : 'level',
					type : 'string'
				}, {
					name : 'email',
					type : 'string'
				}, {
					name : 'telephone',
					type : 'string'
				}, {
					name : 'sex',
					type : 'string'
				}, {
					name : 'appointedDate',
					type : 'string'
				}, {
					name : 'address',
					type : 'string'
				}]
			});
			var colM = new Ext.grid.ColumnModel([new Ext.grid.RowNumberer(), {
				header : '用户账号',
				dataIndex : 'userAccount',
				sortable : true,
				width : 70,
				align : 'center'
			}, {
				header : '用户姓名',
				dataIndex : 'userName',
				width : 70,
				sortable : true,
				align : 'center'
			}, {
				header : '级别',
				dataIndex : 'level',
				width : 70,
				sortable : true,
				align : 'center'
			}, {
				header : '邮箱',
				dataIndex : 'email',
				width : 90,
				sortable : true,
				align : 'center',
				renderer : function(value) {
					
				}
			}, {
				header : '电话',
				sortable : true,
				dataIndex : 'telphone',
				width : 300
				// align : 'center'
			}, {
				header : '入职日期',
				sortable : true,
				width : 80,
				dataIndex : 'appointedDate',
				align : 'center',
				renderer : function(value) {
					if (Ext.isEmpty(value)) {// 判断是否是日期类型的数据
						return '';
					} else
						return (value.split('T'))[0];
				}
			}, {
				header : '地址',
				sortable : true,
				width : 230,
				dataIndex : 'address'
				// align : 'center'
			}
		]);
		
		Ext.apply(this, {
			width : 500,
			height : document.documentElement.clientHeight * 0.82,
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
			]),
			view : new Ext.ux.grid.BufferView({
				rowHeight : 23,
				scrollDelay : false,
				columnsText : '显示的列',
				scrollOffset : 30,
				sortAscText : '升序',
				sortDescText : '降序'
			})
		});
		
		Library.rights.grid.UserGrid.superclass.initComponent.call(this);
		
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
