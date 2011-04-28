package com.huan.library.web.action;


import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.huan.library.domain.model.rights.Function;
import com.huan.library.domain.model.rights.User;
import com.huan.library.domain.service.FunctionService;
import com.huan.library.web.view.FunctionTreeNode;
import com.huan.library.web.view.FunctionView;
import com.huan.library.web.view.form.ExtJsonForm;
import com.opensymphony.xwork2.Action;

/**
 * 
 * @author shuaizhichun
 * @time 2011-3-21 上午01:45:56
 */
@Controller("functionAction")
public class FunctionAction extends BaseActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Function function = new Function();
	private FunctionView functionView = new FunctionView();
	private List<Function> modules = new ArrayList<Function>();
	List<FunctionView> views = new ArrayList<FunctionView>();
	private ExtJsonForm extJsonForm = new ExtJsonForm();
	List<FunctionTreeNode> completeTree = new ArrayList<FunctionTreeNode>();
	
	@Autowired
	private FunctionService functionService ;
	
	public void setFunctionService(FunctionService functionService) {
		this.functionService = functionService;
	}

	public String functionMain(){
		return Action.SUCCESS;
	}
	
	public String remove(){
		Function oldFunc = this.functionService.getById(function);
		Function parent = this.functionService.getById(oldFunc.getParent());
		if(oldFunc.getChildren().size()>0){
			extJsonForm.setSuccess(true);
			extJsonForm.setMsg("");
			extJsonForm.setData("c");
			return Action.SUCCESS;
		}
		this.functionService.remove(function);
		parent.getChildren().remove(oldFunc);
		if(parent.getChildren().size()>0){
			extJsonForm.setSuccess(true);
			extJsonForm.setMsg("");
			extJsonForm.setData("y");
			return Action.SUCCESS;
		}
		extJsonForm.setSuccess(true);
		extJsonForm.setMsg("");
		extJsonForm.setData("p");
		return Action.SUCCESS;
	}
	

	/**
	 * 查找系统模块功能
	 * @return
	 * @throws Exception
	 */
	public String findModules() {
		try {
			User currUser = (User)request.getSession().getAttribute("currUser");
			modules = functionService.findModules(currUser.getRoles());
		} catch (Exception e) {
			e.printStackTrace();
			return Action.ERROR;
		}
		return Action.SUCCESS;
	}

	public String findTreeColumn(){
		List<Function> functions = functionService.findFunctions(functionView);
		
		String[] ignoreList = {"roles","parent"};
		for(Function func :functions){
			FunctionView view = new FunctionView();
			BeanUtils.copyProperties(func, view, ignoreList);
			view.setLeaf(func.getLeaf());
			view.setParentId(func.getParentFuncId());
			views.add(view);
		}
		return Action.SUCCESS;
	}
	
	/**
	 * 保存功能
	 * @return
	 * @throws Exception
	 */
	public String save() {
		try {
			function.setParent((function.getParent() != null
					&& function.getParent().getFuncId() != null && !"".equals(function
					.getParent().getFuncId())) ? function.getParent() : null);
			function = functionService.save(function);
			extJsonForm.setSuccess(true);
			extJsonForm.setMsg("保存成功！");
			extJsonForm.setData(function);
		} catch (Exception e) {
			e.printStackTrace();
			extJsonForm.setSuccess(false);
			extJsonForm.setMsg("保存失败！");
			return Action.ERROR;
		}
		return Action.SUCCESS;
	}
	
	/**
	 * 分配权限时查询所有的功能
	 * 以树的形式全部展开显示
	 */
	public String findFunctionTree() {
		
		List<String> roleOids = null;
		if (functionView != null && functionView.getRoleId() != null) {
			List<Function> funcs = this.functionService.findByRoleId(functionView);
			if (funcs != null && funcs.size() != 0) {
				roleOids = new ArrayList<String>();
				for (Function function : funcs) {
					roleOids.add(function.getFuncId());
				}
			}
			
			List<Function> functions = this.functionService.findAll();
			List<FunctionTreeNode> treeNodes = new ArrayList<FunctionTreeNode>();
			for (Function function : functions) {
				FunctionTreeNode ftr = new FunctionTreeNode();
				ftr.setId(function.getFuncId());
				ftr.setParentId(function.getParentFuncId());
				ftr.setText(function.getResCmpText());
				ftr.setLeaf(function.getLeaf());
				if (roleOids != null && roleOids.contains(function.getFuncId())){
					ftr.setChecked(true);
				}else{
					ftr.setChecked(false);
				}
				ftr.setExpanded(true);
				treeNodes.add(ftr);
			}
			LinkedHashMap<String, FunctionTreeNode> retp = new LinkedHashMap<String, FunctionTreeNode>();
			for (FunctionTreeNode ri : treeNodes) {
				if (ri.getParentId() != null)
					retp.put(ri.getId(), ri);
			}
			for (FunctionTreeNode ri : treeNodes) {
				if (ri.getParentId() == null) {				
					ri = ri.buildTree(ri, retp);
					completeTree.add(ri);
				}
			}
		}
		return Action.SUCCESS;
	}
	
	public Function getFunction() {
		return function;
	}
	public void setFunction(Function function) {
		this.function = function;
	}
	public FunctionView getFunctionView() {
		return functionView;
	}
	public void setFunctionView(FunctionView functionView) {
		this.functionView = functionView;
	}
	public List<Function> getModules() {
		return modules;
	}
	public void setModules(List<Function> modules) {
		this.modules = modules;
	}
	public List<FunctionView> getViews() {
		return views;
	}
	public void setViews(List<FunctionView> views) {
		this.views = views;
	}
	public ExtJsonForm getExtJsonForm() {
		return extJsonForm;
	}
	public void setExtJsonForm(ExtJsonForm extJsonForm) {
		this.extJsonForm = extJsonForm;
	}
	public List<FunctionTreeNode> getCompleteTree() {
		return completeTree;
	}
	public void setCompleteTree(List<FunctionTreeNode> completeTree) {
		this.completeTree = completeTree;
	}
	public FunctionService getFunctionService() {
		return functionService;
	}
	
}
