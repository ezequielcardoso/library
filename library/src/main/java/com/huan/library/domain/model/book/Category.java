package com.huan.library.domain.model.book;

import java.io.Serializable;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import com.huan.library.domain.model.dict.DictItem;


/**
 * 图书分类
 * @author huan
 * @time 2011-3-8  下午03:24:33
 */
@Entity
@DiscriminatorValue("Category")
public class Category extends DictItem implements Serializable{ 

	public Category(){
		super();
	}

}
