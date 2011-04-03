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
import javax.persistence.OneToOne;

import com.huan.library.domain.model.dict.Certificate;
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
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "certificate")
	private Certificate certificate; // 证件类别  学生证
	
	private String certificateCode; // 证件号码
	private String readerDesc; // 读者描述
	
	@ManyToOne(fetch = FetchType.LAZY,targetEntity=ReaderType.class)
	@JoinColumn(name = "readerType")
	private ReaderType readerType; // 读者类别
	
	@OneToOne(fetch = FetchType.LAZY,cascade={CascadeType.MERGE,CascadeType.REMOVE}
	  ,targetEntity=ReaderCard.class)
	@JoinColumn(name = "readerCard")
	private ReaderCard readerCard; // 借阅证

	public Reader() {

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

	public String getCertificateCode() {
		return certificateCode;
	}

	public void setCertificateCode(String certificateCode) {
		this.certificateCode = certificateCode;
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

	public ReaderCard getReaderCard() {
		return readerCard;
	}

	public void setReaderCard(ReaderCard readerCard) {
		this.readerCard = readerCard;
	}

}
