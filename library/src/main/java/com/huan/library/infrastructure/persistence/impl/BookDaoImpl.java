package com.huan.library.infrastructure.persistence.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.huan.library.domain.model.book.Book;
import com.huan.library.infrastructure.persistence.BookDao;
import com.huan.library.infrastructure.persistence.generic.impl.BaseDaoImpl;

/**
 * 
 * @author huan
 * @time 2011-3-10 下午04:52:01
 */
@Repository("bookDao")
public class BookDaoImpl extends BaseDaoImpl<Book> implements BookDao {


	@SuppressWarnings("unchecked")
	public List<Book> selectAllBooks() throws Exception{
		return getHibernateTemplate().find("from Book");
	}

}
