package com.huan.library.web.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.huan.library.domain.model.LibInfo;
import com.huan.library.domain.service.LibInfoService;
import com.huan.library.web.action.BaseActionSupport;
import com.huan.library.web.view.form.ExtJsonForm;
import com.opensymphony.xwork2.Action;

/**
 * 图书馆信息action
 * @author huan
 * @author 2011-3-15 下午02:49:39
 */
@Controller("libInfoAction")
public class LibInfoAction extends BaseActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Autowired
	private LibInfoService libInfoService; // service
	private ExtJsonForm extJsonForm = new ExtJsonForm();
	private LibInfo libInfo = new LibInfo();

	public String libInfoMain() {
		try {
			libInfo = libInfoService.findById(1L);	
		} catch (Exception e) {
		   e.printStackTrace();
		   return Action.ERROR;
		}
		
		return Action.SUCCESS;
	}

	/**
	 * 设置图书馆信息
	 * @return
	 */
	public String save() {
		try {
			libInfo = libInfoService.save(libInfo);
			extJsonForm.setSuccess(true);
			extJsonForm.setMsg("保存成功！");
			extJsonForm.setData(null);
		} catch (Exception e) {
			e.printStackTrace();
			extJsonForm.setSuccess(false);
			extJsonForm.setMsg("保存失败！");
			extJsonForm.setData(null);
			return Action.ERROR;
		}
		return Action.SUCCESS;
	}
	
	public String getById(){
		try {
			libInfo = libInfoService.findById(1L);
		} catch (Exception e) {
		  e.printStackTrace();
		  return Action.ERROR;
		}
		return Action.SUCCESS;
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

	public ExtJsonForm getExtJsonForm() {
		return extJsonForm;
	}

	public void setExtJsonForm(ExtJsonForm extJsonForm) {
		this.extJsonForm = extJsonForm;
	}

}
