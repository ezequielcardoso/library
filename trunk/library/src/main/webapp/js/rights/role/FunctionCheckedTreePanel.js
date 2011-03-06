Ext.ns('Library.rights.tree');

Library.rights.tree.FunctionCheckedTreePanel = Ext.extend(Ext.tree.TreePanel, {
	
	id : 'functionCheckedTreePanel',
	
	initComponent : function(){
		
		// 列表工具条
		var tbar = new Ext.Toolbar({
			items : [{
				text : '刷新',
				handler : function() {
					
				}
			}]
		});
		
		Ext.apply(this, {
			title : '功能和资源列表',
			width : 565,
		    height : 500,
		    autoScroll : true,
		    animate : true,
		    containerScroll: true,
		    border : true,
//		    frame : true,
		    dataUrl: "rights/findRoles.action",
		    root: {
		        nodeType: 'async',
		        text: '系统功能和资源',
		        draggable: false,
		        id: 'functionChecked-Root'
		    },
		    tbar : tbar
		});
		
		Library.rights.tree.FunctionCheckedTreePanel.superclass.initComponent.call(this);
		
	}
});
