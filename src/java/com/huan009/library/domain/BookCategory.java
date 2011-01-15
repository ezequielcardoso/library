package com.huan009.library.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 图书分类
 * @author huan
 *
 */
@Entity @Table(name="t_bookCategory")
public class BookCategory {

	/**
	 * 分类编号
	 */
	private int categoryId;
	/**
	 * 分类名称
	 */
	private String categoryName;
	/**
	 * 可借天数
	 */
	private int canBorrowedDays;
	/**
	 * 罚款金额
	 */
	private float fk;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="category_id")
	public int getCategoryId() {
		return categoryId;
	}
	
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	
	@Column(name="category_name",nullable=false,length=20)
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	
	@Column(name="can_borrowed_days")
	public int getCanBorrowedDays() {
		return canBorrowedDays;
	}
	
	public void setCanBorrowedDays(int canBorrowedDays) {
		this.canBorrowedDays = canBorrowedDays;
	}
	
	public float getFk() {
		return fk;
	}
	public void setFk(float fk) {
		this.fk = fk;
	}
}
