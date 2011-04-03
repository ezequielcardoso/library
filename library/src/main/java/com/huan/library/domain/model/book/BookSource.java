package com.huan.library.domain.model.book;


import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import com.huan.library.domain.model.dict.DictItem;
/**
 * 图书来源
 * @author huan
 * @time 2011-3-8  上午11:13:59
 */
@Entity
@DiscriminatorValue("BookSource")
public class BookSource extends DictItem {
    /**
     * 
     */
	private static final long serialVersionUID = 1L;
	
	public BookSource(){
		super();
	}

}
