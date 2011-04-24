package com.huan.library.domain.model.dict;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class DictItemType {

	@Id
	private Long typeId;
	
	@ManyToOne(targetEntity = DictItem.class, fetch = FetchType.LAZY)
	@JoinColumn(name = "rootId",referencedColumnName="itemId")
	private DictItem root;
	
	private String dictClass;

	public Long getTypeId() {
		return typeId;
	}

	public void setTypeId(Long typeId) {
		this.typeId = typeId;
	}

	public DictItem getRoot() {
		return root;
	}

	public void setRoot(DictItem root) {
		this.root = root;
	}

	public String getDictClass() {
		return dictClass;
	}

	public void setDictClass(String dictClass) {
		this.dictClass = dictClass;
	}
	
}
