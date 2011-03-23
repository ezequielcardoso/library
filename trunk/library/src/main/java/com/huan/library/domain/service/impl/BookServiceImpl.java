package com.huan.library.domain.service.impl;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huan.library.domain.model.book.Book;
import com.huan.library.domain.service.BookService;
import com.huan.library.infrastructure.persistence.BookDao;
import com.huan.library.util.PageModel;

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

	public Book addOrModifyBook(Book book) throws Exception {
		return bookDao.saveOrUpdate(book);
	}
	
	public void removeBook(Book book) throws Exception {
		bookDao.delete(book);
	}

	public Book findBookById(int bookId) throws Exception {
		return bookDao.selectById(bookId);
	}
	
	public PageModel<Book> findBooksByPage(int pageNo, int pageSize)
			throws Exception {
		PageModel<Book> pageModel = new PageModel<Book>();
		try {
			pageModel = bookDao.selectByPage(pageNo, pageSize);
		} catch (Exception e) {
		    e.printStackTrace();
		}
		return pageModel;
	}
}
