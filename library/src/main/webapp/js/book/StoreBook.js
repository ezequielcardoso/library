Ext.onReady(function(){

	var  storeGridPanel= new Library.book.store.StoreGridPanel();
	
	storeGridPanel.render('storeBookGrid');
	
	storeGridPanel.getStore().load({
							params : {
								'start' : 0,
								'limit' : BooksPageSize
							}
						});
	
});