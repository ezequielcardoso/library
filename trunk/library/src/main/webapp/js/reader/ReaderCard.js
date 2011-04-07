Ext.onReady(function(){

	var readerCardGridPanel = new Library.readerCard.grid.ReaderCardGridPanel();
	
	readerCardGridPanel.render('readerCardGrid');
	
	readerCardGridPanel.getStore().load({
	   params:{
	     'start' : 0,
		 'limit' : ReaderCardPageSize
	   }
	});
	
});