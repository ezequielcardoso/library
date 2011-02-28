Ext.onReady(function(){

	var userGrid = new Library.rights.grid.UserGrid({
		id : 'userGrid'
	});
	userGrid.render('userGrid');
	
	var roleGrid = new Library.rights.grid.RoleGrid({
		id : 'roleGrid'
	});
	roleGrid.render('roleCheckedGrid');
	
});