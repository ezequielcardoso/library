Ext.onReady(function(){

	var ReaderAccountGridPanel = new Library.readerAccount.grid.ReaderAccountGridPanel();
	
	ReaderAccountGridPanel.render('readerAccountGrid');
	

	ReaderAccountGridPanel.getStore().load({
							params : {
								'start' : 0,
								'limit' : BooksPageSize
							}
						});
});
