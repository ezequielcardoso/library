package com.huan.library.web.action;

import com.opensymphony.xwork2.Action;

/**
 * 出版社显示层
 * @author huan
 * @time  2011-3-12 下午09:47:21
 */
public class PressAction extends BaseActionSupport{
	
	
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	/**
	 * 显示添加出版社
	 * @return
	 * @throws Exception
	 */
    public String showSavePress() throws Exception {
    	return "showSavePress";
    }
    
	/**
	 * 添加Press
	 * @return
	 * @throws Exception
	 */
	public String savePress() throws Exception {
		try {
			//添加图书
		} catch (Exception e) {
		  e.printStackTrace();
		}
		return Action.SUCCESS;
	}
	
	/**
	 * 显示修改出版社
	 * @return
	 * @throws Exception
	 */
	public String showModifyPress() throws Exception {
		return "showModifyPress";
	}
	
	/**
	 * 修改出版社
	 * @return
	 * @throws Exception
	 */
	public String modifyBook() throws Exception {
		try {
          //修改出版色
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
	public String deletePress() throws Exception {
		try {
		  //删除操作
		} catch (Exception e) {
			e.printStackTrace();
			return Action.ERROR;
		}
		return Action.SUCCESS;
	}
	
	/**
	 * 根据pressId查找Press
	 * @return
	 * @throws Exception
	 */
	public String findPressById() throws Exception {
		try {
		  //执行查找操作
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
