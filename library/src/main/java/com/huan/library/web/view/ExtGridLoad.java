package com.huan.library.web.view;

import java.util.List;

/**
 * 返回给Grid分页数据的基类
 * @author shuaizhichun
 * @time 2011-3-28 上午01:26:20
 */
public class ExtGridLoad implements java.io.Serializable {

	private int totalProperty;//总记录数
	private List root;//返回的分页数据
	
	public ExtGridLoad(){
		
	}

	public int getTotalProperty() {
		return totalProperty;
	}

	public void setTotalProperty(int totalProperty) {
		this.totalProperty = totalProperty;
	}

	public List getRoot() {
		return root;
	}

	public void setRoot(List root) {
		this.root = root;
	}

	
}
