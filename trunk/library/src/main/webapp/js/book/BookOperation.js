function saveBook() {

	var bookId = Ext.get('book.bookId').getValue();
	var bookName = Ext.get('book.bookName').getValue();
	var barcode = Ext.get('book.barcode').getValue();
	var bookNo = Ext.get('book.bookNo').getValue();
	var searchBookId = Ext.get('book.searchBookId').getValue();
	var pressId = Ext.get('book.press.pressId').getValue();
	var speciesId = Ext.get('book.speciesId').getValue();
	var firstCategoryId = Ext.get('book.firstCategory.categoryId').getValue();
	var publisherDate = Ext.get('publisherDate').getValue();
	var revision = Ext.get('revision').getValue();
	var quantity = Ext.get('quantity').getValue();
	var pages = Ext.get('pages').getValue();
	var price = Ext.get('price').getValue();
	var location = Ext.get('location').getValue();
	var ISBN = Ext.get('ISBN').getValue();
	var spell = Ext.get('spell').getValue();
	var donator = Ext.get('donator').getValue();
	var bookDesc = Ext.get('bookDesc').getValue();
	var firstCategoryId = Ext.get('book.firstCategory.itemId').getValue();
	var secondCategoryId = Ext.get('book.secondCategory.itemId').getValue();
	var thirdCategoryId = Ext.get('book.thirdCategory.itemId').getValue();
	var publisherDate = Ext.get('book.publisherDate').getValue();
	var revision = Ext.get('book.revision').getValue();
	var quantity = Ext.get('book.quantity').getValue();
	var pages = Ext.get('book.pages').getValue();
	var price = Ext.get('book.price').getValue();
	var location = Ext.get('book.location').getValue();
	var ISBN = Ext.get('book.ISBN').getValue();
	var spell = Ext.get('book.spell').getValue();
	var donator = Ext.get('book.donator').getValue();
	var bookDesc = Ext.get('book.bookDesc').getValue();

	Ext.Ajax.request({
				url : contextPath + '/book/saveBook.action',
				method : 'POST',
				params : {
					"book.bookId" : bookId,
					"book.bookName" : bookName,
					"book.barCode" : barcode,
					"book.bookNo" : bookNo,
					"book.searchBookId" : searchBookId,
					"book.press.pressId" : pressId,
					"book.speciesId" : speciesId,
					"book.firstCategory.itemId" : firstCategoryId,
					"book.secondCategory.itemId" : secondCategoryId,
					"book.thirdCategory.itemId" : thirdCategoryId,
					"book.publisherDate" : publisherDate,
					"book.revision" : revision,
					"book.fileName" : fileName,
					"book.quantity" : quantity,
					"book.pages" : pages,
					"book.price" : price,
					"book.location" : location,
					"book.ISBN" : ISBN,
					"book.spell" : spell,
					"book.donator" : donator,
					"book.bookDesc" : bookDesc
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
				idField : 'book.security.itemId',
				textField : 'book.security.itemName',
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
				title : '选择币种'
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

   var checkWin = new Library.tree.BaseCheckTreeWindow({
			checkTree : new Library.tree.dict.CategoryCheckTree({
						level : level,
						itemName : null,
						checkModel : 'single'
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