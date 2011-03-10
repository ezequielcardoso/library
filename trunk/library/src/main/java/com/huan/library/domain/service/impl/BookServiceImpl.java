package com.huan.library.domain.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.huan.library.domain.model.book.Book;
import com.huan.library.domain.service.BookService;
import com.huan.library.infrastructure.persistence.BookDao;

/**
 * bookServiceImpl
 * @author huan
 * @time  2011-3-10 下午03:37:36
 */
@Service
public class BookServiceImpl implements BookService {

	@Resource
	private BookDao bookDao;

	public void setBookDao(BookDao bookDao) {
		this.bookDao = bookDao;
	}

	public boolean addOrModifyBook(Book book) throws Exception {
		bookDao.saveOrUpdateDept(book);
		return false;
	}
	
	public boolean removeBook(Book book) throws Exception {
		bookDao.deleteBook(book);
		return false;
	}

	public Book loadBookById(String bookId) throws Exception {
		return bookDao.selectBookById(bookId);
	}
	
	public List<Book> findAllBooks() throws Exception {
		return bookDao.selectAllBooks();
	}

	
}
