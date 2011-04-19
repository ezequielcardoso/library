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
		
		this.on('checkchange', function(node, checked ){
			var id = node.attributes.id;
			Ext.Ajax.request({
				url : contextPath + '/role/setUserRole.action',
				params : {
					'roleView.userId' : this.userId,
					'roleView.roleId' : id,
					'roleView.checked' : checked
				},
				success : function(resp){
					var obj = Ext.util.JSON.decode(resp.responseText);
					if(obj.success){
						Ext.Msg.alert('提示', obj.msg);
					} else {
						Ext.Msg.alert('提示', obj.msg);
						this.getRootNode().reload();
					}
					
				}, 
				failure : function(){
					Ext.Msg.alert('提示', '服务器异常，请稍候再试');
				},
				scope : this
			});	
		}, this);
	}
});
