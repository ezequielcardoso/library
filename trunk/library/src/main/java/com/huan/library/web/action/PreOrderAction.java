package com.huan.library.web.action;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.huan.library.domain.model.borrowReturn.PreOrder;
import com.huan.library.domain.service.PreOrderService;
import com.huan.library.web.view.PreOrderView;
import com.huan.library.web.view.grid.ExtGridLoad;
import com.opensymphony.xwork2.Action;

/**
 * 预约
 * @author Administrator
 *
 */
@Controller("preOrderAction")
public class PreOrderAction extends BaseActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private PreOrderService preOrderService;
	private ExtGridLoad extGridLoad = new ExtGridLoad();
	private PreOrderView preOrderView = new PreOrderView();
	private List<PreOrderView> preOrderViews = new ArrayList<PreOrderView>();
	private Integer start;
	private Integer limit;
	
	/**
	 * 图书预约主页面
	 * @return
	 */
	public String bookPreOrderMain(){
		return Action.SUCCESS;
	}
  
	public String findPreOrders(){
		try {
		  preOrderView.setStart(start);
		  preOrderView.setLimit(limit);
		  List<PreOrder> preOrders = preOrderService.findPreOrders(preOrderView);
		  this.convertToViews(preOrders, preOrderViews);
		  extGridLoad.setRoot(preOrderViews);
		  extGridLoad.setTotalProperty(preOrderView.getTotalCount());
		} catch (Exception e) {
		  e.printStackTrace();
		  return Action.ERROR; 
		}
		return Action.SUCCESS;
	}
	
	private void convertToViews(List<PreOrder> preOrders,
			List<PreOrderView> views) {
		for (PreOrder preOrder : preOrders) {
			PreOrderView view = new PreOrderView();
			view.setId(preOrder.getId());
			if (preOrder.getPreOrderDate() != null) {
				view.setPreOrderDate(preOrder.getPreOrderDate());
			}
			if (preOrder.getPreOrderEndDate() != null) {
				view.setPreOrderEndDate(preOrder.getPreOrderEndDate());
			}
			if (preOrder.getBook() != null
					&& preOrder.getBook().getBookId() != null) {
				view.setBookId(preOrder.getBook().getBookId());
			}
			if (preOrder.getBook() != null
					&& preOrder.getBook().getBookNo() != null) {
				view.setBookNo(preOrder.getBook().getBookNo());
			}
			if (preOrder.getBook() != null
					&& preOrder.getBook().getBarCode() != null) {
				view.setBookBarCode(preOrder.getBook().getBarCode());
			}
			if (preOrder.getBook() != null
					&& preOrder.getBook().getBookName() != null) {
				view.setBookName(preOrder.getBook().getBookName());
			}
			if (preOrder.getBook() != null
					&& preOrder.getBook().getLocation() != null) {
				view.setLocation(preOrder.getBook().getLocation());
			}
			if (preOrder.getBook() != null
					&& preOrder.getBook().getFirstCategory() != null
					&& preOrder.getBook().getFirstCategory().getItemId() != null) {
				view.setFirstCategoryId(preOrder.getBook()
						.getFirstCategory().getItemId());
			}
			if (preOrder.getBook() != null
					&& preOrder.getBook().getFirstCategory() != null
					&& preOrder.getBook().getFirstCategory().getItemName() != null) {
				view.setFirstCategoryName(preOrder.getBook()
						.getFirstCategory().getItemName());
			}
			if (preOrder.getBook() != null
					&& preOrder.getBook().getFirstCategory() != null
					&& preOrder.getBook().getFirstCategory().getItemCode() != null) {
				view.setFirstCategoryCode(preOrder.getBook()
						.getFirstCategory().getItemCode());
			}
			if (preOrder.getBook() != null
					&& preOrder.getBook().getBookState() != null
					&& preOrder.getBook().getBookState().getItemId() != null) {
				view.setBookStateId(preOrder.getBook().getBookState()
						.getItemId());
				view.setBookStateName(preOrder.getBook().getBookState()
						.getItemName());
			}
			if (preOrder.getReader() != null
					&& preOrder.getReader().getId() != null) {
				view.setReaderId(preOrder.getReader().getId());
				view.setCardNo(preOrder.getReader().getCardNo());
				view.setReaderBarCode((preOrder.getReader().getBarCode()));
				view.setReaderName(preOrder.getReader().getReaderName());
			}
			if (preOrder.getReader() != null
					&& preOrder.getReader().getReaderUnits() != null
					&& preOrder.getReader().getReaderUnits().getUnitId() != null) {
				view.setUnitId(preOrder.getReader().getReaderUnits()
						.getUnitId());
				view.setUnitCode(preOrder.getReader().getReaderUnits()
						.getUnitcode());
				view.setUnitName(preOrder.getReader().getReaderUnits()
						.getUnitName());
			}
			if (preOrder.getReader() != null
					&& preOrder.getReader().getReaderType() != null
					&& preOrder.getReader().getReaderType().getId() != null) {
				view.setReaderTypeId(preOrder.getReader().getReaderType()
						.getId());
				view.setReaderCateCode(preOrder.getReader().getReaderType()
						.getReaderCateCode());
				view.setReaderCateName(preOrder.getReader().getReaderType()
						.getReaderCateName());
			}
			views.add(view);
		}
	}

	public void setPreOrderService(PreOrderService preOrderService) {
		this.preOrderService = preOrderService;
	}

	public ExtGridLoad getExtGridLoad() {
		return extGridLoad;
	}

	public void setExtGridLoad(ExtGridLoad extGridLoad) {
		this.extGridLoad = extGridLoad;
	}

	public PreOrderView getPreOrderView() {
		return preOrderView;
	}

	public void setPreOrderView(PreOrderView preOrderView) {
		this.preOrderView = preOrderView;
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
