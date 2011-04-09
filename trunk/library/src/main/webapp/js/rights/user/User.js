Ext.onReady(function(){

	var departmentTreePanel = new Library.rights.tree.DepartmentTreePanel();
	departmentTreePanel.render('departmentTree');
	
	var userGridPanel = new Library.rights.grid.UserGridPanel();
	userGridPanel.render('userGrid');
	
	var roleCheckTreePanel = new Library.rights.tree.RoleCheckTreePanel();
	roleCheckTreePanel.render('roleCheckTree');
	
	userGridPanel.getStore().load({
							params : {
								start : 0,
								limit : UsersPageSize
							}
					});
	
	
});