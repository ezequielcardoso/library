package com.huan.library.domain.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.huan.library.domain.model.rights.User;


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
	
	@ManyToOne(fetch=FetchType.LAZY,targetEntity=User.class)
	@JoinColumn(name="operator")
	private User operator;   //操作员  
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="project")
	private Charge project; //项目
	
	public Punishment(){
		
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

	public User getOperator() {
		return operator;
	}

	public void setOperator(User operator) {
		this.operator = operator;
	}

	public Charge getProject() {
		return project;
	}

	public void setProject(Charge project) {
		this.project = project;
	}
	
}
