Ext.ns('Library.tree');
Library.tree.BaseCheckTree = Ext.extend(Library.tree.BaseTree, {

	//多选: 'multiple'(默认)
	//级联多选: 'cascade'(同时选父和子);
	//单选: 'single'
	//'parentCascade'(选父);
	//'childCascade'(选子)
	checkModel : 'multiple',
	onlyLeafCheckable : false,
	
	INDEX_CATEGORY_CHECKING : false,
	
	autoScroll : true,
	animate : true,
	containerScroll : true,
	frame : false,
	
	initComponent : function() {
		this.listeners = {
			'checkchange' : this.changeNodeCss/*,
			'check' : this.changeNodeCss*/
		};
		this.isChecked = true;
		this.onlyLeafCheckable = this.onlyLeafCheckable;
		Library.tree.BaseCheckTree.superclass.initComponent.call(this, arguments);
	},
	changeNodeCss : function(node, checked) {
		var checkBox = Ext.getCmp('checkBox');
		if (checked) {
			node.getUI().addClass('complete');
			if(checkBox!=null){//用于选择字典时填值
				checkBox.addItem({
					id : node.id,
					name : node.text
				});
			}
		} else {
			node.getUI().removeClass('complete');
			if(checkBox!=null)checkBox.clearValue()
		}
		//选择类型
		 if(this.checkModel == 'single'){
			var tree = node.getOwnerTree();
			var checkedNodes = tree.getChecked();
			for(var i=0;i<checkedNodes.length;i++){
				var n = checkedNodes[i];
				if(n.id != node.id){
					n.getUI().checkbox.checked = false;
					n.attributes.checked = false;
				}
			}
		}else if(!this.onlyLeafCheckable){
			if(this.checkModel == 'cascade'){//级联多选: 'cascade'(同时选父和子)
				if(!this.INDEX_CATEGORY_CHECKING){
	    			this.INDEX_CATEGORY_CHECKING = true;      
	           		this.checkChild(node,checked);
	           		this.checkParent(node,true);
	             	this.INDEX_CATEGORY_CHECKING=false;
	          	}
			}else if(this.checkModel == 'single'){//单选
				
			}else if(this.checkModel == 'parentCascade'){//选父
				var parentNode = node.parentNode;
				if(parentNode !== null) {
					this.checkParent(parentNode,checked);
				}
			}else if(this.checkModel == 'childCascade'){//选子
				if( !node.expanded && !node.childrenRendered ) {
					node.expand(false,false,this.checkChild);
				}else {
					this.checkChild(node);  
				}
			}
		}//else{}默认multiple
	},
	
	checkChild: function(node,checked){
		var thiz = this;
	    node.eachChild(function(child){
		    if(child.childNodes.length>0){
		    	thiz.checkChild(child,checked);//递归
		    }
	    	child.ui.toggleCheck(checked);
	    	child.attributes.checked = checked;
		});
    },
    checkParent: function(node,checked){
    	if(!node){return false;}    		  
		var parentNode = node.parentNode;
		if(parentNode !== null) {
			parentNode.ui.toggleCheck(checked);
    		parentNode.attributes.checked = checked;
    		var isall = 0;//选择的子节点
	        parentNode.eachChild(function(n){
	        	if(n.attributes.checked){
	            	isall ++;
	        	}
	    	});
	    	if(isall <= 0){//没有选择的子节点
	    		parentNode.ui.toggleCheck(!checked);    
    			parentNode.attributes.checked = !checked;
	    	}
		    this.checkParent(parentNode, checked);//递归
		}
	}
});