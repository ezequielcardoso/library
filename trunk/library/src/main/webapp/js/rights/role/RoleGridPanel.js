Ext.ns('Library.rights.grid');

Library.rights.grid.RoleGridPanel = Ext.extend(Ext.grid.EditorGridPanel, {

	id : 'roleGridPanel',
	
	initComponent : function(){
		
		// 列表工具条
		var tbar = new Ext.Toolbar({
			items : [{
				text : '增加',
				handler : function() {
					
				}
			},  {
				text : '删除',
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
		}, {
			name : 'roleActive',
			type : 'boolean'
		}, {
			name : 'createDate',
			type : 'date',
			dateFormat : 'Y-m-d'
		}];
		
		var store = new Ext.data.JsonStore({
			url : contextPath + '/role/findRoles.action',
			totalProperty : 'totalProperty',
			root : 'root',
			storeInfo : {
				field : '列名',
				direction : 'ASC|DESC'
			},
			fields : fields
		});
		
		var sm = new Ext.grid.CheckboxSelectionModel();
		
		var colM = new Ext.grid.ColumnModel([
			new Ext.grid.RowNumberer(), sm, {
				header : '名称',
				dataIndex : 'roleName',
				sortable : true,
				width : 100,
				editor : new Ext.form.TextField({
					allowBlank : false
				})
			}, {
				header : '描述',
				dataIndex : 'roleDesc',
				width : 200,
				editor : new Ext.form.TextField()
			}, {
				xtype : 'datecolumn',
				format: 'Y-m-d',
				header : '创建时间',
				dataIndex : 'createDate',
				sortable : true,
				width : 100,
				editor : new Ext.form.DateField({
					format : 'Y-m-d'
				})
			}, {
//				xtype : 'booleancolumn',
				header : '激活',
				dataIndex : 'roleActive',
				width : 50,
				editor : new Ext.form.Checkbox()
			}
		]);
		
		Ext.apply(this, {
			width : 500,
//			height : document.documentElement.clientHeight * 0.82,
			height : 500,
			autoScroll : true,
			tbar : tbar,
			cm : colM,
			sm : sm,
			loadMask : '正在加载......',
			clicksToEdit : 1,
			store : store,
			stripeRows : true,
			columnLines : true,
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
		
		this.on('afteredit', function(e) {
			e.record.commit();
			var thiz = this;
			Ext.Ajax.request({
						url : contextPath + '/role/save.action',
						method : 'POST',
						params : {
							'role.roleId' : e.record.get('roleId'),
							'role.roleName' : e.record.get('roleName'),
							'role.roleDesc' : e.record.get('roleDesc'),
							'role.createDate' : e.record.get('createDate'),
							'role.roleActive' : e.record.get('roleActive')
						},
						success : function(resp) {
							var obj = Ext.util.JSON.decode(resp.responseText);
							if (obj.success == true) {
								Ext.Msg.alert('提示', obj.msg);
								e.record.set("roleId", obj.data.roleId);
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
	
	addRole : function() {
		
	},
	
	updateRole : function(){
	
	},
	
	deleteRole : function() {
		
	}
	
	
});
