package com.huan.library.web.view;

import java.io.Serializable;


import com.huan.library.web.view.grid.ExtGridPost;
/**
 * @author huan
 * @time  2011-4-6 下午12:12:54
 */
public class ReaderView extends ExtGridPost implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long id; // 主键
	private String readerName;  // 读者姓名
	private String birthday;      //出生日期
	private String sex ;  // 姓名 M:男 F:女
	private String email;       // 邮箱
	private String contactTel;  // 联系电话
	private Float leftMoney = 0.0f; // 余额
	private String spell;           //拼音
	private String cardNo;         //借阅证号
	private String password;       //密码
	private String barCode;        //条形码
	private String entyDate;         //办证日期
	private String effectiveDate;    //有效日期
	private String readerPic;      //头像
	private String certificateNo; // 证件号码
	private String readerDesc;    // 读者描述
	
	private Long unitId; 
	private String unitCode;
	private String unitName;     //读者单位 
	
	private String certificateId;
	private String certificateCode;
	private String certificateName;  // 证件类别  学生证    

	private Long readerTypeId; 
	private String readerCateCode; 
	private String readerCateName; // 读者类别
	
	private String cardStateId;
	private String cardStateCode;
	private String cardStateName;   //借阅证状态
	private Integer borrowedQuantiy = 0;      //当前借阅数量
	private Integer renewTimes = 0 ; //续借次数
	private Integer totalBQuantity = 0;    //累计借阅数量
	
	
	public ReaderView(){
		super();
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getReaderName() {
		return readerName;
	}

	public void setReaderName(String readerName) {
		this.readerName = readerName;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}
    
	
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getEntyDate() {
		return entyDate;
	}

	public void setEntyDate(String entyDate) {
		this.entyDate = entyDate;
	}

	public String getEffectiveDate() {
		return effectiveDate;
	}

	public void setEffectiveDate(String effectiveDate) {
		this.effectiveDate = effectiveDate;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContactTel() {
		return contactTel;
	}

	public void setContactTel(String contactTel) {
		this.contactTel = contactTel;
	}

	public Float getLeftMoney() {
		return leftMoney;
	}

	public void setLeftMoney(Float leftMoney) {
		this.leftMoney = leftMoney;
	}

	public String getSpell() {
		return spell;
	}

	public void setSpell(String spell) {
		this.spell = spell;
	}

	public String getCardNo() {
		return cardNo;
	}

	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getBarCode() {
		return barCode;
	}

	public void setBarCode(String barCode) {
		this.barCode = barCode;
	}


	public String getReaderPic() {
		return readerPic;
	}

	public void setReaderPic(String readerPic) {
		this.readerPic = readerPic;
	}

	public String getCertificateNo() {
		return certificateNo;
	}

	public void setCertificateNo(String certificateNo) {
		this.certificateNo = certificateNo;
	}

	public String getReaderDesc() {
		return readerDesc;
	}

	public void setReaderDesc(String readerDesc) {
		this.readerDesc = readerDesc;
	}

	public Long getUnitId() {
		return unitId;
	}

	public void setUnitId(Long unitId) {
		this.unitId = unitId;
	}

	public String getUnitCode() {
		return unitCode;
	}

	public void setUnitCode(String unitCode) {
		this.unitCode = unitCode;
	}

	public String getUnitName() {
		return unitName;
	}

	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}

	public String getCertificateId() {
		return certificateId;
	}

	public void setCertificateId(String certificateId) {
		this.certificateId = certificateId;
	}
  
    	  
	public Integer getBorrowedQuantiy() {
		return borrowedQuantiy;
	}

	public void setBorrowedQuantiy(Integer borrowedQuantiy) {
		this.borrowedQuantiy = borrowedQuantiy;
	}

	public Integer getTotalBQuantity() {
		return totalBQuantity;
	}

	public void setTotalBQuantity(Integer totalBQuantity) {
		this.totalBQuantity = totalBQuantity;
	}

	public String getCertificateCode() {
		return certificateCode;
	}

	public void setCertificateCode(String certificateCode) {
		this.certificateCode = certificateCode;
	}

	public String getCertificateName() {
		return certificateName;
	}

	public void setCertificateName(String certificateName) {
		this.certificateName = certificateName;
	}

	public Long getReaderTypeId() {
		return readerTypeId;
	}

	public void setReaderTypeId(Long readerTypeId) {
		this.readerTypeId = readerTypeId;
	}

	public String getReaderCateCode() {
		return readerCateCode;
	}

	public void setReaderCateCode(String readerCateCode) {
		this.readerCateCode = readerCateCode;
	}

	public String getReaderCateName() {
		return readerCateName;
	}

	public void setReaderCateName(String readerCateName) {
		this.readerCateName = readerCateName;
	}

	public String getCardStateId() {
		return cardStateId;
	}

	public void setCardStateId(String cardStateId) {
		this.cardStateId = cardStateId;
	}

	public String getCardStateCode() {
		return cardStateCode;
	}

	public void setCardStateCode(String cardStateCode) {
		this.cardStateCode = cardStateCode;
	}

	public String getCardStateName() {
		return cardStateName;
	}

	public void setCardStateName(String cardStateName) {
		this.cardStateName = cardStateName;
	}

	public Integer getRenewTimes() {
		return renewTimes;
	}

	public void setRenewTimes(Integer renewTimes) {
		this.renewTimes = renewTimes;
	}
	
	
    
}
