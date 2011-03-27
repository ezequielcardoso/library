package com.huan.library.infrastructure.persistence.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.stereotype.Repository;

import com.huan.library.domain.model.book.Book;
import com.huan.library.domain.model.rights.User;
import com.huan.library.infrastructure.persistence.BookDao;
import com.huan.library.web.view.BookView;

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

	public List<Book> selectBooks(final BookView bookView) throws Exception {
		List<Book> books = new ArrayList<Book>();
		try{
			StringBuilder hql = new StringBuilder();
			hql.append(" select new Book( b.bookId, b.barCode, b.bookName, b.bookDesc, b.donator, b.author, b.translator," +
			" b.ISBN, b.ISSN, b.emailNo, b.stage, b.allStage, b.pages, b.price, b.publisherDate, " +
			" b.quantity, b.location, b.revision, b.searchBookId, b.speciesId, b.spell, b.storeDate," + 
			" b.bookNo, b.isBook, t_fc.categoryId, t_fc.categoryCode, t_fc.categoryName, t_cc.categoryId," +
			" t_cc.categoryCode, t_cc.categoryName, t_st.itemId, t_st.shortName, " +
			" t_le.itemId, t_le.shortName, t_se.itemId, t_se.shortName, t_cu.itemId, t_cu.shortName, " +
			" t_pr.pressId, t_pr.pressName, t_re.itemId, t_re.shortName) "); 
			hql.append(" from Book b ");
//			hql.append(" where t_dept.deptId=(:deptId) ");
			hql.append(" left join b.firstCategory t_fc ");
			hql.append(" left join b.secondCategory t_cc ");
			hql.append(" left join b.bookState t_st ");
			hql.append(" left join b.bookLevel t_le ");
			hql.append(" left join b.security t_se ");
			hql.append(" left join b.currency t_cu ");
			hql.append(" left join b.press t_pr ");
			hql.append(" left join b.resource t_re ");
			
			final String hqlIn = hql.toString();
			HibernateCallback callback = new HibernateCallback(){

				public Object doInHibernate(Session session)
						throws HibernateException, SQLException {
						Query query = session.createQuery(hqlIn);
						if(bookView!=null && bookView.getIsPage()){
							query.setMaxResults(bookView.getLimit());
							query.setFirstResult(bookView.getStart());
						}
//						query.setParameter("deptId", deptId);
					return query.list();
				}
				
			};
			books = (List<Book>)getHibernateTemplate().executeFind(callback);
			System.out.println(books.size());
		} catch(Exception e){
			e.printStackTrace();
			throw new Exception(e);
		}
		return books;
	}

}
