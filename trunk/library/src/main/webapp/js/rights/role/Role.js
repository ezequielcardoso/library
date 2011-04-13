Ext.onReady(function(){

	var roleGridPanel = new Library.rights.grid.RoleGridPanel();
	roleGridPanel.render('roleGrid');
	
	var functionCheckTreePanel = new Library.rights.tree.FunctionCheckTreePanel();
	functionCheckTreePanel.render('functionCheckedTree');
	
	roleGridPanel.getStore().load({
							params : {
								start : 0,
								limit : 20
							}
					});
	
});