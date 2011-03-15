package com.huan.library.domain.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.huan.library.domain.model.rights.User;
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
	private int id;  //主键
	private String libName; //图书馆名字
	private String address;    //地址
	private String telphone;   //联系电话
	
	@OneToOne(fetch=FetchType.LAZY,targetEntity=User.class)
	@JoinColumn(name="libManager")
	private User libManager;     //管理员
	
	private float payADay=0;    //租金
	private float baseCost=0;   //开户费
	private float depositeTimes=0; //押金倍数
	private String libDesc;       //描述信息
	
	
	public LibInfo(){
		
	}

	public float getPayADay() {
		return payADay;
	}
	public void setPayADay(float payADay) {
		this.payADay = payADay;
	}
	public float getBaseCost() {
		return baseCost;
	}
	public void setBaseCost(float baseCost) {
		this.baseCost = baseCost;
	}
	public float getDepositeTimes() {
		return depositeTimes;
	}
	public void setDepositeTimes(float depositeTimes) {
		this.depositeTimes = depositeTimes;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	
	public String getLibName() {
		return libName;
	}


	public void setLibName(String libName) {
		this.libName = libName;
	}


	public User getLibManager() {
		return libManager;
	}


	public void setLibManager(User libManager) {
		this.libManager = libManager;
	}
	public String getLibDesc() {
		return libDesc;
	}

	public void setLibDesc(String libDesc) {
		this.libDesc = libDesc;
	}


}
