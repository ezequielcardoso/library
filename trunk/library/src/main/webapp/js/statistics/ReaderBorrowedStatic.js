Ext.onReady(function(){

	
	var readerStaticGridPanel = new Library.readerStatic.grid.ReaderStaticGridPanel();
	readerStaticGridPanel.render('readerStaticGrid');
	
	readerStaticGridPanel.getStore().load({
						params : {
							'start' : 0,
							'limit' : ReaderStaticsPageSize
						}
					});
	
});