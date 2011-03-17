package com.huan.library.web.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.huan.library.domain.model.borrowReturn.BorrowReturn;
import com.huan.library.domain.service.BorrowReturnService;
import com.opensymphony.xwork2.Action;

/**
 * 图书借阅归还action
 * @author huan
 * @time  2011-3-17 下午06:41:54
 */
@Controller("borrowReturnAction")
public class BorrowReturnAction extends BaseActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private BorrowReturnService borrowReturnService;    //借还service
	private BorrowReturn borrowReturn;
	
	/**
	 * 书刊借阅界面
	 * @return
	 */
	public String showBookBorrow(){
			return Action.SUCCESS;
	}
	/**
	 * 书刊借阅
	 * @return
	 */
	public String bookBorrow(){
		BorrowReturn borrowCopy = new BorrowReturn();
		try {
			borrowCopy = borrowReturnService.addOrModifyBorrow(borrowReturn);	
			request.setAttribute("borrowReturn", borrowCopy);
		} catch (Exception e) {
			e.printStackTrace();
			return Action.ERROR;
		}
		return Action.SUCCESS;
	}
	/**
	 * 显示书刊归还界面
	 * @return
	 */
	public String showBookReturn(){
		return "showBookReturn";
	}
	/**
	 * 书刊归还
	 * @return
	 */
	public String bookReturn(){
		BorrowReturn returnCopy = new BorrowReturn();
		try {
			returnCopy = borrowReturnService.addReturn(borrowReturn);
			request.setAttribute("borrowReturn", returnCopy);
		} catch (Exception e) {
		    e.printStackTrace();
		}
		return "bookReturn";
	}

	/**
	 * 显示书刊续借界面
	 * @return
	 */
	public String showBookRenew(){
		return "showBookRenew";
	}
	/**
	 * 书刊续借
	 * @return
	 */
	public String bookRenew(){
		BorrowReturn returnCopy = new BorrowReturn();
		try {
			returnCopy = borrowReturnService.addOrModifyBorrow(borrowReturn);
			request.setAttribute("borrowReturn", returnCopy);
		} catch (Exception e) {
		    e.printStackTrace();
		}
		return "bookReturn";
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

}
