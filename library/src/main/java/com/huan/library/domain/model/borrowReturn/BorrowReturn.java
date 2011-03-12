package com.huan.library.domain.model.borrowReturn;

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

import com.huan.library.domain.model.Fine;
import com.huan.library.domain.model.book.Book;
import com.huan.library.domain.model.reader.ReaderCard;
import com.huan.library.domain.model.rights.User;
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
	private int id; //主键
    
	@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="book")
	private Book book;	
    
	@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="readerCard")
    private ReaderCard readerCard;
	
	private Date borrowedDate;       //借阅日期
	private Date duetoReturnDate;    //应还日期
	private Date realityReturndate;  //实还日期
	private int overdueDays;         //逾期天数
	
	@OneToMany(cascade={CascadeType.ALL},fetch=FetchType.LAZY
			,targetEntity=Fine.class)
	private List<Fine> fines = new ArrayList<Fine>();               //罚款
	
	private float exceedFine;        //罚金
	private char  isPay ;            //是或归还
	private int   renewTimes;        //续借次数
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="operator")
	private User operator;          //操作员  
	
	public BorrowReturn(){
		
	}
	
	public List<Fine> getFines() {
		return fines;
	}
	public void setFines(List<Fine> fines) {
		this.fines = fines;
	}
	public ReaderCard getReaderCard() {
		return readerCard;
	}
	public void setReaderCard(ReaderCard readerCard) {
		this.readerCard = readerCard;
	}
	
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
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
	public int getOverdueDays() {
		return overdueDays;
	}
	public void setOverdueDays(int overdueDays) {
		this.overdueDays = overdueDays;
	}
	public float getExceedFine() {
		return exceedFine;
	}
	public void setExceedFine(float exceedFine) {
		this.exceedFine = exceedFine;
	}
	public char getIsPay() {
		return isPay;
	}
	public void setIsPay(char isPay) {
		this.isPay = isPay;
	}
	public int getRenewTimes() {
		return renewTimes;
	}
	public void setRenewTimes(int renewTimes) {
		this.renewTimes = renewTimes;
	}
	public User getOperator() {
		return operator;
	}
	public void setOperator(User operator) {
		this.operator = operator;
	}
	
}
