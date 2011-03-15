Ext.ns('Library.basic.tree');
Library.basic.tree.BaseCheckTree = Ext.extend(Library.basic.tree.BaseTree, {

	initComponent : function() {
		this.listeners = {
			'checkchange' : this.changeNodeCss,
			'check' : this.changeNodeCss
		};
		this.isChecked = true;
		Library.basic.tree.BaseCheckTree.superclass.initComponent.call(this, arguments);
	},
	changeNodeCss : function(node, checked) {
		if (checked) {
			Ext.getCmp('checkBox').addItem({
				id : node.id,
				name : node.text
			});
			node.getUI().addClass('complete');
		} else {
			Ext.getCmp('checkBox').clearValue()
			node.getUI().removeClass('complete');
		}
	},
	autoScroll : true,
	animate : true,
	containerScroll : true,
	frame : false
});