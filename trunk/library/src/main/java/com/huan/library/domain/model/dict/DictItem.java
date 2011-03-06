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
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int itemId;//主键
	
	@Column(insertable=false,updatable=false)
	private String itemType;//参照组代码
	
	private String itemCode;//编码
	
	private String shortName;// 名字

	private String description;// 描述
	
	@ManyToOne(targetEntity=DictItem.class,fetch=FetchType.LAZY)
	@JoinColumn(name="parentItemId",referencedColumnName="itemId")
	private DictItem parent;
	
	@OneToMany(targetEntity=DictItem.class,fetch=FetchType.LAZY)
	@JoinColumn(name="itemId")
	private List<DictItem> children;

	//用于树结构
	private int level;//层级,根节点默认为0,根节点的子节点为1,孙子节点为2，以此类推
	private boolean leaf;//是否叶子
	private boolean checked;//是否选中
	
	private int itemOrder;//排序
	
	private boolean itemActive;//是否启用
	
	public DictItem(){		
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public String getItemType() {
		return itemType;
	}

	public void setItemType(String itemType) {
		this.itemType = itemType;
	}

	public String getItemCode() {
		return itemCode;
	}

	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}

	public String getShortName() {
		return shortName;
	}

	public void setShortName(String shortName) {
		this.shortName = shortName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public DictItem getParent() {
		return parent;
	}

	public void setParent(DictItem parent) {
		this.parent = parent;
	}

	public List<DictItem> getChildren() {
		return children;
	}

	public void setChildren(List<DictItem> children) {
		this.children = children;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public boolean isLeaf() {
		return leaf;
	}

	public void setLeaf(boolean leaf) {
		this.leaf = leaf;
	}

	public boolean isChecked() {
		return checked;
	}

	public void setChecked(boolean checked) {
		this.checked = checked;
	}

	public int getItemOrder() {
		return itemOrder;
	}

	public void setItemOrder(int itemOrder) {
		this.itemOrder = itemOrder;
	}

	public boolean isItemActive() {
		return itemActive;
	}

	public void setItemActive(boolean itemActive) {
		this.itemActive = itemActive;
	}

	
}