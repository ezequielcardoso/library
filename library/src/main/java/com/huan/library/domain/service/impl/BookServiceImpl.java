package com.huan.library.domain.service.impl;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huan.library.domain.model.book.Book;
import com.huan.library.domain.service.BookService;
import com.huan.library.infrastructure.persistence.BookDao;

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

	public void addOrModifyBook(Book book) throws Exception {
		bookDao.saveOrUpdate(book);
	}
	
	public void removeBook(Book book) throws Exception {
		bookDao.delete(book);
	}

	public Book findBookById(String bookId) throws Exception {
		return bookDao.get(bookId);
	}
	
	public List<Book> findAllBooks() throws Exception {
		return bookDao.selectAllBooks();
	}
}
