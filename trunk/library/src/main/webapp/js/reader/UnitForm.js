Ext.ns('Library.tree.form');
Library.tree.form.UnitForm = Ext.extend(Ext.form.FormPanel, {
	
	id : 'unitForm',
    formValues: null,
    
    pid : null,
    deptId : null,
    
    initComponent: function(){
        Ext.apply(this, {
            method: 'post',
            labelWidth: 60,
            labelAlign: 'right',
            autoScroll : true,
            autoWidth : true,
            autoHeight : true,
            defaultType: 'textfield'
        });
        
        // build form-buttons
        this.tbar = new Ext.Toolbar([{
            text: '保存',
            iconCls: 'icon-save',
            handler: function(){
            	this.formSubmit();
            },
            scope: this
        }]);
        
        this.items = this.buildForm();

        Library.tree.form.UnitForm.superclass.initComponent.call(this, arguments);
        
        if(this.deptId!=null){
        	Ext.Ajax.request({
				url : contextPath + '/reader/getById.action',
				params : {
					unitId : this.unitId
				},
				success : function(resp){
					var obj = Ext.util.JSON.decode(resp.responseText);
					var form = this.getForm();
					form.findField('unit.unitName').setValue(obj.unitName);
					form.findField('unit.unitCode').setValue(obj.unitCode);
					form.findField('unit.unitShortName').setValue(obj.unitShortName);
					form.findField('unit.unitAlias').setValue(obj.unitAlias);
					form.findField('unit.unitDesc').setValue(obj.unitDesc);
				}, 
				failure : function(){
					Ext.Msg.alert('提示', '服务器异常，请稍后再试！');
				},
				scope : this
			});
        }
        
        if (this.formValues != null) {
            this.setFormInitValues();
        }
        
    },
    
    /**
     * setFormInitValues
     */
    setFormInitValues: function(){
    	this.getForm().setValues(this.formValues);
    },
    /**
     * buildform
     */
    buildForm: function(){
        return [{
            fieldLabel: '全称',
            width : 160,
            id: 'unit.unitName',
            name: 'unit.unitName'
        }, {
            fieldLabel: '编号',
            width : 160,
            name: 'unit.unitCode',
            id: 'unit.unitCode'
        }, {
            fieldLabel: '简称',
            width : 160,
            name: 'unit.unitShortName',
            id: 'unit.unitShortName'
        },  {
            fieldLabel: '别称',
            width : 160,
            name: 'unit.unitAlias',
            id: 'unit.unitAlias'
        }, {
            fieldLabel: '简介',
            xtype : 'textarea',
            width : 160,
            height : 60,
            autoScroll : true,
            name: 'unit.unitDesc',
            id: 'unit.unitDesc'
        }, 
//        {
//            fieldLabel: '叶子',
//            width : 160,
//            name: 'department.leaf',
//            id: 'department.leaf'
//        }, 
        {
            name: 'unit.unitId',
            id: 'unit.unitId',
            value : this.unitId,
            hidden: true
        }, {
            name: 'unit.parentUnit.unitId',
            id: 'unit.parentUnit.unitId',
            value : this.pid,
            hidden: true
        }];
    },
    
    formSubmit: function(){
        var form = this.getForm();
        var submitValues = form.getValues();
        for (var param in submitValues) {
            if (form.findField(param) == '') {
                submitValues[param] = null;
            }
        }
        if (form.isValid()) 
            form.submit({
                url: contextPath + '/reader/save.action',
                method: "POST",
                waitMsg: "请稍后,开始保存...",
                success: function(form, action){
                    if(action.result.success && action.result.data){
                		Ext.Msg.alert('提示', action.result.msg);
                		this.getForm().findField('unit.unitId').setValue(action.result.data.unitId);
                		Ext.getCmp('readerUnitsTreePanel').getRootNode().reload();
                		Ext.getCmp('readerUnitsTreePanel').getRootNode().expand();
                	}else{
                		Ext.Msg.alert('提示', action.result.msg);
                	}
                },
                failure: function(form, action){
                	Ext.Msg.alert('提示', '服务器异常，请稍后再试！');
                },
                scope: this
            })
    }
    
});
