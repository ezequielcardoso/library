Ext.ns('Library.press.grid');

Library.press.grid.PressGridPanel = Ext.extend(Ext.grid.GridPanel, {

	id : 'pressGridPanel',

	initComponent : function() {

		Library.press.grid.PressGridPanel.superclass.initComponent.call(this);

		var tbar = new Ext.Toolbar({
					items : [{
						text : '查询',
						iconCls : 'silk-add'
							// handler : onAdd
						}, '-', {
						text : '删除',
						iconCls : 'silk-delete',
//						handler : onDel,
						scope : this
					}, '-', {
						text : '修改'
							// handler : onAdd
						}, '-', {
						text : '增加',
//						handler : onAdd,
						scope : this
					}, '-', {
						text : '批量增加',
						// handler : onAdd
						scope : this
					}, '-', {
						text : '导出Excel',
						// handler : onAdd
						scope : this
					}, '-', {
						text : '打印',
						// handler : onAdd
						scope : this
					}]
				});

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
					url : contextPath + 'book/findPresses.action',
					root : 'root',
					idProperty : 'totalProperty',
					fields : fields,
					storeInfo : {
						field : '列名',
						direction : 'ASC|DESC'
					}
				});

		var sm = new Ext.grid.CheckboxSelectionModel();

		var editor = new Ext.ux.grid.RowEditor({
					saveText : 'Update'
				});

		var cm = new Ext.grid.ColumnModel([new Ext.grid.RowNumberer(), sm, {
					header : 'ISBN',
					dataIndex : 'pressISBN',
					width : 100,
					editor : new Ext.form.TextField({})
				}, {
					header : '出版社名称',
					dataIndex : 'pressName',
					width : 300,
					editor : new Ext.form.TextField({})
				}, {
					header : '地址',
					dataIndex : 'pressAddress',
					width : 300,
					editor : new Ext.form.TextField({})
				}, {
					header : '邮编',
					dataIndex : 'zipCode',
					editor : new Ext.form.TextField({})
				}]);

		var bbar = new Ext.PagingToolbar({
					store : store,
					pageSize : 10,
					displayInfo : true
				});

		Ext.apply(this, {
			height : 400,
			width : 900,
			frame : true,
			tbar : tbar,
			store : store,
			plugins : [editor],
			cm : cm,
			sm : sm,
			bbar : bbar,
			listeners : {
				rowdblclick : function(grid, row) {
					var window = new Ext.Window({
						height : 300,
						iconCls : 'icon-grid',
						width : 700,
						buttonAlign : 'center',
						frame : true,
						bodyBorder : true,
						autoShow : true,
						bodyBorder : true,
						collapsed : true,
						style : {
							background : 'blue',
							bgcolor : bule,
							color : 'red',
							marginButtom : '10px'
						},
						items : [new Ext.form.FormPanel({
									id : 'pressDetails',
									buttonAlign : 'center',
									labelAlign : 'right',
									items : [
											new Ext.form.TextField({
														fieldLabel : 'pressISBN',
														frame : true,
														name : 'pressISBN'
													}),
											new Ext.form.TextField({
														fieldLabel : 'zipCode',
														frame : true,
														name : 'zipCode'
													}),
											new Ext.form.TextField({
														fieldLabel : 'pressAddress',
														frame : true,
														name : 'pressAddress'
													})]
								})],
						buttons : [{
									text : 'sure',
									handler : function() {
										window.close();
									}
								}, {
									text : 'quit'
								}]
					});
					window.show(this);
				}
			}

		});

//		/**
//		 * onAdd
//		 */
//		function onAdd(btn, ev) {
//			var u = new this.store.recordType({
//						pressISBN : '',
//						pressName : '',
//						pressAddress : '',
//						zipCode : ''
//					});
//			editor.stopEditing();
//			this.store.insert(0, u);
//			editor.startEditing(0);
//		}
//
//		/**
//		 * 删除
//		 */
//		function onDel() {
//			var selectRecord = this.getSelectionModel().getSelected();
//			if (selectRecord) {
//				Ext.MessageBox.confirm('提示', '确定要删除记录?', function(btn, text) {
//							if (btn == 'yes') {
//								if (!selectRecord) {
//									return false;
//								}
//								this.store.remove(selectRecord);
//							} else {
//								return false;
//							}
//						}, this);
//			} else {
//				Ext.Msg.alert('提示', '请选择要删除的记录');
//			}
//
//		}
	}
});