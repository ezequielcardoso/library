package com.huan.library.domain.model.reader;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.huan.library.domain.model.rights.Department;
/**
 * 读者单位实体
 * @author huan
 * @time 2011-3-14 下午11:54:57
 */
@Entity
public class ReaderUnits  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long unitId;  //单位id
	private String unitcode; //单位编号
	private String unitName; //单位名称
	private String unitShortName; //单位简称
	private String unitDesc;   //单位描述
	
	@ManyToOne(fetch=FetchType.LAZY,targetEntity=ReaderUnits.class,cascade={CascadeType.MERGE,CascadeType.REMOVE})
	@JoinColumn(name="parentUnitId",referencedColumnName="unitId")
	private ReaderUnits parentUnit;   //上级单位
	
	@OneToMany(targetEntity=ReaderUnits.class,mappedBy="parentUnit")
	private List<ReaderUnits> childrenUnits = new ArrayList<ReaderUnits>(); //下级单位
	
	public ReaderUnits(){
		
	}

	public Long getUnitId() {
		return unitId;
	}

	public void setUnitId(Long unitId) {
		this.unitId = unitId;
	}

	public String getUnitcode() {
		return unitcode;
	}

	public void setUnitcode(String unitcode) {
		this.unitcode = unitcode;
	}

	public String getUnitName() {
		return unitName;
	}

	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}

	public String getUnitShortName() {
		return unitShortName;
	}

	public void setUnitShortName(String unitShortName) {
		this.unitShortName = unitShortName;
	}

	public String getUnitDesc() {
		return unitDesc;
	}

	public void setUnitDesc(String unitDesc) {
		this.unitDesc = unitDesc;
	}

	public ReaderUnits getParentUnit() {
		return parentUnit;
	}

	public void setParentUnit(ReaderUnits parentUnit) {
		this.parentUnit = parentUnit;
	}

	public List<ReaderUnits> getChildrenUnits() {
		return childrenUnits;
	}

	public void setChildrenUnits(List<ReaderUnits> childrenUnits) {
		this.childrenUnits = childrenUnits;
	}
	
}
