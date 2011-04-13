package com.huan.library.web.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.huan.library.domain.model.book.Book;
import com.huan.library.domain.service.BookService;
import com.huan.library.web.view.BookView;
import com.huan.library.web.view.form.ExtJsonForm;
import com.huan.library.web.view.grid.ExtGridLoad;
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
	private BookService bookService; // 图书service
	/**
	 * 获取参数和返回数据对象
	 */
	private Book book = new Book(); // 图书信息--增加删除加载一个对象的时候用book,查询时用bookView对象
	private ExtGridLoad extGridLoad = new ExtGridLoad(); // 对应result的extGridLoad
	// 应用struts2的属性驱动模式,自动填充页面的属性
	private BookView bookView = new BookView();// 接收客户端提交的参数
	private ExtJsonForm extJsonForm = new ExtJsonForm();// 回应给客户端的表单数据

	private Integer start;
	private Integer limit;

	/**
	 * 图书基本信息管理主页
	 * 
	 * @return
	 * @throws Exception
	 */
	public String bookMain() {
		return Action.SUCCESS;
	}

	/**
	 * 期刊基本信息管理主页
	 * 
	 * @return
	 * @throws Exception
	 */
	public String magazineMain() {
		return Action.SUCCESS;
	}

	/**
	 * 分页查找图书或者期刊
	 * @return
	 * @throws Exception
	 */
	public String findBooks() {
		try {
			bookView.setStart(start);
			bookView.setLimit(limit);
			List<Book> books = bookService.findBooks(bookView);
			extGridLoad.setRoot(this.convertToView(books));
			extGridLoad.setTotalProperty(bookView.getTotalCount());
		} catch (Exception e) {
			e.printStackTrace();
			return Action.ERROR;
		}
		return Action.SUCCESS;
	}

	public String findBookById() {
		try {
			 book = bookService.getBookById(bookView.getBookId());
		} catch (Exception e) {
			e.printStackTrace();
			return Action.ERROR;
		}
		return Action.SUCCESS;
	}
	
	public String findBookByBarCode() {
		try {
			List<Book> books = bookService.findBooks(bookView);
			if(books.size()>0){
				book = books.listIterator().next();
			} else {
				book = null;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return Action.ERROR;
		}
		return Action.SUCCESS;
	}
	

	/**
	 * 显示添加或者修改期刊
	 */
	public String showSaveMagazine() {
		if (bookView.getBookId() != null) {
			try {
				book = bookService.getBookById(bookView.getBookId());
				if (book.getFirstCategory() != null) {
					book.getFirstCategory().setChildren(null);
					book.getFirstCategory().setParent(null);
				}
				if (book.getSecondCategory() != null) {
					book.getSecondCategory().setChildren(null);
					book.getSecondCategory().setParent(null);
				}
				book.setAttachments(null);
				if (book.getBookState() != null) {
					book.getBookState().setChildren(null);
					book.getBookState().setParent(null);
				}
				if (book.getBookLevel() != null) {
					book.getBookLevel().setChildren(null);
					book.getBookLevel().setParent(null);
				}
				if (book.getBookSecurity() != null) {
					book.getBookSecurity().setChildren(null);
					book.getBookSecurity().setParent(null);
				}
				if (book.getCurrency() != null) {
					book.getCurrency().setChildren(null);
					book.getCurrency().setParent(null);
				}
				if (book.getBookSource() != null) {
					book.getBookSource().setChildren(null);
					book.getBookSource().setParent(null);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return Action.SUCCESS;

	}

	/**
	 * 显示添加或者修改图书
	 */
	public String showSaveBook() {
		if (bookView.getBookId() != null) {
			try {
				book = bookService.getBookById(bookView.getBookId());
				if (book.getFirstCategory() != null) {
					book.getFirstCategory().setChildren(null);
					book.getFirstCategory().setParent(null);
				}
				if (book.getSecondCategory() != null) {
					book.getSecondCategory().setChildren(null);
					book.getSecondCategory().setParent(null);
				}
				book.setAttachments(null);
				if (book.getBookState() != null) {
					book.getBookState().setChildren(null);
					book.getBookState().setParent(null);
				}
				if (book.getBookLevel() != null) {
					book.getBookLevel().setChildren(null);
					book.getBookLevel().setParent(null);
				}
				if (book.getBookSecurity() != null) {
					book.getBookSecurity().setChildren(null);
					book.getBookSecurity().setParent(null);
				}
				if (book.getCurrency() != null) {
					book.getCurrency().setChildren(null);
					book.getCurrency().setParent(null);
				}
				if (book.getBookSource() != null) {
					book.getBookSource().setChildren(null);
					book.getBookSource().setParent(null);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return Action.SUCCESS;
	}

	/**
	 * 保存图书或者期刊
	 * 
	 * @return
	 * @throws Exception
	 */
	public String saveBook() {
		try {
			if (book.getStoreDate() == null || "".equals(book.getStoreDate())) {
				book.setStoreDate(new Date());
			}
			this.formatBook(book);
			book = bookService.addOrModifyBook(book);
			extJsonForm.setSuccess(true);
			extJsonForm.setMsg("保存成功！");
			extJsonForm.setData(book);
		} catch (Exception e) {
			e.printStackTrace();
			extJsonForm.setSuccess(false);
			extJsonForm.setMsg("保存失败！");
			return Action.ERROR;
		}
		return Action.SUCCESS;
	}

	/**
	 * 删除图书或者期刊
	 * 
	 * @return
	 * @throws Exception
	 */
	public String remove() {
		try {
			Book book = new Book();
			book.setBookId(bookView.getBookId());
			// 这里可以取到值
			bookService.removeBook(book);
			extJsonForm.setSuccess(true);
			extJsonForm.setMsg("删除成功！");
			extJsonForm.setData(null);
		} catch (Exception e) {
			e.printStackTrace();
			extJsonForm.setSuccess(false);
			extJsonForm.setMsg("删除失败！");
			extJsonForm.setData(null);
			return Action.ERROR;
		}
		return Action.SUCCESS;
	}

	public List<BookView> convertToView(List<Book> books) {
		List<BookView> views = new ArrayList<BookView>();
		for (Book book : books) {
			BookView view = new BookView();
			view.setBookId(book.getBookId());
			if (book.getBookName() != null) {
				view.setBookName(book.getBookName());
			}
			if (book.getBookDesc() != null) {
				view.setBookDesc(book.getBookDesc());
			}
			if (book.getDonator() != null) {
				view.setDonator(book.getDonator());
			}
			if (book.getAuthor() != null) {
				view.setAuthor(book.getAuthor());
			}
			if (book.getTranslator() != null) {
				view.setTranslator(book.getTranslator());
			}
			if (book.getISBN() != null) {
				view.setISBN(book.getISBN());
			}
			if (book.getPages() != null) {
				view.setPages(book.getPages());
			}
			if (book.getPrice() != null) {
				view.setPrice(book.getPrice());
			}
			if (book.getPublisherDate() != null) {
				view.setPublisherDate(book.getPublisherDate());
			}
			if (book.getQuantity() != null) {
				view.setQuantity(book.getQuantity());
			}
			if (book.getLocation() != null) {
				view.setLocation(book.getLocation());
			}
			if (book.getSearchBookId() != null) {
				view.setSearchBookId(book.getSearchBookId());
			}
			if (book.getSpeciesId() != null) {
				view.setSpeciesId(book.getSpeciesId());
			}
			if (book.getStoreDate() != null) {
				view.setStoreDate(book.getStoreDate());
			}
			if (book.getBookNo() != null) {
				view.setBookNo(book.getBookNo());
			}
			if (book.getAllStage() != null) {
				view.setAllStage(book.getAllStage());
			}
			if (book.getStage() != null) {
				view.setStage(book.getStage());
			}
			if (book.getFirstCategory() != null) {
				view.setFirstCategoryId(book.getFirstCategory().getItemId());
				view
						.setFirstCategoryCode(book.getFirstCategory()
								.getItemCode());
				view
						.setFirstCategoryName(book.getFirstCategory()
								.getItemName());
			}
			if (book.getSecondCategory() != null) {
				view.setSecondCategoryId(book.getSecondCategory().getItemId());
				view.setSecondCategoryCode(book.getSecondCategory()
						.getItemCode());
				view.setSecondCategoryName(book.getSecondCategory()
						.getItemName());
			}
			if (book.getThirdCategory() != null) {
				view.setThirdCategoryId(book.getThirdCategory().getItemId());
				view
						.setThirdCategoryCode(book.getThirdCategory()
								.getItemCode());
				view
						.setThirdCategoryName(book.getThirdCategory()
								.getItemName());
			}
			// 附件
			// if(null != book.getAttachment()){
			// view.setHasAttachment(""); //有
			// }
			// view.setHasAttachment(null); // 无
			if (book.getBookState() != null) {
				view.setBookStateId(book.getBookState().getItemId());
				view.setBookStateName(book.getBookState().getItemName());
			}
			if (book.getBookLevel() != null) {
				view.setBookLevelId(book.getBookLevel().getItemId());
				view.setBookLevelName(book.getBookLevel().getItemName());
			}
			if (book.getBookSecurity() != null) {
				view.setBookSecurityId(book.getBookSecurity().getItemId());
				view.setBookSecurityName(book.getBookSecurity().getItemName());
			}
			if (book.getCurrency() != null) {
				view.setCurrencyId(book.getCurrency().getItemId());
				view.setCurrencyName(book.getCurrency().getItemName());
			}
			if (book.getPress() != null) {
				view.setPressId(book.getPress().getPressId());
				view.setPressName(book.getPress().getPressName());
			}
			if (book.getBookSource() != null) {
				view.setBookSourceId(book.getBookSource().getItemId());
				view.setBookSourceName(book.getBookSource().getItemName());
			}
			views.add(view);
		}
		return views;
	}

	public void formatBook(Book book) {
		book.setAttachments(null);
		book.setBookLevel((book.getBookLevel() != null
				&& book.getBookLevel().getItemId() != null && !"".equals(book
				.getBookLevel())) ? book.getBookLevel() : null);
		System.out.println("......." + book.getBookSecurity().getItemId());
		book.setBookSecurity((book.getBookSecurity() != null
				&& book.getBookSecurity().getItemId() != null && !""
				.equals(book.getBookSecurity().getItemId())) ? book
				.getBookSecurity() : null);
		book.setBookSource((book.getBookSource() != null
				&& book.getBookSource().getItemId() != null && !"".equals(book
				.getBookSource())) ? book.getBookSource() : null);
		book.setBookState((book.getBookState() != null
				&& book.getBookState().getItemId() != null && !"".equals(book
				.getBookState().getItemId())) ? book.getBookState() : null);
		book.setPress((book.getPress() != null
				&& book.getPress().getPressId() != null && 
				book.getPress().getPressId() != 0 && !"".equals(book
				.getPress().getPressId())) ? book.getPress() : null);
		book.setCurrency((book.getCurrency() != null
				&& book.getCurrency().getItemId() != null && !"".equals(book
				.getCurrency().getItemId())) ? book.getCurrency() : null);
		book.setFirstCategory((book.getFirstCategory() != null
				&& book.getFirstCategory().getItemId() != null && !""
				.equals(book.getFirstCategory().getItemId())) ? book
				.getFirstCategory() : null);
		book.setSecondCategory((book.getSecondCategory() != null
				&& book.getSecondCategory().getItemId() != null && !""
				.equals(book.getSecondCategory().getItemId())) ? book
				.getSecondCategory() : null);
		book.setThirdCategory((book.getThirdCategory() != null
				&& book.getThirdCategory().getItemId() != null && !""
				.equals(book.getThirdCategory().getItemId())) ? book
				.getThirdCategory() : null);
	}

	public BookService getBookService() {
		return bookService;
	}

	public void setBookService(BookService bookService) {
		this.bookService = bookService;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public ExtGridLoad getExtGridLoad() {
		return extGridLoad;
	}

	public void setExtGridLoad(ExtGridLoad extGridLoad) {
		this.extGridLoad = extGridLoad;
	}

	public BookView getBookView() {
		return bookView;
	}

	public void setBookView(BookView bookView) {
		this.bookView = bookView;
	}

	public ExtJsonForm getExtJsonForm() {
		return extJsonForm;
	}

	public void setExtJsonForm(ExtJsonForm extJsonForm) {
		this.extJsonForm = extJsonForm;
	}

	public Integer getStart() {
		return start;
	}

	public void setStart(Integer start) {
		this.start = start;
	}

	public Integer getLimit() {
		return limit;
	}

	public void setLimit(Integer limit) {
		this.limit = limit;
	}

}
