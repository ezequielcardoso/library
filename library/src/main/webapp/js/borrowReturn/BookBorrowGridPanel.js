Ext.ns('Library.press.grid');

Library.press.grid.PressGridPanel = Ext.extend(Ext.grid.EditorGridPanel, {

	id : 'pressGridPanel',

	initComponent : function() {

		// 操作图书列表的工具条
		var tbar = new Ext.Toolbar({
					items : [{
								text : '增加',
								handler : function() {
									this.onAdd();
								},
								scope : this
							}, '-', {
								text : '导出Excel',
								handler : function() {

								}
							}, '-', {
								text : '打印',
								handler : function() {
								}
							}]
				});

		var sm = new Ext.grid.CheckboxSelectionModel();

		var cm = new Ext.grid.ColumnModel([new Ext.grid.RowNumberer(), sm, {
					header : '条形码',
					width : 100,
					sortable : true,
					align : 'center',
					editor : new Ext.form.TextField({
								allowBlank : false
							}),
					dataIndex : 'barCode'
				}, {
					header : '书名',
					width : 150,
					sortable : true,
					align : 'center',
					editor : new Ext.form.TextField({
								allowBlank : false
							}),
					dataIndex : 'bookName'
				}, {
					header : '类别',
					width : 100,
					sortable : true,
					align : 'center',
					editor : new Ext.form.TextField({
								allowBlank : false
							}),
					dataIndex : 'firstCategoryName'
				}, {
					header : '数量',
					width : 100,
					sortable : true,
					align : 'center',
					editor : new Ext.form.TextField({
								allowBlank : false
							}),
					dataIndex : 'quantity'
				}, {
					header : '存放位置',
					width : 100,
					sortable : true,
					align : 'center',
					editor : new Ext.form.TextField({
								allowBlank : false
							}),
					dataIndex : 'location'
				}, {
					header : '作者',
					width : 100,
					sortable : true,
					align : 'center',
					editor : new Ext.form.TextField({
								allowBlank : false
							}),
					dataIndex : 'author'
				}, {
					header : '录入人员',
					width : 150,
					sortable : true,
					align : 'center',
					editor : new Ext.form.TextField({
								allowBlank : false
							}),
					dataIndex : 'operator'
				},  {
					header : '出版社',
					width : 150,
					sortable : true,
					align : 'center',
					editor : new Ext.form.TextField({
								allowBlank : false
							}),
					dataIndex : 'pressName'
				}, {
					header : '价格',
					width : 100,
					sortable : true,
					align : 'center',
					editor : new Ext.form.TextField({
								allowBlank : false
							}),
					dataIndex : 'price'
				},{
					header : '状态',
					width : 100,
					sortable : true,
					align : 'center',
					editor : new Ext.form.TextField({
								allowBlank : false
							}),
					dataIndex : 'bookStateName'
				}]);

		var fields = [{
					name : 'bookId',
					type : 'int'
				}, {
					name : 'barCode',
					type : 'string'
				}, {
					name : 'bookName',
					type : 'string'
				}, {
					name : 'bookDesc',
					type : 'string'
				}, {
					name : 'donator',
					type : 'string'
				}, {
					name : 'author',
					type : 'string'
				}, {
					name : 'translator',
					type : 'string'
				}, {
					name : 'ISBN',
					type : 'string'
				}, {
					name : 'ISSN',
					type : 'string'
				}, {
					name : 'operator',
					type : 'string'
				}, {
					name : 'emailNo',
					type : 'string'
				}, {
					name : 'stage',
					type : 'string'
				}, {
					name : 'allStage',
					type : 'string'
				}, {
					name : 'pages',
					type : 'int'
				}, {
					name : 'price',
					type : 'float'
				}, {
					name : 'publisherDate',
					type : 'string'
				}, {
					name : 'quantity',
					type : 'int'
				}, {
					name : 'location',
					type : 'string'
				}, {
					name : 'revision',
					type : 'int'
				}, {
					name : 'searchBookId',
					type : 'string'
				}, {
					name : 'speciesId',
					type : 'string'
				}, {
					name : 'spell',
					type : 'string'
				}, {
					name : 'storeDate',
					type : 'string'
				}, {
					name : 'bookNo',
					type : 'string'
				}, {
					name : 'isBook',
					type : 'boolean'
				}, {
					name : 'firstCategoryId',
					type : 'string'
				}, {
					name : 'firstCategoryName',
					type : 'string'
				}, {
					name : 'firstCategoryCode',
					type : 'string'
				}, {
					name : 'secondCategoryId',
					type : 'string'
				}, {
					name : 'secondCategoryName',
					type : 'string'
				}, {
					name : 'secondCategoryCode',
					type : 'string'
				}, {
					name : 'thirdCategoryId',
					type : 'string'
				}, {
					name : 'thirdCategoryName',
					type : 'string'
				}, {
					name : 'thirdCategoryCode',
					type : 'string'
				}, {
					name : 'hasAttachment',
					type : 'string'
				}, {
					name : 'bookStateId',
					type : 'string'
				}, {
					name : 'bookStateName',
					type : 'string'
				}, {
					name : 'bookLevelId',
					type : 'string'
				}, {
					name : 'bookLevelName',
					type : 'string'
				}, {
					name : 'bookSecurityId',
					type : 'string'
				}, {
					name : 'bookSecurityName',
					type : 'string'
				}, {
					name : 'currencyId',
					type : 'string'
				}, {
					name : 'pressId',
					type : 'string'
				}, {
					name : 'pressName',
					type : 'string'
				}, {
					name : 'bookSourceId',
					type : 'string'
				}, {
					name : 'bookSourceName',
					type : 'string'
				}];

		var store = new Ext.data.JsonStore({
					url : contextPath + '/book/findBooks.action',
					// url : '',
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

		var bbar = new Ext.Toolbar([new Ext.PagingToolbar({
					store : store,
					pageSize : BooksPageSize,
					afterPageText : '/ {0}',
					beforePageText : '页',
					displayInfo : true,
					firstText : '第一页',
					prevText : '前一页',
					nextText : '后一页',
					lastText : '最后一页',
					refreshText : '刷新',
					displayMsg : '显示第 {0}-{1}条  共{2}条 ',
					emptyMsg : '没有数据'
				})]);

		Ext.apply(this, {
					width : 1200,
					height : 400,
					autoScroll : true,
					tbar : tbar,
					sm : sm,
					cm : cm,
					store : store,
					stripeRows : true,
					columnLines : true,
					frame : true,
					bbar : bbar,
					loadMask : '正在加载......',
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

		Library.press.grid.PressGridPanel.superclass.initComponent.call(this);

		this.on('afteredit', function(e) {
					e.record.commit();
					var thiz = this;
					Ext.Ajax.request({
								url : contextPath
										+ '/book/findBookByBarCode.action',
								method : 'POST',
								params : {
									'bookView.barCode' : e.record
											.get('barCode')
								},
								success : function(resp) {
									var obj = Ext.util.JSON
											.decode(resp.responseText);
									if (obj.success == true) {
										// Ext.Msg.alert('提示', obj.msg);
										e.record.set('barCode',
												obj.data.barCode);
										e.record.set('bookName',
												obj.data.bookName);
										e.record.set('firstCategoryName',
												obj.data.firstCategoryName);
										e.record.set('quantity',
												obj.data.quantity);
										e.record.set('location',
												obj.data.location);
										e.record.set('author', obj.data.author);
										e.record.set('pressName',
												obj.data.operator);
										e.record.set('pressName',
												obj.data.operator);
										e.record.set('price',
												obj.data.price);
										e.record.set('bookStateName',
												obj.data.bookStateName);
										e.record.commit();
										// thiz.getStore().reload();
									} else if (obj.success == false) {
										Ext.Msg.alert('提示', obj.msg);
									}
								},
								failure : function() {
									Ext.Msg.alert('提示', '服务器异常，请稍候再试');
								}
							});
				}, this);
	},

	onAdd : function() {
		var Book = this.getStore().recordType;
		var b = new Book({
					barCode : '',
					bookName : '',
					firstCategoryName : '',
					quantity : '',
					location : '',
					author : '',
					operator : '',
					pressName : '',
					price : '',
					bookStateName : ''
				});
		this.stopEditing();
		this.store.insert(0, b);
		this.startEditing(0, 0);
	},
	onImport : function() {

	},
	onExport : function() {

	},
	onPrint : function() {

	},

	onRefresh : function() {

		this.getStore().baseParams = {};

		this.getStore().load({
					params : {
						'start' : 0,
						'limit' : PressesPageSize
					}
				});
	},

	loadPressForm : function() {
		Ext.get('press.pressId').setValue(record.pressId);
	}

});
