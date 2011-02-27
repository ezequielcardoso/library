Ext.onReady(function(){

	var departmentTree = new Library.rights.tree.DepartmentTree({
		id : 'departmentTree',
		url : 'department.json'
	});
	departmentTree.render('department-tree');
	
//	departmentTree.getRootNode().expand(false);
});

