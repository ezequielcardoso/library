Ext.ns('Library.cardLost.form');

Library.cardLost.form.CardLostFormPanel = new Ext.extend(Ext.form.FormPanel, {

	id : 'cardLostFormPanel',

	initComponent : function() {

		Ext.apply(this, {
			width : 400,
			height : 360,
			frame : true,
			labelWidth : 80,
			labelAlign : 'right',
			buttonAlign : 'center',
			items : [{
				xtype : 'textfield',
				name : 'readerView.id',
				hidden : true
			}, {
				xtype : 'textfield',
				width : 240,
				allowBlank : false,
				name : 'readerView.barCode',
				fieldLabel : '读者条形码'
			}, {
				hiddenName : 'readerView.cardStateId',
				width : 240,
				allowBlank : false,
				fieldLabel : '借阅证状态',
				displayField : 'name', // name 显示的数据
				valueField : 'key', // 取值时用
				editable : false,
				xtype : 'flatdiccombobox',
				className : 'com.huan.library.domain.model.reader.CardState'
			}],
			buttons : [{
				text : '增加',
				handler : function() {
					this.onSave();
				},
				scope : this
			}, {
				text : '重置'
			}]
		});
		Library.cardLost.form.CardLostFormPanel.superclass.initComponent.call(this);
	},

	onSave : function() {
		this.getForm().submit({
					url : contextPath + '/reader/cardLost.action',
					success : function() {
						Ext.Msg.alert('提示','更改成功');
					}
				});
	}

});