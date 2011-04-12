package com.huan.library.domain.service.impl;



import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huan.library.domain.model.book.Book;
import com.huan.library.domain.service.BookService;
import com.huan.library.infrastructure.persistence.BookDao;
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

	public Book addOrModifyBook(Book book) throws Exception {
		Book bookCopy = new Book();
		try{
			bookCopy = bookDao.saveOrUpdate(book);
		}catch(Exception e){
			e.printStackTrace();
			throw new Exception(e);
		}
		return bookCopy;
	}
	
	public void removeBook(Book book) throws Exception {
		try{
		    bookDao.delete(book);
		}catch(Exception e){
			e.printStackTrace();
			throw new Exception(e);
		}
	}


	public PageModel<Book> findBooksByPage(int pageNo, int pageSize)
			throws Exception {
		PageModel<Book> pageModel = new PageModel<Book>();
		try {
			pageModel = bookDao.selectByPage(pageNo, pageSize);
		} catch (Exception e) {
		    e.printStackTrace();
		    throw new Exception();
		}
		return pageModel;
	}

	public List<Book> findBooks(BookView bookView) throws Exception {
		List<Book> books = new ArrayList<Book>();
		try {
			books = this.bookDao.selectBooks(bookView);
		} catch (Exception e){
			e.printStackTrace();
			throw new Exception(e);
		}
		return books;
	}

	public Book getBookById(Long bookId) throws Exception {
		Book book = new Book();
		try {
			book = this.bookDao.selectBookById(bookId);
		} catch (Exception e){
			e.printStackTrace();
			throw new Exception(e);
		}
		return book;
	}

}
