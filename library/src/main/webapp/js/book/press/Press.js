Ext.onReady(function() {

			var pressGridPanel = new Library.press.grid.PressGridPanel();

			pressGridPanel.render('pressGridPanel');

			pressGridPanel.getStore().load({
						params : {
							'start' : 0,
							'limit' : PressesPageSize
						}
					});
		});