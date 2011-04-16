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
			hql.append(" select new Book( b.bookId, b.barCode, b.bookName, b.bookDesc, b.donator, b.author, b.translator, b.ISBN, " +
					" b.ISSN, b.emailNo, b.stage, b.allStage, b.pages, b.price, b.publisherDate, " +
				" b.quantity, b.location, b.revision, b.searchBookId, b.speciesId, b.spell, b.orderDate, b.operator, b.storeDate," + 
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
			if(bookView.getBarCode()!=null && !"".equals(bookView.getBarCode())){
				whereSub.append(" and b.barCode = (:barCode) ");
			}
			if(bookView.getBookName()!=null && !"".equals(bookView.getBookName())){
				whereSub.append(" and b.bookName like (:bookName) ");
			}
			if(bookView.getSpell()!=null && !"".equals(bookView.getSpell())){
				whereSub.append(" and b.spell like (:spell) ");
			}
			if(bookView.getPressName()!=null && !"".equals(bookView.getPressName())){
				whereSub.append(" and t_pr.pressName like (:press) ");
			}
			if(bookView.getLocation()!=null && !"".equals(bookView.getLocation())){
				whereSub.append(" and b.location like (:location) ");
			}
			if(bookView.getBookNo()!=null && !"".equals(bookView.getBookNo())){
				whereSub.append(" and b.bookNo like (:bookNo) ");
			}
			if(bookView.getSearchBookId()!=null && !"".equals(bookView.getSearchBookId())){
				whereSub.append(" and b.searchBookId like (:searchBookId) ");
			}
			if(bookView.getSpeciesId()!=null && !"".equals(bookView.getSpeciesId())){
				whereSub.append(" and b.speciesId like (:speciesId) ");
			}
			if(bookView.getFirstCategoryName()!=null&&!"".equals(bookView.getFirstCategoryName())){
				whereSub.append(" and t_fc.itemName like (:firstCategory) ");
			}
			if(bookView.getSecondCategoryName()!=null&&!"".equals(bookView.getSecondCategoryName())){
				whereSub.append(" and t_cc.itemName like (:secondCategory) ");
			}
			if(bookView.getAuthor()!=null && !"".equals(bookView.getAuthor())){
				whereSub.append(" and b.author like (:author) ");
			}
			if(bookView.getOperator()!=null && !"".equals(bookView.getOperator())){
				whereSub.append(" and b.operator like (:operator) ");
			}
			if(bookView.getBookStateName()!=null && !"".equals(bookView.getBookStateName())){
				whereSub.append(" and t_st.itemName = (:bookStateName) ");
			}
			if(bookView.getEmailNo()!=null&&!"".equals(bookView.getEmailNo())){
				whereSub.append(" and b.emailNo like (:emailNo) ");
			}
			if(bookView.getISSN()!=null&&!"".equals(bookView.getISSN())){
				whereSub.append(" and b.ISSN like (:ISSN) ");
			}
			if(bookView.getStoreDate()!=null && bookView.getEndStoreDate()==null){
				whereSub.append(" and b.storeDate =(:storeDate) ");
			}
			if(bookView.getStoreDate()==null && bookView.getEndStoreDate()!=null){
				whereSub.append(" and b.storeDate =(:endStoreDate) ");
			}
			if(bookView.getStoreDate()!=null && bookView.getEndStoreDate()!=null){
				whereSub.append(" and b.storeDate between (:storeDate) and (:endStoreDate) ");
			}
			if(bookView.getOrderDate()!=null && bookView.getEndOrderDate()==null){
				whereSub.append(" and b.orderDate =(:orderDate) ");
			}
			if(bookView.getOrderDate()==null && bookView.getEndOrderDate()!=null){
				whereSub.append(" and b.orderDate =(:endOrderDate) ");
			}
			if(bookView.getOrderDate()!=null && bookView.getEndOrderDate()!=null){
				whereSub.append(" and b.orderDate between (:orderDate) and (:endOrderDate) ");
			}
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
						query.setParameter("isBook", bookView.getIsBook());
						String temp = "";
						if(bookView.getBarCode()!=null && !"".equals(bookView.getBarCode())){
							query.setParameter("barCode", bookView.getBarCode());
						}
						if(bookView.getBookName()!=null && !"".equals(bookView.getBookName())){
							temp = "%"+bookView.getBookName().replace(" ", "%")+"%";
							query.setParameter("bookName",temp);
						}
						if(bookView.getSpell()!=null && !"".equals(bookView.getSpell())){
							temp = "%"+bookView.getSpell().replace(" ", "%")+"%";
							query.setParameter("spell",temp);
						}
						if(bookView.getPressName()!=null && !"".equals(bookView.getPressName())){
							temp = "%"+bookView.getPressName().replace(" ", "%")+"%";
							query.setParameter("press", temp);
						}
						if(bookView.getLocation()!=null && !"".equals(bookView.getLocation())){
							temp = "%"+bookView.getLocation().replace(" ", "%")+"%";
							query.setParameter("location", temp);
						}
						if(bookView.getBookNo()!=null && !"".equals(bookView.getBookNo())){
							temp = "%"+bookView.getBookNo().replace(" ", "%")+"%";
							query.setParameter("bookNo", temp);
						}
						if(bookView.getSearchBookId()!=null && !"".equals(bookView.getSearchBookId())){
							temp = "%"+bookView.getSearchBookId().replace(" ", "%")+"%";
							query.setParameter("searchBookId", temp);
						}
						if(bookView.getSpeciesId()!=null && !"".equals(bookView.getSpeciesId())){
							temp = "%"+bookView.getSpeciesId().replace(" ", "%")+"%";
							query.setParameter("speciesId", temp);
						}
						if(bookView.getFirstCategoryName()!=null&&!"".equals(bookView.getFirstCategoryName())){
							temp = "%"+bookView.getFirstCategoryName().replace(" ", "%")+"%";
							query.setParameter("firstCategory", temp);
						}
						if(bookView.getSecondCategoryName()!=null&&!"".equals(bookView.getSecondCategoryName())){
							temp = "%"+bookView.getSecondCategoryName().replace(" ", "%")+"%";
							query.setParameter("secondCategory", temp);
						}
						if(bookView.getAuthor()!=null && !"".equals(bookView.getAuthor())){
							temp = "%"+bookView.getAuthor().replace(" ", "%")+"%";
							query.setParameter("author", temp);
						}
						if(bookView.getOperator()!=null && !"".equals(bookView.getOperator())){
							temp = "%"+bookView.getTranslator().replace(" ", "%")+"%";
							query.setParameter("operator", temp);
						}
						if(bookView.getBookStateName()!=null && !"".equals(bookView.getBookStateName())){
							query.setParameter("bookStateName", bookView.getBookStateName());
						}
						if(bookView.getEmailNo()!=null && !"".equals(bookView.getEmailNo())){
							temp = "%"+bookView.getEmailNo().replace(" ", "%")+"%";
							query.setParameter("emailNo", temp);
						}
						if(bookView.getISSN()!=null && !"".equals(bookView.getISSN())){
							temp = "%"+bookView.getISSN().replace(" ", "%")+"%";
							query.setParameter("ISSN", temp);
						}
						if(bookView.getStoreDate()!=null && bookView.getEndStoreDate()==null){
							query.setParameter("storeDate", bookView.getStoreDate());
						}
						if(bookView.getStoreDate()==null && bookView.getEndStoreDate()!=null){
							query.setParameter("endStoreDate", bookView.getEndStoreDate());
						}
						if(bookView.getStoreDate()!=null && bookView.getEndStoreDate()!=null){
							query.setParameter("storeDate", bookView.getStoreDate());
							query.setParameter("endStoreDate", bookView.getEndStoreDate());
						}
						if(bookView.getOrderDate()!=null && bookView.getEndOrderDate()==null){
							query.setParameter("orderDate", bookView.getOrderDate());
						}
						if(bookView.getOrderDate()==null && bookView.getEndOrderDate()!=null){
							query.setParameter("endOrderDate", bookView.getEndOrderDate());
						}
						if(bookView.getOrderDate()!=null && bookView.getEndOrderDate()!=null){
							query.setParameter("orderDate", bookView.getOrderDate());
							query.setParameter("endOrderDate", bookView.getEndOrderDate());
						}
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
						if(bookView!=null && bookView.getIsPage()
								&& bookView.getStart()!=null && bookView.getLimit()!=null ){
							query.setMaxResults(bookView.getLimit());
							query.setFirstResult(bookView.getStart());
						}
//						//设置查询参数
						query.setParameter("isBook", bookView.getIsBook());
						String temp = "";
						if(bookView.getBarCode()!=null && !"".equals(bookView.getBarCode())){
							query.setParameter("barCode", bookView.getBarCode());
						}
						if(bookView.getBookName()!=null && !"".equals(bookView.getBookName())){
							temp = "%"+bookView.getBookName().replace(" ", "%")+"%";
							query.setParameter("bookName",temp);
						}
						if(bookView.getSpell()!=null && !"".equals(bookView.getSpell())){
							temp = "%"+bookView.getSpell().replace(" ", "%")+"%";
							query.setParameter("spell",temp);
						}
						if(bookView.getPressName()!=null && !"".equals(bookView.getPressName())){
							temp = "%"+bookView.getPressName().replace(" ", "%")+"%";
							query.setParameter("press", temp);
						}
						if(bookView.getLocation()!=null && !"".equals(bookView.getLocation())){
							temp = "%"+bookView.getLocation().replace(" ", "%")+"%";
							query.setParameter("location", temp);
						}
						if(bookView.getBookNo()!=null && !"".equals(bookView.getBookNo())){
							temp = "%"+bookView.getBookNo().replace(" ", "%")+"%";
							query.setParameter("bookNo", temp);
						}
						if(bookView.getSearchBookId()!=null && !"".equals(bookView.getSearchBookId())){
							temp = "%"+bookView.getSearchBookId().replace(" ", "%")+"%";
							query.setParameter("searchBookId", temp);
						}
						if(bookView.getSpeciesId()!=null && !"".equals(bookView.getSpeciesId())){
							temp = "%"+bookView.getSpeciesId().replace(" ", "%")+"%";
							query.setParameter("speciesId", temp);
						}
						if(bookView.getFirstCategoryName()!=null&&!"".equals(bookView.getFirstCategoryName())){
							temp = "%"+bookView.getFirstCategoryName().replace(" ", "%")+"%";
							query.setParameter("firstCategory", temp);
						}
						if(bookView.getSecondCategoryName()!=null&&!"".equals(bookView.getSecondCategoryName())){
							temp = "%"+bookView.getSecondCategoryName().replace(" ", "%")+"%";
							query.setParameter("secondCategory", temp);
						}
						if(bookView.getOperator()!=null && !"".equals(bookView.getOperator())){
							temp = "%"+bookView.getTranslator().replace(" ", "%")+"%";
							query.setParameter("operator", temp);
						}
						if(bookView.getBookStateName()!=null && !"".equals(bookView.getBookStateName())){
							query.setParameter("bookStateName", bookView.getBookStateName());
						}
						if(bookView.getTranslator()!=null && !"".equals(bookView.getTranslator())){
							temp = "%"+bookView.getTranslator().replace(" ", "%")+"%";
							query.setParameter("translator", temp);
						}
						if(bookView.getEmailNo()!=null && !"".equals(bookView.getEmailNo())){
							temp = "%"+bookView.getEmailNo().replace(" ", "%")+"%";
							query.setParameter("emailNo", temp);
						}
						if(bookView.getISSN()!=null && !"".equals(bookView.getISSN())){
							temp = "%"+bookView.getISSN().replace(" ", "%")+"%";
							query.setParameter("ISSN", temp);
						}
						if(bookView.getStoreDate()!=null && bookView.getEndStoreDate()==null){
							query.setParameter("storeDate", bookView.getStoreDate());
						}
						if(bookView.getStoreDate()==null && bookView.getEndStoreDate()!=null){
							query.setParameter("endStoreDate", bookView.getEndStoreDate());
						}
						if(bookView.getStoreDate()!=null && bookView.getEndStoreDate()!=null){
							query.setParameter("storeDate", bookView.getStoreDate());
							query.setParameter("endStoreDate", bookView.getEndStoreDate());
						}
						if(bookView.getOrderDate()!=null && bookView.getEndOrderDate()==null){
							query.setParameter("orderDate", bookView.getOrderDate());
						}
						if(bookView.getOrderDate()==null && bookView.getEndOrderDate()!=null){
							query.setParameter("endOrderDate", bookView.getEndOrderDate());
						}
						if(bookView.getOrderDate()!=null && bookView.getEndOrderDate()!=null){
							query.setParameter("orderDate", bookView.getOrderDate());
							query.setParameter("endOrderDate", bookView.getEndOrderDate());
						}
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
		hql.append(" where b.bookId = ? ");
		Book book = new Book();
		try {
			book = (Book) this.getHibernateTemplate().find(hql.toString(), bookId).listIterator().next();
		} catch (Exception e){
			e.printStackTrace();
			throw new Exception(e);
		}
		return book;
	}
	
	public Book selectBookByBarCode(String barCode) throws Exception {
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
		hql.append(" where b.barCode = ? ");
		Book book = new Book();
		try {
			book = (Book) this.getHibernateTemplate().find(hql.toString(), barCode).listIterator().next();
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
