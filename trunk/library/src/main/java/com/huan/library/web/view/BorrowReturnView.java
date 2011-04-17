package com.huan.library.web.view;

import java.io.Serializable;

import com.huan.library.web.view.form.ExtJsonForm;

public class BorrowReturnView extends ExtJsonForm implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long id; //主键
	private String borrowedDate;       //借阅日期
	private String duetoReturnDate;    //应还日期
	private String realityReturndate;  //实还日期
	private Integer overdueDays;         //逾期天数
	private Float puniMoney = 0F;        //罚金
	private Integer isPay ;         //是或缴款  1表示是缴款  0表示没
	private Integer   renewTimes ;        //续借次数

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
	
	private String borrowOperator;          //借阅操作员
	private String returnOperator;          //归还操作员 
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getBorrowedDate() {
		return borrowedDate;
	}
	public void setBorrowedDate(String borrowedDate) {
		this.borrowedDate = borrowedDate;
	}
	public String getDuetoReturnDate() {
		return duetoReturnDate;
	}
	public void setDuetoReturnDate(String duetoReturnDate) {
		this.duetoReturnDate = duetoReturnDate;
	}
	public String getRealityReturndate() {
		return realityReturndate;
	}
	public void setRealityReturndate(String realityReturndate) {
		this.realityReturndate = realityReturndate;
	}
	public Integer getOverdueDays() {
		return overdueDays;
	}
	public void setOverdueDays(Integer overdueDays) {
		this.overdueDays = overdueDays;
	}
	public Float getPuniMoney() {
		return puniMoney;
	}
	public void setPuniMoney(Float puniMoney) {
		this.puniMoney = puniMoney;
	}
	public Integer getIsPay() {
		return isPay;
	}
	public void setIsPay(Integer isPay) {
		this.isPay = isPay;
	}
	public Integer getRenewTimes() {
		return renewTimes;
	}
	public void setRenewTimes(Integer renewTimes) {
		this.renewTimes = renewTimes;
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
	
	public Integer getIsBook() {
		return isBook;
	}
	public void setIsBook(Integer isBook) {
		this.isBook = isBook;
	}
	public String getCardNo() {
		return cardNo;
	}
	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}
	public String getReaderBarCode() {
		return readerBarCode;
	}
	public void setReaderBarCode(String readerBarCode) {
		this.readerBarCode = readerBarCode;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
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
	public String getBorrowOperator() {
		return borrowOperator;
	}
	public void setBorrowOperator(String borrowOperator) {
		this.borrowOperator = borrowOperator;
	}
	public String getReturnOperator() {
		return returnOperator;
	}
	public void setReturnOperator(String returnOperator) {
		this.returnOperator = returnOperator;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	
}
