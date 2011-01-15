package com.huan009.library.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * ͼ�����
 * @author huan
 *
 */
@Entity @Table(name="t_bookCategory")
public class BookCategory {

	/**
	 * ������
	 */
	private int categoryId;
	/**
	 * ��������
	 */
	private String categoryName;
	/**
	 * �ɽ�����
	 */
	private int canBorrowedDays;
	/**
	 * ������
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
