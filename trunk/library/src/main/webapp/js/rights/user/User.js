Ext.onReady(function(){

	var userGridPanel = new Library.rights.grid.UserGridPanel();
	userGridPanel.render('userGrid');
	
	var roleCheckedGridPanel = new Library.rights.grid.RoleCheckedGridPanel();
	roleCheckedGridPanel.render('roleCheckedGrid');
	
	userGridPanel.getStore().load({
							params : {
								start : 0,
								limit : 50
							}
						});
	
	
});