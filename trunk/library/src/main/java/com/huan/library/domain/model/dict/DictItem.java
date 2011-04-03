package com.huan.library.domain.model.dict;

import java.util.List;

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
    private String itemId;// 字典编号
	private String itemName;// 名字
	private String itemDesc;// 描述
	private Boolean itemActive;// 是否启用
	private String itemCode;// 编码
	private Integer itemOrder;// 排序
	private Boolean checked;// 是否选中
	private Boolean leaf;// 是否叶子
	private Integer level;// 层级,根节点默认为0,根节点的子节点为1,孙子节点为2，以此类推
	
	@OneToMany(targetEntity = DictItem.class, fetch = FetchType.LAZY, mappedBy = "parent")
	private List<DictItem> children;

	@Column(insertable = false, updatable = false)
	private String itemType;// 参照组代码

	@ManyToOne(targetEntity = DictItem.class, fetch = FetchType.LAZY)
	@JoinColumn(name = "parentItemId",referencedColumnName="itemId")
	private DictItem parent;         

	public DictItem() {
	}


	public String getItemId() {
		return itemId;
	}

	public void setItemId(String itemId) {
		this.itemId = itemId;
	}

	public Boolean getChecked() {
		return checked;
	}

	public void setChecked(Boolean checked) {
		this.checked = checked;
	}

	public Boolean getItemActive() {
		return itemActive;
	}

	public void setItemActive(Boolean itemActive) {
		this.itemActive = itemActive;
	}

	public String getItemCode() {
		return itemCode;
	}

	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}

	public Integer getItemOrder() {
		return itemOrder;
	}

	public void setItemOrder(Integer itemOrder) {
		this.itemOrder = itemOrder;
	}

	public Boolean getLeaf() {
		return leaf;
	}

	public void setLeaf(Boolean leaf) {
		this.leaf = leaf;
	}

	public List<DictItem> getChildren() {
		return children;
	}

	public void setChildren(List<DictItem> children) {
		this.children = children;
	}

	public String getItemType() {
		return itemType;
	}

	public void setItemType(String itemType) {
		this.itemType = itemType;
	}

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	public DictItem getParent() {
		return parent;
	}

	public void setParent(DictItem parent) {
		this.parent = parent;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getItemDesc() {
		return itemDesc;
	}

	public void setItemDesc(String itemDesc) {
		this.itemDesc = itemDesc;
	}

	
}