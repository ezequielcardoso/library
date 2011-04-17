Ext.ns('Library.bookReturn.grid');

Library.bookReturn.grid.BookReturnGridPanel = Ext.extend(
		Ext.grid.EditorGridPanel, {

			id : 'bookReturnGridPanel',

			initComponent : function() {

				var thiz = this;
				
				var tbar = new Ext.Toolbar({
							items : [{
										xtype : 'label',
										width:80,
										text : '读者条形码：'
									}, {
										xtype : 'textfield',
										width : 100,
										id : 'readerBarCode',
										listeners : {
											'blur' :  function(){
												var readerBarCode = Ext.getCmp('readerBarCode').getValue();
												if(readerBarCode==""){
													Ext.Msg.alert('提示', '请输入读者条形码');
													return;
												}
												Ext.Ajax.request({
													url : contextPath
															+ '/borrowReturn/findByBarCodeOrReaderCode.action',
													method : 'POST',
													params : {
														'borrowReturnView.isBook' : 1,
														'borrowReturnView.readerBarCode' : readerBarCode
													},
													success : function(resp) {
														var obj = Ext.util.JSON.decode(resp.responseText);
														if(obj.success){
															var data = new Array();
															data = obj.data;
															for(var i=0; i<data.length; i++){
																var record = thiz.onAdd();
																var borrowReturn= data[i];
																thiz.recordSet(record , borrowReturn);	
															}
														}
													},
													failure : function() {
														Ext.Msg.alert('提示', '服务器异常，请稍候再试');
													}
												});
											}
										}
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
											this.onReturn();
										},
										scope : this
									},'-', {
										text : '续借',
										handler : function() {
											this.onRenew();
										},
										scope : this
									}]
						});

				var fields = [{
							name : 'id',
							type : 'int'
						}, {
							name : 'borrowedDate',
							type : 'date',
							dateFormat : 'm/d/Y'
						}, {
							name : 'duetoReturnDate',
							type : 'date',
							dateFormat : 'm/d/Y'
						}, {
							name : 'realityReturndate',
							type : 'date',
							dateFormat : 'm/d/Y'
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
				var sm = new Ext.grid.CheckboxSelectionModel();

				var cm = new Ext.grid.ColumnModel([
					new Ext.grid.RowNumberer(),
					sm, {
						header : '图书条形码',
						width : 100,
						sortable : true,
						align : 'center',
						editor : new Ext.form.TextField({
									allowBlank : false
								}),
						dataIndex : 'bookBarCode'
					},{
						header : '读者条形码',
						width : 100,
						sortable : true,
						align : 'center',
						dataIndex : 'readerBarCode'
					},{
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
						xtype : 'datecolumn',
						format: 'm/d/Y',
						header : '借阅日期',
						width : 100,
						sortable : true,
						align : 'center',
						dataIndex : 'borrowedDate'
					}, {
						xtype : 'datecolumn',
						format: 'm/d/Y',
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
						dataIndex : 'puniMoney'
					}, {
						header : '续借次数',
						width : 80,
						sortable : true,
						align : 'center',
						dataIndex : 'renewTimes'
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
								+ '/borrowReturn/findByBarCodeOrReaderCode.action',
						method : 'POST',
						params : {
							'borrowReturnView.isBook' : 1,
							'borrowReturnView.bookBarCode' : e.record
									.get('bookBarCode')
						},
						success : function(resp) {
							var obj = Ext.util.JSON.decode(resp.responseText);
							if(obj.success){
								var data = new Array();
								data = obj.data;
								if(data.length>0){
									var borrowReturn= data[0];
									this.recordSet(e.record , borrowReturn);
								}
							}
						},
						failure : function() {
							Ext.Msg.alert('提示', '服务器异常，请稍候再试');
						},
						scope : this
					});
				}, this);
			},

			onAdd : function() {
				var BorrowReturn = this.getStore().recordType;
				var br = new BorrowReturn({
							bookBarCode : '',
							readerBarCode : '',
							readerName : '',
							bookName : '',
							borrowedDate : '',
							duetoReturnDate : '',
							overdueDays : '',
							puniMoney : '',
							renewTimes : '',
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
				return br;
			},
			onReturn : function() {
				
				var sm = this.getSelectionModel();
				if (sm.hasSelection()) {
					Ext.MessageBox.confirm('提示', '你确定要归还图书吗？', function(btn,
							text) {
						if (btn == 'yes') {
							var records = sm.getSelections();
							for (var i = 0; i < records.length; i++) {
								var record = records[i];
								var borrowReturnId = record.get('id');
								var thiz = this;
								var bookStateName = record.get('bookStateName');
								if(bookStateName == '借阅中'){
								
								Ext.Ajax.request({
									url : contextPath
											+ '/borrowReturn/bookReturn.action',
									method : 'POST',
									params : {
										'borrowReturnView.id' : borrowReturnId
									},
									success : function(resp) {
										var respText = resp.responseText;
										var obj = Ext.util.JSON
												.decode(respText);
										if (obj.success == true) {
											record.set('bookStateName','在馆');
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
								}else{
								  Ext.Msg.alert('提示','图书状态不对');
								  return ;
								}	
							}
						} else {
							return false;
						}

					}, this);
 
				} else {
					Ext.Msg.alert('提示', '请选择你要归还的图书');
				}
			},
			onExport : function() {

			},
			onPrint : function() {

			},
			
			onRenew : function(){
			
			  var sm = this.getSelectionModel();
			if (sm.hasSelection()) {
				Ext.MessageBox.confirm('提示', '你确定要续借图书吗？', function(btn,
							text) {
						if (btn == 'yes') {
							var records = sm.getSelections();
							for (var i = 0; i < records.length; i++) {
								var record = records[i];
								var borrowReturnId = record.get('id');
								var renewTimes = record.get('renewTimes');
								var bookStateName = record.get('bookStateName');
				
								if(bookStateName == '借阅中'){
				
								
								if(renewTimes > 2){
								  Ext.Msg.alert('提示','sorry,本类图书只能被续借两次')
								}
								
								
								var thiz = this;
								Ext.Ajax.request({
									url : contextPath
											+ '/borrowReturn/bookRenew.action',
									method : 'POST',
									params : {
										'borrowReturnView.id' : borrowReturnId
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
							  }else{
							     Ext.Msg.alert('提示', '图书状态不可续借');
							     return false;
							  }
							}
						} else {
							return false;
						}

					}, this);

				} else {
					Ext.Msg.alert('提示', '请选择你要续借的图书');
				}
			},
			recordSet : function(record,borrowReturn){
			    record.set('id',borrowReturn.id);
				record.set('readerName', borrowReturn.readerName);
				record.set('bookName', borrowReturn.bookName);
				record.set('bookBarCode', borrowReturn.bookBarCode);
				record.set('readerBarCode', borrowReturn.readerBarCode);
				record.set('borrowedDate', borrowReturn.borrowedDate);
				record.set('duetoReturnDate', borrowReturn.duetoReturnDate);
				record.set('overdueDays', borrowReturn.overdueDays);
				record.set('renewTimes', borrowReturn.renewTimes);
				record.set('bookStateName',borrowReturn.bookStateName);
				record.set('firstCategoryName', borrowReturn.firstCategoryName);
				record.set('unitName', borrowReturn.unitName);
				record.set('readerCateName', borrowReturn.readerCateName);
				record.set('location', borrowReturn.location);
				record.set('borrowOperator', borrowReturn.borrowOperator);
			
				record.commit();
			},
			loadPressForm : function() {
				Ext.get('book.bookId').setValue(record.bookId);
			}

		});
