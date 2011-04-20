package com.huan.library.domain.model;

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

import com.huan.library.domain.model.reader.Reader;
import com.huan.library.domain.model.reader.ReaderType;
import com.huan.library.domain.model.reader.ReaderUnits;



/**
 * 罚款
 * @author huan
 * @time 2011-3-8  下午06:16:12
 */
@Entity
public class Punishment implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id; //主键
	private Float punishMoney; //罚金
	private String eventsDesc; //描述
	private Date operatorDate;  //时间  如 : 2011-3-8 06:16:12
	
	private String operator;   //操作员  
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="charge")
	private Charge charge; //项目
	
	@ManyToOne(fetch=FetchType.LAZY,targetEntity=Reader.class, cascade={CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name="reader")
	private Reader reader;
	
	public Punishment(Long id,Float punishMoney,String eventsDesc,Date operatorDate,String operator,
			String chargeId,String chargeName,Long readerId,String readerBarCode,String readerName,Long unitId,
			String unitName,Long readerTypeId,String readerCateName){
		this.id = id ;
		this.punishMoney = punishMoney;
		this.eventsDesc = eventsDesc;
		this.operatorDate = operatorDate;
		this.operator = operator;
	  
		Charge charge = new Charge();
		charge.setItemId(chargeId);
		charge.setItemName(chargeName);
		this.setCharge(charge);
		
		Reader reader = new Reader();
		reader.setId(readerId);
		reader.setBarCode(readerBarCode);
		reader.setReaderName(readerName);
		
		ReaderUnits readerUnits = new ReaderUnits();
		readerUnits.setUnitId(unitId);
		readerUnits.setUnitName(unitName);
		reader.setReaderUnits(readerUnits);
		
		ReaderType readerType = new ReaderType();
		readerType.setId(readerTypeId);
		readerType.setReaderCateName(readerCateName);
		reader.setReaderType(readerType);
	     	
		this.setReader(reader);
	}
	
	public Punishment(){
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Float getPunishMoney() {
		return punishMoney;
	}

	public void setPunishMoney(Float punishMoney) {
		this.punishMoney = punishMoney;
	}

	public String getEventsDesc() {
		return eventsDesc;
	}

	public void setEventsDesc(String eventsDesc) {
		this.eventsDesc = eventsDesc;
	}

	public Date getOperatorDate() {
		return operatorDate;
	}

	public void setOperatorDate(Date operatorDate) {
		this.operatorDate = operatorDate;
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	public Charge getCharge() {
		return charge;
	}

	public void setCharge(Charge charge) {
		this.charge = charge;
	}

	public Reader getReader() {
		return reader;
	}

	public void setReader(Reader reader) {
		this.reader = reader;
	}
 
    
}
