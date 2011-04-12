
function loadReader(){

	
	var cardNo = Ext.get('reader.cardNo').getValue();
	
	Ext.Ajax.request({
	
		url:contextPath + '/reader/findReader.action',
		method:'POST',
		params:{
		  'readerView.cardNo' : cardNo
		},
		success : function(resp) {
					var obj = Ext.util.JSON.decode(resp.responseText);
					alert(obj.data);
					if (obj.success == true) {
						Ext.Msg.alert('提示', obj.msg);
						loadBookForm(obj.data);

					} else if (obj.success == false) {
						Ext.Msg.alert('提示', obj.msg);
					}
				},
				failure : function() {
					Ext.Msg.alert('提示', '服务器异常，请稍候再试');
				}

	});

};

