Ext.ns('Library.tree.dict');

Library.tree.dict.BookStateCheckTree = Ext.extend(Library.tree.BaseCheckTree, {

	initComponent : function() {
		Ext.apply(this, {
			height : 400,
			autoWidth : true,
			border : false
		});
		this.rootNode = {
			text : '不显示的节点',
			id : 'BookState',
			expanded : true
		};
		this.url = contextPath + '/dict/getChildrenItem.action';
		this.rootVisible = false;
		this.isChecked = true;
		Library.tree.dict.BookStateCheckTree.superclass.initComponent
				.call(this, arguments);
		this.getLoader().on("beforeload", function(treeLoader, node) {
			if (!node.isLeaf()) {
				treeLoader.baseParams['pid'] = node.id;
				treeLoader.baseParams['className'] = 'BookState';
			}
		});
	},
	autoScroll : true,
	animate : true,
	containerScroll : true,
	frame : false
});
