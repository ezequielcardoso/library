Ext.ns('Boa.System.Resource');

Boa.System.Resource.GridPanel = Ext.extend(Ext.ux.tree.TreeGrid, {
    id: null,
    url: Boa.Config.ContextPath + '/resource/loadTreeCol.do',
    
    selectNode: null,
    
    initComponent: function(){
    	var thiz = this;
    	Ext.apply(this, {
	        autoScroll: true,
	    	height: document.body.clientHeight - Boa.Config.gridHeight,
	        enableDD: true,
	        enableSort: false,
	        useArrows: false,
	        lines: true,
	        columnsText: '列',
	        border: false,
	        tbar: ['<b>功能列表</b>','-',{
	        	text: '新增',
	        	iconCls: 'boa-add',
				handler: function(){
					this.onAdd();
				},
				scope: this
	        },{
	        	text: '修改',
	        	iconCls: 'boa-edit',
				handler: function(){
					this.onUpdate();
				},
				scope: this
	        },{
	        	text: '删除',
	        	iconCls: 'boa-delete',
				handler: function(){
					this.onDelete();
				},
				scope: this
	        }],
	        columns: [{
	            header: '功能名称',
	            dataIndex: 'resText'
	        }, {
	            header: '功能标识(resId)',
	            dataIndex: 'resId'
	        }, {
	            header: '资源链接',
	            dataIndex: 'resDerict'
	        }, {
	            header: '图标',
	            dataIndex: 'resIconCls',
	            renderer: function(icon){
	                var returnHtml = '<span class="' + icon + '">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>' + icon;                
	                return returnHtml;
	            }
	        }, {
	            header: '排序',
	            dataIndex: 'resOrder'
	        }, {
	            header: '功能ID(oid)',
	            dataIndex: 'oid'
	        }, {
	            header: '上级功能(poid)',
	            dataIndex: 'parentOid'
	        }, {
	            header: '子节点',
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
	    	if(node.attributes.oid != 'root'){
    			this.getLoader().baseParams['parentOid'] = node.attributes.oid;
	    	}else{
	    		this.getLoader().baseParams['parentOid'] = null;
	    	}
        },this);
        Boa.System.Resource.GridPanel.superclass.initComponent.apply(this, arguments);
    },
    //添加
    onAdd: function(){
    	var node = this.getSelectionModel().getSelectedNode();
    	if(node){
    		this.selectNode = node;
	    	var pid = node.attributes.oid;
	    	var pname = node.attributes.resText;
	    	node.attributes = [];
			node.attributes.poid = pid;
			node.attributes.presText = pname;
	    	var win = new Boa.Window({
	    		formPanel: new Boa.System.Resource.FormPanel({formValues: node.attributes }),
	    		title: '添加功能'
	    	});
    	}else{
			Boa.Util.warn('请选择父功能');
		}
    },
    //修改
    onUpdate: function(){
    	var node = this.getSelectionModel().getSelectedNode();
		if(node){
			this.selectNode = node;
			var pid = node.parentNode.attributes.oid;
	    	var pname = node.parentNode.attributes.resText;
			if(pid == 'root'){
				pid = null;
				pname = null;
			}
			node.attributes.poid = pid;
			node.attributes.presText = pname;
			new Boa.Window({
	    		formPanel: new Boa.System.Resource.FormPanel({formValues: node.attributes}),
	    		title: '修改功能'
	    	});
		}else{
			Boa.Util.warn('请选择要修改的功能');
		}
    },
    //删除
    onDelete: function(){
    	var node = this.getSelectionModel().getSelectedNode();
		if(node && node.attributes.oid){
			Boa.Util.confirm('确定要删除选择的功能['+node.attributes.resText+']？', function(btn){
    			if(btn == 'yes'){
					Ext.Ajax.request({
		            	method: 'GET',
		            	url: Boa.Config.ContextPath + '/resource/deleteResource.do',
			            success: function(resp,opts){
			            	var msg = Ext.util.JSON.decode(resp.responseText);
			            	if(msg.data == 'y'){
			            		Boa.Util.msg("删除成功");
    							node.parentNode.reload();
			            	}else if(msg.data == 'c'){
			            		Boa.Util.warn("该功能有下级功能，无法删除");
			            	}else if(msg.data == 'p'){//同级节点没有了
			            		Boa.Util.msg("删除成功");
    							node.parentNode.parentNode.reload();
			            	}else{
			            		Boa.Util.error("删除失败");
			            	}
			            },
			            failure: function(resp,opts){
			            	Boa.Util.error("删除失败");
			            },
			            params: {'oid': node.attributes.oid }
			        });
			    }
    		});
		}else{
			Boa.Util.warn('请选择要删除的功能');
		}
    }
});
Ext.reg('systemresourcegrid', Boa.System.Resource.GridPanel);