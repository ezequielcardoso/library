package com.huan.library.domain.model.dict;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

import com.huan.library.domain.model.book.Book;

/**
 * 图书来源
 * @author huan
 * @time 2011-3-8  上午11:13:59
 */
public class Resource extends DictItem {
    /**
     * 
     */
	private static final long serialVersionUID = 1L;
	
	public Resource(){
		super();
	}
	
	@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.LAZY,mappedBy="resource")
	private Set<Book> books;   //图书
	
	public Set<Book> getBooks() {
		return books;
	}

	public void setBooks(Set<Book> books) {
		this.books = books;
	}

}
