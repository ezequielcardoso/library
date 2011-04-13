Ext.onReady(function() {

	var bookBorrowGridPanel = new Library.bookBorrow.grid.BookBorrowGridPanel();

	bookBorrowGridPanel.render('bookBorrowGrid');

			bookBorrowGridPanel.getStore().load({
						params : {
							'start' : 0,
							'limit' : BooksPageSize
						}
					});
});
