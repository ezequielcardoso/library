package com.huan.library.domain.model.reader;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import com.huan.library.domain.model.dict.DictItem;
/**
 * 读者单位实体
 * @author huan
 * @time 2011-3-14 下午11:54:57
 */
@Entity
@DiscriminatorValue("ReaderUnits")
public class ReaderUnits extends DictItem {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public ReaderUnits(){
		super();
	}

	
}
