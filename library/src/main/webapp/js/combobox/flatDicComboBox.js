Ext.ns('Govhr.ux');

Govhr.ux.FlatDicComboBox = Ext.extend(Ext.form.ComboBox, {

    className: null,
    
    initComponent: function(){
        this.store = new Ext.data.JsonStore({
            url: contextPath + '/dict/getflatdict.do?className=' + this.className,
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
        
        Govhr.ux.FlatDicComboBox.superclass.initComponent.call(this);
    }
    
    
    
});
Ext.reg('flatdiccombobox', Govhr.ux.FlatDicComboBox);
