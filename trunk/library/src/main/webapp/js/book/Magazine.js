Ext.onReady(function(){
	
	var magazineGridPanel = new Library.magazine.grid.MagazineGridPanel();
	
	magazineGridPanel.render('magazineGrid');

	magazineGridPanel.getStore().load({
							params : {
								'magazineView.start' : 0,
								'magazineView.limit' : BooksPageSize
							}
						});
	Ext.MessageBox.alert('title','liaos');
	
});

