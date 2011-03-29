function saveBook(){

	//取得表单数据
	var bookName = Ext.get('bookName').getValue();
	var barcode = Ext.get('barcode').getValue();
	var bookNo = Ext.get('bookNo').getValue();
	var searchBookId = Ext.get('searchBookId').getValue();
	var pressId = Ext.get('pressId').getValue();
	var speciesId = Ext.get('speciesId').getValue();
    var categoryId = Ext.get('categoryId').getValue();
    //二级分类
    var publisherDate = Ext.get('publisherDate').getValue();
    var revision = Ext.get('revision').getValue();
	//密级
    var quantity = Ext.get('quantity').getValue();
    var pages = Ext.get('pages').getValue();		
    var price = Ext.get('price').getValue();	
    var location = Ext.get('location').getValue();	
    //图书状态
    var ISBN = Ext.get('ISBN：').getValue();	
    var spell = Ext.get('spell').getValue();	
    //密级
    //来源
    //币种
    var donator = Ext.get('donator').getValue();	
	var bookDesc = Ext.get('bookDesc').getValue();	
	
	//Ajax提交表单
	Ext.Ajax.request({
		url : contextPath + '/book/saveBook.action',
		method : 'POST',
		params : {
			"book.bookName" : bookName,
			"book.barCode" : barcode,
			"book.bookNo" : bookNo,
			"book.searchBookId" : searchBookId,
			"book.press.pressId" : pressId,
			"book.speciesId" : speciesId,
			"book.category.categoryId" : categoryId,
			//二级分类
			"book.publisherDate" : publisherDate,
			"book.revision" : revision,
			"book.fileName" : fileName,
			//密级
			"book.quantity" : quantity,
			"book.pages" : pages,
			"book.price" : price,
			"book.location" : location,
			//图书状态
			"book.ISBN" : ISBN,
			"book.spell" : spell,
			 //密级
             //来源
             //币种
			"book.donator" : donator,
			"book.bookDesc" : bookDesc
			//........后面的参数加上.........
		}, 
		success : function(resp){
			//如果返回{success:true, msg :"图书新增成功！"} 提示，并且重新加载表单
			//如果返回{success:false, msg :"图书新增失败！"} 提示
			var obj = Ext.util.JSON.decode(resp.responseText);
			if(obj.success==true){
				Ext.Msg.alert('提示', obj.msg);
				//重新加载表单数据
				loadBookForm(obj.data);
				
			} else if(obj.success==false){
				Ext.Msg.alert('提示', obj.msg);
			}
		},
		failure : function(){
			Ext.Msg.alert('提示', '服务器异常，请稍候再试。');
		}
	});
	
}
//清空表单
function resetBookForm(){

}
//加载表单数据
function loadBookForm(record){

}