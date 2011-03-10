package com.huan.library.infrastructure.persistence;

import java.util.List;

import com.huan.library.domain.model.book.Book;
import com.huan.library.domain.model.rights.Department;

/**
 * 图书dao
 * @author huan
 * @time  2011-3-10 上午07:11:18
 */
public interface BookDao {
    
	/**
     * 增加或者修改图书 
     * @param book
     * @return
     */
	public boolean saveOrUpdateDept(Book book);
	
	/**
	 * 删除图书
	 * @param book
	 * @return
	 */
    public boolean deleteBook(Book book);
	
	/**
	 * 根据Id查找Book
	 * @param bookId
	 * @return
	 */
	public Book selectBookById(String bookId);
	
	/**
	 * 查找所有的Book
	 * @return
	 */
	public List<Book> selectAllBooks();
	
	
}	