package com.huan.library.web.view.form;

/**
 * 表单提交后返回给客户端的对象
 * @author shuaizhichun
 * @time 2011-3-23 上午02:18:59
 */
public class ExtJsonForm {

	private boolean success;//业务处理是否成功
	private String msg;//业务处理后回复的消息
	private Object data;//业务处理后回复的业务对象
	
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
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
}
