Ext.ns('Library.rights.tree');

Library.rights.tree.DepartmentTreePanel = Ext.extend(Library.tree.BaseTree, {
	
	id : 'departmentTreePanel',

	createRootNode: function(){
        return {
            text: '',
            id: '1'
        };
    }, 	 
    
    createTbar : function(thiz){
    	var tbar = new Ext.Toolbar({
			items : [{
				text : '增加',
				iconCls : 'library-readerUnits-add',
				handler : function() {
					var node = thiz.getSelectionModel().getSelectedNode();
			    	if(node){
				    	var pid = node.attributes.id;//取到父id
				    	//弹出增加部门表单window，把pid传过去
				    	var win = new Ext.Window({
				    		width : 280,
				    		height : 240,
				    		title : '增加部门',
				    		items : new Library.rights.form.DeptForm({
				    			pid : pid
				    		})
				    	});
				    	win.show();
			    	}else{ 
						Ext.Msg.alert('提示', '请选择上级部门');
					}
				},
				scope : this
			}, '-',{
				text : '修改',
				iconCls : 'library-binding-readerUnits',
				handler : function() {
					var node = thiz.getSelectionModel().getSelectedNode();
					if(node){
						var id = node.attributes.id;
						var pid = '';
						if(node.getDepth()>0){
							pid = node.parentNode.attributes.id;
						}
						//弹出修改部门表单window，把id传过去并加载上数据
						var win = new Ext.Window({
				    		width : 280,
				    		height : 240,
				    		title : '修改部门',
				    		items : new Library.rights.form.DeptForm({
				    			pid : pid,
				    			deptId : id
				    		})
				    	});
				    	win.show();
					}
				},
				scope : this
			}, '-',  {
				text : '删除',
				iconCls : 'library-readerUnits-delete',
				handler : function() {
					this.onRemove();
				},
				scope : this
			}]
		});
    	return new Ext.Toolbar([tbar]);
    },
	
    onRemove : function(){
    	var node = this.getSelectionModel().getSelectedNode();
			if (node) {
				Ext.MessageBox.confirm('提示', '你确定要删除该部门及其所有下属部门吗？', function(btn, text) {
					if (btn == 'yes') {
						var deptId = node.attributes.id;
						var thiz = this;
						Ext.Ajax.request({
							url : contextPath + '/dept/remove.action',
							method : 'POST',
							params : {
								'deptId' : deptId
							},
							success : function(resp) {
								var respText = resp.responseText;
								var obj = Ext.util.JSON.decode(respText);
								if (obj.success == true) {
									Ext.Msg.alert('提示',obj.msg);
									thiz.getRootNode().reload();
	    							thiz.getRootNode().expand();
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
    
	initComponent : function() {
		
		this.url = contextPath + "/dept/getChildrenByPid.action";
        this.isChecked = false;
        this.rootNode = this.createRootNode();
		this.tbar = this.createTbar(this);
		
		Ext.apply(this, {
			width : 280,
			height : 500
		});
		
		Library.rights.tree.DepartmentTreePanel.superclass.initComponent.call(this, arguments);
		
		var thiz = this;
		Ext.Ajax.request({
			url : contextPath + '/dept/getById.action',
			params : {
				deptId : '1'
			},
			success : function(resp){
				var obj = Ext.util.JSON.decode(resp.responseText);
				thiz.getRootNode().setText(obj.deptName);
				
			}, 
			failure : function(){
				Ext.Msg.alert('提示', '服务器异常，请稍后再试！');
			}
		});
		
		this.getLoader().on("beforeload", function(treeLoader, node) {
			if (!node.isLeaf()) {
				treeLoader.baseParams['pid'] = node.id;
			}
		}, this);
		
		//双击击时加载该部门的用户
		this.on('dblclick', function(node){
			if(node.getDepth()>0){
				var grid = Ext.getCmp('userGridPanel');
				grid.getStore().baseParams = {};
				grid.getStore().baseParams = {
					"userView.deptId" : node.id
				}
				grid.getStore().load({
					params : {
						start : 0,
						limit : UsersPageSize
					}
				});
			}
			
		}, this);
		
		this.getRootNode().expand();
	}
});
