package com.huan.library.web.action;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.huan.library.domain.model.book.Book;
import com.huan.library.domain.model.book.Category;
import com.huan.library.domain.model.book.Press;
import com.huan.library.domain.model.dict.Attachment;
import com.huan.library.domain.model.dict.BookLevel;
import com.huan.library.domain.model.dict.BookState;
import com.huan.library.domain.model.dict.Currency;
import com.huan.library.domain.model.dict.Resource;
import com.huan.library.domain.model.dict.Security;
import com.huan.library.domain.service.BookService;
import com.huan.library.domain.service.CategoryService;
import com.huan.library.domain.service.DictItemService;
import com.huan.library.domain.service.PressService;
import com.huan.library.util.Constants;
import com.huan.library.util.PageModel;
import com.huan.library.web.view.BookView;
import com.huan.library.web.view.DictItemView;
import com.huan.library.web.view.ExtGridLoad;
import com.huan.library.web.view.ExtJsonForm;
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
	@Autowired
	private PressService pressService; // 出版社service
	@Autowired
	private CategoryService categoryService; // 图书分类service
	@Autowired
	private DictItemService dictItemService; // 字典service
	/**
	 * 获取参数和返回数据对象
	 */
	private Book book; // 图书信息--增加删除加载一个对象的时候用book,查询时用bookView对象
	private ExtGridLoad extGridLoad = new ExtGridLoad();  //对应result的extGridLoad 
	//应用struts2的属性驱动模式,自动填充页面的属性
	private BookView bookView = new BookView();//接收客户端提交的参数
	private ExtJsonForm extJsonForm = new ExtJsonForm();//回应给客户端的表单数据
	
	
	private PageModel<Book> pageModel = new PageModel<Book>(); // 图书集合
	private Press press = new Press(); // 出版社
	private List<Press> presses = new ArrayList<Press>(); // 出版社集合
	Category category = new Category(); // 图书分类
	private List<Category> categorys = new ArrayList<Category>(); // 图书分类集合
	private List<DictItemView> attachmentViews; //附件试图
	private List<DictItemView> bookStateViews; //图书状态试图
	private List<DictItemView> bookLevelViews; //图书级别试图
	private List<DictItemView> securityViews; //图书密级试图
	private List<DictItemView> currencyViews; //币种试图
	private List<DictItemView> resourceViews; //来源试图
	
	private int bookId;
	
	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	/**
	 * 分页查找图书
	 * @return
	 * @throws Exception
	 */
	public String findBooksByPages() {
		try {
			bookStateViews = dictItemService.getDictItemByItemClass(BookState.class.getName());
			pageModel = bookService.findBooksByPage(Constants.PAGENO,Constants.PAGESIZE);
		} catch (Exception e) {
			e.printStackTrace();
			return Action.ERROR;
		}
		return Action.SUCCESS;
	}
	
	/**
	 * 分页查找图书
	 * @return
	 * @throws Exception
	 */
	public String findBooks() {
		try {
			List<Book> books = bookService.findBooks(bookView);
			extGridLoad.setRoot(this.convertToView(books));
			extGridLoad.setTotalProperty((bookView.getTotalCount()));
		} catch (Exception e) {
			e.printStackTrace();
			return Action.ERROR;
		}
		return Action.SUCCESS;
	}
	/**
	 * 显示添加图书
	 */
	public String showSaveBook() {
		try {
			init();
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
			book = bookService.addOrModifyBook(book);
			extJsonForm.setSuccess(true);
			extJsonForm.setMsg("新增用户成功！");
			extJsonForm.setData(book);
		} catch (Exception e) {
			e.printStackTrace();
			extJsonForm.setSuccess(false);
			extJsonForm.setMsg("新增用户失败！");
			return Action.ERROR;
		}
		return Action.SUCCESS;
	}
	/**
	 * 显示修改图书
	 */
	public String showModifyBook() {
		try {
//			System.out.println(book.getBookId());
			book= bookService.findBookById(book.getBookId());
//			init();
			/**
			 * 不是在显示修改页面的时候去加载这些数据，这会严重影响效率，
			 * 应该在下拉某个下拉框的时候去加载这个字典的数据，或者显示一个字典选择树的时候加载字典数据
			 */
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "showModifyBook";
	}

	/**
	 * 显示修改图书
	 */
	public String loadBook() {
		try {
			book= bookService.loadBook(bookView);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Action.SUCCESS;
	}
	
	/**
	 * 注销图书
	 * 
	 * @return
	 * @throws Exception
	 */
	public String deleteBook() {
		try {
			System.out.println("bookId:" + book.getBookId());
			//这里可以取到值
			bookService.removeBook(book);
			extJsonForm.setSuccess(true);
			extJsonForm.setMsg("删除用户成功！");
			extJsonForm.setData(null);
		} catch (Exception e) {
			e.printStackTrace();
			extJsonForm.setSuccess(false);
			extJsonForm.setMsg("删除用户失败！");
			extJsonForm.setData(null);
			return Action.ERROR;
		}
		return Action.SUCCESS;
	}
    /**
     * 初始化一些基本信息
     */
	private void init(){
		try{
			presses = pressService.findAllPresses();
			categorys = categoryService.findAllCategorys();
			attachmentViews= dictItemService.getDictItemByItemClass(Attachment.class.getName());
			bookStateViews = dictItemService.getDictItemByItemClass(BookState.class.getName());
			bookLevelViews = dictItemService.getDictItemByItemClass(BookLevel.class.getName());
			securityViews = dictItemService.getDictItemByItemClass(Security.class.getName());
			currencyViews = dictItemService.getDictItemByItemClass(Currency.class.getName());
	        resourceViews = dictItemService.getDictItemByItemClass(Resource.class.getName());
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public List<BookView> convertToView(List<Book> books){
		List<BookView> views = new ArrayList<BookView>();
		for(Book book : books){
			BookView view = new BookView();
			view.setBookId(book.getBookId());
			view.setBookName(book.getBookName());
			
			
			//...............
			
			view.setFirstCategoryId(book.getFirstCategory().getCategoryId());
			view.setFirstCategoryCode(book.getFirstCategory().getCategoryCode());
			view.setFirstCategoryName(book.getFirstCategory().getCategoryName());
			
			//................
			
			views.add(view);
		}
		return views;
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
	public PressService getPressService() {
		return pressService;
	}
	public void setDictItemService(DictItemService dictItemService) {
		this.dictItemService = dictItemService;
	}

	public List<DictItemView> getAttachmentViews() {
		return attachmentViews;
	}

	public void setAttachmentViews(List<DictItemView> attachmentViews) {
		this.attachmentViews = attachmentViews;
	}

	public List<DictItemView> getBookStateViews() {
		return bookStateViews;
	}

	public void setBookStateViews(List<DictItemView> bookStateViews) {
		this.bookStateViews = bookStateViews;
	}

	public List<DictItemView> getBookLevelViews() {
		return bookLevelViews;
	}

	public void setBookLevelViews(List<DictItemView> bookLevelViews) {
		this.bookLevelViews = bookLevelViews;
	}

	public List<DictItemView> getSecurityViews() {
		return securityViews;
	}

	public void setSecurityViews(List<DictItemView> securityViews) {
		this.securityViews = securityViews;
	}

	public List<DictItemView> getCurrencyViews() {
		return currencyViews;
	}

	public void setCurrencyViews(List<DictItemView> currencyViews) {
		this.currencyViews = currencyViews;
	}

	public List<DictItemView> getResourceViews() {
		return resourceViews;
	}

	public void setResourceViews(List<DictItemView> resourceViews) {
		this.resourceViews = resourceViews;
	}

	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}

	public BookView getBookView() {
		return bookView;
	}

	public void setBookView(BookView bookView) {
		this.bookView = bookView;
	}

	public ExtGridLoad getExtGridLoad() {
		return extGridLoad;
	}

	public void setExtGridLoad(ExtGridLoad extGridLoad) {
		this.extGridLoad = extGridLoad;
	}

	public ExtJsonForm getExtJsonForm() {
		return extJsonForm;
	}

	public void setExtJsonForm(ExtJsonForm extJsonForm) {
		this.extJsonForm = extJsonForm;
	}

	
}
