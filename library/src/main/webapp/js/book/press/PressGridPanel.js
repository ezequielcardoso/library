Ext.ns('Library.book.press');

Library.book.press.PressGridPanel = Ext.extend(Ext.grid.GridPanel, {

    id:'pressGridPanel',
	
	initComponent : function() {
		
		var tbar = new Ext.Toolbar({
					items : [{
								text : '��ѯ',
								handler : function() {

								}
							}, {
								text : 'ɾ��',
								handler : function() {
								}
							}, {
								text : '�޸�',
								handler : function() {
								}
							}, {
								text : '����',
								handler : function() {
								},
								scope : this
							}, {
								text : '��������',
								handler : function() {
								}
							}, {
								text : '����excel',
								handler : function() {
								}
							}, {
								text : '��ӡ',
								handler : function() {
								}
							}]
				});

		var data = [[1, '7-5336', '���ս���������', '�Ϸ�', '230063'],
				[2, '7-5337', '���տ�ѧ����������', '�Ϸ�', '230063'],
				[3, '7-5398', '��������������', '�Ϸ�', '230063']];

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

		var store = new Ext.data.SimpleStore({
					data : data,
					fields : fields
				});
		
		var cm = new Ext.grid.ColumnModel({
			header:'id',
			dataIndex:'pressId'
		},{
			header:'���������',
			dataIndex:'pressISBN'
		},{
			header:'����',
			dataIndex:'pressName'
		},{
			header:'�����',
			dataIndex:'pressAddress'
		},{
			header:'�ʱ�',
			dataIndex:'zipCode'
		});		

		Ext.apply(this, {
//					title : '�������б�',
			height : 600,
					width : 300,
					tbar : tbar,
					store : store,
					cm :cm
//					re
				});
				
		Library.book.press.PressGridPanel.superclass.initComponent.call(this);
	}
});