package com.huan.library.domain.model.borrowReturn;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.huan.library.domain.model.book.Book;
import com.huan.library.domain.model.reader.ReaderCard;
import com.huan.library.domain.model.rights.User;
@Entity
public class BorrowReturn implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id; //主键
	private Set<Book> books = new HashSet<Book>(); //图书
	private Set<ReaderCard> readerCards = new HashSet<ReaderCard>(); // 借阅证
	private Date borrowedDate;       //借阅日期
	private Date duetoReturnDate;    //应还日期
	private Date realityReturndate;  //实还日期
	private int overdueDays;         //逾期天数
	private float exceedFine;        //罚金
	private char  isPay ;            //是或归还
	private int   renewTimes;        //续借次数
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="operator")
	private User operator;          //操作员      
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Set<Book> getBooks() {
		return books;
	}
	public void setBooks(Set<Book> books) {
		this.books = books;
	}
	public Set<ReaderCard> getReaderCards() {
		return readerCards;
	}
	public void setReaderCards(Set<ReaderCard> readerCards) {
		this.readerCards = readerCards;
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
