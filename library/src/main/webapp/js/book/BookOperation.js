function saveBook(){

	alert("");
	//ȡ�ñ�����
	var bookName = Ext.get('bookName').getValue();
	var barcode = Ext.get('barcode').getValue();
	var bookNo = Ext.get('bookNo').getValue();
	var searchBookId = Ext.get('searchBookId').getValue();
//	var pressId = Ext.get('pressId').getValue();
	var speciesId = Ext.get('speciesId').getValue();
//	var categoryId = Ext.get('categoryId').getValue();
	//.......�����ȡֵ����........
	
	
	//Ajax�ύ��
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
			//........����Ĳ�������.........
		}, 
		success : function(resp){
			//�������{success:true, data:"ͼ�������ɹ���"} ��ʾ���������¼��ر�
			//�������{success:false, data:"ͼ������ʧ�ܣ�"} ��ʾ
			var obj = Ext.util.JSON.decode(resp.responseText);
			if(obj.success==true){
				//���¼��ر�����
				Ext.Msg.alert('��ʾ', obj.data);
			} else if(obj.success==false){
				Ext.Msg.alert('��ʾ', obj.data);
			}
		},
		failure : function(){
			Ext.Msg.alert('��ʾ', '�������쳣�����Ժ����ԡ�');
		}
	});
	
}