package com.huan.library.infrastructure.persistence;

import java.util.List;

import com.huan.library.domain.model.book.Press;

public interface PressDao extends BaseDao<Press> {
	
	/**
	 * 批量插入出版社信息
	 * @param list
	 */
	public void insertPressBatch(List<Press> list) throws Exception ;

}
