package com.huan.library.domain.model.dict;



import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

import com.huan.library.domain.model.book.Book;

/**
 * 附件名称dvd/vcd/cd/src...
 * @author huan
 * @time 2011-3-8  上午11:06:21
 */
@Entity
@DiscriminatorValue("Attachment")
public class Attachment extends DictItem {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    
	@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.LAZY,mappedBy="attachment")
   	private List<Book> books = new ArrayList<Book>();  //图书
	
	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

	public Attachment(){
		super();
	}

}
