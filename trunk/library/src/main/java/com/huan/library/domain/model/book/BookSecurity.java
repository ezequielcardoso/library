package com.huan.library.domain.model.book;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import com.huan.library.domain.model.dict.DictItem;

/**
 * 图书密级 /1/2/3/4
 * @author shuaizhichun
 * @time 2011-3-6 下午10:24:56
 */
@Entity  
@DiscriminatorValue("BookSecurity")
public class BookSecurity extends DictItem {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public BookSecurity(){
		super();
	}
	
}
