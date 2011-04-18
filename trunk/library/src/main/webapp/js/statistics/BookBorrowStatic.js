Ext.onReady(function(){

	var bookStaticsGridPanel = new Library.book.statics.grid.BookStaticsGridPanel();
	
	bookStaticsGridPanel.render('bookStaticsGrid');
	

	bookStaticsGridPanel.getStore().load({
							params : {
								'start' : 0,
								'limit' : BooksPageSize
							}
						});
});
