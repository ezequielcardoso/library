package com.huan.library.domain.model.dict;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.huan.library.domain.model.book.Book;

/**
 * 图书级别
 * @author huan
 * @time 2011-3-8  上午11:02:32
 */
@Entity
@DiscriminatorValue("BookLevel")
public class BookLevel extends DictItem {
	
    /**
     * 
     */
	private static final long serialVersionUID = 1L;
    
	public BookLevel(){
		super();
	}
	
	@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.LAZY,mappedBy="bookLevel")
   	private List<Book> books = new ArrayList<Book>();  //图书
	
	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}


}
