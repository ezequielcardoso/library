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
			labelAlign : 'center',
			labelWidth : 60,
			frame : true,
			buttonAlign : 'center',
			items : [
					{
						name : 'charge.itemId',
						fieldLabel : '项目',
						displayField : 'name',    // name 显示的数据
						valueField : 'key',     //取值时用
						editable : false,
						xtype : 'flatdiccombobox',
						className : 'com.huan.library.domain.model.Charge'
					},
					{
						xtype : 'textfield',
						name : 'punishMoney',
						anchor : '-20',
						fieldLabel : '金额'
					}, {
						xtype : 'textarea',
						name : 'eventsDesc',
						anchor : '-20',
						flex : 1,
						height : '220',
						fieldLabel : '备注'
					}],
			buttons : [{
						text : '增加'
					}, {
						text : '重置'
					}, {
						text : '返回'
					}]
		});

		Library.charge.form.ChargeFormPanel.superclass.initComponent.call(this);

	},

	onAdd : function() {
          
	}

});