Ext.ns('Library.reader.grid');

Library.reader.grid.ReaderGridPanel = Ext.extend(Ext.grid.EditorGridPanel, {

	id : 'readerGridPanel',

	initComponent : function() {

		var tbar = new Ext.Toolbar({
					items : [{
								text : '查询',
								handler : function() {
									// this.onQuery();
								},
								scope : this
							}, {
								text : '修改',
								handler : function() {
									 this.onMOdify();
								},
								scope : this
							}, {
								text : '删除',
								handler : function() {
									 this.onDelete();
								},
								scope : this
							}, {
								text : '增加',
								handler : function() {
									 this.onAdd();
								},
								scope : this
							}, {
								text : '导入',
								handler : function() {

								}
							}, {
								text : '导出Excel',
								handler : function() {

								}
							}, {
								text : '打印',
								handler : function() {
								}
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
					name : 'entyDate',
					type : 'date',
					dateFormat : 'Y-m-d'
				}, {
					name : 'effectiveDate',
					type : 'date'
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
					name : 'certificateNo',
					type : 'string'
				}, {
					name : 'readerTypeId',
					type : 'string'
				}, {
					name : 'readerTypeCode',
					type : 'string'
				}, {
					name : 'readerTypeName',
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
						'limit' : ReadersPageSize
					},
					fields : fields,
					storeInfo : {
						field : '列名',
						direction : 'ASC|DESC'
					}
				});

		var bbar = new Ext.Toolbar([new Ext.PagingToolbar({
					store : store,
					pageSize : ReadersPageSize,
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
				
		var sm = new Ext.grid.CheckboxSelectionModel();

		var cm = new Ext.grid.ColumnModel([
			new Ext.grid.RowNumberer(), sm, {
					header : '借阅证号',
					width : 100,
					sortable : true,
					align : 'center',
					editor : new Ext.form.TextField({
								allowBlank : true
							}),
					dataIndex : 'cardNo'
				}, {
					header : '条形码',
					width : 100,
					sortable : true,
					align : 'center',
					editor : new Ext.form.TextField({
								allowBlank : false
							}),
					dataIndex : 'barCode'
				}, {
					header : '密码',
					width : 100,
					sortable : true,
					align : 'center',
					editor : new Ext.form.TextField({
								allowBlank : false
							}),
					dataIndex : 'password'
				}, {
					header : '读者姓名',
					width : 100,
					sortable : true,
					align : 'center',
					editor : new Ext.form.TextField({
								allowBlank : false
							}),
					dataIndex : 'readerName'
				}, {
					header : '出生日期',
					width : 100,
					sortable : true,
					align : 'center',
					editor : new Ext.form.DateField({
								format : 'Y-m-d'
							}),
					format : 'Y-m-d',
					dataIndex : 'birthday'
				}, {
					header : '性別',
					width : 50,
					sortable : true,
					align : 'center',
					editor : new Ext.form.TextField({
								allowBlank : false
							}),
					dataIndex : 'sex'
				}, {
					header : '余额',
					width : 50,
					sortable : true,
					align : 'center',
					editor : new Ext.form.TextField({
								allowBlank : false
							}),
					dataIndex : 'leftMoney'
				}, {
					header : '邮箱',
					width : 100,
					sortable : true,
					align : 'center',
					editor : new Ext.form.TextField({
								allowBlank : false
							}),
					dataIndex : 'email'
				}, {
					header : '联系电话',
					width : 100,
					sortable : true,
					align : 'center',
					editor : new Ext.form.TextField({
								allowBlank : false
							}),
					dataIndex : 'contactTel'
				}, {
					header : '办证日期',
					width : 100,
					sortable : true,
					align : 'center',
					editor : new Ext.form.DateField({
								format : 'Y-m-d'
							}),
					format : 'Y-m-d',
					dataIndex : 'entyDate'
				}, {
					header : '有效日期',
					width : 100,
					sortable : true,
					align : 'center',
					editor : new Ext.form.DateField({
								format : 'Y-m-d'
							}),
					format : 'Y-m-d',
					dataIndex : 'effectiveDate'
				}, {
					header : '读者照片',
					width : 100,
					sortable : true,
					align : 'center',
					editor : new Ext.form.TextField({
								allowBlank : false
							}),
					dataIndex : 'readerPic'
				}, {
					header : '拼音',
					width : 100,
					sortable : true,
					align : 'center',
					editor : new Ext.form.TextField({
								allowBlank : false
							}),
					dataIndex : 'spell'
				}, {
					header : '描述',
					width : 200,
					sortable : true,
					align : 'center',
					editor : new Ext.form.TextField({
								allowBlank : false
							}),
					dataIndex : 'readerDesc'
				}, {
					header : '证件类别',
					width : 100,
					sortable : true,
					align : 'center',
					editor : new Ext.form.ComboBox({
						triggerAction : 'all',
						valueField : 'value',
						displayField : 'value',
						mode:'remote',
						lazyRender : true,
						selectOnFocus : true,
						allowBlank : false,
						editable : false,
						store : new Ext.data.JsonStore({
							url : contextPath + '/dict/getByItemClass.action',
							fields : [{
										name : 'key'
									}, {
										name : 'value'
									}],
							baseParams : { className : 'com.huan.library.domain.model.reader.Certificate'}		
						}),
						listeners : {
							'select' : function( combo, record, Nindex ) {
								var rec = Ext.getCmp('readerGridPanel').getSelectionModel().getSelected();
								rec.set("certificateId", record.get('key'));
								rec.commit()
							}
						}
					}),
					dataIndex : 'certificateName'
				}, {
					header : '证件号码',
					width : 300,
					sortable : true,
					align : 'center',
					editor : new Ext.form.TextField({
								allowBlank : false
							}),
					dataIndex : 'certificateNo'
				}]);		

		Ext.apply(this, {
					width : 1000,
					height : 400,
					autoScroll : true,
					tbar : tbar,
					buttonAlign:'left', 
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

		Library.reader.grid.ReaderGridPanel.superclass.initComponent.call(this);

		this.on('afteredit', function(e) {
			e.record.commit();
			var thiz = this;
			Ext.Ajax.request({
						url : contextPath + '/reader/saveReader.action',
						method : 'POST',
						params : {
							'reader.id' : e.record.get('id'),
							'reader.cardNo' : e.record.get('cardNo'),
							'reader.password' : e.record.get('password'),
							'reader.barCode' : e.record.get('barCode'),
							'reader.readerName' : e.record.get('readerName'),
							'reader.birthday' : e.record.get('birthday'),
							'reader.sex' : e.record.get('sex'),
							'reader.leftMoney' : e.record.get('leftMoney'),
							'reader.email' : e.record.get('email'),
							'reader.contactTel' : e.record.get('contactTel'),
							'reader.entyDate' : e.record.get('entyDate'),
							'reader.effectiveDate' : e.record.get('effectiveDate'),
							'reader.readerPic' : e.record.get('readerPic'),
							'reader.spell' : e.record.get('spell'),
							'reader.readerDesc' : e.record.get('readerDesc'),
							'reader.certificate.itemId' : e.record.get('certificateId')
						},
						success : function(resp) {
							var obj = Ext.util.JSON.decode(resp.responseText);
							if (obj.success == true) {
								Ext.Msg.alert('提示', obj.msg);
								e.record.set("id", obj.data.id);
								e.record.commit();
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
	onQuery : function() {
		var pressISBN = Ext.get('pressISBN').getValue();
		var pressName = Ext.get('pressName').getValue();
		var pressAddress = Ext.get('pressAddress').getValue();
		this.getStore().baseParams = {
			'press.pressISBN' : pressISBN,
			'press.pressName' : pressName,
			'press.pressAddress' : pressAddress
		};
		this.getStore().load({
					params : {
						start : 0,
						limit : ReadersPageSize
					}
				})
	},

	onMOdify : function() {

		Ext.Msg.alert('提示', '请选中行并直接编缉！');

	},

	onDelete : function() {
		var sm = this.getSelectionModel();
		if (sm.hasSelection()) {
			Ext.MessageBox.confirm('提示', '你确定要删除记录吗？', function(btn, text) {

						if (btn == 'yes') {
							var records = sm.getSelections();
							for (var i = 0; i < records.length; i++) {
								var record = records[i];
								var readerId = record.get('id');
								var thiz = this;
								Ext.Ajax.request({
											url : contextPath
													+ '/reader/remove.action',
											method : 'POST',
											params : {
												'readerView.id' : readerId
											},
											success : function(resp) {
												var respText = resp.responseText;
												var obj = Ext.util.JSON.decode(respText);
												if (obj.success == true) {
													Ext.Msg.alert('提示',obj.msg);
													thiz.getStore().reload();
												} else {
													Ext.Msg.alert('提示',obj.msg);
												}
											},
											failure : function() {
												Ext.Msg.alert('服务器异常');
											}
										});
							}
						} else {
							return false;
						}

					}, this);

		} else {
			Ext.Msg.alert('提示', '请选择你要删除的记录');
		}
	},
	onAdd : function() {
		var Reader = this.getStore().recordType;
		var r = new Reader({
			cardNo : '0803010099', // 借阅证号
			password : '0803010099', // 密码
			barCode : '0803010099', // 条形码
			readerName : 'huan', // 读者姓名
			birthday : '2011-3-2', // 出生日期
			sex : '男', // 性別 M:男 F:女
			leftMoney : 0, // 余额
			email : '762252352@qq.com', // 邮箱
			contactTel : '13578926265', // 联系电话
			entyDate : '2008-5-5', // 办证日期
			effectiveDate : '2012-5-5', // 有效日期
			readerPic : '080301009.jpg', // 读者照片

			spell : 'huan', // 拼音
			readerDesc : '08级学生',// 读者描述
          
	        
            certificateNo : '080301009'
//			certificateId : '',
//			certificateCode : '',
//			certificateName : '', // 证件类别 学生证
//			certificateNo : '', // 证件号码
//
//			readerTypeId : '',
//			readerTypeCode : '',
//			readerTypeName : '', // 读者类别
//
//			cardStateId : '',
//			cardStateCode : ''
				// cardStateName, //借阅证状
			});
		this.stopEditing();
		this.store.insert(0, r);
		this.startEditing(0, 0);
	},
	onImport : function() {

	},
	onExport : function() {

	},
	onPrint : function() {

	},
	loadPressForm : function() {
		Ext.get('reader.id').setValue(record.id);
	}

});
