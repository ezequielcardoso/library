Ext.onReady(function(){

	var userGridPanel = new Library.rights.grid.UserGridPanel();
	userGridPanel.render('userGrid');
	
	var roleCheckedGridPanel = new Library.rights.grid.RoleCheckedGridPanel();
	roleCheckedGridPanel.render('roleCheckedGrid');
	
});