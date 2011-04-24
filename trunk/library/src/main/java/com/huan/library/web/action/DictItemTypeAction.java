package com.huan.library.web.action;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.huan.library.domain.model.dict.DictItemType;
import com.huan.library.domain.service.DictItemTypeService;
import com.huan.library.web.view.DictItemTypeTreeNode;
import com.huan.library.web.view.tree.ExtTreeNode;
import com.opensymphony.xwork2.Action;

@Controller("dictItemTypeAction")
public class DictItemTypeAction extends BaseActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private DictItemTypeService dictItemTypeService;

	private List<ExtTreeNode> childrenNodes = new ArrayList<ExtTreeNode>();
    
	public String getChildrenByPid() {
		try {
			List<DictItemType> items = dictItemTypeService.findAll();
			for (DictItemType item : items) {
				DictItemTypeTreeNode treeNode = new DictItemTypeTreeNode();
				treeNode.setId(item.getTypeId().toString());
				treeNode.setText(item.getRoot().getItemName());
				treeNode.setLeaf(true);
				treeNode.setRootId(item.getRoot().getItemId());
				treeNode.setDictClass(item.getDictClass());
				childrenNodes.add(treeNode);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Action.SUCCESS;
	}

}
