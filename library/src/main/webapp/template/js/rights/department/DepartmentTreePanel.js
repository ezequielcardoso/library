Ext.ns('Library.rights.tree');

Library.rights.tree.DepartmentTreePanel = Ext.extend(Ext.tree.TreePanel, {
	
	id : 'departmentTreePanel',
	
	initComponent : function(){
		
		Ext.apply(this, {
			width : 350,
		    height : 500,
		    autoScroll: true,
		    animate: true,
		    containerScroll: true,
		    border: true,
		    dataUrl: 'rights/findDepts.action',
		    root: {
		        nodeType: 'async',
		        text: 'XXXX大学',
		        draggable: false,
		        id: 'department-Root'
		    }
		
		});
		
		Library.rights.tree.DepartmentTreePanel.superclass.initComponent.call(this);
		
	}
});
