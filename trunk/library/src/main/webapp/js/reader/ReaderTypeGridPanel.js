Ext.ns('Library.readerType.grid');

Library.readerType.grid.ReaderTypeGridPanel = Ext.extend(
		Ext.grid.EditorGridPanel, {

			id : 'readerTypeGridPanel',

			initComponent : function() {

				// 操作图书列表的工具条
				var tbar = new Ext.Toolbar({
							items : [ {
										text : '增加',
										handler : function() {
											 this.onAdd();
										},
										scope : this
									},'-', {
										text : '删除',
										handler : function() {
											 this.onDelete();
										},
										scope : this
									}, '-',{
										text : '修改',
										handler : function() {
											 this.onModify();
										},
										scope : this
									}, '-',{
										text : '导入',
										handler : function() {

										}
									}, '-',{
										text : '导出Excel',
										handler : function() {

										}
									},'-',{
										text : '打印',
										handler : function() {
										}
									},'-',{
										text : '查询',
										handler : function() {

										}
									}]
						});

				var sm = new Ext.grid.CheckboxSelectionModel();

				var cm = new Ext.grid.ColumnModel([new Ext.grid.RowNumberer(),
						sm, {
							header : '类别编码',
							width : 120,
							sortable : true,
							align : 'center',
							editor : new Ext.form.TextField({
										allowBlank : true
									}),
							dataIndex : 'readerCateCode'
						}, {
							header : '类别名称',
							width : 300,
							sortable : true,
							align : 'center',
							editor : new Ext.form.TextField({
										allowBlank : false
									}),
							dataIndex : 'readerCateName'
						}, {
							header : '借阅天数',
							width : 120,
							sortable : true,
							align : 'center',
							editor : new Ext.form.TextField({
										allowBlank : false
									}),
							dataIndex : 'borrowDays'
						}, {
							header : '借阅数量',
							width : 120,
							sortable : true,
							align : 'center',
							editor : new Ext.form.TextField({
										allowBlank : false
									}),
							dataIndex : 'borrowedQuantity'
						}, {
							header : '租金',
							width : 120,
							sortable : true,
							align : 'center',
							editor : new Ext.form.TextField({
										allowBlank : false
									}),
							dataIndex : 'rent'
						}]);

				var fields = [{
							name : 'id',
							type : 'int'
						}, '-',{
							name : 'readerCateCode',
							type : 'string'
						}, '-',{
							name : 'readerCateName',
							type : 'string'
						}, '-',{
							name : 'borrowDays',
							type : 'int'
						},'-', {
							name : 'borrowedQuantity',
							type : 'int'
						},'-', {
							name : 'rent',
							type : 'float'
						}];

				var store = new Ext.data.JsonStore({
							url : contextPath + '/reader/findReaderTypes.action',
							root : 'root',
							totalProperty : 'totalProperty',
							baseParams : {
								'start' : 0,
								'limit' : ReaderTypesPageSize
							},
							fields : fields,
							storeInfo : {
								field : '列名',
								direction : 'ASC|DESC'
							}
						});

				var bbar = new Ext.Toolbar([new Ext.PagingToolbar({
							store : store,
							pageSize : ReaderTypesPageSize,
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
							width : 1000,
							height : 530,
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

				Library.readerType.grid.ReaderTypeGridPanel.superclass.initComponent
						.call(this);
						
				this.on('afteredit',function(e){
					e.record.commit();
					var thiz = this;
					Ext.Ajax.request({
					   url : contextPath + '/reader/saveReaderType.action',
					   method : 'POST',
					   params : {
					     'readerType.id' : e.record.get('id'), 
					   	 'readerType.readerCateCode': e.record.get('readerCateCode'),
					     'readerType.readerCateName': e.record.get('readerCateName'),
					     'readerType.borrowDays' : e.record.get('borrowDays'),
					     'readerType.borrowedQuantity': e.record.get('borrowedQuantity'),
					     'readerType.rent' : e.record.get('rent')
					   },
					   success : function(resp){
					     var obj = Ext.util.JSON.decode(resp.responseText);
							if (obj.success == true) {
								Ext.Msg.alert('提示', obj.msg);
								e.record.set("id", obj.data.id);
								e.record.commit();
//								thiz.getStore().reload();
							} else if (obj.success == false) {
								Ext.Msg.alert('提示', obj.msg);
							}
					   },
					   failure : function() {
							Ext.Msg.alert('提示', '服务器异常，请稍候再试');
						}
					});
				},this);	
			},
			
			onModify : function(){
			  Ext.Msg.alert('提示','请选中记录修改即可！');
			},
			
			onDelete : function(){
			
				var sm = this.getSelectionModel();
				if (sm.hasSelection()) {
					Ext.MessageBox.confirm('提示', '你确定要删除记录吗？', function(btn,
							text) {

						if (btn == 'yes') {
							var records = sm.getSelections();
							for (var i = 0; i < records.length; i++) {
								var record = records[i];
								var id = record.get('id');
								var thiz = this;
								Ext.Ajax.request({
											url : contextPath
													+ '/reader/deleteReaderType.action',
											method : 'POST',
											params : {
												'readerTypeView.id' : id
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
			onAdd : function(){
			  var ReaderType = this.getStore().recordType;
			  var rt = new ReaderType({
			      readerCateCode : 'A1000',
			      readerCateName : '学生',
			      borrowDays : 30,
			      borrowedQuantity : 5,
			      rent : 0.5
			  });
			  this.stopEditing();
			  this.store.insert(0,rt);
			  this.startEditing(0,0);
			}
		});
		
		
		
		
		
		
		