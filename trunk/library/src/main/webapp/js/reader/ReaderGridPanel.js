Ext.ns('Library.reader.grid');

Library.reader.grid.ReaderGridPanel = Ext.extend(Ext.grid.GridPanel, {

	id : 'readerGridPanel',

	initComponent : function() {

		var tbar = new Ext.Toolbar({
					items : [{
								text : '��ѯ',
								handler : function() {

								}
							},'-', {
								text : '�޸�',
								handler : function() {
									// this.onMOdify();
								},
								scope : this
							}, '-',{
								text : 'ɾ��',
								handler : function() {
									// this.onDelete();
								},
								scope : this
							}, '-',{
								text : '����',
								handler : function() {
									// this.onAdd();
								},
								scope : this
							}, '-',{
								text : '����',
								handler : function() {

								}
							},'-', {
								text : '����Excel',
								handler : function() {

								}
							},'-', {
								text : '��ӡ',
								handler : function() {
								}
							}]

				});
				
		var sm = new Ext.grid.CheckboxSelectionModel();

		var cm = new Ext.grid.ColumnModel([new Ext.grid.RowNumberer(), sm, {
					header : '������',
					width : 100,
					sortable : true,
					align : 'center',
					editor : new Ext.form.TextField({
								allowBlank : true
							}),
					dataIndex : 'readerCateCode'
				},'-', {
					header : '�������',
					width : 300,
					sortable : true,
					align : 'center',
					editor : new Ext.form.TextField({
								allowBlank : false
							}),
					dataIndex : 'readerCateName'
				},'-', {
					header : '��������',
					width : 300,
					sortable : true,
					align : 'center',
					editor : new Ext.form.TextField({
								allowBlank : false
							}),
					dataIndex : 'borrowDays'
				},'-', {
					header : '��������',
					width : 100,
					sortable : true,
					align : 'center',
					editor : new Ext.form.TextField({
								allowBlank : false
							}),
					dataIndex : 'borrowedQuantity'
				},'-', {
					header : '���',
					width : 100,
					sortable : true,
					align : 'center',
					editor : new Ext.form.TextField({
								allowBlank : false
							}),
					dataIndex : 'rent'
				}]);

		var fields = [{
					name : 'pressId',
					type : 'int'
				}, {
					name : 'pressISBN',
					type : 'string'
				}, {
					name : 'pressName',
					type : 'string'
				}, {
					name : 'pressAddress',
					type : 'string'
				}, {
					name : 'zipCode',
					type : 'string'
				}];

		var store = new Ext.data.JsonStore({
					url : contextPath + '/book/findPresses.action',
					root : 'root',
					totalProperty : 'totalProperty',
					baseParams : {
						'start' : 0,
						'limit' : PressesPageSize
					},
					fields : fields,
					storeInfo : {
						field : '����',
						direction : 'ASC|DESC'
					}
				});

		var bbar = new Ext.Toolbar([new Ext.PagingToolbar({
					store : store,
					pageSize : PressesPageSize,
					afterPageText : '/ {0}',
					beforePageText : 'ҳ',
					displayInfo : true,
					firstText : '��һҳ',
					prevText : 'ǰһҳ',
					nextText : '��һҳ',
					lastText : '���һҳ',
					refreshText : 'ˢ��',
					displayMsg : '��ʾ�� {0}-{1}��  ��{2}�� ',
					emptyMsg : 'û������'
				})]);

		
		Ext.apply(this, {

					width : 1000,
					// height : document.documentElement.clientHeight * 0.82,
					height : 480,
					autoScroll : true,
					tbar : tbar,
					sm : sm,
					cm : cm,
					store : store,
					stripeRows : true,
					columnLines : true,
					frame : true,
					bbar : bbar,
					loadMask : '���ڼ���......',
					clicksToEdit : 1,
					viewConfig : new Ext.grid.GridView({
								rowHeight : 23,
								scrollDelay : false,
								columnsText : '��ʾ����',
								scrollOffset : 30,
								sortAscText : '����',
								sortDescText : '����'
							})

				});

		Library.reader.grid.ReaderGridPanel.superclass.initComponent.call(this);

	}

});