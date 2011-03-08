package com.huan.library.domain.model.dict;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

import com.huan.library.domain.model.book.Book;

/**
 * 币种
 * @author shuaizhichun
 * @time 2011-3-6 下午10:30:24
 */
@Entity  
@DiscriminatorValue("Currency")
public class Currency extends DictItem {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Currency(){
		super();
	}
	
	@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.LAZY,mappedBy="currency")
   	private List<Book> books = new ArrayList<Book>();  //图书
	
	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

}
