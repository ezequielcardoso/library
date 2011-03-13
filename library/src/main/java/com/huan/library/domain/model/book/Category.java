package com.huan.library.domain.model.book;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


/**
 * 图书分类
 * @author huan
 * @time 2011-3-8  下午03:24:33
 */
@Entity
public class Category implements Serializable{ 

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int categoryId;    //主键
	private String categoryCode; //分类代码
	private String categoryName;  //分类名称
	
	@ManyToOne(targetEntity=Category.class,fetch=FetchType.LAZY,cascade={CascadeType.MERGE,CascadeType.REMOVE})
	@JoinColumn(name="parentCateId")
	private Category parent;   //上级分类
	
	@OneToMany(targetEntity=Category.class,fetch=FetchType.LAZY,mappedBy="parent")
	private List<Category> children = new ArrayList<Category>(); //下级分类 
	
	public List<Category> getChildren() {
		return children;
	}

	public void setChildren(List<Category> children) {
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

	public Category getParent() {
		return parent;
	}

	public void setParent(Category parent) {
		this.parent = parent;
	}


    
}
