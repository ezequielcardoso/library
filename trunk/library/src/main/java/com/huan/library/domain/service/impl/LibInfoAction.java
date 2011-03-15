package com.huan.library.domain.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.huan.library.domain.model.LibInfo;
import com.huan.library.domain.service.LibInfoService;
import com.huan.library.web.action.BaseActionSupport;
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

	private LibInfo libInfo;

	public LibInfo getLibInfo() {
		return libInfo;
	}

	public void setLibInfo(LibInfo libInfo) {
		this.libInfo = libInfo;
	}

	public void setLibInfoService(LibInfoService libInfoService) {
		this.libInfoService = libInfoService;
	}

	/**
	 * 设置图书馆信息
	 * 
	 * @return
	 */
	public String saveOrUpdate() {
		LibInfo libInfoCopy = new LibInfo();
		try {
			libInfoCopy = libInfoService.addOrModifyLibInfo(libInfo);
			request.setAttribute("libInfo", libInfoCopy);
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
	public String findLibInfoByid() {
		LibInfo libInfoCopy = new LibInfo();
		try {
			libInfoCopy = libInfoService.findLibInfoById(libInfo.getId());
			request.setAttribute("libInfo", libInfoCopy);
		} catch (Exception e) {
			e.printStackTrace();
			return Action.ERROR;
		}
		return Action.SUCCESS;
	}

}
