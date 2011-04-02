Ext.ns('Library.book.addGrid');


Library.book.addGrid.BookAddGrid = Ext.extend(Ext.form.FormPanel,{
  
	id : 'addGrid',
	
	initComponent: function(){
 
		var tbar = new Ext.Toolbar({
		   width: 600,
           height: 100,
           items: [
           {
            xtype:'button',
            text: '修改'
         },{
            xtype: 'button',
            text: '重置'
        },{
            xtype: 'button', 
            text: '返回'
        }]
       });
		
	      var items =[[{
	          name:'label',
	          fieldLabel:'书名',
	          name:'bookName'
	      }],[{
	           name:'label',
	          fieldLabel:'条形码',
	          name:'barCode'
	      }]] ;
      
		Ext.apply(this,{
		   title:'修改图书',
		   height:500,
		   width :600,
		   autoScroll:true,
		   frame:true,
		   tbar:tbar,
		   defaultType:{defaultType :'textfield',width:100},
		   items:items
		});
		
	   	Library.book.addGrid.BookAddGrid.superclass.initComponent.call(this);	
	}
});