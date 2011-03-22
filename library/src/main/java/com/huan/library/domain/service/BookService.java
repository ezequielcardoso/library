package com.huan.library.domain.service;

import com.huan.library.domain.model.book.Book;
import com.huan.library.util.PageModel;


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
	public Book addOrModifyBook(Book book) throws Exception;
	
	/**
	 * 根据id删除Book
	 * @param book
	 * @return
	 */
	public void removeBook(Book book) throws Exception;
	
	/**
	 * 根据Id查找Book
	 * @param bookId
	 * @return
	 */
	public Book findBookById(String bookId) throws Exception;
	
	/**
	 * 分页查找图书
	 * @return
	 * @throws Exception
	 */
	public PageModel<Book> findBooksByPage(int pageNo,int pageSize) throws Exception;


}
