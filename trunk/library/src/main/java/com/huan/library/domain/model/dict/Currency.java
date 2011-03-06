package com.huan.library.domain.model.dict;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * 币种
 * @author shuaizhichun
 * @time 2011-3-6 下午10:30:24
 */
@Entity  
@DiscriminatorValue("Currency")
public class Currency extends DictItem {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Currency(){
		super();
	}

}
