function save(){

	var id = Ext.get('libInfo.id').getValue();
	var libName = Ext.get('libInfo.libName').getValue();
	var baseCost = Ext.get('libInfo.baseCost').getValue();
	var telphone = Ext.get('libInfo.telphone').getValue();
//	var libManager = Ext.get('libInfo.libManager').getValue();
	var depositeTimes = Ext.get('libInfo.depositeTimes').getValue();
	var payADay = Ext.get('libInfo.payADay').getValue();
	var address = Ext.get('libInfo.address').getValue();
	var libDesc = Ext.get('libInfo.libDesc').getValue();
	
		Ext.Ajax.request({
				url : contextPath + '/libInfo/save.action',
				method : 'POST',
				params : {
					'libInfo.id' : id,
					'libInfo.libName' : libName,
					'libInfo.baseCost' : baseCost,
					'libInfo.telphone' : telphone,
//					'libInfo.libManager' : libManager,
					'libInfo.depositeTimes' : depositeTimes,
					'libInfo.payADay' : payADay,
					'libInfo.address' : address,
					'libInfo.libDesc' : libDesc
				},
				success : function(resp) {
					var obj = Ext.util.JSON.decode(resp.responseText);
					if (obj.success == true) {
						Ext.Msg.alert('提示', obj.msg);
//						loadBookForm(obj.data);

					} else if (obj.success == false) {
						Ext.Msg.alert('提示', obj.msg);
					}
				},
				failure : function() {
					Ext.Msg.alert('提示', '服务器异常，请稍候再试');
				}
			});
}

function clear(){
    Ext.get('libInfo.id').set('');
    Ext.get('libInfo.libName').set('');
    Ext.get('libInfo.baseCost').set('');
    Ext.get('libInfo.telphone').set('');
    Ext.get('libInfo.depositeTimes').set('');
//    Ext.get('libInfo.libManager').set('');
    Ext.get('libInfo.depositeTimes').set('');
    Ext.get('libInfo.payADay').set('');
    Ext.get('libInfo.address').set('');
    Ext.get('libInfo.libDesc').set('');
}