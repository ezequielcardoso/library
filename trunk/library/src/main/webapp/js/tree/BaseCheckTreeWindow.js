Ext.ns('Library.tree');

/**
 * 
 * @param checkModel 包含值为single,cascade,parentCascade,childCascade选择类型
 * @idField 需要添入的选择的ID信息
 * @textField 需要添入的选择的NAME信息
 * @debug 是否进行调试模式
 *
 */
Library.tree.BaseCheckTreeWindow = Ext.extend(Ext.Window, {

	checkTree : null,

	debug : false,

	idField : null,

	textField : null,

	initComponent : function() {
		if (!this.checkTree) {
				Ext.Msg.alert("请传入选择树checkTree属性");
			return;
		}
		Ext.apply(this, {
			autoScroll : false,
			border : false
		});
		
		Library.tree.BaseCheckTreeWindow.superclass.initComponent.call(this);
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
		var idElement = Ext.getCmp(this.idField);
		var textElement = Ext.getCmp(this.textField);
		if (this.idField && idElement)
			idElement.setValue(checkedTreeId);
		if (this.textField && textElement)
			textElement.setValue(checkedTreeText);

		idElement = Ext.get(this.idField);
		textElement = Ext.get(this.textField);
		if (this.idField && idElement)
			idElement.dom.value = checkedTreeId;
		if (this.textField && textElement)
			textElement.dom.value = checkedTreeText;
			
		this.closeHandler();
	}
});
