package com.huan.library.web.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.huan.library.domain.model.LibInfo;
import com.huan.library.domain.model.book.Book;
import com.huan.library.domain.model.book.BookState;
import com.huan.library.domain.model.borrowReturn.BorrowReturn;
import com.huan.library.domain.model.reader.Reader;
import com.huan.library.domain.service.BookService;
import com.huan.library.domain.service.BorrowReturnService;
import com.huan.library.domain.service.ReaderService;
import com.huan.library.web.view.BorrowReturnView;
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
	private BorrowReturnService borrowReturnService;
	@Autowired
	private ReaderService readerService;
	@Autowired
	private BookService bookService;
	
	private ExtJsonForm extJsonForm = new ExtJsonForm(); // 返回给客户端的信息
	
	private BorrowReturnView borrowReturnView = new BorrowReturnView();
	
	private BorrowReturn borrowReturn = new BorrowReturn();
    
	private LibInfo libInfo = new LibInfo();
    
	
	public String findBRByBarcode() {
		try {
			
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
           	Reader reader = new Reader();
           	reader.setId(borrowReturnView.getReaderId());
           	Book book = new Book();
           	book.setBookId(borrowReturnView.getBookId());
           	
           	if(borrowReturn.getBook()!=null && borrowReturn.getId()!=null &&!"".equals(borrowReturn.getBook().getBookId())){
           		borrowReturn.setBook(book);	
           	}
           	if(borrowReturn.getReader()!=null && borrowReturn.getReader()!=null &&!"".equals(borrowReturn.getReader().getId())){
           		borrowReturn.setReader(reader);	
           	}
           	
           	reader = readerService.findReaderById(borrowReturnView.getReaderId());
           	book = bookService.getBookById(borrowReturnView.getBookId());
           	Date borrowedDate = new Date();  //借阅日期
           	borrowReturn.setBorrowedDate(borrowedDate);
           	long maxBorrowedTime=(borrowedDate.getTime()/1000)+60*60*24*(reader.getReaderType().getMaxBorrowDays());    
           	Date duetoReturnDate = new Date();
           	duetoReturnDate.setTime(maxBorrowedTime*1000);
            borrowReturn.setDuetoReturnDate(duetoReturnDate);  //归还日期
            
            borrowReturn.setRenewTimes(0);
            borrowReturn.setBorrowOperator("huan");
            
           	borrowReturnService.addOrModifyBorrow(borrowReturn); 
           	
           	reader.setBorrowedQuantiy(reader.getBorrowedQuantiy()+1);
           	reader.setTotalBQuantity(reader.getTotalBQuantity()+1);
//           	reader.set
           	readerService.addOrModifyReader(reader);
           	
           	book.setQuantity(book.getQuantity()-1);
//           	BookState bookState = new BookState();
//           	bookState.setItemName("借阅中");
//           	book.setBookState(bookState);
           	bookService.addOrModifyBook(book);

           	extJsonForm.setSuccess(true);
            extJsonForm.setMsg("借出成功");
            extJsonForm.setData(null);
		} catch (Exception e) {
			e.printStackTrace();
			extJsonForm.setSuccess(false);
            extJsonForm.setMsg("借出失败");
            extJsonForm.setData(null);
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
	public String findByByBarCodeOrReaderCode(){
		List<BorrowReturn> borrowReturns = new ArrayList<BorrowReturn>();
		try {
		  borrowReturns = borrowReturnService.getByBarCodeOrReaderCode(borrowReturnView);
		} catch (Exception e) {
			e.printStackTrace();
			return Action.ERROR;
		}
		return Action.SUCCESS;
	}
	
	
	public String bookReturn(){
		try {
			int overdueDays = borrowReturnView.getOverdueDays();  //超期天数
			if(overdueDays >= 0){  //图书过期
				
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return Action.SUCCESS;
	}
	
	
	/**
	 * 显示书刊续借界面
	 * @return
	 */
	public String showBookRenew() {
		return "showBookRenew";
	}

	public ExtJsonForm getExtJsonForm() {
		return extJsonForm;
	}

	public void setExtJsonForm(ExtJsonForm extJsonForm) {
		this.extJsonForm = extJsonForm;
	}

	public LibInfo getLibInfo() {
		return libInfo;
	}

	public void setLibInfo(LibInfo libInfo) {
		this.libInfo = libInfo;
	}

	public BorrowReturnView getBorrowReturnView() {
		return borrowReturnView;
	}

	public void setBorrowReturnView(BorrowReturnView borrowReturnView) {
		this.borrowReturnView = borrowReturnView;
	}

	public void setBorrowReturnService(BorrowReturnService borrowReturnService) {
		this.borrowReturnService = borrowReturnService;
	}

	public void setBookService(BookService bookService) {
		this.bookService = bookService;
	}

	public BorrowReturn getBorrowReturn() {
		return borrowReturn;
	}

	public void setBorrowReturn(BorrowReturn borrowReturn) {
		this.borrowReturn = borrowReturn;
	}
	
	public void setReaderService(ReaderService readerService) {
		this.readerService = readerService;
	}

}
