Ext.onReady(function() {

	var pressGridPanel = new Library.press.grid.PressGridPanel();

			pressGridPanel.render('pressGrid');
	pressGridPanel.render('pressGrid');

			pressGridPanel.getStore().load({
						params : {
							'start' : 1,
							'limit' : 10
						}
					});
		});
	pressGridPanel.getStore().load({
				params : {
					'start' : 0,
					'limit' : PressesPageSize
				}
			});
});
