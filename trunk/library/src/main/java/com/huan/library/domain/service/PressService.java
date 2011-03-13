package com.huan.library.domain.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.huan.library.domain.model.book.Book;
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
	public Press addOrModifyPress(Press press) throws Exception;
	
	/**
	 * 根据id删除Book
	 * @param book
	 */
	public void removePress(Press press) throws Exception;
	
	/**
	 * 根据Id查找Press
	 * @param pressId
	 * @return
	 */
	public Press findBookById(String pressId) throws Exception;
	
	/**
	 * 查找所有的Book
	 * @return
	 */
	public List<Press> findAllPresses() throws Exception;


}
