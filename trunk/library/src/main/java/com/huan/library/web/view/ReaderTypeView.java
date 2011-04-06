package com.huan.library.web.view;

import java.io.Serializable;

import com.huan.library.web.view.grid.ExtGridPost;
/**
 * 读者类别
 * @author huan
 * @time  2011-4-6 下午12:51:28
 */
public class ReaderTypeView extends ExtGridPost implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long id; // 主键
	private String readerCateCode; // 类别编码
	private String readerCateName; // 类别名称
	private Integer borrowDays = 0; // 借阅天数
	private Integer borrowedQuantity =0; // 借阅数量
	private Float rent; // 租金
	
	public ReaderTypeView(){
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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

	public Integer getBorrowDays() {
		return borrowDays;
	}

	public void setBorrowDays(Integer borrowDays) {
		this.borrowDays = borrowDays;
	}

	public Integer getBorrowedQuantity() {
		return borrowedQuantity;
	}

	public void setBorrowedQuantity(Integer borrowedQuantity) {
		this.borrowedQuantity = borrowedQuantity;
	}

	public Float getRent() {
		return rent;
	}

	public void setRent(Float rent) {
		this.rent = rent;
	}
	

}
