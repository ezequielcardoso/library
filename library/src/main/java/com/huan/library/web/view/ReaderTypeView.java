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
	private Integer maxBorrowDays = 0; // 借阅天数
	private Integer maxBorrowedQuantity =0; // 借阅数量
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

	public Integer getMaxBorrowDays() {
		return maxBorrowDays;
	}

	public void setMaxBorrowDays(Integer maxBorrowDays) {
		this.maxBorrowDays = maxBorrowDays;
	}

	public Integer getMaxBorrowedQuantity() {
		return maxBorrowedQuantity;
	}

	public void setMaxBorrowedQuantity(Integer maxBorrowedQuantity) {
		this.maxBorrowedQuantity = maxBorrowedQuantity;
	}

	public Float getRent() {
		return rent;
	}

	public void setRent(Float rent) {
		this.rent = rent;
	}
	

}
