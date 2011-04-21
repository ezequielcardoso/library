package com.huan.library.web.view;

import java.io.Serializable;

public class FunctionView implements Serializable{

	private String funcId;//功能id
	private String funcName;//名字
	private Boolean funcActive;//是否启用
	
	private Integer funcOrder;//排序
	
	private String funcLogUrl;//日志url
	private String funcLogDesc;//日志业务描述
	
	//用于树结构
	private Integer level;//层级
	private Boolean leaf;//是否叶子
	private Boolean checked;//是否选中
	
	//用于按钮,链接等组件
	private String resCmpId;//组件id
	private String resCmpText;//组件显示的文本
	private String resCmpIconCls;//组件的样式
	private String resCmpHandURL;//组件事件处理要转向的视图
	
	private String parentId;
	
	private Integer roleId;

	public String getFuncId() {
		return funcId;
	}

	public void setFuncId(String funcId) {
		this.funcId = funcId;
	}

	public String getFuncName() {
		return funcName;
	}

	public void setFuncName(String funcName) {
		this.funcName = funcName;
	}

	public Boolean getFuncActive() {
		return funcActive;
	}

	public void setFuncActive(Boolean funcActive) {
		this.funcActive = funcActive;
	}

	public Integer getFuncOrder() {
		return funcOrder;
	}

	public void setFuncOrder(Integer funcOrder) {
		this.funcOrder = funcOrder;
	}

	public String getFuncLogUrl() {
		return funcLogUrl;
	}

	public void setFuncLogUrl(String funcLogUrl) {
		this.funcLogUrl = funcLogUrl;
	}

	public String getFuncLogDesc() {
		return funcLogDesc;
	}

	public void setFuncLogDesc(String funcLogDesc) {
		this.funcLogDesc = funcLogDesc;
	}

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	public Boolean getLeaf() {
		return leaf;
	}

	public void setLeaf(Boolean leaf) {
		this.leaf = leaf;
	}

	public Boolean getChecked() {
		return checked;
	}

	public void setChecked(Boolean checked) {
		this.checked = checked;
	}

	public String getResCmpId() {
		return resCmpId;
	}

	public void setResCmpId(String resCmpId) {
		this.resCmpId = resCmpId;
	}

	public String getResCmpText() {
		return resCmpText;
	}

	public void setResCmpText(String resCmpText) {
		this.resCmpText = resCmpText;
	}

	public String getResCmpIconCls() {
		return resCmpIconCls;
	}

	public void setResCmpIconCls(String resCmpIconCls) {
		this.resCmpIconCls = resCmpIconCls;
	}

	public String getResCmpHandURL() {
		return resCmpHandURL;
	}

	public void setResCmpHandURL(String resCmpHandURL) {
		this.resCmpHandURL = resCmpHandURL;
	}

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

}
