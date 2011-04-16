package com.huan.library.domain.model.borrowReturn;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.huan.library.domain.model.book.Book;
import com.huan.library.domain.model.book.BookState;
import com.huan.library.domain.model.book.Category;
import com.huan.library.domain.model.reader.Reader;
import com.huan.library.domain.model.reader.ReaderType;
import com.huan.library.domain.model.reader.ReaderUnits;
/**
 * 借阅归还
 * @author huan
 * @time 2011-3-9  上午10:21:43
 */
@Entity
public class BorrowReturn implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id; //主键
    
	private Date borrowedDate;       //借阅日期
	private Date duetoReturnDate;    //应还日期
	private Date realityReturndate;  //实还日期
	private Integer overdueDays;         //逾期天数
	private Float puniMoney = 0F;        //罚金
	private Integer isPay = 1;         //是或缴款
	private Integer   renewTimes = 0;        //续借次数
	private String borrowOperator;          //借阅操作员
	private String returnOperator;          //归还操作员 
	
	@ManyToOne(fetch=FetchType.LAZY,targetEntity=Book.class)
    @JoinColumn(name="book")
    private Book book ;   //图书
    
	@ManyToOne(fetch=FetchType.LAZY,targetEntity=Reader.class)
    @JoinColumn(name="reader")
    private Reader reader;     //读者
	
	public BorrowReturn(Long id,Date borrowedDate, Date duetoReturnDate ,Date realityReturndate,
			Integer overdueDays, Float puniMoney,Integer isPay, Integer renewTimes,String borrowOperator,
			String returnOperator,Long bookId,String bookNo,String bookBarCode,String bookName,String location,
			String firstCategoryId,String firstCategoryCode,String firstCategoryName,String bookStateId,String bookStateName,
			Long readerId,String cardNo,String readerBarCode,String readerName,Long unitId,String unitCode,String unitName,
			Long readerTypeId,String readerCateCode,String readerCateName){
		this.id = id ;
		this.borrowedDate=borrowedDate;
		this.duetoReturnDate=duetoReturnDate;
		this.realityReturndate = realityReturndate;
		this.overdueDays = overdueDays;
		this.puniMoney=puniMoney;
		this.isPay = isPay;
		this.renewTimes = renewTimes;
		this.borrowOperator=borrowOperator;
		this.returnOperator=returnOperator;
		
		Book book = new Book();
		book.setBookId(bookId);
		book.setBookNo(bookNo);
		book.setBarCode(bookBarCode);
		book.setBookName(bookName);
		book.setLocation(location);
		
		Category firstCategory = new Category();
		firstCategory.setItemId(firstCategoryId);
		firstCategory.setItemCode(firstCategoryCode);
		firstCategory.setItemName(firstCategoryName);
		book.setFirstCategory(firstCategory);
		
		BookState bookState = new BookState();
		bookState.setItemId(bookStateId);
		bookState.setItemName(bookStateName);
        book.setBookState(bookState);
        
        this.setBook(book);
        
        Reader reader = new Reader();
        reader.setId(readerId);
        reader.setCardNo(cardNo);
        reader.setBarCode(readerBarCode);
        reader.setReaderName(readerName);
        
        ReaderUnits readerUnits = new ReaderUnits();
		readerUnits.setUnitId(unitId);
		readerUnits.setUnitcode(unitCode);
		readerUnits.setUnitName(unitName);
		reader.setReaderUnits(readerUnits);
		
		ReaderType readerType = new ReaderType();
		readerType.setId(readerTypeId);
        readerType.setReaderCateCode(readerCateCode);
        readerType.setReaderCateName(readerCateName);
        reader.setReaderType(readerType);
        this.setReader(reader);
        
 	}
	
	public BorrowReturn(){
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getBorrowedDate() {
		return borrowedDate;
	}

	public void setBorrowedDate(Date borrowedDate) {
		this.borrowedDate = borrowedDate;
	}

	public Date getDuetoReturnDate() {
		return duetoReturnDate;
	}

	public void setDuetoReturnDate(Date duetoReturnDate) {
		this.duetoReturnDate = duetoReturnDate;
	}

	public Date getRealityReturndate() {
		return realityReturndate;
	}

	public void setRealityReturndate(Date realityReturndate) {
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

    public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public Reader getReader() {
		return reader;
	}

	public void setReader(Reader reader) {
		this.reader = reader;
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

}
