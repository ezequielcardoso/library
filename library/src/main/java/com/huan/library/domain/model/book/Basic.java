package com.huan.library.domain.model.book;

import java.io.Serializable;
import java.util.Date;

import com.huan.library.domain.model.dict.BookCategory;
import com.huan.library.domain.model.dict.BookLevel;
import com.huan.library.domain.model.dict.Currency;
import com.huan.library.domain.model.dict.State;
/**
 * 书刊基本信息
 * @author huan
 * @time 2011-3-8  上午11:46:05
 */
public class Basic implements Serializable{
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

    public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getBarCode() {
		return barCode;
	}

	public void setBarCode(String barCode) {
		this.barCode = barCode;
	}

	public String getISBN() {
		return ISBN;
	}

	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}

	public Date getPublisherDate() {
		return publisherDate;
	}

	public void setPublisherDate(Date publisherDate) {
		this.publisherDate = publisherDate;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getSpell() {
		return spell;
	}

	public void setSpell(String spell) {
		this.spell = spell;
	}

	public BookCategory getBookCategory() {
		return bookCategory;
	}

	public void setBookCategory(BookCategory bookCategory) {
		this.bookCategory = bookCategory;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public Date getStoreDate() {
		return storeDate;
	}

	public void setStoreDate(Date storeDate) {
		this.storeDate = storeDate;
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

	public int id; //主键
	
	private String bookName; //书刊名字
	
	private String barCode; //条形码
	
	private String ISBN; //ISBN
	
	private Date publisherDate; //出版日期
	
	private float price;  //价格
	
	private int quantity; //数量
	
	private String spell;  //拼音
	
	private BookCategory bookCategory; //分类
	
	private State state;  //图书状态
	
	private Date storeDate;  //入库时间
	
	private BookLevel bookLevel;  //图书类别
	
	private Currency currency;  //币种
			
	
}
