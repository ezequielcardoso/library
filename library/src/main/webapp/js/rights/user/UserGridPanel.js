Ext.ns('Library.rights.grid');

Library.rights.grid.UserGridPanel = Ext.extend(Ext.grid.EditorGridPanel, {

	id : 'userGridPanel',
	
	initComponent : function(){
		
		// 列表工具条
		var tbar = new Ext.Toolbar({
			items : [{
				text : '增加',
				iconCls : 'library-reader-add',
				handler : function() {
					this.onAdd();
				},
				scope : this
			},'-', {
				text : '删除',
				iconCls : 'library-reader-delete',
				handler : function() {
					this.onDelete();
				},
				scope : this
			},'-', {
				text : '分配部门',
				iconCls : 'library-binding-readerUnits',
				handler : function() {
					var sm = this.getSelectionModel();
					if(sm.hasSelection()){
						var record = sm.getSelected();
						var checkWin = new Library.tree.DepartmentCheckTreeWindow({
							checkTree : new Library.rights.tree.DepartmentCheckTree({
										checkModel : 'single'
									}),
							record : record,
							height : 500,
							width : 300,
							title : '分配部门'
						});
						checkWin.show();
					} else {
						Ext.Msg.alert('提示', '请选择用户');
					}
				},
				scope : this
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
				iconCls : 'library-reader-query',
				handler : function() {
					this.onQuery();
				},
				scope : this
			}, '-', {
				text : '刷新',
				iconCls : 'library-refresh',
				handler : function() {
					this.getStore().baseParams = {};
					this.getStore().load({
							params : {
								start : 0,
								limit : UsersPageSize
							}
					});
				},
				scope : this
			}]
		});
		
		var fields = [{
			name : 'userId',
			type : 'int'
		}, {
			name : 'userAccount',
			type : 'string'
		}, {
			name : 'userName',
			type : 'string'
		}, {
			name : 'createDate',
			type : 'date',
			dateFormat : 'Y-m-d'
		}, {
			name : 'password',
			type : 'string'
		}, {
			name : 'userActive',
			type : 'boolean'
		}, {
			name : 'deptName',
			type : 'string'
		}, {
			name : 'deptId',
			type : 'int'
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
		
		var sm = new Ext.grid.CheckboxSelectionModel({single : true});
		
		var colM = new Ext.grid.ColumnModel([
			new Ext.grid.RowNumberer(), sm, {
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
			width : 600,
			height : 500,
			autoScroll : true,
			tbar : tbar,
			cm : colM,
			sm : sm,
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
			var record = this.getSelectionModel().getSelected();
			var tree = Ext.getCmp('roleCheckTreePanel');
			tree.getLoader().baseParams = {};
			tree.userId = record.get('userId');
			tree.getRootNode().reload();
		}, this);
		
		this.on('afteredit', function(e) {
			e.record.commit();
			var thiz = this;
			Ext.Ajax.request({
				url : contextPath + '/user/save.action',
				method : 'POST',
				params : {
					'user.userId' : e.record.get('userId'),
					'user.userName' : e.record.get('userName'),
					'user.password' : e.record.get('password'),
					'user.userAccount' : e.record.get('userAccount'),
					'user.createDate' : e.record.get('createDate'),
					'user.userActive' : e.record.get('userActive')
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
	
	onAdd : function() {
		var User = this.getStore().recordType;
		var p = new User({
					userName : '',
					userAccount : '',
					password : '123',
					createDate : new Date(),
					userActive : true
				});
		this.stopEditing();
		this.store.insert(0, p);
		this.startEditing(0, 0);
	},
	
	onDelete : function() {
		var sm = this.getSelectionModel();
		if (sm.hasSelection()) {
			Ext.MessageBox.confirm('提示', '你确定要删除记录吗？', function(btn, text) {

				if (btn == 'yes') {
					var record = sm.getSelected();
					var userId = record.get('userId');
					var thiz = this;
					Ext.Ajax.request({
						url : contextPath + '/user/remove.action',
						method : 'POST',
						params : {
							'userView.userId' : userId
						},
						success : function(resp) {
							var respText = resp.responseText;
							var obj = Ext.util.JSON.decode(respText);
							if (obj.success == true) {
								Ext.Msg.alert('提示',obj.msg);
								thiz.getStore().reload();
							} else {
								Ext.Msg.alert('提示',obj.msg);
							}
						},
						failure : function() {
							Ext.Msg.alert('提示', '服务器异常');
						}
					});
				}

			}, this);

		} else {
			Ext.Msg.alert('提示', '请选择你要删除的记录');
		}
	},
	
	onQuery : function(){
		var userName = Ext.get('query_userName').getValue();
		var userAccount = Ext.get('query_userAccount').getValue();
		this.getStore().baseParams = {};
		this.getStore().baseParams = {
			'userView.userName' : userName,
			'userView.userAccount' : userAccount
		};
		this.getStore().load({
			params : {
				start : 0,
				limit : UsersPageSize
			}
		})
	}

});
