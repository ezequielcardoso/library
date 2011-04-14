Ext.onReady(function() {

	//var bookReturnByBarGridPanel = new Library.bookReturn.bookBar.grid.BookReturnByBarGridPanel();
	
	var magazineReturnGridPanel= new Library.magazineReturn.grid.MagazineReturnGridPanel();

	//bookReturnByBarGridPanel.render('bookReturnByBarGrid');
	
    magazineReturnGridPanel.render('magazineReturnGrid');
	
});
