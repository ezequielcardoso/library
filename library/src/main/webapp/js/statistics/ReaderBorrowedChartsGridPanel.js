Ext.ns('Library.readerCharts.grid');

Library.readerCharts.grid.ReaderChartsGridPanel = Ext.extend(Ext.grid.GridPanel, {

	id : 'readerChartsGridPanel',

	initComponent : function() {

		

		var fields = [{
					name : 'id',
					type : 'int'
				}, {
					name : 'cardNo',
					type : 'string'
				}, {
					name : 'password',
					type : 'string'
				}, {
					name : 'barCode',
					type : 'string'
				}, {
					name : 'readerName',
					type : 'string'
				}, {
					name : 'birthday',
				    type : 'date',
                    dateFormat : 'Y-m-d'
				}, {
					name : 'sex',
					type : 'string'
				}, {
					name : 'leftMoney',
					type : 'float'
				}, {
					name : 'email',
					type : 'string'
				}, {
					name : 'contactTel',
					type : 'string'
				}, {
					name : 'borrowedQuantiy',
					type : 'int'
				}, {
					name : 'totalBQuantity',
					type : 'int'
				}, {
					name : 'entyDate',
					type : 'date',
                    dateFormat : 'Y-m-d'
				}, {
					name : 'effectiveDate',
					type : 'date',
                    dateFormat : 'Y-m-d'
				}, {
					name : 'readerPic',
					type : 'string'
				}, {
					name : 'spell',
					type : 'string'
				}, {
					name : 'readerDesc',
					type : 'string'
				}, {
					name : 'unitId',
					type : 'int'
				}, {
					name : 'unitCode',
					type : 'string'
				}, {
					name : 'unitName',
					type : 'string'
				}, {
					name : 'certificateId',
					type : 'string'
				}, {
					name : 'certificateCode',
					type : 'string'
				}, {
					name : 'certificateName',
					type : 'string'
				}, {
					name : 'readerTypeId',
					type : 'int'
				}, {
					name : 'readerCateCode',
					type : 'string'
				}, {
					name : 'readerCateName',
					type : 'string'
				}, {
					name : 'cardStateId',
					type : 'string'
				}, {
					name : 'cardStateCode',
					type : 'string'
				}, {
					name : 'cardStateName',
					type : 'string'
				}];

		var store = new Ext.data.JsonStore({
					url : contextPath + '/reader/findReaders.action',
					root : 'root',
					totalProperty : 'totalProperty',
					baseParams : {
						'start' : 0,
						'limit' : ReaderChartsPageSize
					},
					fields : fields,
					storeInfo : {
						field : '列名',
						direction : 'ASC|DESC'
					}
				});

		
		var cm = new Ext.grid.ColumnModel([
		        {
					header : '读者姓名',
					width : 100,
					sortable : true,
					align : 'center',
					dataIndex : 'readerName'
				}, {
					header : '累计借阅数量',
					width : 100,
					sortable : true,
					align : 'center',
					dataIndex : 'totalBQuantity'
				} ]);

		Ext.apply(this, {
					width : 1200,
					height : 530,
					autoScroll : true,
					buttonAlign : 'left',
					cm : cm,
					store : store,
					stripeRows : true,
					columnLines : true,
					frame : true,
					   items: {
			           xtype: 'linechart',
			           store: store,
			           xField: 'readerName',
			           yField: 'totalBQuantity',
					listeners: {
							itemclick: function(o){
								var rec = store.getAt(o.index);
								Ext.example.msg('Item Selected', 'You chose {0}.', rec.get('name'));
							}
						}
			        },
					bbar : new Ext.Toolbar([new Ext.PagingToolbar({
							store : store,
							pageSize : ReaderChartsPageSize,
							afterPageText : '/ {0}',
							beforePageText : '页',
							displayInfo : true,
							firstText : '第一页',
							prevText : '前一页',
							nextText : '后一页',
							lastText : '最后一页',
							refreshText : '刷新',
							displayMsg : '显示第 {0}-{1}条 共{2}条 ',
							emptyMsg : '没有数据'
			         	})
		         	])
				});

		Library.readerCharts.grid.ReaderChartsGridPanel.superclass.initComponent.call(this);

        this.getStore().load({
	       params : {
				start : 0,
				limit : ReaderChartsPageSize
			}
	   });
	}
	
});
