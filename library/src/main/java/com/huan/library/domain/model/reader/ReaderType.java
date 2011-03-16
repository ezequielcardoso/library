package com.huan.library.domain.model.reader;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
/**
 * 读者类别
 * @author huan
 * @time 2011-3-8 下午08:55:26
 */
@Entity
public class ReaderType implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id; // 主键
	private String readerCateCode; // 类别编码
	private String readerCateName; // 类别名称
	private int borrowDays; // 借阅天数
	private int borrowedQuantity; // 借阅数量
	private float rent; // 租金

	public ReaderType() {

	}

	public float getRent() {
		return rent;
	}

	public void setRent(float rent) {
		this.rent = rent;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	public String getReaderCateCode() {
		return readerCateCode;
	}

	public void setReaderCateCode(String readerCateCode) {
		this.readerCateCode = readerCateCode;
	}

	public String getReaderCateName() {
		return readerCateName;
	}

	public void setReaderCateName(String readerCateName) {
		this.readerCateName = readerCateName;
	}

	public int getBorrowDays() {
		return borrowDays;
	}

	public void setBorrowDays(int borrowDays) {
		this.borrowDays = borrowDays;
	}

	public int getBorrowedQuantity() {
		return borrowedQuantity;
	}

	public void setBorrowedQuantity(int borrowedQuantity) {
		this.borrowedQuantity = borrowedQuantity;
	}
}
