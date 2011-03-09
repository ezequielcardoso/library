package com.huan.library.domain.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.huan.library.domain.model.borrowReturn.BorrowReturn;

/**
 * 罚款
 * @author huan
 * @time 2011-3-8  下午06:16:12
 */
@Entity
public class Fine implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id; //主键
	private float fine; //罚金
	private String desc; //描述
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="project")
	private Project project; //项目
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="borrowReturn")
	private BorrowReturn borrowReturn;   //借阅归还
	
	public BorrowReturn getBorrowReturn() {
		return borrowReturn;
	}
	public void setBorrowReturn(BorrowReturn borrowReturn) {
		this.borrowReturn = borrowReturn;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public float getFine() {
		return fine;
	}
	public void setFine(float fine) {
		this.fine = fine;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public Project getProject() {
		return project;
	}
	public void setProject(Project project) {
		this.project = project;
	}

}
