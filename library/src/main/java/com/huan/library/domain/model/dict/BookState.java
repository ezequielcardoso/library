package com.huan.library.domain.model.dict;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * 图书状态
 * @author huan
 *
 */
@Entity  
@DiscriminatorValue("BookState")
public class BookState extends DictItem {
     
	private static final long serialVersionUID = 1L;

	public BookState(){
		super();
	}
}
