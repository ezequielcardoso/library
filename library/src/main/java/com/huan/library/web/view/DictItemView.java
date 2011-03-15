package com.huan.library.web.view;

public class DictItemView {
	
	public String key;
	
	public String value;
	
	public String comment;

	public String getKey() {
		return key;
	}
	public DictItemView(){
		
	}

	public DictItemView(String key, String value, String comment) {
		super();
		this.key = key;
		this.value = value;
		this.comment = comment;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

}
