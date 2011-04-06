package com.huan.library.web.action;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.huan.library.domain.model.reader.ReaderCard;
import com.huan.library.domain.service.ReaderCardService;
import com.huan.library.web.view.ReaderCardView;
import com.huan.library.web.view.form.ExtJsonForm;
import com.huan.library.web.view.grid.ExtGridLoad;
import com.opensymphony.xwork2.Action;

/**
 * 读者借阅证action
 * @author huan
 * @time 2011-3-15 上午10:26:06
 */
@Controller("readerCardAction")
public class ReaderCardAction extends BaseActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Autowired
	private ReaderCardService readerCardService; // service
	private ReaderCard readerCard = new ReaderCard();
	private ReaderCardView readerCardView = new ReaderCardView();
	
	private ExtJsonForm extJsonForm = new ExtJsonForm();
	private ExtGridLoad extGridLoad = new ExtGridLoad();

	/**
	 * 显示主页面
	 * @return
	 */
	public String readerCardMain(){
		return Action.SUCCESS;
	}
	
	/**
	 * 查找所有的借阅证
	 * @return
	 */
	public String findReaderCards(){
		try {
			
		} catch (Exception e) {
		   e.printStackTrace();
		   return Action.ERROR;
		}
		return Action.SUCCESS;
	}
	
	/**
	 * 显示增加读者借阅证
	 * @return
	 */
	public String showSaveReaderCard() {
		return "showSaveReaderCard";
	}

	/**
	 * 增加读者借阅证
	 * @return
	 */
	public String saveReaderCard() {
		ReaderCard readerCardCopy = new ReaderCard();
		try {
			readerCardCopy = readerCardService
					.addOrModifyReaderCard(readerCard);
		} catch (Exception e) {
			e.printStackTrace();
			return Action.ERROR;
		}
		return Action.SUCCESS;
	}

	/**
	 * 显示修改读者借阅证
	 * @return
	 */
	public String showModifyReaderCard() {
		try {
			readerCardService.findReaderCardById(readerCard.getId());
		} catch (Exception e) {
		    e.printStackTrace();
		    return Action.ERROR;
		}
		return "showModifyReaderCard";
	}

	/**
	 * 修改读者借阅证
	 * @return
	 */
	public String mofidyReaderCard() {
		try {
          readerCardService.addOrModifyReaderCard(readerCard);
		} catch (Exception e) {
			e.printStackTrace();
			return Action.ERROR;
		}
		return Action.SUCCESS;
	}
	
	/**
	 * 删除读者借阅证
	 * @return
	 */
	public String deleteReaderCard() {
		ReaderCard readerCardCopy = new ReaderCard();
		try {
		  readerCardCopy = readerCardService.findReaderCardById(readerCard.getId());	
          readerCardService.removeReaderCard(readerCardCopy);
		} catch (Exception e) {
			e.printStackTrace();
			return Action.ERROR;
		}
		return Action.SUCCESS;
	}
	
	/**
	 * 查找读者借阅证
	 * @return
	 */
	public String findAllReaderCards() {
		List<ReaderCard> readerCards = new ArrayList<ReaderCard>();
		try {
			readerCards = readerCardService.findAllReaderCards();
		} catch (Exception e) {
			e.printStackTrace();
			return Action.ERROR;
		}
		return Action.SUCCESS;
	}
	
	public List<ReaderCardView> convertToView(List<ReaderCard> readerCards){
		List<ReaderCardView> readerCardViews = new ArrayList<ReaderCardView>();
		for(ReaderCard readerCard:readerCards){
			ReaderCardView readerCardView = new ReaderCardView();
			readerCardView.setId(readerCard.getId());
		}
		return readerCardViews;
	}
	
	public ReaderCard getReaderCard() {
		return readerCard;
	}

	public void setReaderCard(ReaderCard readerCard) {
		this.readerCard = readerCard;
	}

	public void setReaderCardService(ReaderCardService readerCardService) {
		this.readerCardService = readerCardService;
	}

	public ReaderCardView getReaderCardView() {
		return readerCardView;
	}

	public void setReaderCardView(ReaderCardView readerCardView) {
		this.readerCardView = readerCardView;
	}

	public ExtJsonForm getExtJsonForm() {
		return extJsonForm;
	}

	public void setExtJsonForm(ExtJsonForm extJsonForm) {
		this.extJsonForm = extJsonForm;
	}

	public ExtGridLoad getExtGridLoad() {
		return extGridLoad;
	}

	public void setExtGridLoad(ExtGridLoad extGridLoad) {
		this.extGridLoad = extGridLoad;
	}
    

}
