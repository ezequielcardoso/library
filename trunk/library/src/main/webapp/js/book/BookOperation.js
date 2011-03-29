function saveBook(){

	//ȡ�ñ�����
	var bookName = Ext.get('bookName').getValue();
	var barcode = Ext.get('barcode').getValue();
	var bookNo = Ext.get('bookNo').getValue();
	var searchBookId = Ext.get('searchBookId').getValue();
	var pressId = Ext.get('pressId').getValue();
	var speciesId = Ext.get('speciesId').getValue();
    var categoryId = Ext.get('categoryId').getValue();
    //��������
    var publisherDate = Ext.get('publisherDate').getValue();
    var revision = Ext.get('revision').getValue();
	//�ܼ�
    var quantity = Ext.get('quantity').getValue();
    var pages = Ext.get('pages').getValue();		
    var price = Ext.get('price').getValue();	
    var location = Ext.get('location').getValue();	
    //ͼ��״̬
    var ISBN = Ext.get('ISBN��').getValue();	
    var spell = Ext.get('spell').getValue();	
    //�ܼ�
    //��Դ
    //����
    var donator = Ext.get('donator').getValue();	
	var bookDesc = Ext.get('bookDesc').getValue();	
	
	//Ajax�ύ��
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
			//��������
			"book.publisherDate" : publisherDate,
			"book.revision" : revision,
			"book.fileName" : fileName,
			//�ܼ�
			"book.quantity" : quantity,
			"book.pages" : pages,
			"book.price" : price,
			"book.location" : location,
			//ͼ��״̬
			"book.ISBN" : ISBN,
			"book.spell" : spell,
			 //�ܼ�
             //��Դ
             //����
			"book.donator" : donator,
			"book.bookDesc" : bookDesc
			//........����Ĳ�������.........
		}, 
		success : function(resp){
			//�������{success:true, msg :"ͼ�������ɹ���"} ��ʾ���������¼��ر�
			//�������{success:false, msg :"ͼ������ʧ�ܣ�"} ��ʾ
			var obj = Ext.util.JSON.decode(resp.responseText);
			if(obj.success==true){
				Ext.Msg.alert('��ʾ', obj.msg);
				//���¼��ر�����
				loadBookForm(obj.data);
				
			} else if(obj.success==false){
				Ext.Msg.alert('��ʾ', obj.msg);
			}
		},
		failure : function(){
			Ext.Msg.alert('��ʾ', '�������쳣�����Ժ����ԡ�');
		}
	});
	
}
//��ձ�
function resetBookForm(){

}
//���ر�����
function loadBookForm(record){

}