Ext.onReady(function() {

	var magazineBorrowGridPanel = new Library.magazineBorrow.grid.MagazineBorrowGridPanel();

	        magazineBorrowGridPanel.render('magazineBorrowGrid');

			magazineBorrowGridPanel.getStore().load({
						params : {
							'start' : 0,
							'limit' : MagazinesPageSize
						}
					});
});
