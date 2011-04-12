
function loadReader(){

	
	var cardNo = Ext.get('reader.cardNo').getValue();
	
	Ext.Ajax.request({
	
		url:contextPath + '/reader/findReader.action',
		method:'POST',
		params:{
		  'readerView.cardNo' : cardNo
		}
	});

};

