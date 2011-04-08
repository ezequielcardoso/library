Ext.onReady(function(){
	
	var magazineGridPanel = new Library.magazine.grid.MagazineGridPanel();
	
	magazineGridPanel.render('magazineGrid');

	magazineGridPanel.getStore().load({
							params : {
								'start' : 0,
								'limit' : MagazinesPageSize
							}
						});
	
});
