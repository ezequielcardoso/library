Ext.ns('Library.rights.tree');

Library.rights.tree.DepartmentTree = Ext.extend(Ext.tree.TreePanel, {
	
	id : null,
	url : null,
	
	initComponent : function(){
		
		Ext.apply(this, {
			width : 350,
		    height : 500,
		    autoScroll: true,
		    animate: true,
		    containerScroll: true,
		    border: true,
		    dataUrl: this.url,
		    root: {
		        nodeType: 'async',
		        text: 'XXXX大学',
		        draggable: false,
		        id: 'department-Root'
		    }
		
		});
		
		Library.rights.tree.DepartmentTree.superclass.initComponent.call(this);
		
	}
});
