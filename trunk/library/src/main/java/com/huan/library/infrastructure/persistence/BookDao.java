package com.huan.library.infrastructure.persistence;


import java.util.List;

import com.huan.library.domain.model.book.Book;

/**
 * 图书dao
 * @author huan
 * @time  2011-3-10 上午07:11:18
 */
public interface BookDao extends BaseDao<Book>{

	public List<Book> selectAllBooks() throws Exception;
	
}	