package com.huan.library.web.action;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.huan.library.domain.model.rights.Department;
import com.huan.library.domain.service.DepartmentService;
import com.huan.library.web.view.tree.ExtTreeNode;
import com.opensymphony.xwork2.Action;

@Controller("departmentAction")
public class DepartmentAction extends BaseActionSupport {
 
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    @Autowired
	private DepartmentService departmentService;
    
    private Department department;
    private Long pid;
    private Long deptId;
    private List<ExtTreeNode> deptChildrenNodes = new ArrayList<ExtTreeNode>();
    
    
	public String getDeptChildrenItem() {
		try {
			List<Department> items = departmentService.getDeptsByParentId(pid);
			for (Department item : items) {
				ExtTreeNode treeNode = new ExtTreeNode();
				treeNode.setId(item.getDeptId().toString());
				treeNode.setText(item.getDeptName());
				treeNode.setCls("x-tree-noicon");
				treeNode.setLeaf(item.getLeaf());
				treeNode.setIsOptional(false);
				deptChildrenNodes.add(treeNode);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Action.SUCCESS;
	}
	
	public String getDeptById() {
		try {
			department = departmentService.getDeptById(deptId);
			System.out.println(department.getDeptName());
			department.setChildren(null);
			department.setParent(null);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Action.SUCCESS;
	}
	/**
	 * 添加部门
	 * @return
	 */
	public String saveDeparment()  {
		try {

		} catch (Exception e) {
		  e.printStackTrace();
		 return Action.ERROR;
		}
		 return Action.SUCCESS;
	}
	

	/**
	 * 修改部门
	 * @return
	 */
	public String modifyDictItem()  {
		try {
			
		} catch (Exception e) {
			e.printStackTrace();
			return Action.ERROR;
		}
		return Action.SUCCESS;
	}
	
	/**
	 * 删除
	 * @return
	 */
	public String deleteDictItem() {
		try {
			
		} catch (Exception e) {
			e.printStackTrace();
			return Action.ERROR;
		}
		return Action.SUCCESS;
	}
	
	public DepartmentService getDepartmentService() {
		return departmentService;
	}

	public void setDepartmentService(DepartmentService departmentService) {
		this.departmentService = departmentService;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Long getPid() {
		return pid;
	}

	public void setPid(Long pid) {
		this.pid = pid;
	}

	public List<ExtTreeNode> getDeptChildrenNodes() {
		return deptChildrenNodes;
	}

	public void setDeptChildrenNodes(List<ExtTreeNode> deptChildrenNodes) {
		this.deptChildrenNodes = deptChildrenNodes;
	}

	public Long getDeptId() {
		return deptId;
	}

	public void setDeptId(Long deptId) {
		this.deptId = deptId;
	}

}
