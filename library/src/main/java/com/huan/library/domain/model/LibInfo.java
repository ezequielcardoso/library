package com.huan.library.domain.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * 图书馆信息
 * @author huan
 * @time  2011-3-10 上午07:03:33
 */
@Entity
public class LibInfo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;  //主键
	private String libName; //图书馆名字
	private String address;    //地址
	private String telphone;   //联系电话
	
	private String libManager;     //管理员
	
	private Float payADay=0F;    //罚金
	private Float baseCost=0F;   //开户费
	private Float depositeTimes=0.0F; //押金倍数
	private String libDesc;       //借阅证背面描述
	private Float libFunds ;     //图书馆资金
	
	public LibInfo(){
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLibName() {
		return libName;
	}

	public void setLibName(String libName) {
		this.libName = libName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getTelphone() {
		return telphone;
	}

	public void setTelphone(String telphone) {
		this.telphone = telphone;
	}
    

	public String getLibManager() {
		return libManager;
	}

	public void setLibManager(String libManager) {
		this.libManager = libManager;
	}

	public Float getPayADay() {
		return payADay;
	}

	public void setPayADay(Float payADay) {
		this.payADay = payADay;
	}

	public Float getBaseCost() {
		return baseCost;
	}

	public void setBaseCost(Float baseCost) {
		this.baseCost = baseCost;
	}

	public Float getDepositeTimes() {
		return depositeTimes;
	}

	public void setDepositeTimes(Float depositeTimes) {
		this.depositeTimes = depositeTimes;
	}

	public String getLibDesc() {
		return libDesc;
	}

	public void setLibDesc(String libDesc) {
		this.libDesc = libDesc;
	}

	public Float getLibFunds() {
		return libFunds;
	}

	public void setLibFunds(Float libFunds) {
		this.libFunds = libFunds;
	}
	
	

}
