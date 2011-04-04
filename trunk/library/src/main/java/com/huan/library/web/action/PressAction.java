package com.huan.library.web.action;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.huan.library.domain.model.book.Press;
import com.huan.library.domain.service.PressService;
import com.huan.library.util.PageModel;
import com.huan.library.web.view.tree.ExtTreeNode;
import com.huan.library.web.view.PressView;
import com.opensymphony.xwork2.Action;

 class PressAction extends BaseActionSupport{
	
	
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private PressService pressService;
	
	private Press press = new Press();
	private PressView pressView = new PressView();
	private List<ExtTreeNode> pressNodes = new ArrayList<ExtTreeNode>();
	
	
	public Press getPress() {
		return press;
	}
	public void setPress(Press press) {
		this.press = press;
	}

	public void setPressService(PressService pressService) {
		this.pressService = pressService;
	}
	
	public String getPressItem() {
		try {
			List<Press> presses = pressService.findPresses(pressView);
			for (Press press : presses) {
				ExtTreeNode treeNode = new ExtTreeNode();
				treeNode.setId(press.getPressId().toString());
				treeNode.setText(press.getPressName());
				treeNode.setCls("x-tree-noicon");
				treeNode.setLeaf(true);
				treeNode.setChecked(false);
				treeNode.setIsOptional(true);
				pressNodes.add(treeNode);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Action.SUCCESS;
	}

	public PressView getPressView() {
		return pressView;
	}
	public void setPressView(PressView pressView) {
		this.pressView = pressView;
	}
	public List<ExtTreeNode> getPressNodes() {
		return pressNodes;
	}
	public void setPressNodes(List<ExtTreeNode> pressNodes) {
		this.pressNodes = pressNodes;
	}
	/**
	 * 显示添加出版社
	 * @return
	 * @throws Exception
	 */
	
	public String showSavePress()  {
    	return "showSavePress";
    }
    
	/**
	 * 添加Press
	 * @return
	 * @throws Exception
	 */
	public String savePress()  {
		try {
			pressService.addOrModifyPress(press);
		} catch (Exception e) {
		  e.printStackTrace();
		 return Action.ERROR;
		}
		 return Action.SUCCESS;
	}
	
	/**
	 * 显示修改出版社
	 * @return
	 * @throws Exception
	 */
	public String showModifyPress() {
		try {
			  //press会不会为空
	          Press pressModify = pressService.findPressById(press.getPressId());
			} catch (Exception e) {
				e.printStackTrace();
				return Action.ERROR;
			}
		return "showModifyPress";
	}
	
	/**
	 * 修改出版社
	 * @return
	 * @throws Exception
	 */
	public String modifyPress()  {
		try {
			 //press会不会为空
           pressService.addOrModifyPress(press);
		} catch (Exception e) {
			e.printStackTrace();
			return Action.ERROR;
		}
		return Action.SUCCESS;
	}
	
	/**
	 * 删除出版社
	 * @return
	 * @throws Exception
	 */
	public String deletePress() {
		try {
		   pressService.removePress(press);
		} catch (Exception e) {
			e.printStackTrace();
			return Action.ERROR;
		}
		return Action.SUCCESS;
	}
	
	
	/**
	 * 查找所有的出版社
	 * @return
	 * @throws Exception
	 */
	public String findPresses() {
		try {
			//执行查找操作
		} catch (Exception e) {
			e.printStackTrace();
			return Action.ERROR;
		}
		return Action.SUCCESS;
	}

	/**
	 * 分页查找出版社
	 * @return
	 * @throws Exception
	 */
	public String findPressesByPage() {
		int pageNo=0;int pageSize=3;
		PageModel<Press> pressModel = new PageModel<Press>();
		try {
			pressModel = pressService.findPressesByPage(pageNo, pageSize);
		} catch (Exception e) {
			e.printStackTrace();
			return Action.ERROR;
		}
		return Action.SUCCESS;
	}

}
