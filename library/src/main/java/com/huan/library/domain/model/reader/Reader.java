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

import com.huan.library.domain.model.rights.Department;
/**
 * 读者
 * @author huan
 * @time 2011-3-8  下午07:56:45
 */
@Entity
public class Reader implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id; //主键
	private String readerName; //读者姓名
    private Date birthday;  //
    private char sex; //姓名  M:男   F:女
    private String email; //邮箱
    private String contactTel; //联系电话
    private float leftMoney=0.0f; //余额
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="department")
    private Department department; //部门
    private String spell;
    private String readerDesc; //读者描述
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="readerCategory")
    private ReaderType readerCategory; //读者类别
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="readerCard")
    private ReaderCard readerCard; //借阅证
    
    public int getId() {
		return id;
	}
	public void setId(int id) {
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
	public char getSex() {
		return sex;
	}
	public void setSex(char sex) {
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
	public float getLeftMoney() {
		return leftMoney;
	}
	public void setLeftMoney(float leftMoney) {
		this.leftMoney = leftMoney;
	}
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	public String getSpell() {
		return spell;
	}
	public void setSpell(String spell) {
		this.spell = spell;
	}
	public String getReaderDesc() {
		return readerDesc;
	}
	public void setReaderDesc(String readerDesc) {
		this.readerDesc = readerDesc;
	}
	public ReaderType getReaderCategory() {
		return readerCategory;
	}
	public void setReaderCategory(ReaderType readerCategory) {
		this.readerCategory = readerCategory;
	}
	public ReaderCard getReaderCard() {
		return readerCard;
	}
	public void setReaderCard(ReaderCard readerCard) {
		this.readerCard = readerCard;
	}

}
