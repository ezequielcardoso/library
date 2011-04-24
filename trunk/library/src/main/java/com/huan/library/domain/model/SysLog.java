package com.huan.library.domain.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class SysLog implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	@Column(nullable=false)
	private String operateType;  //操作类型
	@Column(nullable=false)
	private String funcName;    //事件
	private String operateDescription; //业务描述
	@Column(nullable=false)
	private String operator;  //操作人
	private Date operateDate;  //日期
	@Column(nullable=false)
	private String operateIPAddress; //ip
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getOperateType() {
		return operateType;
	}
	public void setOperateType(String operateType) {
		this.operateType = operateType;
	}
	public String getFuncName() {
		return funcName;
	}
	public void setFuncName(String funcName) {
		this.funcName = funcName;
	}
	public String getOperateDescription() {
		return operateDescription;
	}
	public void setOperateDescription(String operateDescription) {
		this.operateDescription = operateDescription;
	}
	public String getOperator() {
		return operator;
	}
	public void setOperator(String operator) {
		this.operator = operator;
	}
	public Date getOperateDate() {
		return operateDate;
	}
	public void setOperateDate(Date operateDate) {
		this.operateDate = operateDate;
	}
	public String getOperateIPAddress() {
		return operateIPAddress;
	}
	public void setOperateIPAddress(String operateIPAddress) {
		this.operateIPAddress = operateIPAddress;
	}
	
	

}
