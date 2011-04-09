Ext.ns('Library.combo');
/**
 * 返回字典值
 */
Library.combo.ValueDicComboBox = Ext.extend(Ext.form.ComboBox, {

    className: null,
    
    initComponent: function(){
        this.store = new Ext.data.JsonStore({
            url: contextPath + '/dict/getByItemClass.action?className=' + this.className,
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
        
        Library.combo.ValueDicComboBox.superclass.initComponent.call(this);
    }
    
});
Ext.reg('valuediccombobox', Library.combo.ValueDicComboBox);
