package com.huan.library.web.action;

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
	
	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
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
	public String saveBook(){
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
		try {
		  request.setAttribute("book", book);
		} catch (Exception e) {
		  e.printStackTrace();
		}
		return "showModifyBook";
	}
	
	/**
	 * 修改图书
	 * @return
	 * @throws Exception
	 */
	public String modifyBook() {
		try {
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
	public String deleteBook() {
		try {
			bookService.removeBook(book);
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
