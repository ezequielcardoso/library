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
	private Long id; // 主键
	private String readerCateCode; // 类别编码
	private String readerCateName; // 类别名称
	private Integer maxBorrowDays; // 借阅天数
	private Integer maxBorrowedQuantity; // 借阅数量
	private Float rent =0.2f ; // 租金

	public ReaderType() {
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
