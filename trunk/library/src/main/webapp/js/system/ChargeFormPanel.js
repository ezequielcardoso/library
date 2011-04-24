Ext.ns('Library.charge.form');
/**
 * huan
 * 
 * @class Library.charge.form.ChargeForm
 * @extends Ext.form.FormPanel
 */
Library.charge.form.ChargeFormPanel = new Ext.extend(Ext.form.FormPanel, {

	id : 'chargeFormPanel',

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
				name : 'punishmentView.id',
				hidden : true
			}, {
				xtype : 'textfield',
				width : 240,
				allowBlank : false,
				name : 'punishmentView.readerBarCode',
				fieldLabel : '读者条形码'
			}, {
				hiddenName : 'punishmentView.chargeId',
				width : 240,
				allowBlank : false,
				fieldLabel : '项目',
				displayField : 'name', // name 显示的数据
				valueField : 'key', // 取值时用
				editable : false,
				xtype : 'flatdiccombobox',
				className : 'com.huan.library.domain.model.Charge'
			}, {
				xtype : 'numberfield',
				width : 240,
				allowBlank : false,
				name : 'punishmentView.punishMoney',
				fieldLabel : '金额'
			}, {
				xtype : 'textfield',
				width : 240,
				name : 'punishmentView.eventsDesc',
				height : '220',
				fieldLabel : '备注'
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
		Library.charge.form.ChargeFormPanel.superclass.initComponent.call(this);
	},

	onSave : function() {
		this.getForm().submit({
					url : contextPath + '/punishment/save.action',
					success : function() {
						Ext.Msg.alert('提示','收费成功');
					}
				});
	}

});