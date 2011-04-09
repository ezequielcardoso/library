Ext.ns('Library.combo');

Library.combo.FlatDicComboBox = Ext.extend(Ext.form.ComboBox, {

    className: null,
    
    initComponent: function(){
        this.store = new Ext.data.JsonStore({
            url: contextPath + '/dict/getByItemClass.action?className=' + this.className,
            fields: ['key', 'value', 'comment']
        });
        
        Ext.apply(this, {
            displayField: 'value',
            valueField: 'key',
            mode: 'remote',
            triggerAction: 'all',
            lazyInit: false,
            loadingText: '载入数据...',
            editable: false,
            selectOnFocus: true
        });
        
        Library.combo.FlatDicComboBox.superclass.initComponent.call(this);
    }
    
    
    
});
Ext.reg('flatdiccombobox', Library.combo.FlatDicComboBox);
