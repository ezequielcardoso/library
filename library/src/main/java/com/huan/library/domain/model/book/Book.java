package com.huan.library.domain.model.book;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


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
	private Long bookId; // 主键
	private String bookNo; // 图书编号
	private String barCode; //条形码
	private String bookName; //书刊名字
	private String bookDesc; //图书简介
	private String donator; //捐赠人
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
	private Boolean isBook = true;  //类型true:表示图书 false:表示期刊

	@ManyToOne(fetch = FetchType.LAZY,targetEntity=Category.class)
	@JoinColumn(name = "firstCategory")
	private Category firstCategory; // 图书分类
	
	@ManyToOne(fetch = FetchType.LAZY,targetEntity=Category.class)
	@JoinColumn(name = "secondCategory")
	private Category secondCategory; // 图书分类
	
	@ManyToOne(fetch = FetchType.LAZY,targetEntity=Category.class)
	@JoinColumn(name = "thirdCategory")
	private Category thirdCategory; // 图书分类
	
	@OneToMany(fetch=FetchType.LAZY,targetEntity=Attachment.class,mappedBy="book")
	private List<Attachment> attachments = new ArrayList<Attachment>(); // 附件
	
	@ManyToOne(fetch=FetchType.LAZY,targetEntity=BookState.class)
	@JoinColumn(name="bookState")
	private BookState bookState; // 图书状态
	
	@ManyToOne(fetch = FetchType.LAZY, optional = true)
	@JoinColumn(name = "bookLevel")
	private BookLevel bookLevel; // 图书级别
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="bookSecurity")
	private BookSecurity bookSecurity;   //图书密级
	
	@ManyToOne(fetch = FetchType.LAZY, optional = true)
	@JoinColumn(name = "currency")
	private Currency currency; // 币种
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "press")
	private Press press; // 出版社
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "bookSource")
	private BookSource bookSource; // 来源
	
	public Book(){
		super();
	}
	
	public Book(Long bookId, String barCode, String bookName, String bookDesc, String donator, String author, String translator,
			String ISBN, String ISSN, String emailNo, String stage, String allStage, Integer pages, Float price, Date publisherDate, 
			Integer quantity, String location, Integer revision, String searchBookId, String speciesId, String spell, Date storeDate, 
			String bookNo, Boolean isBook, String firstCategoryId, String firstCategoryCode, String firstCategoryName,
			String secondCategoryId, String secondCategoryCode, String secondCategoryName, String thirdCategoryId, 
			String thirdCategoryCode, String thirdCategoryName, String stateId, String stateName, 
			String levelId, String levelName, String bookSecurityId, String bookSecurityName, String currencyId, String currencyName, 
			Long pressId, String pressName, String sourceId, String sourceName){ /**String hasAttachment,*/
		this.bookId = bookId;
		this.barCode = barCode;
		this.bookName = bookName;
		this.bookDesc = bookDesc;
		this.donator = donator;
		this.author = author;
		this.translator = translator;
		this.ISBN = ISBN;
		this.ISSN = ISSN;
		this.emailNo = emailNo;
		this.stage = stage;
		this.allStage = allStage;
		this.pages = pages;
		this.price = price;
		this.publisherDate = publisherDate;
		this.bookNo = bookNo;
		this.isBook = isBook;
		
		Category firstCategory = new Category();
		firstCategory.setCategoryId(firstCategoryId);
		firstCategory.setCategoryCode(firstCategoryCode);
		firstCategory.setCategoryName(firstCategoryName);
		this.setFirstCategory(firstCategory);
		
		Category secondCategory = new Category();
		secondCategory.setCategoryId(secondCategoryId);
		secondCategory.setCategoryCode(secondCategoryCode);
		firstCategory.setCategoryName(secondCategoryName);
		this.setSecondCategory(secondCategory);
		
		Category thirdCategory = new Category();
		thirdCategory.setCategoryId(secondCategoryId);
		thirdCategory.setCategoryCode(secondCategoryCode);
		thirdCategory.setCategoryName(secondCategoryName);
		this.setSecondCategory(thirdCategory);
		
//		this.hasAttachment = hasAttachment;
		
		BookState state = new BookState();
		state.setItemId(stateId);
		state.setItemName(stateName);
		this.setBookState(state);
		
		BookLevel level = new BookLevel();
		level.setItemId(levelId);
		level.setItemName(levelName);
		this.setBookLevel(level);
		
		BookSecurity bookSecurity = new BookSecurity();
		bookSecurity.setItemId(bookSecurityId);
		bookSecurity.setItemName(bookSecurityName);
		this.setBookSecurity(bookSecurity);
		
		Currency currency = new Currency();
		currency.setItemId(currencyId);
		currency.setItemName(currencyName);
		this.setCurrency(currency);
		
		Press press = new Press();
		press.setPressId(pressId);
		press.setPressName(pressName);
		this.setPress(press);
		
		BookSource source = new BookSource();
		source.setItemId(sourceId);
		source.setItemName(sourceName);
		this.setBookSource(source);
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

	public Boolean getIsBook() {
		return isBook;
	}

	public void setIsBook(Boolean isBook) {
		this.isBook = isBook;
	}

	public Category getFirstCategory() {
		return firstCategory;
	}

	public void setFirstCategory(Category firstCategory) {
		this.firstCategory = firstCategory;
	}

	public Category getSecondCategory() {
		return secondCategory;
	}

	public void setSecondCategory(Category secondCategory) {
		this.secondCategory = secondCategory;
	}

	public Category getThirdCategory() {
		return thirdCategory;
	}

	public void setThirdCategory(Category thirdCategory) {
		this.thirdCategory = thirdCategory;
	}

	public List<Attachment> getAttachments() {
		return attachments;
	}

	public void setAttachments(List<Attachment> attachments) {
		this.attachments = attachments;
	}

	public BookState getBookState() {
		return bookState;
	}

	public void setBookState(BookState bookState) {
		this.bookState = bookState;
	}

	public BookLevel getBookLevel() {
		return bookLevel;
	}

	public void setBookLevel(BookLevel bookLevel) {
		this.bookLevel = bookLevel;
	}

	public Currency getCurrency() {
		return currency;
	}

	public void setCurrency(Currency currency) {
		this.currency = currency;
	}

	public Press getPress() {
		return press;
	}

	public void setPress(Press press) {
		this.press = press;
	}

	public BookSource getBookSource() {
		return bookSource;
	}

	public void setBookSource(BookSource bookSource) {
		this.bookSource = bookSource;
	}

	public BookSecurity getBookSecurity() {
		return bookSecurity;
	}

	public void setBookSecurity(BookSecurity bookSecurity) {
		this.bookSecurity = bookSecurity;
	}

}
