Ext.onReady(function(){

	var readerGridPanel = new Library.reader.grid.ReaderGridPanel();
	
	readerGridPanel.render('readerGrid');
	
	readerGridPanel.getStore().load({
						params : {
							'start' : 0,
							'limit' : ReadersPageSize
						}
					});
	
});