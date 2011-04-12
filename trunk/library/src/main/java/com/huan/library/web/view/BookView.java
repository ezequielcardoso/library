package com.huan.library.web.view;

import java.io.Serializable;
import java.util.Date;

import com.huan.library.web.view.grid.ExtGridPost;

/**
 * 图书信息
 * @author huan
 * @time 2011-3-8 上午10:55:59
 */
public class BookView extends ExtGridPost implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long bookId; // 主键
	private String barCode; // 条形码
	private String bookName; // 书刊名字
	private String bookDesc; // 图书简介
	private String donator; // 捐赠人
	private String author ; //作者
    private String translator; //译者 
	private String ISBN; // ISBN
	private String ISSN; // 国内统一刊号
	private String emailNo; // 邮发代码
	private String stage; // 第几期
	private String allStage; // 总第几期
	private Integer pages; // 页数
	private Float price; // 价格
	private Date publisherDate; // 出版日期
	private Integer quantity; // 数量
	private String location; //存放位置
	private Integer revision; // 版次
	private String searchBookId; // 索书号
	private String speciesId; // 种次号
	private String spell; // 拼音
	private Date storeDate; // 入库时间
	private Date endStoreDate; //结束时间  检索图书入库的统计的
	private String bookNo; // 图书编号
	private String operator;  //录入人员
	private Integer isBook; // 类型1:表示图书 0:表示期刊

	private String firstCategoryId;
	private String firstCategoryCode;
	private String firstCategoryName; // 图书分类
	private String secondCategoryId;
	private String secondCategoryCode;
	private String secondCategoryName; // 图书分类
	private String thirdCategoryId;
	private String thirdCategoryCode;
	private String thirdCategoryName; // 图书分类
	private String hasAttachment;//是否有附件，不为null或者""表示有
	private String bookStateId;
	private String bookStateName; // 图书状态
	private String bookLevelId;
	private String bookLevelName; // 图书级别
	private String bookSecurityId;
	private String bookSecurityName;   //图书密级
	private String currencyId;
	private String currencyName; // 币种
	private Long pressId;
	private String pressName; // 出版社
	private String bookSourceId;
	private String bookSourceName; // 来源
	
	public BookView(){
		super();
	}

	public Long getBookId() {
		return bookId;
	}

	public void setBookId(Long bookId) {
		this.bookId = bookId;
	}

	public String getBarCode() {
		return barCode;
	}

	public void setBarCode(String barCode) {
		this.barCode = barCode;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getBookDesc() {
		return bookDesc;
	}

	public void setBookDesc(String bookDesc) {
		this.bookDesc = bookDesc;
	}

	public String getDonator() {
		return donator;
	}

	public void setDonator(String donator) {
		this.donator = donator;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getTranslator() {
		return translator;
	}

	public void setTranslator(String translator) {
		this.translator = translator;
	}

	public String getISBN() {
		return ISBN;
	}

	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}

	public String getISSN() {
		return ISSN;
	}

	public void setISSN(String iSSN) {
		ISSN = iSSN;
	}

	public String getEmailNo() {
		return emailNo;
	}

	public void setEmailNo(String emailNo) {
		this.emailNo = emailNo;
	}

	public String getStage() {
		return stage;
	}

	public void setStage(String stage) {
		this.stage = stage;
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	public String getAllStage() {
		return allStage;
	}

	public void setAllStage(String allStage) {
		this.allStage = allStage;
	}

	public Integer getPages() {
		return pages;
	}

	public void setPages(Integer pages) {
		this.pages = pages;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public Date getPublisherDate() {
		return publisherDate;
	}

	public void setPublisherDate(Date publisherDate) {
		this.publisherDate = publisherDate;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Integer getRevision() {
		return revision;
	}

	public void setRevision(Integer revision) {
		this.revision = revision;
	}

	public String getSearchBookId() {
		return searchBookId;
	}

	public void setSearchBookId(String searchBookId) {
		this.searchBookId = searchBookId;
	}

	public String getSpeciesId() {
		return speciesId;
	}

	public void setSpeciesId(String speciesId) {
		this.speciesId = speciesId;
	}

	public String getSpell() {
		return spell;
	}

	public void setSpell(String spell) {
		this.spell = spell;
	}

	public Date getStoreDate() {
		return storeDate;
	}

	public void setStoreDate(Date storeDate) {
		this.storeDate = storeDate;
	}

	public String getBookNo() {
		return bookNo;
	}

	public void setBookNo(String bookNo) {
		this.bookNo = bookNo;
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
	

	public Date getEndStoreDate() {
		return endStoreDate;
	}

	public void setEndStoreDate(Date endStoreDate) {
		this.endStoreDate = endStoreDate;
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

	public String getSecondCategoryId() {
		return secondCategoryId;
	}

	public void setSecondCategoryId(String secondCategoryId) {
		this.secondCategoryId = secondCategoryId;
	}

	public String getSecondCategoryCode() {
		return secondCategoryCode;
	}

	public void setSecondCategoryCode(String secondCategoryCode) {
		this.secondCategoryCode = secondCategoryCode;
	}

	public String getSecondCategoryName() {
		return secondCategoryName;
	}

	public void setSecondCategoryName(String secondCategoryName) {
		this.secondCategoryName = secondCategoryName;
	}

	public String getThirdCategoryId() {
		return thirdCategoryId;
	}

	public void setThirdCategoryId(String thirdCategoryId) {
		this.thirdCategoryId = thirdCategoryId;
	}

	public String getThirdCategoryCode() {
		return thirdCategoryCode;
	}

	public void setThirdCategoryCode(String thirdCategoryCode) {
		this.thirdCategoryCode = thirdCategoryCode;
	}

	public String getThirdCategoryName() {
		return thirdCategoryName;
	}

	public void setThirdCategoryName(String thirdCategoryName) {
		this.thirdCategoryName = thirdCategoryName;
	}

	public String getHasAttachment() {
		return hasAttachment;
	}

	public void setHasAttachment(String hasAttachment) {
		this.hasAttachment = hasAttachment;
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

	public String getBookLevelId() {
		return bookLevelId;
	}

	public void setBookLevelId(String bookLevelId) {
		this.bookLevelId = bookLevelId;
	}

	public String getBookLevelName() {
		return bookLevelName;
	}

	public void setBookLevelName(String bookLevelName) {
		this.bookLevelName = bookLevelName;
	}

	public String getBookSecurityId() {
		return bookSecurityId;
	}

	public void setBookSecurityId(String bookSecurityId) {
		this.bookSecurityId = bookSecurityId;
	}

	public String getBookSecurityName() {
		return bookSecurityName;
	}

	public void setBookSecurityName(String bookSecurityName) {
		this.bookSecurityName = bookSecurityName;
	}

	public String getCurrencyId() {
		return currencyId;
	}

	public void setCurrencyId(String currencyId) {
		this.currencyId = currencyId;
	}

	public String getCurrencyName() {
		return currencyName;
	}

	public void setCurrencyName(String currencyName) {
		this.currencyName = currencyName;
	}

	public Long getPressId() {
		return pressId;
	}

	public void setPressId(Long pressId) {
		this.pressId = pressId;
	}

	public String getPressName() {
		return pressName;
	}

	public void setPressName(String pressName) {
		this.pressName = pressName;
	}

	public String getBookSourceId() {
		return bookSourceId;
	}

	public void setBookSourceId(String bookSourceId) {
		this.bookSourceId = bookSourceId;
	}

	public String getBookSourceName() {
		return bookSourceName;
	}

	public void setBookSourceName(String bookSourceName) {
		this.bookSourceName = bookSourceName;
	}


}
