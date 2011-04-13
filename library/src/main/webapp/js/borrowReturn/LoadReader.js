Ext.get('reader.cardNo').on('blur', function(){
	loadReader(this.getValue());
}, Ext.get('reader.cardNo'));

function loadReader(cardNo){

	Ext.Ajax.request({
		url : contextPath + '/reader/getReaderByCardNo.action',
		method : 'POST',
		params : {
			"readerView.cardNo" : cardNo
		},
		success : function(resp){
			var reader = Ext.util.JSON.decode(resp.responseText);
			document.getElementById('reader.id').value = reader.id;
			document.getElementById('reader.cardNo').value = reader.cardNo;
			document.getElementById('reader.readerName').value = reader.readerName;
			//................
		},
		failure : function(){
		
		}
	});
}