package com.huan.library.web.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.huan.library.domain.model.LibInfo;
import com.huan.library.domain.model.book.Book;
import com.huan.library.domain.model.borrowReturn.BorrowReturn;
import com.huan.library.domain.model.reader.Reader;
import com.huan.library.domain.service.BorrowReturnService;
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
           	
           	borrowReturn.setBook(book);
           	borrowReturn.setReader(reader);
           	
            borrowReturnService.addOrModifyBorrow(borrowReturn);         	
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
	
}
