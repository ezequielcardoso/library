Ext.ns('Library.bookReturn.grid');

Library.bookReturn.grid.BookReturnGridPanel = Ext.extend(
		Ext.grid.EditorGridPanel, {

			id : 'bookReturnGridPanel',

			initComponent : function() {

				// 操作图书列表的工具条
				var tbar = new Ext.Toolbar({
							items : [{
										xtype : 'label',
										width:80,
										text : '读者条形码：'
									}, {
										xtype : 'textfield',
										width : 100,
										id : 'readerBarCode'
									},{
										xtype : 'label',
										width:80,
										buttonAlign:'right',
										text : '输入读者借阅证号请回车..'
									},'-', {
										text : '增加',
										handler : function() {
											this.onAdd();
										},
										scope : this
									}, '-', {
										text : '归还',
										handler : function() {
											this.onBorrowed();
										},
										scope : this
									}]
						});

				var sm = new Ext.grid.CheckboxSelectionModel();

				var cm = new Ext.grid.ColumnModel([new Ext.grid.RowNumberer(),
						sm, {
							header : '图书条形码',
							width : 100,
							sortable : true,
							align : 'center',
							editor : new Ext.form.TextField({
										allowBlank : false
									}),
							dataIndex : 'bookBarCode'
						}, {
							header : '读者姓名',
							width : 100,
							sortable : true,
							align : 'center',
							dataIndex : 'readerName'
						}, {
							header : '书名',
							width : 80,
							sortable : true,
							align : 'center',
							dataIndex : 'bookName'
						}, {
							header : '借阅日期',
							width : 100,
							sortable : true,
							align : 'center',
							dataIndex : 'borrowedDate'
						}, {
							header : '应还日期',
							width : 100,
							sortable : true,
							align : 'center',
							dataIndex : 'duetoReturnDate'
						}, {
							header : '超期天数',
							width : 100,
							sortable : true,
							align : 'center',
							dataIndex : 'overdueDays'
						}, {
							header : '罚金',
							width : 80,
							sortable : true,
							align : 'center',
							editor : new Ext.form.TextField({
										allowBlank : false
									}),
							dataIndex : 'puniMoney'
						}, {
							header : '是或缴款',
							width : 60,
							sortable : true,
							align : 'center',
							editor : new Library.combo.ArrayLocalComboBox({
										storeArray : [['是', '是'], ['否', '否']],
										listeners : {
											select : function(t) {
											},
											scope : this
										}
									}),
							dataIndex : 'isPay'
						}, {
							header : '图书状态',
							width : 80,
							sortable : true,
							align : 'center',
							dataIndex : 'bookStateName'
						}, {
							header : '图书类别',
							width : 80,
							sortable : true,
							align : 'center',
							dataIndex : 'firstCategoryName'
						}, {
							header : '读者单位',
							width : 100,
							sortable : true,
							align : 'center',
							dataIndex : 'unitName'
						}, {
							header : '读者类别',
							width : 80,
							sortable : true,
							align : 'center',
							dataIndex : 'readerCateName'
						}, {
							header : '存放位置',
							width : 80,
							sortable : true,
							align : 'center',
							dataIndex : 'location'
						}, {
							header : '借阅操作员',
							width : 80,
							sortable : true,
							align : 'center',
							dataIndex : 'borrowOperator'
						}]);

				var fields = [{
							name : 'id',
							type : 'int'
						}, {
							name : 'borrowedDate',
							type : 'string'
						}, {
							name : 'duetoReturnDate',
							type : 'string'
						}, {
							name : 'realityReturndate',
							type : 'string'
						}, {
							name : 'overdueDays',
							type : 'int'
						}, {
							name : 'puniMoney',
							type : 'float'
						}, {
							name : 'isPay',
							type : 'int'
						}, {
							name : 'renewTimes',
							type : 'int'
						}, {
							name : 'borrowOperator',
							type : 'string'
						}, {
							name : 'returnOperator',
							type : 'string'
						}, {
							name : 'bookId',
							type : 'int'
						}, {
							name : 'bookNo',
							type : 'string'
						}, {
							name : 'bookBarCode',
							type : 'string'
						}, {
							name : 'bookName',
							type : 'string'
						}, {
							name : 'location',
							type : 'int'
						}, {
							name : 'firstCategoryId',
							type : 'float'
						}, {
							name : 'firstCategoryCode',
							type : 'string'
						}, {
							name : 'firstCategoryName',
							type : 'string'
						}, {
							name : 'bookStateId',
							type : 'string'
						}, {
							name : 'bookStateName',
							type : 'int'
						}, {
							name : 'readerId',
							type : 'int'
						}, {
							name : 'readerName',
							type : 'string'
						}, {
							name : 'cardNo',
							type : 'string'
						}, {
							name : 'readerBarCode',
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
							name : 'readerTypeId',
							type : 'int'
						}, {
							name : 'readerCateCode',
							type : 'string'
						}, {
							name : 'readerCateName',
							type : 'string'
						}];

				var store = new Ext.data.JsonStore({
							// url : contextPath + '/book/findBooks.action',
							root : 'root',
							totalProperty : 'totalProperty',
							baseParams : {
								'start' : 0,
								'limit' : BooksPageSize
							},
							fields : fields,
							storeInfo : {
								field : '列名',
								direction : 'ASC|DESC'
							}
						});

				Ext.apply(this, {
							width : 1200,
							height : 500,
							autoScroll : true,
							tbar : tbar,
							sm : sm,
							cm : cm,
							store : store,
							stripeRows : true,
							columnLines : true,
							frame : true,
							clicksToEdit : 1,
							viewConfig : new Ext.grid.GridView({
										rowHeight : 23,
										scrollDelay : false,
										columnsText : '显示的列',
										scrollOffset : 30,
										sortAscText : '升序',
										sortDescText : '降序'
									})
						});

				Library.bookReturn.grid.BookReturnGridPanel.superclass.initComponent
						.call(this);

				this.on('afteredit', function(e) {
					e.record.commit();
					var thiz = this;
					Ext.Ajax.request({
						url : contextPath
								+ '/borrowReturn/findByByBarCodeOrReaderCode.action',
						method : 'POST',
						params : {
							'borrowReturnView.bookBarCode' : e.record
									.get('bookBarCode')
						},
						success : function(resp) {
							var borrowReturn = Ext.util.JSON.decode(resp.responseText);
							e.record.set('id',borrowReturn.id);
							
//							e.record.set('readerName', borrowReturn.reader.readerName);
//							e.record.set('bookName', borrowReturn.book.bookName);
//							e.record.set('bookBarCode', borrowReturn.book.barCode);
							e.record.set('borrowedDate', borrowReturn.borrowedDate);
							e.record.set('duetoReturnDate', borrowReturn.duetoReturnDate);
							e.record.set('overdueDays', borrowReturn.overdueDays);
							e.record.set('isPay', borrowReturn.isPay);
//							e.record.set('bookStateName',borrowReturn.book.bookState.itemName);
//							e.record.set('firstCategoryName', borrowReturn.book.firstCategory.itemName);
//							e.record.set('unitName', borrowReturn.reader.readerUnits.unitName);
//							e.record.set('readerCateName', borrowReturn.reader.readerType.readerCateName);
//							e.record.set('location', borrowReturn.book.location);
							e.record.set('borrowOperator', borrowReturn.borrowOperator);
						
							e.record.commit();
						},
						failure : function() {
							Ext.Msg.alert('提示', '服务器异常，请稍候再试');
						}
					});
				}, this);
			},

			onAdd : function() {
				var BorrowReturn = this.getStore().recordType;
				var br = new BorrowReturn({
							bookBarCode : '',
							readerName : '',
							bookName : '',
							borrowedDate : '',
							duetoReturnDate : '',
							overdueDays : '',
							puniMoney : '',
							isPay : '',
							firstCategoryName : '',
							unitName : '',
							readerCateName : '',
							location : '',
							bookStateName : '',
							borrowOperator : ''
						});
				this.stopEditing();
				this.store.insert(0, br);
				this.startEditing(0, 0);
			},
			onBorrowed : function() {
				var cardNo = Ext.get('reader.cardNo').getValue();
				// var bookId = Ext.get('book.barCode').getValue();
				var sm = this.getSelectionModel();
				if (sm.hasSelection()) {
					Ext.MessageBox.confirm('提示', '你确定要借出图书吗？', function(btn,
							text) {
						if (btn == 'yes') {
							var records = sm.getSelections();
							for (var i = 0; i < records.length; i++) {
								var record = records[i];
								var bookId = record.get('bookId');
								var thiz = this;
								Ext.Ajax.request({
									url : contextPath
											+ '/borrowReturn/bookBorrow.action',
									method : 'POST',
									params : {
										'book.bookId' : bookId,
										'reader.cardNo' : cardNo
									},
									success : function(resp) {
										var respText = resp.responseText;
										var obj = Ext.util.JSON
												.decode(respText);
										if (obj.success == true) {
											Ext.Msg.alert('提示', obj.msg);
											thiz.getStore().reload();
										} else {
											Ext.Msg.alert('提示', obj.msg);
										}
									},
									failure : function() {
										Ext.Msg.alert('提示', '服务器异常');
									}
								});
							}
						} else {
							return false;
						}

					}, this);

				} else {
					Ext.Msg.alert('提示', '请选择你要借阅的图书');
				}
			},
			onExport : function() {

			},
			onPrint : function() {

			},

			loadPressForm : function() {
				Ext.get('book.bookId').setValue(record.bookId);
			}

		});
