package com.huan.library.domain.model.reader;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import com.huan.library.util.Constants;

/**
 * 借阅证
 * @author huan
 * @time 2011-3-8  下午06:53:19
 */
@Entity
public class ReaderCard implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String readerCardCode; //借阅证号
	private String password;       //密码
	private String barCode;        //条形码
	private Date entyDate;         //办证日期
	private Date effectiveDate;    //有效日期
	private String readerPic;      //头像
	private String readerCardDesc; //描述
	private String cardState = Constants.COMMON;    //借阅证状态
	
	@OneToOne(cascade={CascadeType.MERGE},fetch=FetchType.LAZY,
			mappedBy="readerCard")
	private Reader reader;         //读者
	
	
	public ReaderCard(){
		
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getReaderCardCode() {
		return readerCardCode;
	}
	public void setReaderCardCode(String readerCardCode) {
		this.readerCardCode = readerCardCode;
	}
	public String getCardState() {
		return cardState;
	}
	public void setCardState(String cardState) {
		this.cardState = cardState;
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
	public String getReaderCardDesc() {
		return readerCardDesc;
	}
	public void setReaderCardDesc(String readerCardDesc) {
		this.readerCardDesc = readerCardDesc;
	}
	public Reader getReader() {
		return reader;
	}
	public void setReader(Reader reader) {
		this.reader = reader;
	}
}
