Ext.ns('Library.tree.dict');

Library.tree.dict.CurrencyCheckTree = Ext.extend(Library.tree.BaseCheckTree, {

	initComponent : function() {
		Ext.apply(this, {
			height : 400,
			autoWidth : true,
			border : false
		});
		this.rootNode = {
			text : '不显示的节点',
			id : 'Currency',
			expanded : true
		};
		this.url = contextPath + '/dict/getChildrenItem.action';
		this.rootVisible = false;
		this.isChecked = true;
		Library.tree.dict.CurrencyCheckTree.superclass.initComponent
				.call(this, arguments);
		this.getLoader().on("beforeload", function(treeLoader, node) {
			if (!node.isLeaf()) {
				treeLoader.baseParams['pid'] = node.id;
				treeLoader.baseParams['className'] = 'Currency';
			}
		});
	},
	autoScroll : true,
	animate : true,
	containerScroll : true,
	frame : false
});
