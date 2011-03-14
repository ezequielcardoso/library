package com.huan.library.domain.model.dict;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;


/**
 * 图书级别
 * @author huan
 * @time 2011-3-8  上午11:02:32
 */
@Entity
@DiscriminatorValue("BookLevel")
public class BookLevel extends DictItem {
	
    /**
     * 
     */
	private static final long serialVersionUID = 1L;
    
	public BookLevel(){
		super();
	}

}
