package com.huan.library.web.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.huan.library.domain.model.book.Book;
import com.huan.library.domain.model.book.BookState;
import com.huan.library.domain.model.borrowReturn.BorrowReturn;
import com.huan.library.domain.model.reader.Reader;
import com.huan.library.domain.service.BookService;
import com.huan.library.domain.service.BorrowReturnService;
import com.huan.library.domain.service.ReaderService;
import com.huan.library.util.DateFormatUtil;
import com.huan.library.web.view.BorrowReturnView;
import com.huan.library.web.view.form.ExtJsonForm;
import com.huan.library.web.view.grid.ExtGridLoad;
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
	private ExtGridLoad extGridLoad = new ExtGridLoad();

	private BorrowReturnView borrowReturnView = new BorrowReturnView();

	private BorrowReturn borrowReturn = new BorrowReturn();

	private List<BorrowReturnView> borrowReturnViews = new ArrayList<BorrowReturnView>();
    
	private Integer start;
	private Integer limit;

	/**
	 * 图书借阅界面
	 * @return
	 */
	public String bookBorrowMain() {
		return Action.SUCCESS;
	}
	/**
	 * 期刊借阅界面
	 * @return
	 */
	public String magazineBorrowMain() {
		return Action.SUCCESS;
	}
	/**
	 * 图书归还界面
	 * @return
	 */
	public String bookReturnMain() {
		return Action.SUCCESS;
	}
    /**
     * 期刊归还界面
     * @return
     */
	public String magazineReturnMain() {
		return Action.SUCCESS;
	}
    
	public String findBorrowReturns(){
		try {
		  borrowReturnView.setStart(start);
		  borrowReturnView.setLimit(limit);
		  List<BorrowReturn> borrowReturns = borrowReturnService.findBorrowReturns(borrowReturnView);
		  this.convertToViews(borrowReturns, borrowReturnViews);
		  extGridLoad.setRoot(borrowReturnViews);
		  extGridLoad.setTotalProperty(borrowReturnView.getTotalCount());
		} catch (Exception e) {
		  e.printStackTrace();
		  return Action.ERROR; 
		}
		return Action.SUCCESS;
	}
	
	/**
	 * 图书借阅
	 * @return
	 */
	public String bookBorrow() {
		try {
			Reader reader = readerService.findReaderById(borrowReturnView
					.getReaderId());
			Book book = bookService.getBookById(borrowReturnView.getBookId());
			Date borrowedDate = new Date(); // 借阅日期
			borrowReturn.setBorrowedDate(borrowedDate);
			long maxBorrowedTime = (borrowedDate.getTime() / 1000) + 60 * 60
					* 24 * (reader.getReaderType().getMaxBorrowDays());
			Date duetoReturnDate = new Date();
			duetoReturnDate.setTime(maxBorrowedTime * 1000);
			borrowReturn.setDuetoReturnDate(duetoReturnDate); // 归还日期

			borrowReturn.setRenewTimes(0);
			// User currUser = (User)this.session.get("currUser");
			// borrowReturn.setBorrowOperator(currUser.getUserName());

			reader.setBorrowedQuantiy(reader.getBorrowedQuantiy() + 1);
			reader.setTotalBQuantity(reader.getTotalBQuantity() + 1);
			readerService.addOrModifyReader(reader);

			book.setQuantity(book.getQuantity() - 1);
			BookState bookState = new BookState();
			bookState.setItemId("BookState_JY");
			book.setBookState(bookState);
			bookService.addOrModifyBook(book);

			 borrowReturn.setBook(book);
			 borrowReturn.setReader(reader);
			borrowReturnService.addOrModifyBorrow(borrowReturn);

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
	 * 书刊归还
	 * 
	 * @return
	 */
	public String bookReturn() {
		try {

			borrowReturn = borrowReturnService.getBRById(borrowReturnView
					.getId());
			borrowReturn.setRealityReturndate(new Date());
			// User currUser = (User)this.session.get("currUser");
			// borrowReturn.setBorrowOperator(currUser.getUserName());

			Book book = bookService.getBookById(borrowReturn.getBook()
					.getBookId());
			book.setQuantity(borrowReturn.getBook().getQuantity() + 1);
			BookState bookState = new BookState();
			bookState.setItemId("BookState_ZG");
			book.setBookState(bookState);
			this.bookService.addOrModifyBook(book);

			Reader reader = readerService.findReaderById(borrowReturn
					.getReader().getId());
            if(reader.getBorrowedQuantiy()<=0){
            	reader.setBorrowedQuantiy(0);
            }else{
            	reader.setBorrowedQuantiy(reader.getBorrowedQuantiy() - 1);
            }
            
//			reader.setBorrowedQuantiy();
			this.readerService.addOrModifyReader(reader);
			// borrowReturn.setReader(reader);
			// borrowReturn.setBook(book);
			borrowReturnService.addOrModifyBorrow(borrowReturn);
			extJsonForm.setSuccess(true);
			extJsonForm.setMsg("归还成功");
			extJsonForm.setData(null);
		} catch (Exception e) {
			e.printStackTrace();
			extJsonForm.setSuccess(false);
			extJsonForm.setMsg("归还失败");
			extJsonForm.setData(null);
			return Action.ERROR;
		}
		return Action.SUCCESS;
	}

	public String findByBarCodeOrReaderCode() {
		try {
			List<BorrowReturn> borrowReturns = borrowReturnService
					.getByBarCodeOrReaderCode(borrowReturnView);
			this.convertToViews(borrowReturns, borrowReturnViews);
			extJsonForm.setSuccess(true);
			extJsonForm.setData(borrowReturnViews);
		} catch (Exception e) {
			e.printStackTrace();
			return Action.ERROR;
		}
		return Action.SUCCESS;
	}

	public String bookRenew() {
		try {
			borrowReturn = borrowReturnService.getBRById(borrowReturnView
					.getId());
			// borrowReturn.setRealityReturndate(new Date());
			// User currUser = (User)this.session.get("currUser");
			// borrowReturn.setBorrowOperator(currUser.getUserName());

			Reader reader = readerService.findReaderById(borrowReturn
					.getReader().getId());

			Date borrowedDate = borrowReturn.getBorrowedDate();
			long maxBorrowedTime = (borrowedDate.getTime() / 1000) + 60 * 60
					* 24 * (reader.getReaderType().getMaxBorrowDays());
			Date reNewReturnDate = new Date();
			reNewReturnDate.setTime(maxBorrowedTime * 1000 * 2);
			borrowReturn.setDuetoReturnDate(reNewReturnDate);

			borrowReturn.setRenewTimes(borrowReturn.getRenewTimes() + 1);
			borrowReturnService.addOrModifyBorrow(borrowReturn);
			
			extJsonForm.setSuccess(true);
			extJsonForm.setMsg("续借成功");
			extJsonForm.setData(null);
		} catch (Exception e) {
			e.printStackTrace();
			extJsonForm.setSuccess(false);
			extJsonForm.setMsg("续借失败");
			extJsonForm.setData(null);
		}
		return Action.SUCCESS;
	}
	
	/**
	 * 导出Excel
	 * @return
	 */
	public String exportExcel(){
   	    try {
   	    	String rootDir = this.getWebRoot();
   	    	String fileName =  borrowReturnService.exportExcel(rootDir,borrowReturnView);
   	    	extJsonForm.setData(fileName);
   	    	extJsonForm.setSuccess(true);
   	    	extJsonForm.setMsg("导出成功");
		} catch (Exception e) {
			extJsonForm.setData("");
   	    	extJsonForm.setSuccess(false);
   	    	extJsonForm.setMsg("导出失败");
			return Action.ERROR;
		}
		return Action.SUCCESS;
	}

	private void convertToViews(List<BorrowReturn> borrowReturns,
			List<BorrowReturnView> views) {
		for (BorrowReturn borrowReturn : borrowReturns) {
			BorrowReturnView view = new BorrowReturnView();
			view.setId(borrowReturn.getId());
			if (borrowReturn.getBorrowedDate() != null) {
				view.setBorrowedDate(DateFormatUtil.format(borrowReturn
						.getBorrowedDate(), "MM/dd/yyyy"));
			}
			if (borrowReturn.getDuetoReturnDate() != null) {
				view.setDuetoReturnDate(DateFormatUtil.format(borrowReturn
						.getDuetoReturnDate(), "MM/dd/yyyy"));
			}
			if (borrowReturn.getRealityReturndate() != null) {
				view.setRealityReturndate(DateFormatUtil.format(borrowReturn
						.getRealityReturndate(), "MM/dd/yyyy"));
			}
			if (borrowReturn.getOverdueDays() != null) {
				view.setOverdueDays(borrowReturn.getOverdueDays());
			}
			if (borrowReturn.getPuniMoney() != null) {
				view.setPuniMoney(borrowReturn.getPuniMoney());
			}
			if (borrowReturn.getIsPay() != null) {
				view.setIsPay(borrowReturn.getIsPay());
			}
			if (borrowReturn.getRenewTimes() != null) {
				view.setRenewTimes(borrowReturn.getRenewTimes());
			}
			if (borrowReturn.getBook() != null
					&& borrowReturn.getBook().getBookId() != null) {
				view.setBookId(borrowReturn.getBook().getBookId());
			}
			if (borrowReturn.getBook() != null
					&& borrowReturn.getBook().getBookNo() != null) {
				view.setBookNo(borrowReturn.getBook().getBookNo());
			}
			if (borrowReturn.getBook() != null
					&& borrowReturn.getBook().getBarCode() != null) {
				view.setBookBarCode(borrowReturn.getBook().getBarCode());
			}
			if (borrowReturn.getBook() != null
					&& borrowReturn.getBook().getBookName() != null) {
				view.setBookName(borrowReturn.getBook().getBookName());
			}
			if (borrowReturn.getBook() != null
					&& borrowReturn.getBook().getLocation() != null) {
				view.setLocation(borrowReturn.getBook().getLocation());
			}
			if (borrowReturn.getBook() != null
					&& borrowReturn.getBook().getFirstCategory() != null
					&& borrowReturn.getBook().getFirstCategory().getItemId() != null) {
				view.setFirstCategoryId(borrowReturn.getBook()
						.getFirstCategory().getItemId());
			}
			if (borrowReturn.getBook() != null
					&& borrowReturn.getBook().getFirstCategory() != null
					&& borrowReturn.getBook().getFirstCategory().getItemName() != null) {
				view.setFirstCategoryName(borrowReturn.getBook()
						.getFirstCategory().getItemName());
			}
			if (borrowReturn.getBook() != null
					&& borrowReturn.getBook().getFirstCategory() != null
					&& borrowReturn.getBook().getFirstCategory().getItemCode() != null) {
				view.setFirstCategoryCode(borrowReturn.getBook()
						.getFirstCategory().getItemCode());
			}
			if (borrowReturn.getBook() != null
					&& borrowReturn.getBook().getBookState() != null
					&& borrowReturn.getBook().getBookState().getItemId() != null) {
				view.setBookStateId(borrowReturn.getBook().getBookState()
						.getItemId());
				view.setBookStateName(borrowReturn.getBook().getBookState()
						.getItemName());
			}
			if (borrowReturn.getReader() != null
					&& borrowReturn.getReader().getId() != null) {
				view.setReaderId(borrowReturn.getReader().getId());
				view.setCardNo(borrowReturn.getReader().getCardNo());
				view.setReaderBarCode((borrowReturn.getReader().getBarCode()));
				view.setReaderName(borrowReturn.getReader().getReaderName());
			}
			if (borrowReturn.getReader() != null
					&& borrowReturn.getReader().getReaderUnits() != null
					&& borrowReturn.getReader().getReaderUnits().getUnitId() != null) {
				view.setUnitId(borrowReturn.getReader().getReaderUnits()
						.getUnitId());
				view.setUnitCode(borrowReturn.getReader().getReaderUnits()
						.getUnitcode());
				view.setUnitName(borrowReturn.getReader().getReaderUnits()
						.getUnitName());
			}
			if (borrowReturn.getReader() != null
					&& borrowReturn.getReader().getReaderType() != null
					&& borrowReturn.getReader().getReaderType().getId() != null) {
				view.setReaderTypeId(borrowReturn.getReader().getReaderType()
						.getId());
				view.setReaderCateCode(borrowReturn.getReader().getReaderType()
						.getReaderCateCode());
				view.setReaderCateName(borrowReturn.getReader().getReaderType()
						.getReaderCateName());
			}
			if (borrowReturn.getBorrowOperator() != null
					&& !"".equals(borrowReturn.getBorrowOperator())) {
				view.setBorrowOperator(borrowReturn.getBorrowOperator());
			}
			if (borrowReturn.getReturnOperator() != null
					&& !"".equals(borrowReturn.getReturnOperator())) {
				view.setReturnOperator(borrowReturn.getReturnOperator());
			}
			views.add(view);
		}
	}

	public ExtJsonForm getExtJsonForm() {
		return extJsonForm;
	}

	public void setExtJsonForm(ExtJsonForm extJsonForm) {
		this.extJsonForm = extJsonForm;
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

	public List<BorrowReturnView> getBorrowReturnViews() {
		return borrowReturnViews;
	}

	public void setBorrowReturnViews(List<BorrowReturnView> borrowReturnViews) {
		this.borrowReturnViews = borrowReturnViews;
	}
	public ExtGridLoad getExtGridLoad() {
		return extGridLoad;
	}
	public void setExtGridLoad(ExtGridLoad extGridLoad) {
		this.extGridLoad = extGridLoad;
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
