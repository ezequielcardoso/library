Ext.onReady(function(){

	var bookOrderGridPanel = new Library.bookOrder.grid.BookOrderGridPanel();
	
	bookOrderGridPanel.render('bookOrderGrid');
	

	bookOrderGridPanel.getStore().load({
							params : {
								'start' : 0,
								'limit' : BooksPageSize
							}
						});
});
