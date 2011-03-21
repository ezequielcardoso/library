package com.huan.library.web.action;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.huan.library.domain.model.reader.ReaderType;
import com.huan.library.domain.service.ReaderTypeService;
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

	private ReaderType readerType;

	public void setReaderTypeService(ReaderTypeService readerTypeService) {
		this.readerTypeService = readerTypeService;
	}

	public ReaderType getReaderType() {
		return readerType;
	}

	public void setReaderType(ReaderType readerType) {
		this.readerType = readerType;
	}

	/**
	 * 增加读者类型
	 * @return
	 */
	public String saveReaderType() {
		ReaderType readerTypeCopy = new ReaderType();
		try {
			readerTypeCopy = readerTypeService.addOrModifyReaderType(readerType);
			request.setAttribute("readerType", readerTypeCopy);
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

	/**
	 * 查找所有的读者类型
	 * @return
	 */
	public String findAllReaderTypes() {
		List<ReaderType> readerTypes = new ArrayList<ReaderType>();
		try {
			readerTypes = readerTypeService.findAllReaderTypes();
			request.setAttribute("readerTypes", readerTypes);
		} catch (Exception e) {
			e.printStackTrace();
			return Action.ERROR;
		}
		return Action.SUCCESS;
	}
}
