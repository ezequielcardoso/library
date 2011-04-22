Ext.ns('Library.rights.form');

Library.rights.form.FunctionForm = Ext.extend(Ext.form.FormPanel, {
    
    formValues: null,
    
    initComponent: function(){    
        Ext.apply(this, {
            labelWidth: 80,
            method: 'post',
            labelAlign: 'right',
            frame: true,
            border: false,
            defaultType: 'textfield',
            layout: 'form',
            labelSeparator: '',
            defaults: {anchor:'98%'},
            anchor:'98%'
        });
        this.items = this.buildForm();
        Library.rights.form.FunctionForm.superclass.initComponent.apply(this, arguments);
        
        if (this.formValues != null) {
            this.setFormInitValues();
        }       
    },   
    buildForm: function(){
        return [{
            fieldLabel: '父功能名称',
            name: 'function.parent.funcName',
            readOnly: true
        }, {
            fieldLabel: '功能ID',
            name: 'function.funcId',
            allowBlank: false
        }, {
            fieldLabel: '功能名称',
            name: 'function.funcName',
            allowBlank: false
        }, {
            fieldLabel: '资源标识',
            name: 'function.resCmpId',
            allowBlank: false
        }, {
            fieldLabel: '资源链接',
            name: 'function.resCmpHandURL'
        }, {
            fieldLabel: '资源图标',
            name: 'function.resCmpIconCls'
        }, {
            fieldLabel: '资源排序',
            name: 'function.funcOrder'
        }, {
            hidden: true,
            name: 'function.level'
        }, {
            hidden: true,
            name: 'function.parent.funcId'
        }, {
            hidden: true,
            name: 'function.leaf'
        }];
    },
    setFormInitValues: function(){
    	var form = this.getForm();
        form.setValues(this.formValues);
        if(this.formValues.parentId)form.findField('function.parent.funcId').setValue(this.formValues.parentId);
        if(this.formValues.parentName)form.findField('function.parent.funcName').setValue(this.formValues.parentName);
        if(this.formValues.funcName)form.findField('function.funcName').setValue(this.formValues.funcName);
        if(this.formValues.resCmpId)form.findField('function.resCmpId').setValue(this.formValues.resCmpId);
        if(this.formValues.resCmpHandURL)form.findField('function.resCmpHandURL').setValue(this.formValues.resCmpHandURL);
        if(this.formValues.resCmpIconCls)form.findField('function.resCmpIconCls').setValue(this.formValues.resCmpIconCls);
        if(this.formValues.funcOrder)form.findField('function.funcOrder').setValue(this.formValues.funcOrder);
        if(this.formValues.funcId)form.findField('function.funcId').setValue(this.formValues.funcId);
        if(this.formValues.level)form.findField('function.level').setValue(this.formValues.level);
        form.findField('function.leaf').setValue(this.formValues.leaf);
    },
    
    formSubmit: function(win){
        var form = this.getForm();
        if (form.isValid()){
            form.submit({
                url: contextPath + '/function/save.action',
                method: "POST",
                waitMsg: "请稍后,开始保存...",
                success: function(form, action){
                	if(action.result && action.result.data){
                		win.closeWin();
                		var grid = Ext.getCmp('FunctionTreeGrid');
						grid.selectNode.parentNode.reload();
                    	Ext.Msg.alert('提示', '保存成功');
                	}else{
                		Ext.Msg.alert('提示', '保存失败');
                	}
                },
                failure: function(form, action){
                    Ext.Msg.alert('提示', '保存失败');
                },
                scope: this
            })
        }
    }
    
});
