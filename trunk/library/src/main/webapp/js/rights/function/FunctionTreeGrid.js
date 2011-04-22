Ext.ns('Library.rights.treegrid');

Library.rights.treegrid.FunctionTreeGrid = Ext.extend(Ext.ux.tree.TreeGrid, {
    
    id: 'FunctionTreeGrid',
    url: contextPath + '/function/findTreeColumn.action',
    
    selectNode: null,
    
    initComponent: function(){
    	var thiz = this;
    	Ext.apply(this, {
	        autoScroll: true,
	    	height: 500,
	        enableDD: true,
	        enableSort: false,
	        useArrows: false,
	        lines: true,
	        columnsText: '列',
	        border: false,
	        tbar: [{
	        	text: '新增',
	        	iconCls: '',
				handler: function(){
					this.onAdd();
				},
				scope: this
	        },{
	        	text: '修改',
	        	iconCls: '',
				handler: function(){
					this.onUpdate();
				},
				scope: this
	        },{
	        	text: '删除',
	        	iconCls: '',
				handler: function(){
					this.onDelete();
				},
				scope: this
	        }],
	        columns: [{
	            header: '功能名称',
//	            width : 200,
	            dataIndex: 'funcName'
	        }, {
	            header: '资源标识',
//	            width : 100,
	            dataIndex: 'resCmpId'
	        }, {
	            header: '资源链接',
//	            width : 100,
	            dataIndex: 'resCmpHandURL'
	        }, {
	            header: '资源图标',
//	            width : 60,
	            dataIndex: 'resCmpIconCls',
	            renderer: function(icon){
	                var returnHtml = '<span class="' + icon + '">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>' + icon;                
	                return returnHtml;
	            }
	        }, {
	            header: '资源排序',
//	            width : 60,
	            dataIndex: 'funcOrder'
	        }, {
	            header: '功能ID',
//	            width : 100,
	            dataIndex: 'funcId'
	        }, {
	            header: '上级功能ID',
//	            width : 100,
	            dataIndex: 'parentId'
	        }, {
	            header: '子节点',
//	            width : 60,
	            dataIndex: 'leaf'
	        }],
	        listeners: {
	        	click: function(node, e){
	            	this.selectNode = node;
	            },
	            dblclick: function(node, e){
	            	this.selectNode = node;
	        		this.onUpdate();
	            }
	        },
			dataUrl : this.url,
			root: new Ext.tree.AsyncTreeNode({ 
				id : 'root',
				oid : 'root',
				text : 'root', 
				draggable : false,//根節點不容許拖動
				expanded : true
			})
	    });
	    this.on("beforeload", function(node){
	    	if(node.attributes.funcId != 'root'){
    			this.getLoader().baseParams['functionView.parentId'] = node.attributes.funcId;
	    	}else{
	    		this.getLoader().baseParams['functionView.parentId'] = null;
	    	}
        },this);
        Library.rights.treegrid.FunctionTreeGrid.superclass.initComponent.apply(this, arguments);
    },
    //添加
    onAdd: function(){
		var node = this.getSelectionModel().getSelectedNode();
		if(node){
			this.selectNode = node;
			var parentId = node.attributes.funcId;
	    	var parentName = node.attributes.funcName;
			node.attributes = [];
			node.attributes.parentId = parentId;
			node.attributes.parentName = parentName;
			new Library.util.Window({
	    		formPanel: new Library.rights.form.FunctionForm({formValues: node.attributes}),
	    		title: '添加功能'
	    	});
		}else{
			Ext.Msg.alert('提示','请选择父功能');
		}
    },
    //修改
    onUpdate: function(){
    	var node = this.getSelectionModel().getSelectedNode();
		if(node){
			this.selectNode = node;
			var parentId = node.parentNode.attributes.funcId;
	    	var parentName = node.parentNode.attributes.funcName;
			if(parentId == 'root'){
				parentId = null;
				parentName = null;
			}
			node.attributes.parentId = parentId;
			node.attributes.parentName = parentName;
			new Library.util.Window({
	    		formPanel: new Library.rights.form.FunctionForm({formValues: node.attributes}),
	    		title: '修改功能'
	    	});
		}else{
			Ext.Msg.alert('提示','请选择要修改的功能');
		}
    },
    //删除
    onDelete: function(){
    	var node = this.getSelectionModel().getSelectedNode();
		if(node && node.attributes.funcId){
			Library.Util.confirm('确定要删除选择的功能['+node.attributes.funcName+']？', function(btn){
    			if(btn == 'yes'){
					Ext.Ajax.request({
		            	method: 'GET',
		            	url: contextPath + '/function/remove.action',
			            success: function(resp,opts){
			            	var obj = Ext.util.JSON.decode(resp.responseText);
			            	if(obj.data == 'y'){
			            		Library.Util.msg("删除成功");
    							node.parentNode.reload();
			            	}else if(obj.data == 'c'){
			            		Library.Util.warn("该功能有下级功能，无法删除");
			            	}else if(obj.data == 'p'){//同级节点没有了
			            		Library.Util.msg("删除成功");
    							node.parentNode.parentNode.reload();
			            	}else{
			            		Library.Util.error("删除失败");
			            	}
			            },
			            failure: function(resp,opts){
			            	Library.Util.error("删除失败");
			            },
			            params: {'function.funcId': node.attributes.funcId }
			        });
			    }
    		});
		}else{
//			Boa.Util.warn('请选择要删除的功能');
		}
    }
});
Ext.reg('functiontreegrid', Library.rights.treegrid.FunctionTreeGrid);