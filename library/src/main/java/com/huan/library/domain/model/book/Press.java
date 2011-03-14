package com.huan.library.domain.model.book;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * 出版社
 * @author huan
 * @time 2011-3-8  上午11:02:10
 */
@Entity
public class Press implements Serializable{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;       //主键
    
	private String pressAddress; //地址
    
	private String pressISBN; //ISBN

	private String pressName; //出版社名称

	private String zipCode;   //邮编
	
	public Press(){
		
	}
	
	public String getPressISBN() {
		return pressISBN;
	}

	public void setPressISBN(String pressISBN) {
		this.pressISBN = pressISBN;
	}

	
	public int getId() {
		return id;
	}

	public String getPressAddress() {
		return pressAddress;
	}

	
	public String getPressName() {
		return pressName;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setPressAddress(String pressAddress) {
		this.pressAddress = pressAddress;
	}

    public void setPressName(String pressName) {
		this.pressName = pressName;
	}
    
    public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
}
