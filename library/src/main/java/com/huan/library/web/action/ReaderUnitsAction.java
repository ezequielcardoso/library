package com.huan.library.web.action;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.huan.library.domain.model.reader.ReaderUnits;
import com.huan.library.domain.service.ReaderUnitsService;
import com.huan.library.web.view.form.ExtJsonForm;
import com.huan.library.web.view.tree.ExtTreeNode;
import com.opensymphony.xwork2.Action;

/**
 * 读者单位
 * 
 * @author huan
 * @time 2011-4-10 下午07:28:39
 */
@Controller("readerUnitsAction")
public class ReaderUnitsAction extends BaseActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Autowired
	private ReaderUnitsService readerUnitsService;

	private ReaderUnits unit = new ReaderUnits();
	private Long pid;
	private Long id;
	private List<ExtTreeNode> childrenNodes = new ArrayList<ExtTreeNode>();
	private ExtJsonForm extJsonForm = new ExtJsonForm();

	public String getChildrenByPid() {
		List<ReaderUnits> units = new ArrayList<ReaderUnits>();
		try {
			units = readerUnitsService.getChildrenByPid(pid);
			for (ReaderUnits unit : units) {
				ExtTreeNode treeNode = new ExtTreeNode();
				treeNode.setId(unit.getUnitId().toString());
				treeNode.setText(unit.getUnitName());
				treeNode.setLeaf(unit.getLeaf());
				treeNode.setIsOptional(false);    //干什么用的
				
				childrenNodes.add(treeNode);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return Action.ERROR;
		}
		return Action.SUCCESS;
	}
	
	public String getById() {
		try {
			unit = readerUnitsService.getById(id);
			unit.setParentUnit(null);
			unit.setChildrenUnits(null);
		} catch (Exception e) {
		   e.printStackTrace();
		   return Action.ERROR;
		}
		return Action.SUCCESS;
	}
	
	/**
	 * 增加或是修改
	 * @return
	 */
	public String save(){
		try {
			unit = readerUnitsService.save(unit);
			extJsonForm.setSuccess(true);
			extJsonForm.setMsg("保存成功！");
			extJsonForm.setData(unit);
		} catch (Exception e) {
		  e.printStackTrace();
		  extJsonForm.setSuccess(false);
		  extJsonForm.setMsg("保存失败！");
		  extJsonForm.setData(null);
		  return Action.ERROR;
		}
		return Action.SUCCESS;
	}

	/**
	 * 移除
	 * @return
	 */
	public String remove() {
		try {
			unit.setUnitId(id);
			readerUnitsService.remove(unit);
		    extJsonForm.setSuccess(true);
		    extJsonForm.setMsg("删除成功！");
		    extJsonForm.setData(null);
		} catch (Exception e) {
		  e.printStackTrace();
		  extJsonForm.setSuccess(false);
		  extJsonForm.setMsg("移除失败！");
		  extJsonForm.setData(null);
		  return Action.ERROR;
		}
		return Action.SUCCESS;
	}
	
	public ReaderUnits getUnit() {
		return unit;
	}

	public void setUnit(ReaderUnits unit) {
		this.unit = unit;
	}

	public Long getPid() {
		return pid;
	}

	public void setPid(Long pid) {
		this.pid = pid;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<ExtTreeNode> getChildrenNodes() {
		return childrenNodes;
	}

	public void setChildrenNodes(List<ExtTreeNode> childrenNodes) {
		this.childrenNodes = childrenNodes;
	}

	public ExtJsonForm getExtJsonForm() {
		return extJsonForm;
	}

	public void setExtJsonForm(ExtJsonForm extJsonForm) {
		this.extJsonForm = extJsonForm;
	}

	public void setReaderUnitsService(ReaderUnitsService readerUnitsService) {
		this.readerUnitsService = readerUnitsService;
	}

}
