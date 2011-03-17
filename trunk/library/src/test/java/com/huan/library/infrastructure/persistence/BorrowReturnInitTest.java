package com.huan.library.infrastructure.persistence;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import com.huan.library.application.BaseSpringBeans;
import com.huan.library.domain.model.book.Book;
import com.huan.library.domain.model.borrowReturn.BorrowReturn;
import com.huan.library.domain.model.reader.ReaderCard;

/**
 * ΩË‘ƒπÈªπdao≤‚ ‘
 * 
 * @author huan
 * @time 2011-3-17 œ¬ŒÁ07:22:54
 */
public class BorrowReturnInitTest {

	private static BorrowReturnDao borrowReturnDao;
	private static ReaderCardDao readerCardDao;
	private static BookDao bookDao;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		borrowReturnDao = (BorrowReturnDao) BaseSpringBeans.getInstance()
				.getBean("borrowReturnDao");
		readerCardDao = (ReaderCardDao) BaseSpringBeans.getInstance().getBean(
				"readerCardDao");
		bookDao = (BookDao) BaseSpringBeans.getInstance().getBean("bookDao");
	}
    @Test
	public void testBorrow() {
		try {
			BorrowReturn borrowReturn = new BorrowReturn();

			// ΩË‘ƒ÷§
			ReaderCard readerCard = readerCardDao.selectById(1);
			borrowReturn.setReaderCard(readerCard);
			System.out.println(readerCard.getPassword());

			// Õº È
			List<Book> books = new ArrayList<Book>();
			Book book = bookDao.selectById(1);
			books.add(book);
			borrowReturn.setBooks(books);

			borrowReturn.setBorrowedDate(new Date());
			borrowReturn.setDuetoReturnDate(new Date(5013 - 2 - 2));
			borrowReturn.setOperator(null);

			borrowReturnDao.saveOrUpdate(borrowReturn);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
