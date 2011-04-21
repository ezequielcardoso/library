package com.huan.library.web.view;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map.Entry;

import com.huan.library.web.view.tree.ExtTreeNode;

/**
 * @author ShuaiZhichun
 * @version 1.0 2010-5-25用于树加载的view对象
 */

public class FunctionTreeNode extends ExtTreeNode{
	
	private String parentId;
	
	private List<FunctionTreeNode> children;

	public void addChild(FunctionTreeNode extTreeNode) {
		if (null == children)
			children = new ArrayList<FunctionTreeNode>();
		children.add(extTreeNode);
	}
	
	public FunctionTreeNode buildTree(FunctionTreeNode topResource,
			LinkedHashMap<String, FunctionTreeNode> resources) {
		Iterator<Entry<String, FunctionTreeNode>> iter = resources.entrySet()
				.iterator();
		while (iter.hasNext()) {
			Entry<String, FunctionTreeNode> entry = iter.next();
			if (entry.getValue().getParentId().equals(topResource
					.getId())) {
				topResource.addChild(entry.getValue());
			}
		}
		List<FunctionTreeNode> children = topResource.getChildren();
		if (children == null)
			return topResource;
		for (FunctionTreeNode re : children) {
			buildTree(re, resources);
		}
		return topResource;
	}

	public List<FunctionTreeNode> getChildren() {
		return children;
	}

	public void setChildren(List<FunctionTreeNode> children) {
		this.children = children;
	}

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}



}
