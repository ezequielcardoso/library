package com.huan.library.infrastructure.persistence;

import java.util.List;

import com.huan.library.domain.model.book.Press;
import com.huan.library.web.view.PressesView;

public interface PressDao extends BaseDao<Press> {
	
	
	public List<Press> selectBooks(PressesView pressesView) throws Exception;
	/**
	 * 批量插入出版社信息
	 * @param list
	 */
	public void insertPressBatch(List<Press> list) throws Exception ;

}
