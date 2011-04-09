package com.huan.library.web.view;

import java.io.Serializable;
import java.util.Date;


import com.huan.library.util.Constants;
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
	private Date birthday;      //出生日期
	private String sex = Constants.MALE;  // 姓名 M:男 F:女
	private String email;       // 邮箱
	private String contactTel;  // 联系电话
	private Float leftMoney = 0.0f; // 余额
	private String spell;           //拼音
	private String cardNo;         //借阅证号
	private String password;       //密码
	private String barCode;        //条形码
	private Date entyDate;         //办证日期
	private Date effectiveDate;    //有效日期
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
	private String readerTypeCode; 
	private String readerTypeName; // 读者类别
	
	private String cardStateId;
	private String cardStateCode;
	private String cardStateName;   //借阅证状态
	
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

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
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

	public Date getEntyDate() {
		return entyDate;
	}

	public void setEntyDate(Date entyDate) {
		this.entyDate = entyDate;
	}

	public Date getEffectiveDate() {
		return effectiveDate;
	}

	public void setEffectiveDate(Date effectiveDate) {
		this.effectiveDate = effectiveDate;
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

	public String getReaderTypeCode() {
		return readerTypeCode;
	}

	public void setReaderTypeCode(String readerTypeCode) {
		this.readerTypeCode = readerTypeCode;
	}

	public String getReaderTypeName() {
		return readerTypeName;
	}

	public void setReaderTypeName(String readerTypeName) {
		this.readerTypeName = readerTypeName;
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
    
}
