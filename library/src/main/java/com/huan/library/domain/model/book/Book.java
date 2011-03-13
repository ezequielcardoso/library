package com.huan.library.domain.model.book;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.huan.library.domain.model.borrowReturn.BorrowReturn;
import com.huan.library.domain.model.dict.Attachment;
import com.huan.library.domain.model.dict.BookLevel;
import com.huan.library.domain.model.dict.Currency;
import com.huan.library.domain.model.dict.Resource;
import com.huan.library.domain.model.dict.Security;
import com.huan.library.domain.model.dict.State;

/**
 * 图书信息
 * @author huan
 * @time 2011-3-8 上午10:55:59
 */
@Entity
public class Book implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id; // 主键
	
	private String barCode; // 条形码
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "bookCategory")
	private Category bookCategory; // 图书分类
	
	@ManyToOne(fetch = FetchType.LAZY, optional = true)
	@JoinColumn(name = "attachment")
	private Attachment attachment; // 附件名称
	
	private String bookDesc; // 图书简介
	
	@ManyToOne(fetch = FetchType.LAZY, optional = true)
	@JoinColumn(name = "bookLevel")
	private BookLevel bookLevel; // 图书类别
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="security")
	private Security security;   //图书密级
	
	private String bookName; // 书刊名字
	
	@ManyToOne(fetch = FetchType.LAZY, optional = true)
	@JoinColumn(name = "currency")
	private Currency currency; // 币种
	
	private String donator; // 捐赠人
	private String electoricDoc; // 电子文档
	private String ISBN; // ISBN
	private String ISSN; // 国内统一刊号
	private String emailNo; // 邮发代码
	private String stage; // 第几期
	private String allStage; // 总第几期
	private int pages; // 页数
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "press")
	private Press press; // 出版社
	
	private float price; // 价格
	private Date publisherDate; // 出版日期
	private int quantity; // 数量
	private String location; //存放位置
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "resource")
	private Resource resource; // 来源
	
	private int revision; // 版次
	private String searchBookId; // 索书号
	private String speciesId; // 种次号
	private String spell; // 拼音
	private State state; // 图书状态
	private Date storeDate; // 入库时间
	private String bookNo; // 图书编号
	private int type; // 类型 0:表示图书 1:表示期刊
	
	@OneToMany(cascade={CascadeType.ALL},fetch=FetchType.LAZY,targetEntity=BorrowReturn.class)
	private List<BorrowReturn> borrowReturn = new ArrayList<BorrowReturn>(); //借阅归还

	public List<BorrowReturn> getBorrowReturn() {
		return borrowReturn;
	}
	public Security getSecurity() {
		return security;
	}

	public void setSecurity(Security security) {
		this.security = security;
	} 
	public void setBorrowReturn(List<BorrowReturn> borrowReturn) {
		this.borrowReturn = borrowReturn;
	}

	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
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

	public String getAllStage() {
		return allStage;
	}

	public void setAllStage(String allStage) {
		this.allStage = allStage;
	}

	public String getBookNo() {
		return bookNo;
	}

	public void setBookNo(String bookNo) {
		this.bookNo = bookNo;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public Attachment getAttachment() {
		return attachment;
	}

	public String getBarCode() {
		return barCode;
	}

	public Category getBookCategory() {
		return bookCategory;
	}

	public String getBookDesc() {
		return bookDesc;
	}

	public BookLevel getBookLevel() {
		return bookLevel;
	}

	public String getBookName() {
		return bookName;
	}

	public Currency getCurrency() {
		return currency;
	}

	public String getDonator() {
		return donator;
	}

	public String getElectoricDoc() {
		return electoricDoc;
	}

	public int getId() {
		return id;
	}

	public String getISBN() {
		return ISBN;
	}

	public int getPages() {
		return pages;
	}

	public Press getPress() {
		return press;
	}

	public float getPrice() {
		return price;
	}

	public Date getPublisherDate() {
		return publisherDate;
	}

	public int getQuantity() {
		return quantity;
	}

	public Resource getResource() {
		return resource;
	}

	public int getRevision() {
		return revision;
	}

	public String getSearchBookId() {
		return searchBookId;
	}

	public String getSpeciesId() {
		return speciesId;
	}

	public String getSpell() {
		return spell;
	}

	public State getState() {
		return state;
	}

	public Date getStoreDate() {
		return storeDate;
	}

	public void setAttachment(Attachment attachment) {
		this.attachment = attachment;
	}

	public void setBarCode(String barCode) {
		this.barCode = barCode;
	}

	public void setBookCategory(Category bookCategory) {
		this.bookCategory = bookCategory;
	}

	public void setBookDesc(String bookDesc) {
		this.bookDesc = bookDesc;
	}

	public void setBookLevel(BookLevel bookLevel) {
		this.bookLevel = bookLevel;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public void setCurrency(Currency currency) {
		this.currency = currency;
	}

	public void setDonator(String donator) {
		this.donator = donator;
	}

	public void setElectoricDoc(String electoricDoc) {
		this.electoricDoc = electoricDoc;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}

	public void setPages(int pages) {
		this.pages = pages;
	}

	public void setPress(Press press) {
		this.press = press;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public void setPublisherDate(Date publisherDate) {
		this.publisherDate = publisherDate;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public void setResource(Resource resource) {
		this.resource = resource;
	}

	public void setRevision(int revision) {
		this.revision = revision;
	}

	public void setSearchBookId(String searchBookId) {
		this.searchBookId = searchBookId;
	}

	public void setSpeciesId(String speciesId) {
		this.speciesId = speciesId;
	}

	public void setSpell(String spell) {
		this.spell = spell;
	}

	public void setState(State state) {
		this.state = state;
	}

	public void setStoreDate(Date storeDate) {
		this.storeDate = storeDate;
	}

}
