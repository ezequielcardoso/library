package com.huan.library.web.view.tree;

/**
 * 
 * @author Administrator
 *
 */
public class ExtTreeNode {
	
	private String id;
	private String text;
	private String cls;
	private String iconCls;
	private Boolean childrenLoaded = false;
	private Boolean leaf = false;
	private Boolean expanded;
	private Boolean checked;
	private Boolean isOptional = true;
	
	public Boolean getLeaf() {
		return leaf;
	}

	public String getId() {
		return id;
	}

	public String getText() {
		return text;
	}

	public String getCls() {
		return cls;
	}

	public String getIconCls() {
		return iconCls;
	}

	public Boolean getChildrenLoaded() {
		return childrenLoaded;
	}


	public Boolean getExpanded() {
		return expanded;
	}



	public void setId(String id) {
		this.id = id;
	}

	public void setText(String text) {
		this.text = text;
	}

	public void setCls(String cls) {
		this.cls = cls;
	}

	public void setIconCls(String iconCls) {
		this.iconCls = iconCls;
	}

	public void setChildrenLoaded(Boolean childrenLoaded) {
		this.childrenLoaded = childrenLoaded;
	}

	public void setLeaf(Boolean leaf) {
		this.leaf = leaf;
	}

	public void setExpanded(Boolean expanded) {
		this.expanded = expanded;
	}


	public Boolean getIsOptional() {
		return isOptional;
	}

	public void setIsOptional(Boolean isOptional) {
		this.isOptional = isOptional;
	}

	public Boolean getChecked() {
		return checked;
	}

	public void setChecked(Boolean checked) {
		this.checked = checked;
	}


}
