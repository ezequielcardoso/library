package com.huan.library.domain.model;

import java.io.Serializable;

/**
 * 罚款
 * @author huan
 * @time 2011-3-8  下午06:16:12
 */
public class Fine implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id; //主键
	private float fine; //罚金
	private String desc; //描述
	
	private Project project; //项目
	
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
