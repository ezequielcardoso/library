package com.huan.library.infrastructure.persistence.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.huan.library.domain.model.book.Book;
import com.huan.library.infrastructure.persistence.BookDao;
import com.huan.library.infrastructure.persistence.generic.HibernateDaoSupportBean;

/**
 * 
 * @author huan
 * @time 2011-3-10 下午04:52:01
 */
@Repository("bookDao")
public class BookDaoImpl extends HibernateDaoSupportBean implements BookDao {

	public boolean deleteBook(Book book) {
		getHibernateTemplate().delete(book);
		return false;
	}

	public boolean saveOrUpdateBook(Book book) {
		getHibernateTemplate().saveOrUpdate(book);
		return false;
	}

	public Book selectBookById(String bookId) {
		return getHibernateTemplate().load(Book.class, bookId);
	}

	public List<Book> selectAllBooks() {
		return getHibernateTemplate().find("from Book");
	}

}
