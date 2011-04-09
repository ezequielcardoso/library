Ext.ns('Library.rights.grid');

Library.rights.grid.UserGridPanel = Ext.extend(Ext.grid.EditorGridPanel, {

	id : 'userGridPanel',
	
	initComponent : function(){
		
		// 列表工具条
		var tbar = new Ext.Toolbar({
			items : [{
				text : '增加',
				handler : function() {
					
				}
			},'-', {
				text : '删除',
				handler : function() {
					
				}
			},'-', {
				xtype : 'label',
				text : '姓名：'
			}, {
				xtype : 'textfield',
				width : 100,
				id : 'query_userName'
			}, '-', {
				xtype : 'label',
				text : '账号：'
			}, {
				xtype : 'textfield',
				width : 100,
				id : 'query_userAccount'
			}, '-', {
				text : '查询',
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
			type : 'date'
		}, {
			name : 'password',
			type : 'string'
		}, {
			name : 'userActive',
			type : 'boolean'
		}, {
			name : 'depteName',
			type : 'string'
		}, {
			name : 'deptId',
			type : 'string'
		}];
		
		var store = new Ext.data.JsonStore({
			url : contextPath + '/user/findUsers.action',
			totalProperty : 'totalProperty',
			baseParams : {
				"userView.deptId" : ""
			},
			root : 'root',
			storeInfo : {
				field : '列名',
				direction : 'ASC|DESC'
			},
			fields : fields
		});
		var colM = new Ext.grid.ColumnModel([
		new Ext.grid.RowNumberer(), {
				header : '账号',
				dataIndex : 'userAccount',
				sortable : true,
				width : 90,
				editor : new Ext.form.TextField({
					allowBlank : false
				})
			}, {
				header : '姓名',
				dataIndex : 'userName',
				width : 80,
				sortable : true,
				editor : new Ext.form.TextField({
					allowBlank : false
				})
			}, {
				header : '密码',
				dataIndex : 'password',
				width : 60,
				editor : new Ext.form.TextField({
					allowBlank : false
				})
			}, {
				xtype: 'datecolumn',
				header : '创建时间',
				dataIndex : 'createDate',
				width : 100,
				sortable : true,
				editor : new Ext.form.DateField({
					format : 'Y-m-d'
				}),
				format : 'Y-m-d'
			}, {
				xtype: 'booleancolumn',
				header : '激活',
				dataIndex : 'userActive',
				width : 50,
				editor : new Ext.form.Checkbox()
			}, {
				header : '部门',
				dataIndex : 'deptName',
				width : 100,
				sortable : true
			}
		]);
		
		Ext.apply(this, {
			width : 505,
//			height : document.documentElement.clientHeight * 0.82,
			height : 500,
			autoScroll : true,
			tbar : tbar,
			cm : colM,
			store : store,
			stripeRows : true,
			columnLines : true,
			loadMask : '正在加载......',
			clicksToEdit : 1,
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
		
		this.on('afteredit', function(e) {
			e.record.commit();
			var thiz = this;
			Ext.Ajax.request({
						url : contextPath + '/user/save.action',
						method : 'POST',
						params : {
							'user.userId' : e.record.get('roleId'),
							'user.userName' : e.record.get('roleName'),
							'user.password' : e.record.get('password'),
							'user.userAccount' : e.record.get('roleDesc'),
							'user.createDate' : e.record.get('createDate'),
							'user.userActive' : e.record.get('roleActive')
						},
						success : function(resp) {
							var obj = Ext.util.JSON.decode(resp.responseText);
							if (obj.success == true) {
								Ext.Msg.alert('提示', obj.msg);
								e.record.set("userId", obj.data.userId);
								e.record.commit();
							} else if (obj.success == false) {
								Ext.Msg.alert('提示', obj.msg);
							}
						},
						failure : function() {
							Ext.Msg.alert('提示', '服务器异常，请稍候再试');
						}
					});
		}, this);
	},
	
	addUser : function() {
		
	},
	
	updateUser : function(){
	
	},
	
	deleteUser : function() {
		
	}

});
