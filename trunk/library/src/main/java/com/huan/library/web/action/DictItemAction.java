package com.huan.library.web.action;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.huan.library.domain.model.dict.DictItem;
import com.huan.library.domain.service.DictItemService;
import com.huan.library.web.view.tree.ExtTreeNode;
import com.opensymphony.xwork2.Action;

/**
 * 字典action
 * @author huan
 * @time  2011-3-14 上午11:00:31
 */
@Controller("dictItemAction")
public class DictItemAction extends BaseActionSupport {
 
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    @Autowired
	private DictItemService dictItemService;
    
    private DictItem dictItem;
    private String pid;
    private String className;
    private Integer level;
    private String itemName;
    private List<ExtTreeNode> dictChildrenNodes = new ArrayList<ExtTreeNode>();
    
	public void setDictItemService(DictItemService dictItemService) {
		this.dictItemService = dictItemService;
	}
    
	public String getChildrenItem() {
		try {
			List<DictItem> dictItems = dictItemService.getChildrenItem(pid, className);
			for (DictItem item : dictItems) {
				ExtTreeNode treeNode = new ExtTreeNode();
				treeNode.setId(item.getItemId());
				treeNode.setText(item.getItemName());
				treeNode.setCls("x-tree-noicon");
				treeNode.setLeaf(item.getLeaf());
				treeNode.setChecked(false);
				treeNode.setIsOptional(true);
				dictChildrenNodes.add(treeNode);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Action.SUCCESS;
	}
	
	public String getCategoryItem() {
		try {
			List<DictItem> dictItems = dictItemService.getCategoryItem(pid, level, itemName);
			for (DictItem item : dictItems) {
				ExtTreeNode treeNode = new ExtTreeNode();
				treeNode.setId(item.getItemId());
				treeNode.setText(item.getItemName());
				if(level==1){
					treeNode.setText(item.getItemShortName());
				}
				treeNode.setCls("x-tree-noicon");
				treeNode.setLeaf(true);
				treeNode.setChecked(false);
				treeNode.setIsOptional(true);
				dictChildrenNodes.add(treeNode);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Action.SUCCESS;
	}
	
	/**
	 * 添加字典
	 * @return
	 */
	public String saveDictItem()  {
		try {
			dictItemService.addOrModifyDictItem(dictItem);
		} catch (Exception e) {
		  e.printStackTrace();
		 return Action.ERROR;
		}
		 return Action.SUCCESS;
	}
	

	/**
	 * 修改字典
	 * @return
	 */
	public String modifyDictItem()  {
		try {
		 dictItemService.addOrModifyDictItem(dictItem);
		} catch (Exception e) {
			e.printStackTrace();
			return Action.ERROR;
		}
		return Action.SUCCESS;
	}
	
	/**
	 * 删除dictItem
	 * @return
	 */
	public String deleteDictItem() {
		try {
		  dictItemService.removeDictItem(dictItem);
		} catch (Exception e) {
			e.printStackTrace();
			return Action.ERROR;
		}
		return Action.SUCCESS;
	}
	
	/**
	 * 查找所有的dictItem
	 * @return
	 */
	public String findDictItem() {
		try {
		  List<DictItem> dictItemList = dictItemService.findAllDictItems();
		} catch (Exception e) {
			e.printStackTrace();
			return Action.ERROR;
		}
		return Action.SUCCESS;
	}

	public DictItem getDictItem() {
		return dictItem;
	}

	public void setDictItem(DictItem dictItem) {
		this.dictItem = dictItem;
	}

	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public List<ExtTreeNode> getDictChildrenNodes() {
		return dictChildrenNodes;
	}

	public void setDictChildrenNodes(List<ExtTreeNode> dictChildrenNodes) {
		this.dictChildrenNodes = dictChildrenNodes;
	}

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	
}
