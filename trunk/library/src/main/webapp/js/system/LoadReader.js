Ext.get('readerCateCode').on('blur', function(){
	loadReader(this.getValue());
}, Ext.get('readerCateCode'));

function loadReader(readerCateCode){

	Ext.Msg.alert(211111111111111);
	
	Ext.Ajax.request({
		url : contextPath + '/reader/getReaderByCardNo.action',
		method : 'POST',
		params : {
			"readerView.cardNo" : readerCateCode
		},
		success : function(resp){
			var reader = Ext.util.JSON.decode(resp.responseText);
			document.getElementById('reader.id').value = reader.id;
		},
		failure : function(){
		   Ext.Msg.alert('服务器繁忙,请稍候重试!');
		}
	});
}