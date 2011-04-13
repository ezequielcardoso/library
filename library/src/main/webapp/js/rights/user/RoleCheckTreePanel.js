Ext.ns('Library.rights.tree');

Library.rights.tree.RoleCheckTreePanel = Ext.extend(Library.tree.BaseCheckTree, {

	id : 'roleCheckTreePanel',
	
	userId : null,
	
	initComponent : function() {
		Ext.apply(this, {
			title : '角色列表',
			width : 250,
			height : 500,
			border : true
		});
		this.rootNode = {
			text : '不显示的节点',
			id : 'RoleRoot',
			expanded : true
		};
		this.url = contextPath + '/role/findAllByUserId.action';
		this.rootVisible = false;
		this.isChecked = true;
		Library.rights.tree.RoleCheckTreePanel.superclass.initComponent.call(this, arguments);
		
		this.getLoader().on("beforeload", function(treeLoader, node) {
			if (!node.isLeaf()) {
				treeLoader.baseParams['roleView.userId'] = this.userId;
			}
		}, this);
	}
});
