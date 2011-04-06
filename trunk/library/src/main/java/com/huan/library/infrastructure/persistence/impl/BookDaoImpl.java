package com.huan.library.infrastructure.persistence.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.stereotype.Repository;

import com.huan.library.domain.model.book.Book;
import com.huan.library.infrastructure.persistence.BookDao;
import com.huan.library.web.view.BookView;

/**
 * 
 * @author huan
 * @time 2011-3-10 下午04:52:01
 */
@Repository("bookDao")
public class BookDaoImpl extends BaseDaoImpl<Book> implements BookDao {

	public List<Book> selectBooks(final BookView bookView) throws Exception {
		List<Book> books = new ArrayList<Book>();
		try{
			StringBuilder hql = new StringBuilder();
			StringBuilder hql_ = new StringBuilder();
			//select 子句 
			hql_.append(" select count(b) ");
			// count select 子句
			hql.append(" select new Book( b.bookId, b.barCode, b.bookName, b.bookDesc, b.donator, b.author, b.translator," +
				" b.ISBN, b.ISSN, b.emailNo, b.stage, b.allStage, b.pages, b.price, b.publisherDate, " +
				" b.quantity, b.location, b.revision, b.searchBookId, b.speciesId, b.spell, b.storeDate," + 
				" b.bookNo, b.isBook, t_fc.itemId, t_fc.itemCode, t_fc.itemName, t_fc.itemShortName, t_cc.itemId," +
				" t_cc.itemCode, t_cc.itemName, t_th.itemId, t_th.itemCode, t_th.itemName, " +
				" t_st.itemId, t_st.itemName, t_le.itemId, t_le.itemName, t_se.itemId, t_se.itemName, t_cu.itemId, t_cu.itemName, " +
				" t_pr.pressId, t_pr.pressName, t_so.itemId, t_so.itemName) "); 
			// from 子句
			hql.append(" from Book b ");
			// count from 子句
			hql_.append(" from Book b ");
			
			StringBuilder joinSub = new StringBuilder();
			//left join 子句
			joinSub.append(" left join b.firstCategory t_fc ");
			joinSub.append(" left join b.secondCategory t_cc ");
			joinSub.append(" left join b.thirdCategory t_th ");
			joinSub.append(" left join b.bookState t_st ");
			joinSub.append(" left join b.bookLevel t_le ");
			joinSub.append(" left join b.bookSecurity t_se ");
			joinSub.append(" left join b.currency t_cu ");
			joinSub.append(" left join b.press t_pr ");
			joinSub.append(" left join b.bookSource t_so ");
			
			hql.append(joinSub);
			hql_.append(joinSub);
			
			//where 子句
			hql.append(" where 1=1 ");
			// count where 子句
			hql_.append(" where 1=1 ");
			StringBuilder whereSub = new StringBuilder();
			/**
			 * 拼接条件 如果某个字段的值不为空，则将作为查询条件
			 */
			whereSub.append(" and b.isBook = :isBook ");
//			if(field!=null ){
//				whereSub.append(" and b.fieldName = : fieldValue ");
//			}
			//.......继续拼接........
			
			hql.append(whereSub);
			hql_.append(whereSub);//count 查询hql拼接结束

			//group by 子句 
			
			//order by 子句
			
			//查找总记录
			final String hqlIn_ = hql_.toString();
			HibernateCallback callback_ = new HibernateCallback(){

				public Object doInHibernate(Session session)
						throws HibernateException, SQLException {
						Query query = session.createQuery(hqlIn_);
						//设置查询参数
						query.setParameter("isBook", bookView.getIsBook()==1 ? true : false);
					return query.list();
				}
				
			};
			Long totalCount  = (Long) getHibernateTemplate().executeFind(callback_).iterator().next();
			//把记录数设置到view对象中，在action中可取到这个值
			bookView.setTotalCount(totalCount);
			
			//查找列表
			final String hqlIn = hql.toString();
			HibernateCallback callback = new HibernateCallback(){

				public Object doInHibernate(Session session)
						throws HibernateException, SQLException {
						Query query = session.createQuery(hqlIn);
						//判断是否分页
						if(bookView!=null && bookView.getIsPage()){
							query.setMaxResults(bookView.getLimit());
							query.setFirstResult(bookView.getStart());
						}
//						//设置查询参数
						query.setParameter("isBook", bookView.getIsBook()==1 ? true : false );
					return query.list();
				}
			};
			books = (List<Book>)getHibernateTemplate().executeFind(callback);
		} catch(Exception e){
			e.printStackTrace();
			throw new Exception(e);
		}
		return books;
	}
   
	public Book selectBookById(Long bookId) throws Exception {
		StringBuilder hql = new StringBuilder();
		hql.append(" from Book as b " ); 
		hql.append(" left join fetch b.firstCategory t_fc ");
		hql.append(" left join fetch b.secondCategory t_cc ");
		hql.append(" left join fetch b.thirdCategory t_th ");
		hql.append(" left join fetch b.bookState t_st ");
		hql.append(" left join fetch b.bookLevel t_le ");
		hql.append(" left join fetch b.bookSecurity t_se ");
		hql.append(" left join fetch b.currency t_cu ");
		hql.append(" left join fetch b.press t_pr ");
		hql.append(" left join fetch b.bookSource t_so ");
		hql.append(" where b.bookId=? ");
		Book book = new Book();
		try {
			book = (Book) this.getHibernateTemplate().find(hql.toString(), bookId).listIterator().next();
		} catch (Exception e){
			e.printStackTrace();
			throw new Exception(e);
		}
		return book;
	}

	public void insertBooksBatch(List<Book> books) throws Exception {
		try {
			SessionFactory sessionFactory = this.getSessionFactory();
			Session session = sessionFactory.openSession();
			Transaction tx = session.getTransaction();
			int i = 0;
			for (Book book : books) {
				session.save(book);
				if (i % 100 == 0) {
					tx.begin();
					session.flush();
					session.clear();
					tx.commit();
				}
				i++;
			}
			tx.begin();
			session.flush();
			session.clear();
			tx.commit();
			session.close();
			sessionFactory.close();
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e);
		}
	}

}
