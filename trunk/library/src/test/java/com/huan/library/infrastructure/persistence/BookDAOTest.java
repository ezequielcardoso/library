package com.huan.library.infrastructure.persistence;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import jxl.Cell;
import jxl.CellType;
import jxl.LabelCell;
import jxl.NumberCell;
import jxl.Sheet;
import jxl.Workbook;

import org.junit.BeforeClass;
import org.junit.Test;

import com.huan.library.application.BaseSpringBeans;
import com.huan.library.application.Constants;
import com.huan.library.domain.model.book.Book;
import com.huan.library.domain.model.book.BookState;
import com.huan.library.domain.model.book.Category;
import com.huan.library.domain.model.book.Currency;
import com.huan.library.domain.model.book.Press;
import com.huan.library.domain.model.book.BookSource;
import com.huan.library.domain.model.dict.DictItem;
import com.huan.library.domain.model.reader.Certificate;
/**
 * 图书dao测试类
 * @author huan
 * @time  2011-3-11 下午01:57:59
 */
public class BookDAOTest {

	private String filePath = Constants.ExcelDir + "books.xls";
	
	private static BookDao bookDao ;
    private static DictItemDao dictItemDao;
    private static PressDao pressDao;
	private  static CategoryDao categoryDao;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	  bookDao = (BookDao) BaseSpringBeans.getInstance().getBean("bookDao");
	  dictItemDao = (DictItemDao)BaseSpringBeans.getInstance().getBean("dictItemDao");
	  pressDao = (PressDao)BaseSpringBeans.getInstance().getBean("pressDao");
	  categoryDao= (CategoryDao)BaseSpringBeans.getInstance().getBean("categoryDao");
	}
    
	@Test public void testAdd(){
		try{
		Book book = new Book();
		book.setBookName("高等数学");
		book.setBookNo("abc-222");
		book.setBarCode("xx--222");
	    book.setSearchBookId("m2");
	    book.setSpeciesId("a21");
	    book.setAllStage("11111");
	    
	    //出版社
		Press press = new Press();
		press.setPressAddress("大连");
		press.setZipCode("18612");
		pressDao.saveOrUpdate(press);
		book.setPress(press);
		
		//图书分类
		Category category = new Category();
		category.setCategoryCode("B");
		category.setCategoryId("B");
		category.setCategoryName("数学");
		category.setParent(null);
		categoryDao.saveOrUpdate(category);
		book.setFirstCategory(category);
		
		//图书级别
		Certificate certificate = new Certificate();
		certificate.setItemName("密级");
	    dictItemDao.saveOrUpdate(certificate);
	    
	    //来源
	    BookSource source = new BookSource();
	    source.setItemName("捐赠");
	    dictItemDao.saveOrUpdate(source);
	    book.setBookSource(source);
	    
	    //币种
	    Currency currency = new Currency();
	    currency.setItemName("人名币");
	    dictItemDao.saveOrUpdate(currency);
	    book.setCurrency(currency);
	    
	    //图书状态
	    BookState bookState = new BookState();
	    bookState.setItemName("借阅中");
	    dictItemDao.saveOrUpdate(bookState);
	    book.setBookState(bookState);
  
		bookDao.saveOrUpdate(book);

		}catch (Exception e) {
		  e.printStackTrace();
		}
	}
	
	@Test
	public void testInsertBookBatch(){
		// 取得excel文件
		File file = new File(filePath);
		Workbook wb;

		try {
			// 打开workbook
			wb = Workbook.getWorkbook(file);
			// 打卡第一个sheet
			Sheet sheet = wb.getSheet(0);
			// 取得行数
			int row = sheet.getRows();
			// 取得列数
			int col = sheet.getColumns();
			// 取到一行中每列的值赋值给一个DictItem对象对应的属性，直到最后一行
			List<Book> books = new ArrayList<Book>();
			for (int i = 1; i < row; i++) {
				Book book = new Book();
				
				Press press = new Press();
				Category firstCategory = new Category();
				Category secondCategory = new Category();
				Category thirdCategory = new Category();
				BookState bookState = new BookState();
				
				for (int j = 0; j < col; j++) {
					Cell cell = sheet.getCell(j, i);
					if (cell.getType() == CellType.NUMBER) {
						NumberCell numberCell = (NumberCell) cell;
						switch (j) {
							case 3:
								press.setPressId((long)numberCell.getValue());
								book.setPress(press);
								break;
							case 12:
								book.setQuantity((int)numberCell.getValue());
								break;	
							case 13:
								book.setPrice((float)numberCell.getValue());
								break;	
							case 14:
								break;	
						}
					} else if (cell.getType() == CellType.LABEL) {
						LabelCell lc = (LabelCell) cell;
						switch (j) {
							case 0:
								book.setBookNo(lc.getContents());
								break;
							case 1:
								book.setBarCode(lc.getContents());
								break;	
							case 2:
								book.setBookName(lc.getContents());
								break;	
							case 4:
								
								break;	
							case 5:
								firstCategory.setCategoryId(lc.getContents());
								book.setFirstCategory(firstCategory);
								break;	
							case 6:
								secondCategory.setCategoryId(lc.getContents());
								book.setSecondCategory(secondCategory);
								break;
							case 7:
								thirdCategory.setCategoryId(lc.getContents());
								book.setThirdCategory(thirdCategory);
								break;
							case 8:
								book.setSearchBookId(lc.getContents());
								break;	
							case 9:
								book.setLocation(lc.getContents());
								break;	
							case 10:
								book.setAuthor(lc.getContents());
								break;	
							case 11:
								book.setTranslator(lc.getContents());
								break;	
							case 15:
								bookState.setItemId(lc.getContents());
								book.setBookState(bookState);
								break;		
						}
					}
				}
				books.add(book);
			}
			bookDao.insertBooksBatch(books);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
