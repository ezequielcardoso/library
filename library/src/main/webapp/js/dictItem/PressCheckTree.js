Ext.ns('Library.tree.dict');

Library.tree.dict.PressCheckTree = Ext.extend(Library.tree.BaseCheckTree, {

	initComponent : function() {
		Ext.apply(this, {
			height : 400,
			autoWidth : true,
			border : false
		});
		this.rootNode = {
			text : '不显示的节点',
			id : 'Press',
			expanded : true
		};
		this.url = contextPath + '/press/getPressItem.action';
		this.rootVisible = false;
		this.isChecked = true;
		Library.tree.dict.PressCheckTree.superclass.initComponent
				.call(this, arguments);
	},
	autoScroll : true,
	animate : true,
	containerScroll : true,
	frame : false
});
