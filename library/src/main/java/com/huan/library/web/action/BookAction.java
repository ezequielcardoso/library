package com.huan.library.web.action;


import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.huan.library.domain.model.book.Book;
import com.huan.library.domain.service.BookService;
import com.opensymphony.xwork2.Action;

/**
 * 
 * @author huan
 * @time  2011-3-10 下午03:55:49
 */
@Controller("bookAction")
public class BookAction extends BaseActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private BookService bookService;  //service
     
	private Book book = new Book();   //图书信息
	
	private String bookId;            //图书编号


	public void setBookId(String bookId) {
		this.bookId = bookId;
	}
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
     * 显示添加图书
     */
    public String showSaveBook() {
    	return "showSaveBook";
    }
    
	/**
	 * 添加Book
	 * @return
	 * @throws Exception
	 */
	public String saveBook() {
		try {
			bookService.addOrModifyBook(book);
		} catch (Exception e) {
		  e.printStackTrace();
		}
		return Action.SUCCESS;
	}
	
	 /**
     * 显示修改图书
     */
	public String showModifyBook(){
		return "showModifyBook";
	}
	
	/**
	 * 修改图书
	 * @return
	 * @throws Exception
	 */
	public String modifyBook() {
		try {
			book.setId(Integer.parseInt(bookId));
			bookService.addOrModifyBook(book);
		} catch (Exception e) {
			e.printStackTrace();
			return Action.ERROR;
		}
		return Action.SUCCESS;
	}
	
	/**
	 * 注销图书
	 * @return
	 * @throws Exception
	 */
	public String delete() {
		try {
			book.setId(Integer.parseInt(bookId));
			bookService.removeBook(book);
		} catch (Exception e) {
			e.printStackTrace();
			return Action.ERROR;
		}
		return Action.SUCCESS;
	}
	
	/**
	 * 根据BookId查找Book
	 * @return
	 * @throws Exception
	 */
	public String findById() {
		try {
			request.setAttribute("book", bookService.findBookById(String.valueOf(book.getId())));
		} catch (Exception e) {
			e.printStackTrace();
			return Action.ERROR;
		}
		return Action.SUCCESS;
	}
	/**
	 * 查找所有的图书
	 * @return
	 * @throws Exception
	 */
	public String findBooks() {
		try {
			request.setAttribute("books", bookService.findAllBooks());
		} catch (Exception e) {
			e.printStackTrace();
			return Action.ERROR;
		}
		return Action.SUCCESS;
	}

}
