function savePress() {

	
	
	var pressId = Ext.get('pressId').getValue();
	var pressISBN = Ext.get('pressISBN').getValue();
	var pressName = Ext.get('pressName').getValue();
	var pressAddress = Ext.get('pressAddress').getValue();
	var zipCode = Ext.get('zipCode').getValue();

	Ext.Ajax.request({
				url : contextPath + '/book/savePress.action',
				method:'POST',
				params : {
					pressId : 'pressId',
					pressISBN : 'pressISBN',
					pressName : 'pressName',
					pressAddress : 'pressAddress',
					zipCode : 'zipCode'
				},
				success : function(resp) {
					var obj = Ext.util.JSON.decode(resp.responseText);
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
}

function resetBookForm() {

}

function loadBookForm(record) {
	Ext.get('pressId').setValue(record.pressId);
}
