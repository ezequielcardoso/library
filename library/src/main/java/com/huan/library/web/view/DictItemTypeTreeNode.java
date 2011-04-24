package com.huan.library.web.view;

import com.huan.library.web.view.tree.ExtTreeNode;


public class DictItemTypeTreeNode extends ExtTreeNode {

	private String rootId;
	
	private String dictClass;

	public String getRootId() {
		return rootId;
	}

	public void setRootId(String rootId) {
		this.rootId = rootId;
	}

	public String getDictClass() {
		return dictClass;
	}

	public void setDictClass(String dictClass) {
		this.dictClass = dictClass;
	}
	
}
