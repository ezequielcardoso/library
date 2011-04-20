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
			buttonAlign : 'center',
			items : [
				    {
						xtype : 'hidden',
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
						id : 'charge.itemId',
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
						id : 'punishMoney',
						anchor : '-20',
						fieldLabel : '金额'
					}, {
						xtype : 'textarea',
						name : 'eventsDesc',
						id : 'eventsDesc',
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
          var id = Ext.get('id').getValue();
          var readerCateCode = Ext.get('readerCateCode').getValue();
          var chargeId = Ext.get('charge.itemId').getValue();
          var punishMoney = Ext.get('punishMoney').getValue();
          var eventsDesc = Ext.get('eventsDesc').getValue();
          Ext.Ajax.request({
//				url : contextPath + '/book/saveBook.action',
				method : 'POST',
				params : {
					'punishment.id' : id,
					'punishment.reader.readerCateCode' : readerCateCode,
					'punishment.charge.itemId' : chargeId,
					'punishment.punishMoney' : punishMoney,
					'punishment.eventsDesc' : eventsDesc
				},
				success : function(resp) {
					var obj = Ext.util.JSON.decode(resp.responseText);
					if (obj.success == true) {
						Ext.Msg.alert('提示', obj.msg);
//						loadBookForm(obj.data);

					} else if (obj.success == false) {
						Ext.Msg.alert('提示', obj.msg);
					}
				},
				failure : function() {
					Ext.Msg.alert('提示', '服务器异常，请稍候再试');
				}
			});
	}

});