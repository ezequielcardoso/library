Ext.onReady(function(){

	
	var readerUnitsTreePanel = new Library.reader.tree.ReaderUnitsTreePanel();
	readerUnitsTreePanel.render('readerUnitsTree');
	
	var readerGridPanel = new Library.reader.grid.ReaderGridPanel();
	readerGridPanel.render('readerGrid');
	
	
	
	readerGridPanel.getStore().load({
						params : {
							'start' : 0,
							'limit' : ReadersPageSize
						}
					});
	
});