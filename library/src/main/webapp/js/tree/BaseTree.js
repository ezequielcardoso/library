/**
 * 
 */
Ext.ns('Library.basic.tree');
Library.basic.tree.BaseTree = Ext.extend(Ext.tree.TreePanel, {
	
	url : null,
	rootNode : null,
	isChecked : false,

	initComponent : function() {
		Ext.apply(this, {
			root : new Ext.tree.AsyncTreeNode(this.rootNode),
			loader : new Ext.tree.TreeLoader({
				dataUrl : this.url
			})
		});
		if (this.isChecked)
			this.loader.baseAttrs = {
				uiProvider : Ext.ux.TreeCheckNodeUI
			};
		Library.basic.tree.BaseTree.superclass.initComponent.call(this, arguments);
	}
});
