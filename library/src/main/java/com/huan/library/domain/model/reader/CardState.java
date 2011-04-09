package com.huan.library.domain.model.reader;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import com.huan.library.domain.model.dict.DictItem;

/**
 * 借阅证状态
 * @author shuaizhichun
 * 2010-4-8
 */
@Entity  
@DiscriminatorValue("CardState")
public class CardState  extends DictItem {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CardState(){
		super();
	}
}
