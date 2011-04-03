Ext.onReady(function(){

	var bookGridPanel = new Library.book.grid.BookGridPanel();
	
	bookGridPanel.render('bookGrid');
	

	bookGridPanel.getStore().load({
							params : {
								'start' : 0,
								'limit' : BooksPageSize
							}
						});
});
