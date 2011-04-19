package com.huan.library.web.view;

import java.io.Serializable;
import java.util.Date;

import com.huan.library.web.view.grid.ExtGridPost;

public class PreOrderView extends ExtGridPost implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long id; //主键
    
	private Date preOrderDate;       //预约日期
	private Date endPreOrderDate;
	private Date preOrderEndDate;    //预约到期日期
	private Date endPreOrderEndDate; 
	
    private Long bookId; // 图书主键
    private String bookNo; // 图书编号
	private String bookBarCode; //条形码
	private String bookName; //图书名字 
	private String location; //存放位置
	private Integer isBook; //是图书 还是期刊
	
	private String firstCategoryId;
	private String firstCategoryCode;
	private String firstCategoryName; // 图书分类
	
	private String bookStateId;
	private String bookStateName; // 图书状态
	

    private Long readerId; // 读者主键
    private String cardNo; //借阅证号
    private String readerBarCode;        //条形码
    private String readerName;  // 读者姓名
	
	private Long unitId; 
	private String unitCode;
	private String unitName;     //读者单位 
	
	private Long readerTypeId; 
	private String readerCateCode; 
	private String readerCateName; // 读者类别
	
    
	public PreOrderView(){
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getPreOrderDate() {
		return preOrderDate;
	}

	public void setPreOrderDate(Date preOrderDate) {
		this.preOrderDate = preOrderDate;
	}

	public Date getPreOrderEndDate() {
		return preOrderEndDate;
	}

	public void setPreOrderEndDate(Date preOrderEndDate) {
		this.preOrderEndDate = preOrderEndDate;
	}

	public Long getBookId() {
		return bookId;
	}

	public void setBookId(Long bookId) {
		this.bookId = bookId;
	}

	public String getBookNo() {
		return bookNo;
	}

	public void setBookNo(String bookNo) {
		this.bookNo = bookNo;
	}

	public String getBookBarCode() {
		return bookBarCode;
	}

	public void setBookBarCode(String bookBarCode) {
		this.bookBarCode = bookBarCode;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Integer getIsBook() {
		return isBook;
	}

	public void setIsBook(Integer isBook) {
		this.isBook = isBook;
	}

	public String getFirstCategoryId() {
		return firstCategoryId;
	}

	public void setFirstCategoryId(String firstCategoryId) {
		this.firstCategoryId = firstCategoryId;
	}

	public String getFirstCategoryCode() {
		return firstCategoryCode;
	}

	public void setFirstCategoryCode(String firstCategoryCode) {
		this.firstCategoryCode = firstCategoryCode;
	}

	public String getFirstCategoryName() {
		return firstCategoryName;
	}

	public void setFirstCategoryName(String firstCategoryName) {
		this.firstCategoryName = firstCategoryName;
	}

	public String getBookStateId() {
		return bookStateId;
	}

	public void setBookStateId(String bookStateId) {
		this.bookStateId = bookStateId;
	}

	public String getBookStateName() {
		return bookStateName;
	}

	public void setBookStateName(String bookStateName) {
		this.bookStateName = bookStateName;
	}

	public Long getReaderId() {
		return readerId;
	}

	public void setReaderId(Long readerId) {
		this.readerId = readerId;
	}

	public String getCardNo() {
		return cardNo;
	}

	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}
	
	

	public Date getEndPreOrderDate() {
		return endPreOrderDate;
	}

	public void setEndPreOrderDate(Date endPreOrderDate) {
		this.endPreOrderDate = endPreOrderDate;
	}

	public Date getEndPreOrderEndDate() {
		return endPreOrderEndDate;
	}

	public void setEndPreOrderEndDate(Date endPreOrderEndDate) {
		this.endPreOrderEndDate = endPreOrderEndDate;
	}

	public String getReaderBarCode() {
		return readerBarCode;
	}

	public void setReaderBarCode(String readerBarCode) {
		this.readerBarCode = readerBarCode;
	}

	public String getReaderName() {
		return readerName;
	}

	public void setReaderName(String readerName) {
		this.readerName = readerName;
	}

	public Long getUnitId() {
		return unitId;
	}

	public void setUnitId(Long unitId) {
		this.unitId = unitId;
	}

	public String getUnitCode() {
		return unitCode;
	}

	public void setUnitCode(String unitCode) {
		this.unitCode = unitCode;
	}

	public String getUnitName() {
		return unitName;
	}

	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}

	public Long getReaderTypeId() {
		return readerTypeId;
	}

	public void setReaderTypeId(Long readerTypeId) {
		this.readerTypeId = readerTypeId;
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
}
