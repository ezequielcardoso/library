package com.huan.library.web.view;

import java.io.Serializable;
import java.util.Date;

import com.huan.library.web.view.grid.ExtGridPost;
/**
 * 罚款
 * @author Administrator
 *
 */
public class PunishmentView extends ExtGridPost implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
 
		private Long id; //主键
		private Float punishMoney; //罚金
		private String eventsDesc; //描述
		private Date operatorDate;  //时间  如 : 2011-3-8 06:16:12
		private Date endOperatorDate ; 
		
		private String operator;   //操作员  
		
		private String chargeId;
		private String chargeName; // 收费项目
	    
	
	    private Long readerId; // 读者主键
	    private String readerBarCode;        //条形码
	    private String readerName;  // 读者姓名
		
		private Long unitId; 
		private String unitName;     //读者单位 
		
		private Long readerTypeId; 
		private String readerCateName; // 读者类别
		
		public PunishmentView(){
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
		public String getChargeId() {
			return chargeId;
		}
		public void setChargeId(String chargeId) {
			this.chargeId = chargeId;
		}
		public String getChargeName() {
			return chargeName;
		}
		public void setChargeName(String chargeName) {
			this.chargeName = chargeName;
		}
		public Long getReaderId() {
			return readerId;
		}
		public void setReaderId(Long readerId) {
			this.readerId = readerId;
		}
		public String getReaderBarCode() {
			return readerBarCode;
		}
		public void setReaderBarCode(String readerBarCode) {
			this.readerBarCode = readerBarCode;
		}
		public String getReaderName() {
			return readerName;
		}
		public void setReaderName(String readerName) {
			this.readerName = readerName;
		}
		public Long getUnitId() {
			return unitId;
		}
		public void setUnitId(Long unitId) {
			this.unitId = unitId;
		}
		
		public String getUnitName() {
			return unitName;
		}
		public void setUnitName(String unitName) {
			this.unitName = unitName;
		}
		public Long getReaderTypeId() {
			return readerTypeId;
		}
		public void setReaderTypeId(Long readerTypeId) {
			this.readerTypeId = readerTypeId;
		}
	
		public String getReaderCateName() {
			return readerCateName;
		}
		public void setReaderCateName(String readerCateName) {
			this.readerCateName = readerCateName;
		}

		public Date getEndOperatorDate() {
			return endOperatorDate;
		}

		public void setEndOperatorDate(Date endOperatorDate) {
			this.endOperatorDate = endOperatorDate;
		}
		
		
}   
