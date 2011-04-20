Ext.onReady(function(){

	var magazineOrderGridPanel = new Library.magazineOrder.grid.MagazineOrderGridPane();
	
	magazineOrderGridPanel.render('magazineOrderGrid');
	

	magazineOrderGridPanel.getStore().load({
							params : {
								'start' : 0,
								'limit' : MagazinesPageSize
							}
						});
});
