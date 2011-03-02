Ext.onReady(function(){

	var userGrid = new Library.rights.grid.UserGrid({
		id : 'userGrid'
	});
	userGrid.render('userGrid');
	
	var roleCheckedGrid = new Library.rights.grid.RoleCheckedGrid({
		id : 'roleCheckedGrid'
	});
	roleCheckedGrid.render('roleCheckedGrid');
	
});