package com.huan.library.web.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.huan.library.domain.model.book.Press;
import com.huan.library.domain.service.PressService;
import com.opensymphony.xwork2.Action;

/**
 * 出版社显示层
 * @author huan
 * @time  2011-3-12 下午09:47:21
 */
@Controller("pressAction")
public class PressAction extends BaseActionSupport{
	
	
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private PressService pressService;
	
	private Press press;
	
	public Press getPress() {
		return press;
	}
	public void setPress(Press press) {
		this.press = press;
	}

	public void setPressService(PressService pressService) {
		this.pressService = pressService;
	}

	/**
	 * 显示添加出版社
	 * @return
	 * @throws Exception
	 * try {
		
	} catch (Exception e) {
		e.printStackTrace();
	}
	 */
	
	public String showSavePress()  {
    	return "showSavePress";
    }
    
	/**
	 * 添加Press
	 * @return
	 * @throws Exception
	 */
	public String savePress()  {
		try {
			pressService.addOrModifyPress(press);
		} catch (Exception e) {
		  e.printStackTrace();
		 return Action.ERROR;
		}
		 return Action.SUCCESS;
	}
	
	/**
	 * 显示修改出版社
	 * @return
	 * @throws Exception
	 */
	public String showModifyPress() {
		try {
			  //press会不会为空
	          Press pressModify = pressService.findPressById(press.getId());
	          request.setAttribute("press", pressModify);
			} catch (Exception e) {
				e.printStackTrace();
				return Action.ERROR;
			}
		return "showModifyPress";
	}
	
	/**
	 * 修改出版社
	 * @return
	 * @throws Exception
	 */
	public String modifyPress()  {
		try {
			 //press会不会为空
           pressService.addOrModifyPress(press);
		} catch (Exception e) {
			e.printStackTrace();
			return Action.ERROR;
		}
		return Action.SUCCESS;
	}
	
	/**
	 * 删除出版社
	 * @return
	 * @throws Exception
	 */
	public String deletePress() {
		try {
		   pressService.removePress(press);
		} catch (Exception e) {
			e.printStackTrace();
			return Action.ERROR;
		}
		return Action.SUCCESS;
	}
	
	
	/**
	 * 查找所有的出版社
	 * @return
	 * @throws Exception
	 */
	public String findPresses() throws Exception {
		try {
			//执行查找操作
		} catch (Exception e) {
			e.printStackTrace();
			return Action.ERROR;
		}
		return Action.SUCCESS;
	}


}
