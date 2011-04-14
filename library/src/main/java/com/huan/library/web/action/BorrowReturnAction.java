package com.huan.library.web.action;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.huan.library.domain.model.LibInfo;
import com.huan.library.domain.model.book.Book;
import com.huan.library.domain.model.borrowReturn.BorrowReturn;
import com.huan.library.domain.model.reader.Reader;
import com.huan.library.domain.service.BookService;
import com.huan.library.domain.service.BorrowReturnService;
import com.huan.library.domain.service.LibInfoService;
import com.huan.library.domain.service.ReaderService;
import com.huan.library.util.DateFormatUtil;
import com.huan.library.web.view.form.ExtJsonForm;
import com.opensymphony.xwork2.Action;

/**
 * 图书借阅归还action
 * 
 * @author huan
 * @time 2011-3-17 下午06:41:54
 */
@Controller("borrowReturnAction")
public class BorrowReturnAction extends BaseActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Autowired
	private BorrowReturnService borrowReturnService; // 借还service
	@Autowired
	private BookService bookService ;   //图书service
	@Autowired
	private ReaderService readerService; //读者service
	@Autowired
	private LibInfoService libInfoService ; //图书馆service
	private BorrowReturn borrowReturn = new BorrowReturn();

	private ExtJsonForm extJsonForm = new ExtJsonForm(); // 返回给客户端的信息
	private Book book = new Book();
	private Reader reader = new Reader();
    private LibInfo libInfo = new LibInfo();
    
	
	public String findBRByBarcode() {
		try {
			if(book.getBarCode()!=null && !"".equals(book.getBarCode())){
				borrowReturn = borrowReturnService.getBRByBarCode(book.getBarCode());
			}
			if(reader.getBarCode()!=null && !"".equals(reader.getBarCode())){
//				borrowReturn = borrowReturnService.get
			}
			
		} catch (Exception e) {
		    e.printStackTrace();
		}
		return Action.SUCCESS;
	}
	
	/**
	 * 图书借阅界面
	 * @return
	 */
	public String bookBorrowMain() {
		return Action.SUCCESS;
	}

	/**
	 * 图书借阅
	 * @return
	 */
	public String bookBorrow() {
		try {
            reader = readerService.findReaderById(reader.getCardNo());
			book = bookService.getBookById(book.getBookId());
			if(book.getQuantity()==null||book.getQuantity()<=0){
				extJsonForm.setData(null);
				extJsonForm.setMsg("图书数量不足！");
				extJsonForm.setSuccess(false);
			}
			if(book.getBookState()!=null&&!"在馆".equals(book.getBookState().getItemName())){
				extJsonForm.setData(null);
				extJsonForm.setMsg("图书不在馆或是待核审！");
				extJsonForm.setSuccess(false);
			}
			if(reader.getLeftMoney()==null&&reader.getLeftMoney()<=0){
				extJsonForm.setData(null);
				extJsonForm.setMsg("读者余额不足,请充值！");
				extJsonForm.setSuccess(false);
			}
			if(reader.getCardState()!=null && !"可用".equals(reader.getCardState().getItemName())){
				extJsonForm.setData(null);
				extJsonForm.setMsg("借阅证已经挂失,请询问管理员！");
				extJsonForm.setSuccess(false);
			}
			if(reader.getBorrowedQuantiy()>=reader.getReaderType().getBorrowedQuantity()){
				extJsonForm.setData(null);
				extJsonForm.setMsg("已经达到最大借阅量,不能再借！");
				extJsonForm.setSuccess(false);
			}
			borrowReturn.setBorrowedDate(new Date());
			borrowReturn.setDuetoReturnDate(DateFormatUtil.convertToDate(String.valueOf(((new Date().getTime()/1000)+60*60*24*30)*1000)));
			borrowReturn.setRealityReturndate(null);
			borrowReturn.setPuniMoney(0f);
			borrowReturn.setIsPay(1);
			borrowReturn.setRenewTimes(0);

		
			borrowReturn.setBook(book);
			borrowReturn.setReader(reader);
			book.getBookState().setItemName("借阅中");
			book.setQuantity(book.getQuantity()-1);
			bookService.addOrModifyBook(book);
			reader.setBorrowedQuantiy(reader.getBorrowedQuantiy()+1);
		    readerService.addOrModifyReader(reader);
			
			borrowReturn = borrowReturnService.addOrModifyBorrow(borrowReturn);
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
			return Action.ERROR;
		}
		return Action.SUCCESS;
	}

	/**
	 * 显示归还页面
	 * @return
	 */
	public String bookReturnMain() {
		return Action.SUCCESS;
	}

	/**
	 * 书刊归还
	 * @return
	 */
	public String bookReturn() {
		try {
			//实际借阅天数
			int reallyBorrowedDays = (int)(borrowReturn.getBorrowedDate().getTime() - new Date().getTime()); 
		    int overdueDays = 0;
			if((overdueDays = (reallyBorrowedDays - reader.getReaderType().getBorrowDays())) > 0){
                  Float fineMoney = overdueDays * libInfo.getPayADay();
                  
                  reader.setLeftMoney(reader.getLeftMoney() - fineMoney);
		          readerService.addOrModifyReader(reader);
                  libInfo.setLibFunds(libInfo.getLibFunds() + fineMoney);
		          libInfoService.save(libInfo);
		          borrowReturn.setIsPay(1);
			}
			borrowReturn.setOverdueDays(overdueDays);
			borrowReturn.setRealityReturndate(new Date());
	    	borrowReturnService.addOrModifyBorrow(borrowReturn);
	    	extJsonForm.setSuccess(true);
	    	extJsonForm.setMsg("归还成功！");
	    	extJsonForm.setData(borrowReturn);
		} catch (Exception e) {
			e.printStackTrace();
			extJsonForm.setSuccess(false);
	    	extJsonForm.setMsg("归还失败！");
	    	extJsonForm.setData(null);
			return Action.ERROR;
		}
		return Action.SUCCESS;
	}

	/**
	 * 显示书刊续借界面
	 * 
	 * @return
	 */
	public String showBookRenew() {
		return "showBookRenew";
	}

	public BorrowReturn getBorrowReturn() {
		return borrowReturn;
	}

	public void setBorrowReturn(BorrowReturn borrowReturn) {
		this.borrowReturn = borrowReturn;
	}

	public void setBorrowReturnService(BorrowReturnService borrowReturnService) {
		this.borrowReturnService = borrowReturnService;
	}

	public ExtJsonForm getExtJsonForm() {
		return extJsonForm;
	}

	public void setExtJsonForm(ExtJsonForm extJsonForm) {
		this.extJsonForm = extJsonForm;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public Reader getReader() {
		return reader;
	}

	public void setReader(Reader reader) {
		this.reader = reader;
	}

	public void setBookService(BookService bookService) {
		this.bookService = bookService;
	}

	public void setReaderService(ReaderService readerService) {
		this.readerService = readerService;
	}

	public LibInfo getLibInfo() {
		return libInfo;
	}

	public void setLibInfo(LibInfo libInfo) {
		this.libInfo = libInfo;
	}

	public void setLibInfoService(LibInfoService libInfoService) {
		this.libInfoService = libInfoService;
	}
    
	
	
}
