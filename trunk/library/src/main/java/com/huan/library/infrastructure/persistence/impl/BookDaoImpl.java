package com.huan.library.infrastructure.persistence.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
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
				" b.bookNo, b.isBook, t_fc.categoryId, t_fc.categoryCode, t_fc.categoryName, t_cc.categoryId," +
				" t_cc.categoryCode, t_cc.categoryName, t_st.itemId, t_st.shortName, " +
				" t_le.itemId, t_le.shortName, t_se.itemId, t_se.shortName, t_cu.itemId, t_cu.shortName, " +
				" t_pr.pressId, t_pr.pressName, t_re.itemId, t_re.shortName) "); 
			// from 子句
			hql.append(" from Book b ");
			// count from 子句
			hql_.append(" from Book b ");
			
			//left join 子句
			hql.append(" left join b.firstCategory t_fc ");
			hql.append(" left join b.secondCategory t_cc ");
			hql.append(" left join b.bookState t_st ");
			hql.append(" left join b.bookLevel t_le ");
			hql.append(" left join b.security t_se ");
			hql.append(" left join b.currency t_cu ");
			hql.append(" left join b.press t_pr ");
			hql.append(" left join b.resource t_re ");
			
			//where 子句
			hql.append(" where 1=1 ");
			// count where 子句
			hql_.append(" where 1=1 ");
			StringBuilder whereSub = new StringBuilder();
			/**
			 * 拼接条件 如果某个字段的值不为空，则将作为查询条件
			 */
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
//						query.setParameter("fieldValue", view.getFieldValue);
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
//						query.setParameter("fieldValue", view.getFieldValue);
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
   
	public Book selectBook(BookView bookView) throws Exception {
		StringBuilder hql = new StringBuilder();
		hql.append(" from Book as b " ); 
		hql.append(" left join fetch b.firstCategory t_fc ");
		hql.append(" left join fetch b.secondCategory t_cc ");
		hql.append(" left join fetch b.bookState t_st ");
		hql.append(" left join fetch b.bookLevel t_le ");
		hql.append(" left join fetch b.security t_se ");
		hql.append(" left join fetch b.currency t_cu ");
		hql.append(" left join fetch b.press t_pr ");
		hql.append(" left join fetch b.resource t_re ");
		hql.append(" where b.bookId=? ");
		Book book = new Book();
		try {
			List books = this.getHibernateTemplate().find(hql.toString(), bookView.getBookId());
			book = (Book)books.listIterator().next();
		} catch (Exception e){
			e.printStackTrace();
			throw new Exception(e);
		}
		return book;
	}

}
