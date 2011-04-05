Ext.ns('Library.tree.dict');

Library.tree.dict.CategoryCheckTree = Ext.extend(Library.tree.BaseCheckTree, {

	level : null,
	itemName : null,
	rootId : null,
	
	initComponent : function() {
		Ext.apply(this, {
			height : 400,
			autoWidth : true,
			border : false
		});
		this.rootNode = {
			text : '不显示的节点',
			id : this.rootId,
			expanded : true
		};
		this.url = contextPath + '/dict/getCategoryItem.action';
		this.rootVisible = false;
		this.isChecked = true;
		Library.tree.dict.CategoryCheckTree.superclass.initComponent
				.call(this, arguments);
		this.getLoader().on("beforeload", function(treeLoader, node) {
			if (!node.isLeaf()) {
				treeLoader.baseParams['pid'] = node.id;
				treeLoader.baseParams['level'] = this.level;
				treeLoader.baseParams['itemName'] = this.itemName;
			}
		}, this);
	},
	autoScroll : true,
	animate : true,
	containerScroll : true,
	frame : false
});
