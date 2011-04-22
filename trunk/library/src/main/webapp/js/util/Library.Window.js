Ext.ns("Library.util");

Library.util.Window = Ext.extend(Ext.Window, {
	
	formPanel: null,
	
	title: null,
	width: null,
	height: null,
	tbar: null,
	fbar: null,
	
	initComponent: function(){
		Ext.apply(this, {
			title: (this.title) ? this.title : '编辑窗口',
			iconCls: 'boa-window-title',
            autoScroll : false,
			border : false,
			width: (this.width) ? this.width : 500,
			height: (this.height) ? this.height : 'auto'
        });
        this.items = this.formPanel;
        this.tbar = this.tbar;
        this.fbar = this.fbar;
        if(!this.tbar && !this.fbar)this.fbar = this.buildFbar();
        Library.util.Window.superclass.initComponent.apply(this, arguments);
        this.show();
	},
	buildFbar: function(){
		var thiz = this;
    	return [{
            text: '保存',
            iconCls: 'boa-save',
            handler: function(){
            	thiz.formPanel.formSubmit(thiz)
            },
            scope: this
        }, {
            text: '取消',
            iconCls: 'boa-cancel',
            handler: function(){
            	thiz.closeWin();
            },
            scope: this
        }];
    },
    closeWin: function(){
    	this.formPanel = null;	
		this.title = null;
		this.width = null;
		this.height = null;
		this.tbar = null;
		this.fbar = null;
        this.close();
    }
});