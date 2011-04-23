package com.huan.library.domain.service.impl;



import java.io.File;
import java.util.ArrayList;
import java.util.List;

import jxl.Workbook;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huan.library.domain.model.book.Book;
import com.huan.library.domain.model.book.Press;
import com.huan.library.domain.service.BookService;
import com.huan.library.infrastructure.persistence.BookDao;
import com.huan.library.util.ExcelOperate;
import com.huan.library.util.ExcelStyle;
import com.huan.library.util.PageModel;
import com.huan.library.web.view.BookView;

/**
 * bookServiceImpl
 * @author huan
 * @time  2011-3-10 下午03:37:36
 */
@Service("bookService")
public class BookServiceImpl implements BookService {
	
	@Autowired
	private BookDao bookDao;

	public void setBookDao(BookDao bookDao) {
		this.bookDao = bookDao;
	}

	public Book addOrModifyBook(Book book)  {
			book = bookDao.saveOrUpdate(book);
		return book;
	}
	
	public void removeBook(Book book)  {
		
		    bookDao.delete(book);
		
	}


	public PageModel<Book> findBooksByPage(int pageNo, int pageSize)
			 {
		return bookDao.selectByPage(pageNo, pageSize);
	}

	public List<Book> findBooks(BookView bookView)  {
		return this.bookDao.selectBooks(bookView);
	}

	public Book getBookById(Long bookId)  {
		return this.bookDao.selectBookById(bookId);
	}

	public Book getBookByBarCode(String barCode)  {
		return this.bookDao.selectBookByBarCode(barCode);
	}
	
	public String exportExcel(String rootDir, BookView bookView) {
		List<Book> books = new ArrayList<Book>();
		WritableWorkbook ww;
		String fileName = "upload" + File.separator +"books.xls";
		File file = new File(rootDir + fileName);
		try {
			books = bookDao.selectBooks(bookView);
			ww = Workbook.createWorkbook(file);
			WritableSheet ws = ww.createSheet("图书信息", 0);
			
			ExcelOperate.addLabelToSheet(ws, 0, 0, 9, 0,"书刊信息", ExcelStyle.getHeaderStyle());
			ExcelOperate.addLabelToSheet(ws, 0, 1, "条形码", ExcelStyle.getTitleStyle());
			ExcelOperate.addLabelToSheet(ws, 1, 1, "图书编号", ExcelStyle.getTitleStyle());
			ExcelOperate.addLabelToSheet(ws, 2, 1, "书刊名字", ExcelStyle.getTitleStyle());
			ExcelOperate.addLabelToSheet(ws, 3, 1, "种次号", ExcelStyle.getTitleStyle());
			ExcelOperate.addLabelToSheet(ws, 4, 1, "一级分类", ExcelStyle.getTitleStyle());
			ExcelOperate.addLabelToSheet(ws, 5, 1, "二级分类", ExcelStyle.getTitleStyle());
			ExcelOperate.addLabelToSheet(ws, 6, 1, "三级分类", ExcelStyle.getTitleStyle());
			ExcelOperate.addLabelToSheet(ws, 7, 1, "出版社", ExcelStyle.getTitleStyle());
			ExcelOperate.addLabelToSheet(ws, 8, 1, "拼音", ExcelStyle.getTitleStyle());
			ExcelOperate.addLabelToSheet(ws, 9, 1, "图书级别", ExcelStyle.getTitleStyle());
			ExcelOperate.addLabelToSheet(ws, 10, 1, "图书密级", ExcelStyle.getTitleStyle());
			ExcelOperate.addLabelToSheet(ws, 11, 1, "币种", ExcelStyle.getTitleStyle());
			ExcelOperate.addLabelToSheet(ws, 12, 1, "页数", ExcelStyle.getTitleStyle());
			ExcelOperate.addLabelToSheet(ws, 13, 1, "价格", ExcelStyle.getTitleStyle());
			ExcelOperate.addLabelToSheet(ws, 14, 1, "出版日期", ExcelStyle.getTitleStyle());
			ExcelOperate.addLabelToSheet(ws, 15, 1, "数量", ExcelStyle.getTitleStyle());
			ExcelOperate.addLabelToSheet(ws, 16, 1, "存放位置", ExcelStyle.getTitleStyle());
			ExcelOperate.addLabelToSheet(ws, 17, 1, "版次", ExcelStyle.getTitleStyle());
			ExcelOperate.addLabelToSheet(ws, 18, 1, "入库时间", ExcelStyle.getTitleStyle());
			ExcelOperate.addLabelToSheet(ws, 19, 1, "录入人员", ExcelStyle.getTitleStyle());
			ExcelOperate.addLabelToSheet(ws, 20, 1, "图书状态", ExcelStyle.getTitleStyle());
			ExcelOperate.addLabelToSheet(ws, 21, 1, "图书简介", ExcelStyle.getTitleStyle());
			ExcelOperate.addLabelToSheet(ws, 22, 1, "附件", ExcelStyle.getTitleStyle());
    
			if(bookView.getIsBook()==1){
				ExcelOperate.addLabelToSheet(ws, 23, 1, "索书号", ExcelStyle.getTitleStyle());
				ExcelOperate.addLabelToSheet(ws, 24, 1, "作者", ExcelStyle.getTitleStyle());
				ExcelOperate.addLabelToSheet(ws, 25, 1, "译者", ExcelStyle.getTitleStyle());
				ExcelOperate.addLabelToSheet(ws, 26, 1, "ISBN", ExcelStyle.getTitleStyle());
			}if(bookView.getIsBook() == 0){
				ExcelOperate.addLabelToSheet(ws, 23, 1, "国内统一刊号", ExcelStyle.getTitleStyle());
				ExcelOperate.addLabelToSheet(ws, 24, 1, "ISSN", ExcelStyle.getTitleStyle());
				ExcelOperate.addLabelToSheet(ws, 25, 1, "邮发代码", ExcelStyle.getTitleStyle());
				ExcelOperate.addLabelToSheet(ws, 26, 1, "第几期", ExcelStyle.getTitleStyle());
				ExcelOperate.addLabelToSheet(ws, 27, 1, "总第几期", ExcelStyle.getTitleStyle());
			}
			
			int count =2;
	           for(Book book : books){
	            	ExcelOperate.addLabelToSheet(ws, 0, count, book.getBarCode(), ExcelStyle.getContentStyle());   
	            	ExcelOperate.addLabelToSheet(ws, 1, count, book.getBookNo(), ExcelStyle.getContentStyle());
	            	ExcelOperate.addLabelToSheet(ws, 2, count, book.getBookName(), ExcelStyle.getContentStyle());
	            	ExcelOperate.addLabelToSheet(ws, 3, count, book.getSpeciesId(), ExcelStyle.getContentStyle());
	            	ExcelOperate.addLabelToSheet(ws, 4, count, book.getFirstCategory().getItemName(), ExcelStyle.getContentStyle());
	            	ExcelOperate.addLabelToSheet(ws, 5, count, book.getSecondCategory().getItemName(), ExcelStyle.getContentStyle());
	            	ExcelOperate.addLabelToSheet(ws, 6, count, book.getThirdCategory().getItemName(), ExcelStyle.getContentStyle());
	            	ExcelOperate.addLabelToSheet(ws, 7, count, book.getPress().getPressName(), ExcelStyle.getContentStyle());
	            	ExcelOperate.addLabelToSheet(ws, 8, count, book.getSpell(), ExcelStyle.getContentStyle());
	            	ExcelOperate.addLabelToSheet(ws, 9, count, book.getBookLevel().getItemName(), ExcelStyle.getContentStyle());
	            	ExcelOperate.addLabelToSheet(ws, 10, count, book.getBookSecurity().getItemName(), ExcelStyle.getContentStyle());
	            	ExcelOperate.addLabelToSheet(ws, 11, count, book.getCurrency().getItemName(), ExcelStyle.getContentStyle());
	            	ExcelOperate.addLabelToSheet(ws, 12, count, book.getPages(), ExcelStyle.getContentStyle());
	            	ExcelOperate.addLabelToSheet(ws, 13, count, book.getPrice(), ExcelStyle.getContentStyle());
	            	ExcelOperate.addLabelToSheet(ws, 14, count, book.getPublisherDate(), ExcelStyle.getContentStyle());
	            	ExcelOperate.addLabelToSheet(ws, 15, count, book.getQuantity(), ExcelStyle.getContentStyle());
	            	ExcelOperate.addLabelToSheet(ws, 16, count, book.getLocation(), ExcelStyle.getContentStyle());
	            	ExcelOperate.addLabelToSheet(ws, 17, count, book.getRevision(), ExcelStyle.getContentStyle());
	            	ExcelOperate.addLabelToSheet(ws, 18, count, book.getStoreDate(), ExcelStyle.getContentStyle());
	            	ExcelOperate.addLabelToSheet(ws, 19, count, book.getOperator(), ExcelStyle.getContentStyle());
	            	ExcelOperate.addLabelToSheet(ws, 20, count, book.getBookState().getItemName(), ExcelStyle.getContentStyle());
	            	ExcelOperate.addLabelToSheet(ws, 21, count, book.getBookDesc(), ExcelStyle.getContentStyle());
	            	ExcelOperate.addLabelToSheet(ws, 22, count, "有", ExcelStyle.getContentStyle());
	            	
	            	if(bookView.getIsBook() == 1){
	            		ExcelOperate.addLabelToSheet(ws, 23, count, book.getSearchBookId(), ExcelStyle.getContentStyle());
	            		ExcelOperate.addLabelToSheet(ws, 24, count, book.getAuthor(), ExcelStyle.getContentStyle());
	            		ExcelOperate.addLabelToSheet(ws, 25, count, book.getTranslator(), ExcelStyle.getContentStyle());
	            		ExcelOperate.addLabelToSheet(ws, 26, count, book.getISBN(), ExcelStyle.getContentStyle());
	            	}else if(bookView.getIsBook() == 0){
	            		ExcelOperate.addLabelToSheet(ws, 23, count, book.getISBN(), ExcelStyle.getContentStyle());
	            		ExcelOperate.addLabelToSheet(ws, 24, count, book.getISSN(), ExcelStyle.getContentStyle());
	            		ExcelOperate.addLabelToSheet(ws, 25, count, book.getEmailNo(), ExcelStyle.getContentStyle());
	            		ExcelOperate.addLabelToSheet(ws, 26, count, book.getStage(), ExcelStyle.getContentStyle());
	            		ExcelOperate.addLabelToSheet(ws, 27, count, book.getAllStage(), ExcelStyle.getContentStyle());
	            	}
	            	
	            	count++;
	            }
			 
	            for (int i = 0; i < 29; i++) {   
	                ws.setColumnView(i, 16);   
	            }   
	            ws.setRowView(0, 20); 
	            ww.write();   
	            ww.close();   
	            System.out.println("写入excel成功！");	
		} catch (Exception e) {
			e.printStackTrace();
		}
		return fileName;
	}


}
