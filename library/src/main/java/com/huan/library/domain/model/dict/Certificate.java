package com.huan.library.domain.model.dict;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * 证件 如:学生证/身份证/驾驶本
 * @author shuaizhichun
 * @time 2011-3-6 下午10:35:51
 */
@Entity  
@DiscriminatorValue("Certificate")
public class Certificate extends DictItem {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Certificate(){
		super();
	}
}
