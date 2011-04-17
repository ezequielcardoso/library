Ext.ns('Library.rights.tree');

Library.rights.tree.DepartmentCheckTree = Ext.extend(Library.tree.BaseCheckTree, {

	initComponent : function() {
		Ext.apply(this, {
			height : 400,
			autoWidth : true,
			border : false
		});
		this.rootNode = {
			text : '',
			id : 1,
			expanded : true
		};
		this.url = contextPath + '/dept/getChildrenByPid.action';
		this.rootVisible = true;
		this.isChecked = true;
		Library.rights.tree.DepartmentCheckTree.superclass.initComponent
				.call(this, arguments);
				
		var thiz = this;
		Ext.Ajax.request({
			url : contextPath + '/dept/getById.action',
			params : {
				deptId : 1
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
				treeLoader.baseParams['isOptional'] = true;
			}
		}, this);
	},
	autoScroll : true,
	animate : true,
	containerScroll : true,
	frame : false
});
