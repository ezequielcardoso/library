package com.huan.library.domain.service.gengeric;

import java.util.List;

import com.huan.library.domain.model.book.Press;


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
	public void addOrModifyPress(Press press) throws Exception;
	
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
	public Press findPressById(int pressId) throws Exception;
	
	/**
	 * 查找所有的Press
	 * @return
	 */
	public List<Press> findAllPresses() throws Exception;


}
