package com.huan.library.web.action;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.huan.library.domain.model.reader.Reader;
import com.huan.library.domain.service.ReaderService;
import com.opensymphony.xwork2.Action;

/**
 * 读者显示层
 * @author huan
 * @time  2011-3-14 下午02:23:03
 */
@Controller("readerAction")
public class ReaderAction extends BaseActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private ReaderService readerService;
	
	private Reader reader;

	public Reader getReader() {
		return reader;
	}

	public void setReader(Reader reader) {
		this.reader = reader;
	}

	public void setReaderService(ReaderService readerService) {
		this.readerService = readerService;
	}
	
	 /**
	  * 显示增加读者
	  * @return
	  */
    public String showSaveReader() {
           return "showSaveReader";
	}
    
	/**
	 * 增加读者
	 * @return
	 */
	public String saveReader()  {
		try {
			readerService.addOrModifyReader(reader);
		} catch (Exception e) {
		  e.printStackTrace();
		   return Action.ERROR;
		}
		  return Action.SUCCESS;
	}
	
	 /**
	  * 显示修改读者
	  * @return
	  */
	public String showModifyReader()  {
		return "showModifyReader";
	}
	
	/**
	 * 修改读者
	 * @return
	 */
	public String modifyReader() {
		try {
		 readerService.addOrModifyReader(reader);
		} catch (Exception e) {
			e.printStackTrace();
			return Action.ERROR;
		}
		return Action.SUCCESS;
	}
	
	/**
	 * 注销读者
	 * @return
	 */
	public String deleteReader() {
		try {
			readerService.removeReader(reader);
		} catch (Exception e) {
			e.printStackTrace();
			return Action.ERROR;
		}
		return Action.SUCCESS;
	}
	
	/**
	 * 根据id查找reader
	 * @return
	 */
	public String findReaderById() {
		try {
			request.setAttribute("reader", readerService.findReaderById(reader.getId()));
		} catch (Exception e) {
			e.printStackTrace();
			return Action.ERROR;
		}
		return Action.SUCCESS;
	}
	/**
	 * 查找所有的读者
	 * @return
	 */
	public String findReaders() {
		List<Reader> readers = new ArrayList<Reader>();
		try {
			readers = readerService.findAllReaderes();
			request.setAttribute("readers", readers);
		} catch (Exception e) {
			e.printStackTrace();
			return Action.ERROR;
		}
		return Action.SUCCESS;
	}

}
