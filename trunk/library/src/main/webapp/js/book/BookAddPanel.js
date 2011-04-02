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
            text: '�޸�'
         },{
            xtype: 'button',
            text: '����'
        },{
            xtype: 'button', 
            text: '����'
        }]
       });
		
	      var items =[[{
	          name:'label',
	          fieldLabel:'����',
	          name:'bookName'
	      }],[{
	           name:'label',
	          fieldLabel:'������',
	          name:'barCode'
	      }]] ;
      
		Ext.apply(this,{
		   title:'�޸�ͼ��',
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