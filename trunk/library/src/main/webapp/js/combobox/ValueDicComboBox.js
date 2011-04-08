Ext.ns('Govhr.ux');
/**
 * 返回字典值
 */
Govhr.ux.ValueDicComboBox = Ext.extend(Ext.form.ComboBox, {

    className: null,
    
    initComponent: function(){
        this.store = new Ext.data.JsonStore({
            url: contextPath + '/dict/getflatdict.do?className=' + this.className,
            fields: ['key', 'value', 'comment']
        });
        
        Ext.apply(this, {
            displayField: 'value',
            valueField: 'value',
            mode: 'remote',
            triggerAction: 'all',
            lazyInit: false,
            loadingText: '载入数据...',
            editable: false,
            selectOnFocus: true
        });
        
        Govhr.ux.ValueDicComboBox.superclass.initComponent.call(this);
    }
    
    
    
});
Ext.reg('valuediccombobox', Govhr.ux.ValueDicComboBox);
