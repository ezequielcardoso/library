Ext.onReady(function(){

	var magazineOrderGridPanel = new Library.magazineOrder.grid.MagazineOrderGridPanel();
	
	magazineOrderGridPanel.render('magazineOrderGrid');
	

	magazineOrderGridPanel.getStore().load({
							params : {
								'start' : 0,
								'limit' : MagazinesPageSize
							}
						});
});
