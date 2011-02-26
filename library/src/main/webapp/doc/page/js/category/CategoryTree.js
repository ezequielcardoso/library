Ext.ns('Library.category.tree');

Library.category.tree.CategoryTree = Ext.extend(Ext.tree.TreePanel, {
	
	id : null,
	url : null,
	
	initComponent : function(){
		
		Ext.apply(this, {
			width : 350,
		    height : 500,
		    autoScroll: true,
		    animate: true,
		    containerScroll: true,
		    border: true,
		    dataUrl: this.url,
		    root: {
		        nodeType: 'async',
		        text: '中图法',
		        draggable: false,
		        id: 'cate-Root'
		    }
		
		});
		
		Library.category.tree.CategoryTree.superclass.initComponent.call(this);
		
	}
});
