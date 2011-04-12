Ext.ns('Library.borrow.tabPanel');

Library.borrow.tabPanel.BorrowTabPanel = Ext.extend(Ext.TabPanel, {

			id : 'borrowTabPanel',

			initComponent : function() {

				Ext.apply(this, {
                            width:400,
                            
							activeTab : 0,
							items : [{  
								        xtype : '',
										title : 'Tab 1',
										html : 'A simple tab'
									}, {
										title : 'Tab 2',
										html : 'Another one'
									}]

						});

				Library.borrow.tabPanel.BorrowTabPanel.superclass
						.initComponent(this);
			}

		});