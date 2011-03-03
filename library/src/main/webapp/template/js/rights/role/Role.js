Ext.onReady(function(){

	var roleGridPanel = new Library.rights.grid.RoleGridPanel();
	roleGridPanel.render('roleGrid');
	
	var functionCheckedTreePanel = new Library.rights.tree.FunctionCheckedTreePanel();
	functionCheckedTreePanel.render('functionCheckedTree');
	
});