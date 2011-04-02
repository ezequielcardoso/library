package com.huan.library.web.view;

import java.io.Serializable;

import com.huan.library.web.view.grid.ExtGridPost;
/**
 * 分类视图
 * @author huan
 * @time 2011-4-1 下午10:12:07
 */
public class CategoryView extends ExtGridPost implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String categoryId;
	private String categoryCode;
	private String categoryName;
	private String parentCategoryId;
	
	public CategoryView(){
		super();
	}
	
	public String getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(String categoryId) {
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
	public String getParentCategoryId() {
		return parentCategoryId;
	}
	public void setParentCategoryId(String parentCategoryId) {
		this.parentCategoryId = parentCategoryId;
	}
}
