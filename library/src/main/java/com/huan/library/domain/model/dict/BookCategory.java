package com.huan.library.domain.model.dict;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.huan.library.domain.model.book.Book;

/**
 * 图书分类
 * @author huan
 * @time 2011-3-8  下午03:24:33
 */
@Entity
public class BookCategory implements Serializable{ 

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int categoryId;    //主键
	private String categoryCode; //分类代码
	private String categoryName;  //分类名称
	@ManyToOne(targetEntity=BookCategory.class,fetch=FetchType.LAZY)
	@JoinColumn(name="parentCateId",referencedColumnName="categoryId")
	private BookCategory parent;   //上级分类
	@OneToMany(targetEntity=BookCategory.class,fetch=FetchType.LAZY)
	@JoinColumn(name="categoryId")
	private List<BookCategory> children = new ArrayList<BookCategory>(); //下级分类 
	
	public List<BookCategory> getChildren() {
		return children;
	}

	public void setChildren(List<BookCategory> children) {
		this.children = children;
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

	@OneToMany(cascade={CascadeType.ALL},fetch=FetchType.LAZY,mappedBy="bookCategory")
	private List<Book> books = new ArrayList<Book>();  //图书
	
	
	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryCode() {
		return categoryCode;
	}

	public void setCategoryCode(String categoryCode) {
		this.categoryCode = categoryCode;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public BookCategory getParent() {
		return parent;
	}

	public void setParent(BookCategory parent) {
		this.parent = parent;
	}


    
}
