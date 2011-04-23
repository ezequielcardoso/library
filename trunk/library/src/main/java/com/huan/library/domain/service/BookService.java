package com.huan.library.domain.service;

import java.util.List;

import com.huan.library.domain.model.book.Book;
import com.huan.library.util.PageModel;
import com.huan.library.web.view.BookView;


/**
 * 图书
 * @author huan
 * @time  2011-3-10 下午03:20:49
 */
public interface BookService {
	/**
	 * 增加或者修改Book
	 * @param book
	 * @return
	 */
	public Book addOrModifyBook(Book book) ;
	
	/**
	 * 根据id删除Book
	 * @param book
	 * @return
	 */
	public void removeBook(Book book) ;
	
	
	/**
	 * 分页查找图书
	 * @return
	 * @
	 */
	public PageModel<Book> findBooksByPage(int pageNo,int pageSize) ;

	/**
	 * 分页查找图书
	 * @return
	 * @
	 */
	public List<Book> findBooks(BookView bookView) ;

	/**
	 * 根据Id查找Book
	 * @param bookId
	 * @return
	 */
	public Book getBookById(Long bookId) ;
	
	/**
	 * 
	 * @param barCode
	 * @return
	 * @
	 */
	public Book getBookByBarCode(String barCode) ;
    
	public String exportExcel(String rootDir, BookView bookView) ;
}
