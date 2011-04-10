package com.huan.library.domain.model.reader;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.huan.library.util.Constants;

/**
 * 读者
 * @author huan
 * @time 2011-3-8 下午07:56:45
 */
@Entity
public class Reader implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id; // 主键
	private String readerName;  // 读者姓名
	private Date birthday;      //出生日期
	private String sex = Constants.MALE;  // 姓名 M:男 F:女
	private String email;       // 邮箱
	private String contactTel;  // 联系电话
	private Float leftMoney = 0.0f; // 余额
	private String spell;           //拼音
	
	@ManyToOne(fetch=FetchType.LAZY,targetEntity=ReaderUnits.class)
	@JoinColumn(name="readerUnits")
	private ReaderUnits readerUnits;  //读者单位
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "certificate")
	private Certificate certificate; // 证件类别  学生证
	
	private String certificateNo; // 证件号码
	private String readerDesc; // 读者描述
	
	@ManyToOne(fetch = FetchType.LAZY,targetEntity=ReaderType.class)
	@JoinColumn(name = "readerType")
	private ReaderType readerType; // 读者类别
	
	private String cardNo; //借阅证号
	private String password;       //密码
	private String barCode;        //条形码
	private Date entyDate;         //办证日期
	private Date effectiveDate;    //有效日期
	private String readerPic;      //头像
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CardState")
	private CardState cardState;    //借阅证状态

	public Reader() {
        super();
	}
	
	public Reader(Long id,String cardNo,String password,String barCode,String readerName, 
			Date birthday, String sex,Float leftMoney, String email, String contactTel,
			 Date entyDate,Date effectiveDate, String readerPic, String spell,
			String readerDesc,String certificateNo, Long unitId, String unitCode, String unitName,
			 String certificateId, String certificateCode,String certificateName, Long readerTypeId, String readerTypeCode,
			String readerTypeName, String cardStateId, String cardStateCode,
			String cardStateName) {
		this.id = id;
		this.readerName = readerName;
		this.birthday = birthday;
		this.sex = sex;
		this.email = email;
		this.contactTel = contactTel;
		this.leftMoney = leftMoney;
		this.spell = spell;
		this.cardNo = cardNo;
		this.password = password;
		this.barCode = barCode;
		this.entyDate = entyDate;
		this.effectiveDate = effectiveDate;
		this.readerPic = readerPic;
		this.certificateNo = certificateNo;
		this.readerDesc = readerDesc;
		
		ReaderUnits readerUnits = new ReaderUnits();
		readerUnits.setUnitId(unitId);
		readerUnits.setUnitcode(unitCode);
		readerUnits.setUnitName(unitName);
		this.readerUnits = readerUnits;
		
		Certificate certificate = new Certificate();
		certificate.setItemId(certificateId);
		certificate.setItemCode(certificateCode);
		certificate.setItemName(certificateName);
		this.certificate = certificate;
		
		ReaderType readerType = new ReaderType();
		readerType.setId(readerTypeId);
		readerType.setReaderCateCode(readerTypeCode);
		readerType.setReaderCateName(readerTypeName);
		this.readerType = readerType;
		
		
		CardState cardState = new CardState();
		cardState.setItemId(cardStateId);
		cardState.setItemCode(cardStateCode);
		cardState.setItemName(cardStateName);
		this.cardState = cardState;
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

	public ReaderUnits getReaderUnits() {
		return readerUnits;
	}

	public void setReaderUnits(ReaderUnits readerUnits) {
		this.readerUnits = readerUnits;
	}

	public Certificate getCertificate() {
		return certificate;
	}

	public void setCertificate(Certificate certificate) {
		this.certificate = certificate;
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

	public ReaderType getReaderType() {
		return readerType;
	}

	public void setReaderType(ReaderType readerType) {
		this.readerType = readerType;
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

	public CardState getCardState() {
		return cardState;
	}

	public void setCardState(CardState cardState) {
		this.cardState = cardState;
	}


}
