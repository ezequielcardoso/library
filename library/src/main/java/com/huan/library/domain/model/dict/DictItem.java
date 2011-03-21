package com.huan.library.domain.model.dict;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 * 参照字典实体
 * 
 * @author shuaizhichun
 * @time 2011-3-6 下午10:25:21
 */
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "itemType", discriminatorType = DiscriminatorType.STRING)
public class DictItem implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	private String itemId;// 主键

	private boolean checked;// 是否选中

	@OneToMany(targetEntity = DictItem.class, fetch = FetchType.LAZY, mappedBy = "parent")
	private List<DictItem> children;

	private String description;// 描述

	private boolean itemActive;// 是否启用

	private String itemCode;// 编码

	private int itemOrder;// 排序

	@Column(insertable = false, updatable = false)
	private String itemType;// 参照组代码

	private boolean leaf;// 是否叶子
	private String shortName;// 名字

	// 用于树结构
	private int level;// 层级,根节点默认为0,根节点的子节点为1,孙子节点为2，以此类推

	@ManyToOne(targetEntity = DictItem.class, fetch = FetchType.LAZY, cascade = {
			CascadeType.REMOVE, CascadeType.MERGE })
	@JoinColumn(name = "parentItemId")
	private DictItem parent;

	public DictItem() {
	}

	public List<DictItem> getChildren() {
		return children;
	}

	public String getDescription() {
		return description;
	}

	public String getItemCode() {
		return itemCode;
	}

	public int getItemOrder() {
		return itemOrder;
	}

	public String getItemType() {
		return itemType;
	}

	public int getLevel() {
		return level;
	}

	public DictItem getParent() {
		return parent;
	}

	public String getShortName() {
		return shortName;
	}

	public boolean isChecked() {
		return checked;
	}

	public boolean isItemActive() {
		return itemActive;
	}

	public boolean isLeaf() {
		return leaf;
	}

	public void setChecked(boolean checked) {
		this.checked = checked;
	}

	public void setChildren(List<DictItem> children) {
		this.children = children;
	}
	
	public String getItemId() {
		return itemId;
	}

	public void setItemId(String itemId) {
		this.itemId = itemId;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setItemActive(boolean itemActive) {
		this.itemActive = itemActive;
	}

	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}

	public void setItemOrder(int itemOrder) {
		this.itemOrder = itemOrder;
	}

	public void setItemType(String itemType) {
		this.itemType = itemType;
	}

	public void setLeaf(boolean leaf) {
		this.leaf = leaf;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public void setParent(DictItem parent) {
		this.parent = parent;
	}

	public void setShortName(String shortName) {
		this.shortName = shortName;
	}
}