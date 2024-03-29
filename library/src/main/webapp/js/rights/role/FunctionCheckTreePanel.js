Ext.ns('Library.rights.tree');

Library.rights.tree.FunctionCheckTreePanel = Ext.extend(Library.tree.BaseCheckTree, {
	
	id: 'FunctionCheckTreePanel',
	
	roleId: null,
	
	createRootNode: function(){
        return {
            text: 'root',
            id: 'root'
        };
    },
    createTbar: function(){
    	return [{
			text: '保存',
			iconCls : 'library-reader-save',
			handler: function(){
				this.saveRoleFunc();
			},
			scope: this
    	}]
    },
	initComponent : function(){
		this.url = contextPath + "/function/findFunctionTree.action";
        this.rootNode = this.createRootNode();
        this.tbar = this.createTbar();
        Library.rights.tree.FunctionCheckTreePanel.superclass.initComponent.call(this);
        
	},
    checkModel : 'cascade',
    saveRoleFunc: function(){
		if(this.roleId){
			var checkedNodes = this.getChecked();
			var s = [];
			for (var i = 0; i < checkedNodes.length; i++) {
				if(checkedNodes[i].id!='root') s.push(checkedNodes[i].id);
			}
			Ext.Ajax.request({
				url : contextPath + '/role/saveRoleFunc.action',
				method : 'POST',
				params : {
					"roleView.roleId" : this.roleId,
					"roleView.funcIds" : s
				},
				success : function(response, options) {
//					this.loader.dataUrl = this.url + '?functionView.roleId=' + this.roleId;
					this.root.reload();
					
				},
				failure : function() {
					
				},
				scope: this
			});
		}else{
			
		}
	},
	width : 500,
    height : 500,
    border : true,
    rootVisible : false
});
Ext.reg('functionchecktreepanel', Library.rights.tree.FunctionCheckTreePanel);