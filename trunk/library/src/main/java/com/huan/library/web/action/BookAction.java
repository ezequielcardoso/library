package com.huan.library.web.action;


import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.huan.library.domain.model.book.Book;
import com.huan.library.domain.service.BookService;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 
 * @author huan
 * @time  2011-3-10 下午03:55:49
 */
@Controller
public class BookAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Resource
	private BookService bookService;

	private Book book;
	
	private List<Book> books = new ArrayList<Book>();
	
	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}
	
	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

	public void setBookService(BookService bookService) {
		this.bookService = bookService;
	}

	/**
	 * 显示添加Book页面
	 * @return
	 * @throws Exception
	 */
	public String showAdd() throws Exception {
		return Action.SUCCESS;
	}
	
	/**
	 * 添加Book
	 * @return
	 * @throws Exception
	 */
	public String add() throws Exception {
		try {
			bookService.addOrModifyBook(book);
		} catch (Exception e) {
		  e.printStackTrace();
		}
		return Action.SUCCESS;
	}
	
}
