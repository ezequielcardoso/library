function saveBook(){

	alert("");
	//取得表单数据
	var bookName = Ext.get('bookName').getValue();
	var barcode = Ext.get('barcode').getValue();
	var bookNo = Ext.get('bookNo').getValue();
	var searchBookId = Ext.get('searchBookId').getValue();
//	var pressId = Ext.get('pressId').getValue();
	var speciesId = Ext.get('speciesId').getValue();
//	var categoryId = Ext.get('categoryId').getValue();
	//.......后面的取值加上........
	
	
	//Ajax提交表单
	Ext.Ajax.request({
		url : contextPath + '/books/saveBook.action',
		method : 'POST',
		params : {
			"book.bookName" : bookName,
			"book.barCode" : barcode,
			"book.bookNo" : bookNo,
			"book.searchBookId" : searchBookId,
			"book.press.pressId" : '',
			"book.speciesId" : speciesId,
			"book.category.categoryId" : ''
			//........后面的参数加上.........
		}, 
		success : function(resp){
			//如果返回{success:true, data:"图书新增成功！"} 提示，并且重新加载表单
			//如果返回{success:false, data:"图书新增失败！"} 提示
			var obj = Ext.util.JSON.decode(resp.responseText);
			if(obj.success==true){
				//重新加载表单数据
				Ext.Msg.alert('提示', obj.data);
			} else if(obj.success==false){
				Ext.Msg.alert('提示', obj.data);
			}
		},
		failure : function(){
			Ext.Msg.alert('提示', '服务器异常，请稍候再试。');
		}
	});
	
}