package com.huan.library.web.action;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.huan.library.domain.model.book.Attachment;
import com.huan.library.domain.model.book.Book;
import com.huan.library.domain.model.book.BookLevel;
import com.huan.library.domain.model.book.BookState;
import com.huan.library.domain.model.book.Category;
import com.huan.library.domain.model.book.Currency;
import com.huan.library.domain.model.book.Press;
import com.huan.library.domain.model.book.BookSecurity;
import com.huan.library.domain.model.book.BookSource;
import com.huan.library.domain.service.BookService;
import com.huan.library.domain.service.CategoryService;
import com.huan.library.domain.service.DictItemService;
import com.huan.library.domain.service.PressService;
import com.huan.library.util.PageModel;
import com.huan.library.web.view.BookView;
import com.huan.library.web.view.DictItemView;
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
	@Autowired
	private PressService pressService; // 出版社service
	@Autowired
	private CategoryService categoryService; // 图书分类service
	@Autowired
	private DictItemService dictItemService; // 字典service
	/**
	 * 获取参数和返回数据对象
	 */
	private Book book = new Book(); // 图书信息--增加删除加载一个对象的时候用book,查询时用bookView对象
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
	
	private Integer start;
	private Integer limit;
	
	/**
	 * 图书基本信息管理主页
	 * @return
	 * @throws Exception
	 */
	public String bookMain() {
		return Action.SUCCESS;
	}
	
	/**
	 * 期刊基本信息管理主页
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
	/**
	 * 显示添加或者修改期刊
	 */
	public String showSaveMagazine() {
		if(book.getBookId()!=0){
			try {
				book= bookService.findBookById(book.getBookId());
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
		if(bookView.getBookId()!=null && bookView.getBookId()!=0){
			try {
				book = bookService.getBookById(bookView.getBookId());
				if(book.getFirstCategory()!=null){
					book.getFirstCategory().setChildren(null);
					book.getFirstCategory().setParent(null);
				}
				if(book.getSecondCategory()!=null){
					book.getSecondCategory().setChildren(null);
					book.getSecondCategory().setParent(null);
				}
				book.setAttachments(null);
				if(book.getBookState()!=null){
					book.getBookState().setChildren(null);
					book.getBookState().setParent(null);
				}
				if(book.getBookLevel()!=null){
					book.getBookLevel().setChildren(null);
					book.getBookLevel().setParent(null);
				}
				if(book.getBookSecurity()!=null){
					book.getBookSecurity().setChildren(null);
					book.getBookSecurity().setParent(null);
				}
				if(book.getCurrency()!=null){
					book.getCurrency().setChildren(null);
					book.getCurrency().setParent(null);
				}
				if(book.getBookSource()!=null){
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
	 * @return
	 * @throws Exception
	 */
	public String saveBook() {
		try {
			book = bookService.addOrModifyBook(book);
			extJsonForm.setSuccess(true);
			extJsonForm.setMsg("新增成功！");
			extJsonForm.setData(book);
		} catch (Exception e) {
			e.printStackTrace();
			extJsonForm.setSuccess(false);
			extJsonForm.setMsg("新增失败！");
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
	public String deleteBook() {
		try {
			Book book = new Book();
			book.setBookId(bookView.getBookId());
			//这里可以取到值
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
			securityViews = dictItemService.getDictItemByItemClass(BookSecurity.class.getName());
			currencyViews = dictItemService.getDictItemByItemClass(Currency.class.getName());
	        resourceViews = dictItemService.getDictItemByItemClass(BookSource.class.getName());
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public List<BookView> convertToView(List<Book> books){
		List<BookView> views = new ArrayList<BookView>();
		for(Book book : books){
			BookView view = new BookView();
			view.setBookId(book.getBookId());
			if(book.getBookName()!=null){
				view.setBookName(book.getBookName());
			}
			if(book.getBookDesc()!=null){
				view.setBookDesc(book.getBookDesc());
			}
			if(book.getDonator()!=null){
				view.setDonator(book.getDonator());
			}
			if(book.getAuthor()!=null){
				view.setAllStage(book.getAuthor());
			}
			if(book.getTranslator()!=null){
				view.setTranslator(book.getTranslator());
			}
			if(book.getISBN()!=null){
				view.setISBN(book.getISBN());
			}
			if(book.getPages()!=null){
				view.setPages(book.getPages());
			}
			if(book.getPrice()!=null){
				view.setPrice(book.getPrice());
			}
			if(book.getPublisherDate()!=null){
				view.setPublisherDate(book.getPublisherDate());
			}
			if(book.getQuantity()!=null){
				view.setQuantity(book.getQuantity());
			}
			if(book.getLocation()!=null){
				view.setLocation(book.getLocation());
			}
			if(book.getSearchBookId()!=null){
				view.setSearchBookId(book.getSearchBookId());
			}
			if(book.getSpeciesId()!=null){
				view.setSpeciesId(book.getSpeciesId());
			}
			if(book.getStoreDate()!=null){
				view.setStoreDate(book.getStoreDate());
			}
			if(book.getBookNo()!=null){
				view.setBookNo(book.getBookNo());
			}
			if(book.getFirstCategory()!=null){
				view.setFirstCategoryId(book.getFirstCategory().getCategoryId());
				view.setFirstCategoryCode(book.getFirstCategory().getCategoryCode());
				view.setFirstCategoryName(book.getFirstCategory().getCategoryName());
			}
			if(book.getSecondCategory()!=null){
				view.setSecondCategoryId(book.getSecondCategory().getCategoryId());
				view.setSecondCategoryCode(book.getSecondCategory().getCategoryCode());
				view.setSecondCategoryName(book.getSecondCategory().getCategoryName());
			}
			if(book.getThirdCategory()!=null){
				view.setThirdCategoryId(book.getThirdCategory().getCategoryId());
				view.setThirdCategoryCode(book.getThirdCategory().getCategoryCode());
				view.setThirdCategoryName(book.getThirdCategory().getCategoryName());
			}
			//附件
//			if(null != book.getAttachment()){
//				view.setHasAttachment("");  //有
//			}
//			view.setHasAttachment(null);  // 无
			if(book.getBookState()!=null){
				view.setBookStateId(book.getBookState().getItemId());  
				view.setBookStateName(book.getBookState().getItemName());
			}
			if(book.getBookLevel()!=null){
				view.setBookLevelId(book.getBookLevel().getItemId());
				view.setBookLevelName(book.getBookLevel().getItemName());
			}
			if(book.getBookSecurity()!=null){
				view.setBookSecurityId(book.getBookSecurity().getItemId());
				view.setBookSecurityName(book.getBookSecurity().getItemName());	
			}
			if(book.getCurrency()!=null){
				view.setCurrencyId(book.getCurrency().getItemId());
				view.setCurrencyName(book.getCurrency().getItemName());
			}
			if(book.getPress()!=null){
				view.setPressId(book.getPress().getPressId());
				view.setPressName(book.getPress().getPressName());
			}
			if(book.getBookSource()!=null){
				view.setBookSourceId(book.getBookSource().getItemId());
				view.setBookSourceName(book.getBookSource().getItemName());
			}
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
