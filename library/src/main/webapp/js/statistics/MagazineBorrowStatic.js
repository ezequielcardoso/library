Ext.onReady(function(){

	var magazineStaticsGridPanel = new Library.magazine.statics.grid.MagazineStaticsGridPanel();
	
	magazineStaticsGridPanel.render('magazineStaticsGrid');
	

	magazineStaticsGridPanel.getStore().load({
							params : {
								'start' : 0,
								'limit' : MagazinesPageSize
							}
						});
});
