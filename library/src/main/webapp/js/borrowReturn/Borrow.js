Ext.onReady(function() {

			var borrowTabPanel = new Ext.TabPanel({
						// renderTo: Ext.getBody(),
						activeTab : 0,
						width : 600,
						height : 250,
						items : [{
									title : '读者信息',
									html : 'A simple tab'
								}, {
									title : '图书信息',
									html : 'Another one'
								}]
					});

			borrowTabPanel.render('borrowTab');

		});