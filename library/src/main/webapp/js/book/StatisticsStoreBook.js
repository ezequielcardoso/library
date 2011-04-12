Ext.onReady(function(){

	var  staticsStoreBookGridPanel= new Library.book.grid.child.statics.StaticsStoreBookGridPanel();
	
	staticsStoreBookGridPanel.render('staticsStoreBookGrid');
	
	staticsStoreBookGridPanel.getStore().load({
							params : {
								'start' : 0,
								'limit' : BooksPageSize
							}
						});
	
});