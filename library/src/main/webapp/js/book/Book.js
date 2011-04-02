Ext.onReady(function(){

	var bookGridPanel = new Library.book.grid.BookGridPanel();
	
	bookGridPanel.render('bookGrid');
	

	bookGridPanel.getStore().load({
							params : {
								'bookView.start' : 0,
								'bookView.limit' : BooksPageSize
							}
						});
});
