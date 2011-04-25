Ext.ns('Library.readerStatic.grid');

Library.readerStatic.grid.ReaderStaticGridPanel = Ext.extend(Ext.grid.GridPanel, {

	id : 'readerStaticGridPanel',

	initComponent : function() {

		var tbar = new Ext.Toolbar({
					items : [ {
								text : '导出Excel',
								iconCls : 'library-export-excel',
								handler : function() {
                                   this.onExport();
								},
								scope:this
							}, '->', {
								xtype : 'label',
								text : '姓名：'
							}, {
								xtype : 'textfield',
								width : 100,
								id : 'query_readerName'
							}, '-', {
								xtype : 'label',
								text : '借阅证号：'
							}, {
								xtype : 'textfield',
								width : 100,
								id : 'query_cardNo'
							}, '-', {
								xtype : 'label',
								text : '部门：'
							}, {
								xtype : 'textfield',
								width : 100,
								id : 'query_unitName'
							}, '-', {
								xtype : 'label',
								text : '读者类别：'
							}, {
								xtype : 'textfield',
								width : 100,
								id : 'query_readerCateName'
							}, {
								text : '查询',
								iconCls : 'library-query',
								handler : function() {
									 this.onQuery();
								},
								scope : this
							}, '-', {
								text : '刷新',
								iconCls : 'library-refresh',
								handler : function() {
									 this.onRefresh();
								},
								scope : this
							}]
				});

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
						'limit' : ReaderStaticsPageSize
					},
					fields : fields,
					storeInfo : {
						field : '列名',
						direction : 'ASC|DESC'
					}
				});

		
		var cm = new Ext.grid.ColumnModel([
		       new Ext.grid.RowNumberer(), 
		       {
					header : '借阅证号',
					width : 100,
					sortable : true,
					align : 'center',
					dataIndex : 'cardNo'
				}, {
					header : '条形码',
					width : 100,
					sortable : true,
					align : 'center',
					dataIndex : 'barCode'
				}, {
					header : '读者姓名',
					width : 100,
					sortable : true,
					align : 'center',
					dataIndex : 'readerName'
				}, {
					header : '性別',
					width : 100,
					sortable : true,
					align : 'center',
					dataIndex : 'sex'
				}, {
					header : '当前借阅数量',
					width : 100,
					sortable : true,
					align : 'center',
					dataIndex : 'borrowedQuantiy'
				}, {
					header : '累计借阅数量',
					width : 100,
					sortable : true,
					align : 'center',
					dataIndex : 'totalBQuantity'
				}, {
					header : '读者部门',
					width : 150,
					sortable : true,
					align : 'center',
					dataIndex : 'unitName'
				}, {
					header : '读者类别',
					width : 100,
					sortable : true,
					align : 'center',
					dataIndex : 'readerCateName'
				} ]);

		Ext.apply(this, {
					width : 1000,
					height : 530,
					autoScroll : true,
					tbar : tbar,
					buttonAlign : 'left',
					cm : cm,
					store : store,
					stripeRows : true,
					columnLines : true,
					frame : true,
					bbar : new Ext.Toolbar([new Ext.PagingToolbar({
							store : store,
							pageSize : ReaderStaticsPageSize,
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
		         	]),
					loadMask : '正在加载......',
					viewConfig : new Ext.grid.GridView({
								rowHeight : 23,
								scrollDelay : false,
								columnsText : '显示的列',
								scrollOffset : 30,
								sortAscText : '升序',
								sortDescText : '降序'
							})
				});

		Library.readerStatic.grid.ReaderStaticGridPanel.superclass.initComponent.call(this);


	},
	onQuery : function() {
		var readerName = Ext.get('query_readerName').getValue();
		var cardNo = Ext.get('query_cardNo').getValue();
		var unitName = Ext.get('query_unitName').getValue();
		var readerCateName = Ext.get('query_readerCateName').getValue();
		this.getStore().baseParams = {
			'readerView.readerName' : readerName,
			'readerView.cardNo' : cardNo,
			'readerView.unitName' : unitName,
			'readerView.readerCateName' : readerCateName
		};
		this.getStore().load({
					params : {
						start : 0,
						limit : ReadersPageSize
					}
				})
	},
	
	onExport : function() {
        var readerName = Ext.get('query_readerName').getValue();
		var cardNo = Ext.get('query_cardNo').getValue();
		var unitName = Ext.get('query_unitName').getValue();
		var readerCateName = Ext.get('query_readerCateName').getValue();
		
		Ext.Ajax.request({
				url : contextPath+ '/reader/exportReaderBorrowedExcel.action',
				method : 'POST',
				params : {
					'readerView.readerName' : readerName,
			        'readerView.cardNo' : cardNo,
			        'readerView.unitName' : unitName,
			        'readerView.readerCateName' : readerCateName
				},
				success : function(resp) {
					var respText = resp.responseText;
					var obj = Ext.util.JSON.decode(respText);
					if (obj.success) {
						window.location.href = contextPath + "/file/downloadFile.action?fileName=" + obj.data;
					} else {
						Ext.Msg.alert('提示',obj.msg);
					}
				},
				failure : function() {
					Ext.Msg.alert('提示', '服务器异常');
				}
			});
	},
      onRefresh : function(){
    	
    	this.getStore().baseParams = {};

    	
        this.getStore().load({
						params : {
							'start' : 0,
							'limit' : ReaderStaticsPageSize
						}
					});
    }
});
