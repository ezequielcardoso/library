Ext.ns('Library.bookSecurity.panel');

Library.bookSecurity.panel.BookSecurityPanel = Ext.extend(Ext.grid.GridEditor,
		{

			id : 'bookSecurityPanel',

			initComponent : function() {

				Ext.grid.EditorGridPanel.superclass.initComponent.call(this);

				var tbar = new Ext.Toolbar([{
							xtype : 'button',
							text : '����'
						}, '-',{
							xtype : 'button',
							text : '�޸�'
						}, '-', {
							xtype : 'button',
							text : 'ɾ��'
						}]);
                
                var cm = new Ext.grid.ColumnModel([]); 
                
				Ext.apply(this, {
					        width:400,
                            height:600,
							autoScroll : true,
							tbar : tbar,
							cm : cm,
                            store:store 
						});

			}

		});