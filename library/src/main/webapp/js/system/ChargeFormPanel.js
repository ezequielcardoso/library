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
			labelWidth : 80,
			frame : true,
			xtype : 'form',
			buttonAlign : 'center',
			items : [
				    {
						xtype : 'textfield',
						name : 'id',
						id:'id',
						anchor : '-20'
					},{
						xtype : 'textfield',
						name : 'readerCateCode',
						id : 'readerCateCode',
						anchor : '-20',
						fieldLabel : '读者条形码'
					},{
						name : 'charge.itemId',
//						id : 'charge.itemId',
						fieldLabel : '项目',
						anchor : '-20',
						displayField : 'name',    // name 显示的数据
						valueField : 'key',     //取值时用
						editable : false,
						xtype : 'flatdiccombobox',
						className : 'com.huan.library.domain.model.Charge'
					},
					{
						xtype : 'textfield',
						name : 'punishMoney',
//						id : 'punishMoney',
						anchor : '-20',
						fieldLabel : '金额'
					}, {
						xtype : 'textfield',
						name : 'eventsDesc',
//						id : 'eventsDesc',
						anchor : '-20',
						flex : 1,
						height : '220',
						fieldLabel : '备注'
					}],
			buttons : [{
						text : '增加',
						handler : function() {
					      this.onAdd();
				       },
				       scope : this
					}, {
						text : '重置'
					}, {
						text : '刷新'
					}]
		});
		Library.charge.form.ChargeFormPanel.superclass.initComponent.call(this);
	},

	onAdd : function() {
//        this.getComponent('chargeFormPanel').getForm().submit({
//           url:''
//           success:function(){
//		Ext.Msg.alert('提示','添加成功');
		chargeFormPanel.getForm().submit({url:'',success : function(){
		   alert('提示','保存成功');
		}});
//             
//           },
//           falie 
//        });         
	}

});