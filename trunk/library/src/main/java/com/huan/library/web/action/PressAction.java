package com.huan.library.web.action;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.huan.library.domain.model.book.Press;
import com.huan.library.domain.service.PressService;
import com.huan.library.web.view.PressView;
import com.huan.library.web.view.form.ExtJsonForm;
import com.huan.library.web.view.grid.ExtGridLoad;
import com.huan.library.web.view.tree.ExtTreeNode;
import com.opensymphony.xwork2.Action;
@Controller("pressAction")
public class PressAction extends BaseActionSupport{
	
	
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private PressService pressService;
	
	private ExtGridLoad extGridLoad = new ExtGridLoad();
	//返回增加后的业务逻辑
	private ExtJsonForm extJsonForm = new ExtJsonForm();
 
	private Press press = new Press();
 	private PressView pressView = new PressView();
	private List<ExtTreeNode> pressNodes = new ArrayList<ExtTreeNode>();
	
	private Integer start;
	private Integer limit;
	
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
			return Action.ERROR;
		}
		return Action.SUCCESS;
	}


	public String pressMain()  {
    	return Action.SUCCESS;
    }
	
	/**
	 * 添加Press
	 * @return
	 * @throws Exception
	 */
	public String save()  {
		try {
			pressService.addOrModifyPress(press);
			extJsonForm.setSuccess(true);
			extJsonForm.setMsg("保存成功！");
			extJsonForm.setData(press);
		} catch (Exception e) {
		  e.printStackTrace();
		  extJsonForm.setSuccess(false);
		  extJsonForm.setMsg("保存失败");
		  extJsonForm.setData(null);
		 return Action.ERROR;
		}
		 return Action.SUCCESS;
	}
	
	/**
	 * 删除出版社
	 * @return
	 * @throws Exception
	 */
	public String remove() {
		try {
		   press.setPressId(pressView.getPressId());
		   pressService.removePress(press);
		   extJsonForm.setMsg("删除成功！");
		   extJsonForm.setSuccess(true);
		   extJsonForm.setData(null);
		} catch (Exception e) {
			e.printStackTrace();
			extJsonForm.setMsg("删除失败！");
			extJsonForm.setSuccess(false);
			extJsonForm.setData(null);
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
			pressView.setStart(start);
			pressView.setLimit(limit);
			List<Press> presses = pressService.findPresses(pressView);
			extGridLoad.setRoot(this.convertToView(presses));
			extGridLoad.setTotalProperty(pressView.getTotalCount());
		} catch (Exception e) {
			e.printStackTrace();
			return Action.ERROR;
		}
		return Action.SUCCESS;
	}
	
	public String exportExcel(){
   	    try {
   	    	String rootDir = this.getWebRoot();
   	    	String fileName = pressService.exportExcel(rootDir,pressView);
   	    	extJsonForm.setData(fileName);
   	    	extJsonForm.setSuccess(true);
   	    	extJsonForm.setMsg("导出成功");
		} catch (Exception e) {
			extJsonForm.setData("");
   	    	extJsonForm.setSuccess(false);
   	    	extJsonForm.setMsg("导出失败");
			return Action.ERROR;
		}
		return Action.SUCCESS;
	}
	
	public List<PressView> convertToView(List<Press> presses) {
		List<PressView> pressViews = new ArrayList<PressView>();
		try {
           for(Press press:presses){
        	   PressView pressView = new PressView();
        	   pressView.setPressId(press.getPressId());
        	   if(press.getPressISBN()!=null){
        		   pressView.setPressISBN(press.getPressISBN());
        	   }
        	   if(press.getPressName()!=null){
        		   pressView.setPressName(press.getPressName());
        	   }
        	   if(press.getPressAddress()!=null){
        		   pressView.setPressAddress(press.getPressAddress());
        	   }
        	   if(press.getZipCode()!=null){
        		   pressView.setZipCode(press.getZipCode());
        	   }
        	   pressViews.add(pressView);  
           }
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pressViews;
	}

	public Integer getStart() {
		return start;
	}
	public void setStart(Integer start) {
		this.start = start;
	}
	public Integer getLimit() {
		return limit;
	}
	public void setLimit(Integer limit) {
		this.limit = limit;
	}
	public ExtGridLoad getExtGridLoad() {
		return extGridLoad;
	}
	public void setExtGridLoad(ExtGridLoad extGridLoad) {
		this.extGridLoad = extGridLoad;
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

	public Press getPress() {
		return press;
	}

	public void setPress(Press press) {
		this.press = press;
	}

	public void setPressService(PressService pressService) {
		this.pressService = pressService;
	}
	public ExtJsonForm getExtJsonForm() {
		return extJsonForm;
	}

	public void setExtJsonForm(ExtJsonForm extJsonForm) {
		this.extJsonForm = extJsonForm;
	}

 
}
