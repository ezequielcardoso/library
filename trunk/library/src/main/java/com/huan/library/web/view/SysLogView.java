package com.huan.library.web.view;

import java.io.Serializable;
import java.util.Date;

import com.huan.library.web.view.grid.ExtGridPost;



public class SysLogView extends ExtGridPost implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long id;
	private String operateType;  //操作类型
	private String funcName;    //事件
	private String operatorName;  //业务名称
	private String operateDescription; //业务描述
	private String operator;  //操作人
	private Date operateDate;  //日期
	private Date endOperateDate ;
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
	public String getOperatorName() {
		return operatorName;
	}
	public void setOperatorName(String operatorName) {
		this.operatorName = operatorName;
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
	
	public String getOperateIPAddress() {
		return operateIPAddress;
	}
	public void setOperateIPAddress(String operateIPAddress) {
		this.operateIPAddress = operateIPAddress;
	}
	public Date getOperateDate() {
		return operateDate;
	}
	public void setOperateDate(Date operateDate) {
		this.operateDate = operateDate;
	}
	public Date getEndOperateDate() {
		return endOperateDate;
	}
	public void setEndOperateDate(Date endOperateDate) {
		this.endOperateDate = endOperateDate;
	}
    	
	
}
