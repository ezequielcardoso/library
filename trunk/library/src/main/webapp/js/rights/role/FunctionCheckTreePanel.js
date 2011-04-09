Ext.ns('Library.rights.tree');

Library.rights.tree.FunctionCheckTreePanel = Ext.extend(Library.tree.BaseCheckTree, {
	
	id : 'functionCheckTreePanel',
	
	roleId : null,
	
	initComponent : function(){
		
		this.rootNode = {
			text : '不显示的节点',
			id : 'Root',
			expanded : true
		};
		this.url = contextPath + '/function/getAllByRoleId.action';
		this.rootVisible = false;
		this.isChecked = true;
		
		Ext.apply(this, {
			title : '资源列表',
			width : 300,
		    height : 500,
		    border : true
		});
		
		Library.rights.tree.FunctionCheckTreePanel.superclass.initComponent.call(this);
		
		this.getLoader().on("beforeload", function(treeLoader, node) {
			if (!node.isLeaf()) {
				treeLoader.baseParams['roleId'] = this.roleId;
			}
		}, this);
	}
});
