Ext.onReady(function(){

	var categoryTree = new Library.category.tree.CategoryTree({
		id : 'categoryTree',
		url : 'category.json'
	});
	categoryTree.render('category-tree');
	
//	categoryTree.getRootNode().expand(false);
});

