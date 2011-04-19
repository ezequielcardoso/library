Ext.onReady(function(){

	var sysLogGridPanel = new Library.sysLog.grid.SysLogGridPanel();
	
	sysLogGridPanel.render('sysLogGrid');
	

	sysLogGridPanel.getStore().load({
							params : {
								'start' : 0,
								'limit' : SysLogsPageSize
							}
						});
});
