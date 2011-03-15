Ext.ns('Library.basic.tree');

Library.basic.tree.BookSourceCheckTree = Ext.extend(Library.basic.tree.BaseCheckTree, {

	initComponent : function() {
		Ext.apply(this, {
			height : 400,
			autoWidth : true,
			border : false
		});
		this.rootNode = {
			text : '不显示的节点',
			id : 'AN',
			expanded : true
		};
		this.url = contextPath + '/dict/getChildren.do';
		this.rootVisible = false;
		this.isChecked = true;
		Library.basic.tree.BookSourceCheckTree.superclass.initComponent
				.call(this, arguments);
		this.getLoader().on("beforeload", function(treeLoader, node) {
			if (!node.isLeaf()) {
				treeLoader.baseParams['pid'] = node.id;
				treeLoader.baseParams['className'] = 'BookSource';
			}
		});
	},
	autoScroll : true,
	animate : true,
	containerScroll : true,
	frame : false
});
