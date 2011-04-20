Ext.ns('Library.bookBorrow.grid');

Library.bookBorrow.grid.BookBorrowGridPanel = Ext.extend(
		Ext.grid.EditorGridPanel, {

			id : 'bookBorrowGridPanel',

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
										text : '借阅',
										handler : function() {
											this.onBorrowed();
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
							type : 'date'
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
							type : 'int'
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
				var sm = new Ext.grid.CheckboxSelectionModel();

				var cm = new Ext.grid.ColumnModel([
					new Ext.grid.RowNumberer(),
					sm, {
						header : '条形码',
						width : 100,
						sortable : true,
						align : 'center',
						editor : new Ext.form.TextField({
									allowBlank : false
								}),
						dataIndex : 'barCode'
					}, {
						header : '编号',
						width : 100,
						sortable : true,
						align : 'center',
						dataIndex : 'bookNo'
					}, {
						header : '书名',
						width : 100,
						sortable : true,
						align : 'center',
						dataIndex : 'bookName'
					}, {
						header : '数量',
						width : 80,
						sortable : true,
						align : 'center',
						dataIndex : 'quantity'
					}, {
						header : '分类',
						width : 100,
						sortable : true,
						align : 'center',
						dataIndex : 'firstCategoryName'
					}, {
						header : '二级分类',
						width : 100,
						sortable : true,
						align : 'center',
						dataIndex : 'secondCategoryName'
					}, {
						header : '存放位置',
						width : 100,
						sortable : true,
						align : 'center',
						dataIndex : 'location'
					}, {
						header : '作者',
						width : 80,
						sortable : true,
						align : 'center',
						dataIndex : 'author'
					}, {
						header : '录入人员',
						width : 80,
						sortable : true,
						align : 'center',
						dataIndex : 'operator'
					}, {
						header : '出版社',
						width : 100,
						sortable : true,
						align : 'center',
						dataIndex : 'pressName'
					}, {
						header : '价格',
						width : 80,
						sortable : true,
						align : 'center',
						dataIndex : 'price'
					}, {
						header : '状态',
						width : 80,
						sortable : true,
						align : 'center',
						dataIndex : 'bookStateName'
					}]);
				// var bbar = new Ext.Toolbar([new Ext.PagingToolbar({
				// store : store,
				// pageSize : BooksPageSize,
				// afterPageText : '/ {0}',
				// beforePageText : '页',
				// displayInfo : true,
				// firstText : '第一页',
				// prevText : '前一页',
				// nextText : '后一页',
				// lastText : '最后一页',
				// refreshText : '刷新',
				// displayMsg : '显示第 {0}-{1}条 共{2}条 ',
				// emptyMsg : '没有数据'
				// })]);

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
							// bbar : bbar,
							// loadMask : '正在加载......',
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

				Library.bookBorrow.grid.BookBorrowGridPanel.superclass.initComponent
						.call(this);

				this.on('afteredit', function(e) {
							e.record.commit();
							var thiz = this;
							Ext.Ajax.request({
										url : contextPath
												+ '/book/findBookByBarCode.action',
										method : 'POST',
										params : {
											'bookView.isBook' : 1,  
											'bookView.barCode' : e.record.get('barCode')
										},
										success : function(resp) {
											var book = Ext.util.JSON.decode(resp.responseText);
											e.record.set('bookId', book.bookId);
											e.record.set('barCode',book.barCode);
											e.record.set('bookNo', book.bookNo);
											e.record.set('bookName',book.bookName);
											e.record.set('quantity',book.quantity);
											e.record.set('firstCategoryName',book.firstCategory.itemName);
											e.record.set('secondCategoryName',book.secondCategory.itemName);
											e.record.set('location',book.location);
											e.record.set('author', book.author);
											e.record.set('operator',book.operator);
											e.record.set('pressName',book.press.pressName);
											e.record.set('price', book.price);
											e.record.set('bookStateName',book.bookState.itemName);
											e.record.commit();
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
							bookNo : '',
							bookName : '',
							quantity : '',
							firstCategoryName : '',
							secondCategoryName : '',
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
			onBorrowed : function() {

				// 读者校验
				var borrowedQuantiy = Ext.get('reader.borrowedQuantiy').getValue();
				var maxBorrowedQuantity = Ext.get('reader.readerType.maxBorrowedQuantity').getValue();
				var cardState= Ext.get('reader.cardState.itemName').getValue();
				
				if(cardState != '可用'){
				  Ext.Msg.alert('提示','借阅证状态不可用,请联系管理员');
				  return;
				}
				
				if (borrowedQuantiy >= maxBorrowedQuantity) {
					Ext.Msg.alert('提示', '已达最大借阅数量');
					return false;
				}

				var leftMoney = Ext.get('reader.leftMoney').getValue();
				if (leftMoney <= 0) {
					Ext.Msg.alert('提示', '余额不足,请充值');
					return false;
				}

				// 图书校验
				var sm = this.getSelectionModel();
				if (sm.hasSelection()) {
					var records = sm.getSelections();
					for (var i = 0; i < records.length; i++) {
						var record = records[i];

						var quantity = record.get('quantity'); // 图书数量
						if (quantity <= 0) {
							Ext.Msg.alert('提示', '图书数量有不足的,请查看');
							return false;
						}

						var bookStateName = record.get('bookStateName'); // 图书状态
						if (bookStateName != '在馆') {
							Ext.Msg.alert('提示', 'sorry,该图书不可借');
							return false;
						}
					}
				}

				var readerId = Ext.get('reader.id').getValue();
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
									url : contextPath + '/borrowReturn/bookBorrow.action',
									method : 'POST',
									params : {
										'borrowReturnView.bookId' : bookId,
										'borrowReturnView.readerId' : readerId
									},
									success : function(resp) {
										var respText = resp.responseText;
										var obj = Ext.util.JSON
												.decode(respText);
										if (obj.success == true) {
											record.set('bookStateName','借阅中');
											record.commit();
											Ext.Msg.alert('提示', obj.msg);
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
					Ext.Msg.alert('提示', '请选择你要借出的图书');
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
