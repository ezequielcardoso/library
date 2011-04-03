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
	private String categoryId;    //主键
	
	private String categoryCode; //分类代码
	private String categoryName;  //分类名称
	private Long categoryOrder;//分类排序
	
	@ManyToOne(targetEntity=Category.class,fetch=FetchType.LAZY,cascade={CascadeType.MERGE,CascadeType.REMOVE})
	@JoinColumn(name="parentCateId",referencedColumnName="categoryId")
	private Category parent;   //上级分类
	
	@OneToMany(targetEntity=Category.class,mappedBy="parent")
	private List<Category> children = new ArrayList<Category>(); //下级分类 
	
    public Category(){
		
	}
	public String getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}
    
	public List<Category> getChildren() {
		return children;
	}

	public void setChildren(List<Category> children) {
		this.children = children;
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
	public Long getCategoryOrder() {
		return categoryOrder;
	}
	public void setCategoryOrder(Long categoryOrder) {
		this.categoryOrder = categoryOrder;
	}

}
