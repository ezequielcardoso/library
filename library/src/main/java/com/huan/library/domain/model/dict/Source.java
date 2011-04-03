package com.huan.library.domain.model.dict;


import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
/**
 * 图书来源
 * @author huan
 * @time 2011-3-8  上午11:13:59
 */
@Entity
@DiscriminatorValue("Resource")
public class Source extends DictItem {
    /**
     * 
     */
	private static final long serialVersionUID = 1L;
	
	public Source(){
		super();
	}

}
