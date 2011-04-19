Ext.ns('Library.sysLog.grid');

Library.sysLog.grid.SysLogGridPanel = Ext.extend(Ext.grid.GridPanel, {
	
	id : 'sysLogGridPanel',
	
	initComponent : function(){
		
		// 操作图书列表的工具条
		var tbar = new Ext.Toolbar({
			items : [{
				text : '导出Excel',
				handler : function() {
					
				}
			},'-',{
				text : '转Excel',
				handler : function() {
					
				}
			},'->', {
				xtype : 'label',
				text : '操作日期从：'
			}, '-',{
				xtype : 'datefield',
				width : 100,
				id : 'operateDate',
				format : 'm/d/Y'
			},'-', {
				xtype : 'label',
				text : '到：'
			}, '-',{
				xtype : 'datefield',
				width : 100,
				id : 'endOperateDate',
				format : 'm/d/Y'
			},'-',{
				text : '查询',
				handler : function() {
					this.querySysLogs();
				},
				scope:this
			},'-',{
				text : '刷新',
				handler : function() {
					this.onRefresh();
				},
				scope:this
			} ]
		});
		
		var fields = [{
							name : 'id',
							type : 'int'
						},{
							name : 'operateType',
							type : 'string'
						},{
							name : 'funcName',
							type : 'string'
						},{
							name : 'operatorName',
							type : 'string'
						},{
							name : 'operateDescription',
							type : 'string'
						},{
							name : 'operator',
							type : 'string'
						}, {
							name : 'operateDate',
							 type : 'date',
                             dateFormat : 'Y-m-d'
						} , {
							name : 'operateIPAddress',
							type : 'string'
						}];
		
		var store = new Ext.data.JsonStore({
			url : contextPath + '/sysLog/findSysLogs.action',
			totalProperty : 'totalProperty',
			root : 'root',
			storeInfo : {
				field : '列名',
				direction : 'ASC|DESC'
			},
			fields : fields
		});
		
	   var cm = new Ext.grid.ColumnModel([
					new Ext.grid.RowNumberer(),
					{
						header : '操作类型',
						width : 100,
						sortable : true,
						align : 'center',
						dataIndex : 'operateType'
					},{
						header : '事件',
						width : 150,
						sortable : true,
						align : 'center',
						dataIndex : 'funcName'
					},{
						header : '业务名称',
						width : 150,
						sortable : true,
						align : 'center',
						dataIndex : 'operatorName'
					},{
						header : '操作人',
						width : 100,
						sortable : true,
						align : 'center',
						dataIndex : 'operator'
					}, {
						xtype : 'datecolumn',
						format: 'Y-m-d',
						header : '操作日期',
						width : 100,
						sortable : true,
						align : 'center',
						editor : new Ext.form.DateField({
								format : 'Y-m-d'
							}),
					format: 'Y-m-d',
						dataIndex : 'operateDate'
					}, {
						header : 'ip地址',
						width : 100,
						sortable : true,
						align : 'center',
						dataIndex : 'operateIPAddress'
					}, {
						header : '业务描述',
						width : 300,
						sortable : true,
						align : 'center',
						dataIndex : 'operateDescription'
					}]);

		
		Ext.apply(this, {
			width : 1250,
//			height : document.documentElement.clientHeight * 0.82,
			height : 450,
			autoScroll : true,
			tbar : tbar,
			cm : cm,
			store : store,
			stripeRows : true,
			columnLines : true,
			frame : false,
			loadMask : '正在加载......',
			bbar : new Ext.Toolbar([new Ext.PagingToolbar({
					store : store,
					pageSize : SysLogsPageSize,
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
			viewConfig : new Ext.grid.GridView({
				rowHeight : 23,
				scrollDelay : false,
				columnsText : '显示的列',
				scrollOffset : 30,
				sortAscText : '升序',
				sortDescText : '降序'
			})
		});
		
		Library.sysLog.grid.SysLogGridPanel.superclass.initComponent.call(this);
		
	},
	
	querySysLogs : function(){
	   var operateType = Ext.get('sysLog.operateType').getValue();
	   var funcName = Ext.get('sysLog.funcName').getValue();
	   var operatorName = Ext.get('sysLog.operatorName').getValue();
	   var operator = Ext.get('sysLog.operator').getValue();
	   var operateDate = Ext.get('operateDate').getValue();
	   var endOperateDate = Ext.get('endOperateDate').getValue();
	   
	   
	   this.getStore().baseParams = {
	       'sysLogView.operateType' : operateType,
	       'sysLogView.funcName' : funcName,
	       'sysLogView.operatorName' : operatorName,
	       'sysLogView.operator' : operator,
	       'sysLogView.operateDate' : operateDate,
	       'sysLogView.endOperateDate' : endOperateDate
	       
	      
	   }
	   this.getStore().load({
	       params : {
				start : 0,
				limit : SysLogsPageSize
			}
	   });
	},
	
	onRefresh : function(){
	   
		this.getStore().baseParams={};
		
		this.getStore().load({
							params : {
								'start' : 0,
								'limit' : SysLogsPageSize
							}
						});
		
	}
});
