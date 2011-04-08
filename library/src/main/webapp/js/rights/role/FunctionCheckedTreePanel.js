Ext.ns('Library.rights.tree');

Library.rights.tree.FunctionCheckedTreePanel = Ext.extend(Library.tree.BaseCheckTree, {
	
	id : 'functionCheckedTreePanel',
	
	initComponent : function(){
		
		this.rootNode = {
			text : '不显示的节点',
			id : 'Root',
			expanded : true
		};
		this.url = contextPath + '/function/getChildrenItem.action';
		this.rootVisible = false;
		this.isChecked = true;
		
		Ext.apply(this, {
			title : '资源列表',
			width : 565,
		    height : 500,
		    border : true
		});
		
		Library.rights.tree.FunctionCheckedTreePanel.superclass.initComponent.call(this);
		
	}
});
