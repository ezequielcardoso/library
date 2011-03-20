package com.huan.library.domain.model.rights;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 * 功能
 * @author shuaizhichun
 * @time 2011-3-6 下午10:27:12
 */
@Entity
public class Function implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
//	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int funcId;//功能id
	private String funcName;//名字
	private boolean funcActive;//是否启用
	
	//功能排序
	private int funcOrder;//排序
	
	//做日志用
	private String funcLogUrl;//日志url
	private String funcLogDesc;//日志业务描述
	
	//用于树结构
	private int level;//层级,根节点默认为0,根节点的子节点为1,孙子节点为2，以此类推
	private boolean leaf;//是否叶子
	private boolean checked;//是否选中
	
	//用于按钮,链接等组件
	private String resCmpId;//组件id
	private String resCmpText;//组件显示的文本
	private String resCmpIconCls;//组件的样式
	private String resCmpHandURL;//组件事件处理要转向的视图，如链接到某个jsp页面
	
	//父功能
	@ManyToOne(targetEntity=Function.class,fetch=FetchType.LAZY)
	@JoinColumn(name="parentFuncId",referencedColumnName="funcId")
	private Function parent;
	
	//子功能
	@OneToMany(targetEntity=Function.class)
	@JoinColumn(name="funcId")
	private List<Function> children = new ArrayList<Function>();

	//拥有此功能的所有角色对象
	@ManyToMany(
			mappedBy="functions",targetEntity=Role.class,
			fetch=FetchType.LAZY,cascade=CascadeType.REMOVE)
	private List<Role> roles = new ArrayList<Role>();

	public Function(){
		
	}
	
	public Function(int funcId, String funcName, boolean funcActive, int funcOrder, int level, String resCmpId,
			String resCmpText, String resCmpIconCls, String resCmpHandURL){
		this.funcId = funcId;
		this.funcName = funcName;
		this.funcActive = funcActive;
		this.funcOrder = funcOrder;
		this.level = level;
		this.resCmpId = resCmpId;
		this.resCmpText = resCmpText;
		this.resCmpIconCls = resCmpIconCls;
		this.resCmpHandURL = resCmpHandURL;
	}
	
	public int getFuncId() {
		return funcId;
	}

	public void setFuncId(int funcId) {
		this.funcId = funcId;
	}

	public String getFuncName() {
		return funcName;
	}

	public void setFuncName(String funcName) {
		this.funcName = funcName;
	}

	public boolean isFuncActive() {
		return funcActive;
	}

	public void setFuncActive(boolean funcActive) {
		this.funcActive = funcActive;
	}

	public int getFuncOrder() {
		return funcOrder;
	}

	public void setFuncOrder(int funcOrder) {
		this.funcOrder = funcOrder;
	}

	public String getFuncLogUrl() {
		return funcLogUrl;
	}

	public void setFuncLogUrl(String funcLogUrl) {
		this.funcLogUrl = funcLogUrl;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public boolean isLeaf() {
		return leaf;
	}

	public void setLeaf(boolean leaf) {
		this.leaf = leaf;
	}

	public boolean isChecked() {
		return checked;
	}

	public void setChecked(boolean checked) {
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

	public Function getParent() {
		return parent;
	}

	public void setParent(Function parent) {
		this.parent = parent;
	}

	public List<Function> getChildren() {
		return children;
	}

	public void setChildren(List<Function> children) {
		this.children = children;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public String getFuncLogDesc() {
		return funcLogDesc;
	}

	public void setFuncLogDesc(String funcLogDesc) {
		this.funcLogDesc = funcLogDesc;
	}

}
