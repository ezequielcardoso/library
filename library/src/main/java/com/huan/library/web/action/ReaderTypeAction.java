package com.huan.library.web.action;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.huan.library.domain.model.reader.ReaderType;
import com.huan.library.domain.service.ReaderTypeService;
import com.huan.library.web.view.ReaderTypeView;
import com.huan.library.web.view.form.ExtJsonForm;
import com.huan.library.web.view.grid.ExtGridLoad;
import com.opensymphony.xwork2.Action;

/**
 * 读者类别action
 * 
 * @author huan
 * @time 2011-3-15 上午10:58:36
 */
@Controller("readerTypeAction")
public class ReaderTypeAction extends BaseActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Autowired
	private ReaderTypeService readerTypeService; // 读者类型service

	private ReaderType readerType = new ReaderType();
	private ReaderTypeView readerTypeView = new ReaderTypeView();

	private ExtGridLoad extGridLoad = new ExtGridLoad(); // 分页数据和记录
	private ExtJsonForm extJsonForm = new ExtJsonForm(); // 返回给客户的信息

	private Integer start;
	private Integer limit;

	public String readerTypeMain() {
		return Action.SUCCESS;
	}
    /**
	 *查找所有读者类型
	 * @return
	 */   
	public String findReaderTypes() {
		try {
           readerTypeView.setStart(start);
           readerTypeView.setLimit(limit);
           List<ReaderType> readerTypes = readerTypeService.findReaderTypes(readerTypeView);
           extGridLoad.setRoot(this.convertToView(readerTypes));
           extGridLoad.setTotalProperty(readerTypeView.getTotalCount());
		} catch (Exception e) {
           e.printStackTrace();
           return Action.ERROR;
		}
        return Action.SUCCESS; 
	}

	/**
	 * 增加读者类型
	 * @return
	 */
	public String saveReaderType() {
		ReaderType readerTypeCopy = new ReaderType();
		try {
			readerTypeCopy = readerTypeService
					.addOrModifyReaderType(readerType);
		} catch (Exception e) {
			e.printStackTrace();
			return Action.ERROR;
		}
		return Action.SUCCESS;
	}

	/**
	 * 删除读者类型
	 * @return
	 */
	public String deleteReaderType() {
		try {
			readerTypeService.removeReaderType(readerType);
		} catch (Exception e) {
			e.printStackTrace();
			return Action.ERROR;
		}
		return Action.SUCCESS;
	}

	/**
	 * 修改读者类型
	 * 
	 * @return
	 */
	public String modifyReaderType() {
		try {
			readerTypeService.addOrModifyReaderType(readerType);
		} catch (Exception e) {
			e.printStackTrace();
			return Action.ERROR;
		}
		return Action.SUCCESS;
	}

	public List<ReaderTypeView> convertToView(List<ReaderType> readerTypes) {
		List<ReaderTypeView> readerTypeViews = new ArrayList<ReaderTypeView>();
		for (ReaderType readerType : readerTypes) {
			ReaderTypeView readerTypeView = new ReaderTypeView();
			readerTypeView.setId(readerType.getId());
			if (readerType.getReaderCateCode() != null) {
				readerTypeView
						.setReaderCateCode(readerType.getReaderCateCode());
			}
			if (readerType.getReaderCateName() != null) {
				readerTypeView
						.setReaderCateName(readerType.getReaderCateName());
			}
			if (readerType.getBorrowDays() != null) {
				readerTypeView.setBorrowDays(readerType.getBorrowDays());
			}
			if (readerType.getBorrowedQuantity() != null) {
				readerTypeView.setBorrowedQuantity(readerType
						.getBorrowedQuantity());
			}
			if (readerType.getRent() != null) {
				readerTypeView.setRent(readerType.getRent());
			}
			readerTypeViews.add(readerTypeView);
		}
		return readerTypeViews;
	}

	public void setReaderTypeService(ReaderTypeService readerTypeService) {
		this.readerTypeService = readerTypeService;
	}

	public ReaderType getReaderType() {
		return readerType;
	}

	public void setReaderType(ReaderType readerType) {
		this.readerType = readerType;
	}

	public ReaderTypeView getReaderTypeView() {
		return readerTypeView;
	}

	public void setReaderTypeView(ReaderTypeView readerTypeView) {
		this.readerTypeView = readerTypeView;
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
