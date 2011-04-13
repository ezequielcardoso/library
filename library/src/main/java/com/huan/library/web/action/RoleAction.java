package com.huan.library.web.action;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.huan.library.domain.model.rights.Role;
import com.huan.library.domain.service.RoleService;
import com.huan.library.util.DateFormatUtil;
import com.huan.library.web.view.RoleView;
import com.huan.library.web.view.form.ExtJsonForm;
import com.huan.library.web.view.grid.ExtGridLoad;
import com.huan.library.web.view.tree.ExtTreeNode;
import com.opensymphony.xwork2.Action;

@Controller("roleAction")
public class RoleAction extends BaseActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	static Logger logger = Logger.getLogger(RoleAction.class.getName());
	
	@Autowired
	private RoleService roleService;
	
	private Role role = new Role();
	private RoleView roleView = new RoleView();
	private ExtJsonForm extJsonForm = new ExtJsonForm();
	private ExtGridLoad extGridLoad = new ExtGridLoad(); 
	private List<ExtTreeNode> childrenNodes = new ArrayList<ExtTreeNode>();
	private Integer start;
	private Integer limit;
	
	/**
	 * 保存角色
	 * @return
	 * @throws Exception
	 */
	public String save() {
		try {
			this.formatRole(role);
			role = roleService.save(role);
			extJsonForm.setSuccess(true);
			extJsonForm.setMsg("保存成功！");
			extJsonForm.setData(role);
		} catch (Exception e) {
			e.printStackTrace();
			extJsonForm.setSuccess(false);
			extJsonForm.setMsg("保存失败！");
			return Action.ERROR;
		}
		return Action.SUCCESS;
	}
	
	public String remove() {
		try {
			Role role = new Role();
			role.setRoleId(roleView.getRoleId());
			// 这里可以取到值
			roleService.remove(role);
			extJsonForm.setSuccess(true);
			extJsonForm.setMsg("删除成功！");
			extJsonForm.setData(null);
		} catch (Exception e) {
			e.printStackTrace();
			extJsonForm.setSuccess(false);
			extJsonForm.setMsg("删除失败！");
			extJsonForm.setData(null);
			return Action.ERROR;
		}
		return Action.SUCCESS;
	}
	
	private void formatRole(Role role) {
		if(role.getUsers()==null || role.getUsers().size()==0){
			role.setUsers(null);
		}
		if(role.getFunctions()==null || role.getFunctions().size()==0){
			role.setFunctions(null);
		}
	}

	public String findRoles(){
		try {
			roleView.setStart(start);
			roleView.setLimit(limit);
			List<Role> roles = roleService.findRoles(roleView);
			extGridLoad.setRoot(this.convertToView(roles));
			extGridLoad.setTotalProperty(roleView.getTotalCount());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Action.SUCCESS;
		
	}
	
	public List<RoleView> convertToView(List<Role> roles ){
		List<RoleView> views = new ArrayList<RoleView>();
		for(int i=0; i<roles.size(); i++){
			RoleView view = new RoleView();
			view.setRoleId(roles.get(i).getRoleId());
			if(roles.get(i).getRoleName()!=null){
				view.setRoleName(roles.get(i).getRoleName());
			}
			if(roles.get(i).getRoleDesc()!=null){
				view.setRoleDesc(roles.get(i).getRoleDesc());
			}
			if(roles.get(i).getCreateDate()!=null){
				view.setCreateDate(DateFormatUtil.format(roles.get(i).getCreateDate(), "yyyy-MM-dd"));	
			}
			if(roles.get(i).getRoleActive()!=null){
				view.setRoleActive(roles.get(i).getRoleActive());
			}
			views.add(view);
		}
		return views;
	}

	public String findAllByUserId() {
		try {
			roleView.setStart(start);
			roleView.setLimit(limit);
			List<Role> allRoles = roleService.findRoles(roleView);
			List<Role> roles = roleService.findRoles(new RoleView());
			
			for (int i=0; i<roles.size(); i++) {
				roles.get(i).setChecked(false);
			}
			for (int i=0; i<allRoles.size(); i++) {
				allRoles.get(i).setChecked(true);
			}
			Set<Role> roleSet = new HashSet<Role>();
			roleSet.addAll(roles);
			roleSet.addAll(allRoles);
			for (Role role : roleSet) {
				ExtTreeNode treeNode = new ExtTreeNode();
				treeNode.setId(role.getRoleId().toString());
				treeNode.setText(role.getRoleName());
				treeNode.setLeaf(true);
				treeNode.setChecked(role.getChecked());
				treeNode.setIsOptional(true);
				childrenNodes.add(treeNode);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Action.SUCCESS;
	}
	
	public List<ExtTreeNode> getChildrenNodes() {
		return childrenNodes;
	}

	public void setChildrenNodes(List<ExtTreeNode> childrenNodes) {
		this.childrenNodes = childrenNodes;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public RoleView getRoleView() {
		return roleView;
	}

	public void setRoleView(RoleView roleView) {
		this.roleView = roleView;
	}

	public ExtJsonForm getExtJsonForm() {
		return extJsonForm;
	}

	public void setExtJsonForm(ExtJsonForm extJsonForm) {
		this.extJsonForm = extJsonForm;
	}

	public ExtGridLoad getExtGridLoad() {
		return extGridLoad;
	}

	public void setExtGridLoad(ExtGridLoad extGridLoad) {
		this.extGridLoad = extGridLoad;
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

	public void setRoleService(RoleService roleService) {
		this.roleService = roleService;
	}


}
