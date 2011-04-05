function saveBook() {

	var bookId = Ext.get('book.bookId').getValue();
	var bookName = Ext.get('book.bookName').getValue();
	var barCode = Ext.get('book.barCode').getValue();
	var bookNo = Ext.get('book.bookNo').getValue();
	var ISBN = Ext.get('book.ISBN').getValue();
	var author = Ext.get('book.author').getValue();
	var bookDesc = Ext.get('book.bookDesc').getValue();
	var donator = Ext.get('book.donator').getValue();
	var translator = Ext.get('book.translator');
	
	var searchBookId = Ext.get('book.searchBookId').getValue();
	var speciesId = Ext.get('book.speciesId').getValue();
	var publisherDate = Ext.get('book.publisherDate').getValue();
	var revision = Ext.get('book.revision').getValue();
	var quantity = Ext.get('book.quantity').getValue();
	var pages = Ext.get('book.pages').getValue();
	var price = Ext.get('book.price').getValue();
	var location = Ext.get('book.location').getValue();
	var spell = Ext.get('book.spell').getValue();
	var storeDate = Ext.get('book.storeDate').getValue();
	var operator = Ext.get('book.operator').getValue();
	
	var firstCategoryId = Ext.get('book.firstCategory.itemId').getValue();
	var secondCategoryId = Ext.get('book.secondCategory.itemId').getValue();
	var thirdCategoryId = Ext.get('book.thirdCategory.itemId').getValue();
	var pressId = Ext.get('book.press.pressId').getValue();
	var bookStateId = Ext.get('book.bookState.itemId').getValue();
	var bookLevelId = Ext.get('book.bookLevel.itemId').getValue();
	var bookSecurityId = Ext.get('book.bookSecurity.itemId').getValue();
	var currencyId = Ext.get('book.currency.itemId').getValue();
	var bookSourceId = Ext.get('book.bookSource.itemId').getValue();

	Ext.Ajax.request({
				url : contextPath + '/book/saveBook.action',
				method : 'POST',
				params : {
					'book.bookId' : bookId,
					'book.bookName' : bookName,
					'book.barCode' : barCode,
					'book.bookNo' : bookNo,
					'book.ISBN' : ISBN,
					'book.author' : author,
					'book.bookDesc' : bookDesc,
					'book.donator' : donator,
					'book.translator' : translator,
					
					'book.searchBookId' : searchBookId,
					'book.speciesId' : speciesId,
					'book.publisherDate' : publisherDate,
					'book.revision' : revision,
					'book.quantity' : quantity,
					'book.pages' : pages,
					'book.price' : price,
					'book.location' : location,
					'book.spell' : spell,
					'book.storeDate' : storeDate,
					'book.operator' : operator,
					
					'book.firstCategory.itemId' : firstCategoryId,
					'book.secondCategory.itemId' : secondCategoryId,
					'book.thirdCategory.itemId' : thirdCategoryId,
					'book.press.pressId' : pressId,
					'book.bookState.itemId' : bookStateId,
					'book.bookLevel.itemId' : bookLevelId,
					'book.bookSecurity.itemId' : bookSecurityId,
					'book.currency.itemId' : currencyId,
					'book.bookSource.itemId' : bookSourceId
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
	Ext.get('book.bookId').setValue('');
	Ext.get('book.bookName').setValue('');
	Ext.get('book.barcode').setValue('');
	Ext.get('book.bookNo').setValue('');
	Ext.get('book.donator').setValue('');
	Ext.get('book.author').setValue('');
	Ext.get('book.bookDesc').setValue('');
	Ext.get('book.ISBN').setValue('');
	Ext.get('book.translator').setValue('');;	
	
	Ext.get('book.searchBookId').setValue('');
	Ext.get('book.speciesId').setValue('');
	Ext.get('book.publisherDate').setValue('');
	Ext.get('book.revision').setValue('');
	Ext.get('book.quantity').setValue('');
	Ext.get('book.pages').setValue('');
	Ext.get('book.price').setValue('');
	Ext.get('book.location').setValue('');
	Ext.get('book.spell').setValue('');
	Ext.get('book.storeDate').setValue('');
	Ext.get('book.operator').setValue('');
	
	Ext.get('book.firstCategory.itemId').setValue('');
	Ext.get('book.secondCategory.itemId').setValue('');
	Ext.get('book.thirdCategory.itemId').setValue('');
	Ext.get('book.firstCategory.itemName').setValue('');
	Ext.get('book.secondCategory.itemName').setValue('');
	Ext.get('book.thirdCategory.itemName').setValue('');
	Ext.get('book.press.pressId').setValue('');
	Ext.get('book.press.pressName').setValue('')
	Ext.get('book.bookState.itemId').getValue();
	Ext.get('book.bookLevel.itemId').getValue();
	Ext.get('book.bookSecurity.itemId').getValue();
	Ext.get('book.currency.itemId').getValue();
	Ext.get('book.bookSource.itemId').getValue();
	Ext.get('book.bookState.itemName').getValue();
	Ext.get('book.bookLevel.itemName').getValue();
	Ext.get('book.bookSecurity.itemName').getValue();
	Ext.get('book.currency.itemName').getValue();
	Ext.get('book.bookSource.itemName').getValue();
}

function loadBookForm(record) {
	Ext.get('book.bookId').setValue(record.bookId);
}

/**
 * 图书密级
 */
function checkBookSecurity(){
   
	var checkWin = new Library.tree.BaseCheckTreeWindow({
				checkTree : new Library.tree.dict.BookSecurityCheckTree({
							checkModel : 'single'
						}),
				idField : 'book.bookSecurity.itemId',
				textField : 'book.bookSecurity.itemName',
				height : 300,
				width : 200,
				title : '选择图书密级'
			});
	checkWin.show();
}
/**
 * 图书来源 
 */
function checkBookSource() {

	var checkWin = new Library.tree.BaseCheckTreeWindow({
				checkTree : new Library.tree.dict.BookSourceCheckTree({
							checkModel : 'single'
						}),
				idField : 'book.bookSource.itemId',
				textField : 'book.bookSource.itemName',
				height : 300,
				width : 200,
				title : '选择图书来源'
			});
	checkWin.show();
}
/**
 * 币种
 */
function checkCurrency(){
 
		var checkWin = new Library.tree.BaseCheckTreeWindow({
				checkTree : new Library.tree.dict.CurrencyCheckTree({
							checkModel : 'single'
						}),
				idField : 'book.currency.itemId',
				textField : 'book.currency.itemName',
				height : 300,
				width : 200,
				title : '选择币种'
					});
			checkWin.show();
		 
		}
 
		/**
 * 图书状态
 */
function checkBookState(){

       var checkWin = new Library.tree.BaseCheckTreeWindow({
				checkTree : new Library.tree.dict.BookStateCheckTree({
							checkModel : 'single'
						}),
				idField : 'book.bookState.itemId',
				textField : 'book.bookState.itemName',
				height : 300,
				width : 200,
				title : '选择图书状态'
			});
	checkWin.show();
}

function checkBookLevel(){

   var checkWin = new Library.tree.BaseCheckTreeWindow({
			checkTree : new Library.tree.dict.BookLevelCheckTree({
						checkModel : 'single'
					}),
			idField : 'book.bookLevel.itemId',
			textField : 'book.bookLevel.itemName',
			height : 300,
			width : 200,
			title : '选择图书级别'
		});
	checkWin.show();
}

function checkCategory(level, idField, textField){
	var rootId = 'Category';
	if(level==2){
		var itemId = Ext.get('book.firstCategory.itemId').getValue();
		if(itemId!=null && itemId!=""){
			rootId = itemId;
		} else {
			Ext.Msg.alert('提示', '请选择类别');
			return;
		}
	} else if(level==3){
		var itemId = Ext.get('book.firstCategory.itemId').getValue();
		if(itemId!=null && itemId!=""){
			//do nothing
		} else {
			Ext.Msg.alert('提示', '请选择类别');
			return;
		}
		itemId = Ext.get('book.secondCategory.itemId').getValue();
		if(itemId!=null && itemId!=""){
			rootId = itemId;
		} else {
			Ext.Msg.alert('提示', '请选择二级分类');
			return;
		}
	} 
	
   var checkWin = new Library.tree.BaseCheckTreeWindow({
			checkTree : new Library.tree.dict.CategoryCheckTree({
						level : level,
						itemName : null,
						checkModel : 'single',
						rootId : rootId
					}),
			idField : idField,
			textField : textField,
			height : 500,
			width : 300,
			title : '选择图书分类'
		});
	checkWin.show();
}

function checkPress() {
	var checkWin = new Library.tree.BaseCheckTreeWindow({
				checkTree : new Library.tree.dict.PressCheckTree({
							checkModel : 'single'
						}),
				idField : 'book.press.pressId',
				textField : 'book.press.pressName',
				height : 500,
				width : 300,
				title : '选择出版社'
			});
	checkWin.show();
}