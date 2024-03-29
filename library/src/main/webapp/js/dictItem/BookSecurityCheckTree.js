Ext.ns('Library.tree.dict');

Library.tree.dict.BookSecurityCheckTree = Ext.extend(Library.tree.BaseCheckTree, {

	initComponent : function() {
		Ext.apply(this, {
			height : 400,
			autoWidth : true,
			border : false
		});
		this.rootNode = {
			text : '不显示的节点',
			id : 'BookSecurity',
			expanded : true
		};
		this.url = contextPath + '/dict/getChildrenByPid.action';
		this.rootVisible = false;
		this.isChecked = true;
		Library.tree.dict.BookSecurityCheckTree.superclass.initComponent
				.call(this, arguments);
		this.getLoader().on("beforeload", function(treeLoader, node) {
			if (!node.isLeaf()) {
				treeLoader.baseParams['pid'] = node.id;
				treeLoader.baseParams['className'] = 'BookSecurity';
			}
		});
	},
	autoScroll : true,
	animate : true,
	containerScroll : true,
	frame : false
});
