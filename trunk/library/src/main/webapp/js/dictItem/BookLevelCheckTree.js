Ext.ns('Library.tree.dict');

Library.tree.dict.BookLevelCheckTree = Ext.extend(Library.tree.BaseCheckTree, {

	initComponent : function() {
		Ext.apply(this, {
			height : 400,
			autoWidth : true,
			border : false
		});
		this.rootNode = {
			text : '不显示的节点',
			id : 'BookLevel',
			expanded : true
		};
		this.url = contextPath + '/dict/getChildrenItem.action';
		this.rootVisible = false;
		this.isChecked = true;
		Library.tree.dict.BookLevelCheckTree.superclass.initComponent
				.call(this, arguments);
		this.getLoader().on("beforeload", function(treeLoader, node) {
			if (!node.isLeaf()) {
				treeLoader.baseParams['pid'] = node.id;
				treeLoader.baseParams['className'] = 'BookLevel';
			}
		});
	},
	autoScroll : true,
	animate : true,
	containerScroll : true,
	frame : false
});
