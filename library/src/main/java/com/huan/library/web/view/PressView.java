package com.huan.library.web.view;

import java.io.Serializable;

import com.huan.library.web.view.grid.ExtGridPost;

public class PressView extends ExtGridPost implements Serializable{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long pressId;       //主键
    private String pressAddress; //地址
    private String pressISBN; //ISBN
	private String pressName; //出版社名称
	private String zipCode;   //邮编
	
	public PressView(){
		
	}
	
	public String getPressISBN() {
		return pressISBN;
	}

	public void setPressISBN(String pressISBN) {
		this.pressISBN = pressISBN;
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

	public void setPressAddress(String pressAddress) {
		this.pressAddress = pressAddress;
	}

    public void setPressName(String pressName) {
		this.pressName = pressName;
	}
    
    public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public Long getPressId() {
		return pressId;
	}

	public void setPressId(Long pressId) {
		this.pressId = pressId;
	}
    
    
}
