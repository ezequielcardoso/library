Ext.ns('Library.rights.form');
Library.rights.form.DeptForm = Ext.extend(Ext.form.FormPanel, {
	
	id : 'DeptForm',
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

        Library.rights.form.DeptForm.superclass.initComponent.call(this, arguments);
        
        if(this.deptId!=null){
        	Ext.Ajax.request({
				url : contextPath + '/dept/getById.action',
				params : {
					deptId : this.deptId
				},
				success : function(resp){
					var obj = Ext.util.JSON.decode(resp.responseText);
					var form = this.getForm();
					form.findField('department.deptName').setValue(obj.deptName);
					form.findField('department.deptCode').setValue(obj.deptCode);
					form.findField('department.deptShortName').setValue(obj.deptShortName);
					form.findField('department.deptAlias').setValue(obj.deptAlias);
					form.findField('department.deptDesc').setValue(obj.deptDesc);
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
            xtype : 'textarea',
            width : 160,
            height : 60,
            autoScroll : true,
            name: 'department.deptDesc',
            id: 'department.deptDesc'
        }, 
//        {
//            fieldLabel: '叶子',
//            width : 160,
//            name: 'department.leaf',
//            id: 'department.leaf'
//        }, 
        {
            name: 'department.deptId',
            id: 'department.deptId',
            value : this.deptId,
            hidden: true
        }, {
            name: 'department.parent.deptId',
            id: 'department.parent.deptId',
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
                url: contextPath + '/dept/save.action',
                method: "POST",
                waitMsg: "请稍后,开始保存...",
                success: function(form, action){
                    if(action.result.success && action.result.data){
                		Ext.Msg.alert('提示', action.result.msg);
                		this.getForm().findField('department.deptId').setValue(action.result.data.deptId);
                		Ext.getCmp('departmentTreePanel').getRootNode().reload();
                		Ext.getCmp('departmentTreePanel').getRootNode().expand();
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
