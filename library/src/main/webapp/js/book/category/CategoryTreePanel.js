Ext.ns('Library.book.tree');

Library.book.tree.CategoryTreePanel = Ext.extend(Ext.tree.TreePanel, {
	
	id : null,
//	url : null,
	
	initComponent : function(){
		
		Ext.apply(this, {
			width : 400,
		    height : 500,
		    autoScroll: true,
		    animate: true,
		    containerScroll: true,
		    border: true,
		    dataUrl:contextPath + '/book/findCategorys.action',
//		    dataUrl:contextPath +'/js/book/category/category.json',
		    root: {
		        nodeType: 'async',
		        text: '中图法',
		        draggable: false,
		        id: 'cate-Root'
		    }
		
		});
		
		Library.book.tree.CategoryTreePanel.superclass.initComponent.call(this);
		
	}
});
