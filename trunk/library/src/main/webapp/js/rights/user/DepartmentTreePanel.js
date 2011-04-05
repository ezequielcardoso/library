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
				handler : function() {
					
				}
			}, {
				text : '修改',
				handler : function() {
					
				}
			},  {
				text : '删除',
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
		
	}
});
