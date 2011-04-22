Ext.onReady(function(){

	var bookQueryGridPanel = new Library.bookQuery.grid.BookQueryGridPanel();
	
	bookQueryGridPanel.render('bookQueryGrid');
	

	bookQueryGridPanel.getStore().load({
							params : {
								'start' : 0,
								'limit' : BooksPageSize
							}
						});
});
