package com.huan.library.infrastructure.persistence.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.huan.library.domain.model.book.Book;
import com.huan.library.infrastructure.persistence.BookDao;
import com.huan.library.infrastructure.persistence.generic.HibernateDaoSupportBean;
@Repository
public class BookDaoImpl extends HibernateDaoSupportBean implements BookDao{

	public boolean deleteBook(Book book) {
		this.getHibernateTemplate().delete(book);
		return false;
	}

	public boolean saveOrUpdateDept(Book book) {
		this.getHibernateTemplate().saveOrUpdate(book);
		return false;
	}

    public Book selectBookById(String bookId) {
		return this.getHibernateTemplate().load(Book.class, bookId);
	}
	
	@SuppressWarnings("unchecked")
	public List<Book> selectAllBooks() {
		return this.getSession().createQuery("from Book").list();
	}

}
