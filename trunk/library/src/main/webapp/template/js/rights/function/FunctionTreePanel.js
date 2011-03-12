Ext.ns('Library.rights.tree');

Library.rights.tree.FunctionTreePanel = Ext.extend(Ext.tree.TreePanel, {
	
	id : 'functionTreePanel',
	
	initComponent : function(){
		
		Ext.apply(this, {
			width : 400,
		    height : 500,
		    autoScroll: true,
		    animate: true,
		    containerScroll: true,
		    border: true,
		    dataUrl: 'rights/findFunctions.action',
		    root: {
		        nodeType: 'async',
		        text: '系统功能和资源',
		        draggable: false,
		        id: 'function-Root'
		    }
		
		});
		
		Library.rights.tree.FunctionTreePanel.superclass.initComponent.call(this);
		
	}
});
