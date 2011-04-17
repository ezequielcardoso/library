Ext.ns('Library.tree');

/**
 * 
 * @param checkModel 包含值为single,cascade,parentCascade,childCascade选择类型
 * @idField 需要添入的选择的ID信息
 * @textField 需要添入的选择的NAME信息
 * @debug 是否进行调试模式
 *
 */
Library.tree.DepartmentCheckTreeWindow = Ext.extend(Ext.Window, {

	checkTree : null,

	debug : false,

	record : null,

	initComponent : function() {
		if (!this.checkTree) {
				Ext.Msg.alert("请传入选择树checkTree属性");
			return;
		}
		Ext.apply(this, {
			autoScroll : false,
			border : false
		});
		
		Library.tree.DepartmentCheckTreeWindow.superclass.initComponent.call(this);
		this.add(this.createFormPanel());
		this.addButton("确定", this.confirmHandler, this);
		this.addButton("关闭", this.closeHandler, this);

	},

	createFormPanel : function() {
		var states = new Ext.data.SimpleStore({});
		return new Ext.form.FormPanel({
			id : 'f1Form',
			autoHeight : true,
			header : false,
			bodyStyle : 'padding:5px;',
			labelWidth : 1,
			labelAlign : 'left',
			items : [this.checkTree/*, {
				allowBlank : false,
				id : 'checkBox',
				resizable : true,
				xtype : 'superboxselect',
				store : states,
				mode : 'local',
				displayField : 'name',
				valueField : 'id',
				anchor : '100%',
				forceSelection : true,
				allowAddNewData : true,
				listeners : {
					removeitem : function(bs, v) {
						var tree = this.checkTree;
						var selNodes = tree.getChecked();
						Ext.each(selNodes, function(node) {
							if (v == node.id) {
								node.getUI().checkbox.checked = false;
								node.attributes.checked = false;
								tree.fireEvent('check', node,
										false);
							}
						});
					},
					scope : this
				}
			}*/]
		});

	},

	closeHandler : function() {
		this.close();
	},
	confirmHandler : function() {
		var checkedTreeText = '', 
			checkedTreeId = '', 
			selNodes = this.checkTree .getChecked();
		Ext.each(selNodes, function(node) {
			if (checkedTreeText.length > 0) {
				checkedTreeText += ',';
				checkedTreeId += ','
			}
			checkedTreeText += node.text;
			checkedTreeId += node.id;
		});
		if (this.debug) {
			Ext.Msg.show({
				title : '提示',
				msg : ('text :' + checkedTreeText + 'id :' + checkedTreeId),
				icon : Ext.Msg.INFO,
				minWidth : 200,
				buttons : Ext.Msg.OK
			});
		}
		var thiz = this;
		Ext.Ajax.request({
			url : contextPath + '/user/save.action',
			params : {
				"user.userId" : this.record.get('userId'),
				"user.dept.deptId" : checkedTreeId
			},
			success : function(resp){
				this.record.set('deptId', checkedTreeId);
				this.record.set('deptName', checkedTreeText);
				this.record.commit();
			}, 
			failure : function(){
				Ext.Msg.alert('提示', '服务器异常，请稍后再试！');
			},
			scope : this
		});
		this.closeHandler();
	}
});
