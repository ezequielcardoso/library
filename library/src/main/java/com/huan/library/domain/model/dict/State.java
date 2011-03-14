package com.huan.library.domain.model.dict;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * 图书状态
 * @author huan
 *
 */
@Entity  
@DiscriminatorValue("State")
public class State extends DictItem {
     
	private static final long serialVersionUID = 1L;

	public State(){
		super();
	}
}
