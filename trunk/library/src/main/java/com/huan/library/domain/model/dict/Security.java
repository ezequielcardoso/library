package com.huan.library.domain.model.dict;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * 图书密级 /保留/浏览//公开/
 * @author shuaizhichun
 * @time 2011-3-6 下午10:24:56
 */
@Entity  
@DiscriminatorValue("Security")
public class Security extends DictItem {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Security(){
		super();
	}
	
}
