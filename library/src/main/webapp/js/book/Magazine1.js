Ext.onReady(function(){
	
	var magazineGridPanel = new Library.magazine.grid.MagazineGridPanel();
	magazineGridPanel.render('magazineGrid');
	magazineGridPanel.getStore().load({
							params : {
								'bookView.start' : 0,
								'bookView.limit' : BooksPageSize
							}
						});
	
});

