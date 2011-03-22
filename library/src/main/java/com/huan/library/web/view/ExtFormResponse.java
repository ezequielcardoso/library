package com.huan.library.web.view;

/**
 * 表单提交后返回给客户端的对象
 * @author shuaizhichun
 * @time 2011-3-23 上午02:18:59
 */
public class ExtFormResponse {

	private boolean success;
	private Object data;
	
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	
}
