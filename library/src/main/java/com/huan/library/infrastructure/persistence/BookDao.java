package com.huan.library.infrastructure.persistence;


import java.util.List;

import com.huan.library.domain.model.book.Book;
import com.huan.library.web.view.BookView;

/**
 * 图书dao
 * @author huan
 * @time  2011-3-10 上午07:11:18
 */
public interface BookDao extends BaseDao<Book>{

	public List<Book> selectBooks(BookView bookView) throws Exception;

	public Book selectBook(BookView bookView) throws Exception;
	
}	