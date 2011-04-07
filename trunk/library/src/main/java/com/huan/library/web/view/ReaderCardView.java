package com.huan.library.web.view;

import java.io.Serializable;
import java.util.Date;


import com.huan.library.util.Constants;
import com.huan.library.web.view.grid.ExtGridPost;
/**
 * 借阅证
 * @author huan
 * @time 2011-4-6 下午10:35:14
 */
public class ReaderCardView extends ExtGridPost implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String readerCardCode; //借阅证号
	private String password;       //密码
	private String barCode;        //条形码
	private Date entyDate;         //办证日期
	private Date effectiveDate;    //有效日期
	private String readerPic;      //头像
	private String readerCardDesc; //描述
	private String cardState = Constants.COMMON;    //借阅证状态
	
	private Long readerId;         //读者
	private String readerName;     
	private Long readerUnitsId;    //读者单位
	private String readerUnitsName;  
	
	public ReaderCardView(){
		super();
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
	public String getCardState() {
		return cardState;
	}
	public void setCardState(String cardState) {
		this.cardState = cardState;
	}
    
	public Long getReaderId() {
		return readerId;
	}
	public void setReaderId(Long readerId) {
		this.readerId = readerId;
	}
	public String getReaderName() {
		return readerName;
	}
	public void setReaderName(String readerName) {
		this.readerName = readerName;
	}
	
	public String getReaderUnitsName() {
		return readerUnitsName;
	}
	public void setReaderUnitsName(String readerUnitsName) {
		this.readerUnitsName = readerUnitsName;
	}
	public Long getReaderUnitsId() {
		return readerUnitsId;
	}
	public void setReaderUnitsId(Long readerUnitsId) {
		this.readerUnitsId = readerUnitsId;
	}
}
