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
	public Book findBookById(int bookId) throws Exception;
	
	/**
	 * 分页查找图书
	 * @return
	 * @throws Exception
	 */
	public PageModel<Book> findBooksByPage(int pageNo,int pageSize) throws Exception;

	/**
	 * 分页查找图书
	 * @return
	 * @throws Exception
	 */
	public List<Book> findBooks(BookView bookView) throws Exception;

	/**
	 * 查找图书的总数
	 * @param bookView
	 * @return
	 */
	public Long findBooksCount() throws Exception;
	

}
