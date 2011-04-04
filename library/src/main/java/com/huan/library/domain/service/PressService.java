package com.huan.library.domain.service;

import java.util.List;

import com.huan.library.domain.model.book.Press;
import com.huan.library.util.PageModel;
import com.huan.library.web.view.PressView;
/**
 * 出版社业务层
 * @author huan
 * @time  2011-3-12 下午07:01:39
 */
public interface PressService {
	/**
	 * 增加或者修改Press
	 * @param press
	 * @return
	 */
	public Press addOrModifyPress(Press press) throws Exception;
	
	/**
	 * 删除Press
	 * @param press
	 */
	public void removePress(Press press) throws Exception;
	
	/**
	 * 根据Id查找Press
	 * @param pressId
	 * @return
	 */
	public Press findPressById(Long pressId) throws Exception;
	
	/**
	 * 查找所有的Press
	 * @return
	 */
	public List<Press> findAllPresses() throws Exception;

	/**
	 * 分页查找出版社
	 * @return
	 * @throws Exception
	 */
	public PageModel<Press> findPressesByPage(int pageNo,int pageSize) throws Exception;

	/**
	 * 分页查找出版社
	 * @return
	 * @throws Exception
	 */
	public List<Press> findPresses(PressView pressView) throws Exception;

}
