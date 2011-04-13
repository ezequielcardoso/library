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
			document.getElementById('reader.readerUnits.unitName').value = reader.readerUnits.unitName;
			document.getElementById('reader.readerType.readerCateName').value = reader.readerType.readerCateName;
			document.getElementById('reader.cardState.itemName').value = reader.cardState.itemName;
			document.getElementById('reader.sex').value = reader.sex;
			document.getElementById('reader.borrowedQuantiy').value = reader.borrowedQuantiy;
			document.getElementById('reader.totalBQuantity').value = reader.totalBQuantity;
			document.getElementById('reader.leftMoney').value = reader.leftMoney;
			document.getElementById('reader.readerType.borrowedQuantity').value = reader.readerType.borrowedQuantity;
			document.getElementById('reader.readerType.rent').value = reader.readerType.rent;
			document.getElementById('reader.readerType.borrowDays').value = reader.readerType.borrowDays;
		},
		failure : function(){
		   Ext.Msg.alert('∑˛ŒÒ∆˜∑±√¶,«Î…‘∫Ú÷ÿ ‘!');
		}
	});
}