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
				buttonAlign:'left',
				handler : function() {
					var node = this.getSelectionModel().getSelectedNode();
			    	if(node){
			    		this.selectNode = node;
				    	var pid = node.attributes.id;//取到父id
				    	//弹出增加部门表单window，把pid传过去
				    	
				    	
				    	
			    	}else{ 
						Ext.Msg.alert('提示', '请选择父功能');
					}
				}
			}, '-',{
				text : '修改',
				buttonAlign:'left',
				handler : function() {
					var node = this.getSelectionModel().getSelectedNode();
					if(node){
						this.selectNode = node;
						var id = node.attributes.id;
						//弹出修改部门表单window，把id传过去并加载上数据
						
					}else{
						Boa.Util.warn('请选择要修改的功能');
					}
				}
			}, '-',  {
				text : '删除',
				buttonAlign:'left',
				handler : function() {
					
				}
			}]
		});
    	return new Ext.Toolbar([tbar]);
    },
	
	initComponent : function() {
		
		this.url = contextPath + "/rights/getDeptChildrenItem.action";
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
			url : contextPath + '/rights/getDeptById.action',
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
		
		//单击时加载该部门的用户
		this.on('click', function(node){
			var grid = Ext.getCmp('userGridPanel');
			grid.getStore().baseParams = {
				"userView.deptId" : node.id
			}
			grid.getStore().load({
				params : {
					start : 0,
					limit : 20
				}
			});
		}, this);
		
	}
});
