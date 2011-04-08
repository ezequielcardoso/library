Ext.ns('Govhr.ux');

Govhr.ux.ArrayLocalComboBox = Ext.extend(Ext.form.ComboBox, {

    storeArray: null,
    
    initComponent: function(){
		if(this.storeArray)
			this.storeArray.unshift(['','请选择...']);
        this.store = new Ext.data.ArrayStore({
            fields: ['key', 'value'],
            data: this.storeArray
        });
        
        Ext.apply(this, {
            displayField: 'value',
            valueField: 'key',
            mode: 'local',
            triggerAction: 'all',
            lazyInit: true,
            loadingText: '载入数据...',
            editable: false,
            selectOnFocus: true
        });
		
		
        
        Govhr.ux.ArrayLocalComboBox.superclass.initComponent.call(this);
    }
    
    
    
});
Ext.reg('arraylocalcombobox', Govhr.ux.ArrayLocalComboBox);
