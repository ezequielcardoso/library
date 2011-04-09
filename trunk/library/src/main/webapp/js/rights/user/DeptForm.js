Ext.ns('Library.rights.form');
Library.rights.form.DeptForm = Ext.extend(Ext.form.FormPanel, {
	
	id : 'DeptForm',
    formValues: null,
    
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
            	this.formSubmit
            },
            scope: this
        }, {
            text: '添加',
            iconCls: 'icon-save',
            handler: function(){
            	this.formValues = null;
            	this.getForm().setFormInitValues();
            },
            scope: this
        }]);
        
        this.items = this.buildForm();

        Library.rights.form.DeptForm.superclass.initComponent.call(this, arguments);
        
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
            id: 'department.deptName',
            name: 'department.deptName'
        }, {
            fieldLabel: '编号',
            width : 160,
            name: 'department.deptCode',
            id: 'department.deptCode'
        }, {
            fieldLabel: '简称',
            width : 160,
            name: 'department.deptShortName',
            id: 'department.deptShortName'
        },  {
            fieldLabel: '别称',
            width : 160,
            name: 'department.deptAlias',
            id: 'department.deptAlias'
        }, {
            fieldLabel: '简介',
            width : 160,
            name: 'department.deptDesc',
            id: 'department.deptDesc'
        }, {
            fieldLabel: '叶子',
            width : 160,
            name: 'department.leaf',
            id: 'department.leaf'
        }, {
            name: 'department.deptId',
            id: 'department.deptId',
            hidden: true
        }, {
            name: 'department.parent.deptId',
            id: 'department.parent.deptId',
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
                url: contextPath + '/dept/save.action',
                method: "POST",
                waitMsg: "请稍后,开始保存...",
                success: function(form, action){
                    if(action.result.success && action.result.data){
                	
                	}else{
                	
                	}
                },
                failure: function(form, action){
                	
                },
                scope: this
            })
    }
    
});
