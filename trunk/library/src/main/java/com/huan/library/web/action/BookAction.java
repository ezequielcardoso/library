package com.huan.library.web.action;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.huan.library.domain.model.book.Book;
import com.huan.library.domain.model.book.Category;
import com.huan.library.domain.model.book.Press;
import com.huan.library.domain.service.BookService;
import com.huan.library.domain.service.CategoryService;
import com.huan.library.domain.service.PressService;
import com.huan.library.util.Constants;
import com.huan.library.util.PageModel;
import com.opensymphony.xwork2.Action;

/**
 * 
 * @author huan
 * @time 2011-3-10 下午03:55:49
 */
@Controller("bookAction")
public class BookAction extends BaseActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Autowired
	private BookService bookService;                       // 图书service
	@Autowired
	private PressService pressService;                    // 出版社service
	@Autowired
	private CategoryService categoryService;             //图书分类service

	private Book book = new Book();                      // 图书信息
	private PageModel<Book> pageModel = new PageModel<Book>();

	private Press press = new Press();                    // 出版社
	private List<Press> presses = new ArrayList<Press>(); // 出版社集合
	Category category = new Category();                   // 图书分类
	private List<Category> categorys = new ArrayList<Category>(); // 图书分类集合

	/**
	 * 显示添加图书
	 */
	public String showSaveBook() {
		try {
			presses = pressService.findAllPresses();
			categorys = categoryService.findAllCategorys();
		} catch (Exception e) {
			e.printStackTrace();
		}
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
			return Action.ERROR;
		}
		return Action.SUCCESS;
	}

	/**
	 * 显示修改图书
	 */
	public String showModifyBook() {
		try {
			presses = pressService.findAllPresses();
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
	public String findBooksByPages() {
		try {
			pageModel = bookService.findBooksByPage(Constants.PAGENO, Constants.PAGESIZE);
		} catch (Exception e) {
			e.printStackTrace();
			return Action.ERROR;
		}
		return Action.SUCCESS;
	}

	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	public Press getPress() {
		return press;
	}
	public void setPress(Press press) {
		this.press = press;
	}
	public void setPressService(PressService pressService) {
		this.pressService = pressService;
	}
	public void setBookService(BookService bookService) {
		this.bookService = bookService;
	}
	public List<Press> getPresses() {
		return presses;
	}
	public void setPresses(List<Press> presses) {
		this.presses = presses;
	}
	public PageModel<Book> getPageModel() {
		return pageModel;
	}
	public void setPageModel(PageModel<Book> pageModel) {
		this.pageModel = pageModel;
	}

	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public List<Category> getCategorys() {
		return categorys;
	}
	public void setCategorys(List<Category> categorys) {
		this.categorys = categorys;
	}

}
