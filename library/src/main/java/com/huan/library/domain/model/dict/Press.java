package com.huan.library.domain.model.dict;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.huan.library.domain.model.book.Book;
/**
 * 出版社
 * @author huan
 * @time 2011-3-8  上午11:02:10
 */
@Entity
public class Press implements Serializable{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;       //主键
    
	private String pressAddress; //地址
    
	private String pressId; //ISBN

	private String pressName; //出版社名称

	private String zipCode;   //邮编
	
	@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.LAZY,mappedBy="press")
	private Set<Book> books;   //图书
	
	public Set<Book> getBooks() {
		return books;
	}

	public void setBooks(Set<Book> books) {
		this.books = books;
	}

	public int getId() {
		return id;
	}

	public String getPressAddress() {
		return pressAddress;
	}

	public String getPressId() {
		return pressId;
	}

	public String getPressName() {
		return pressName;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setPressAddress(String pressAddress) {
		this.pressAddress = pressAddress;
	}

	public void setPressId(String pressId) {
		this.pressId = pressId;
	}
    
    public void setPressName(String pressName) {
		this.pressName = pressName;
	}
    
    public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
}
