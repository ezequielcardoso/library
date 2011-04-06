Ext.onReady(function(){

	var readerTypeGridPanel = new Library.readerType.grid.ReaderTypeGridPanel();
	
	readerTypeGridPanel.render('readerTypeGrid');
	
	
	readerTypeGridPanel.getStore().load({
	   params:{
	     'start' : 0,
		 'limit' : ReaderTypesPageSize
	   }
	});
});