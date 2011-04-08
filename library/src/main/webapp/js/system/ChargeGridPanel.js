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
							items : [{
										marging : '0px 0px 10px 0px',
										xtype : 'combo',
										anchor : '-20',
										mode : 'local',
										name : 'project.itemName',
										value : '租金',
										fieldLabel : '项目',
										displayField : 'name',
										editable : false,
										triggerAction : 'all',
										forceSelection : true,
										store : new Ext.data.JsonStore({
													fields : ['name', 'value'],
													data : [{
																name : '租金',
																value : 'mr'
															}, {
																name : '罚金',
																value : 'mrs'
															}, {
																name : '补卡',
																value : 'miss'
															}]
												})
									}, {
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

			}
		});