package com.huan.library.domain.model.book;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import com.huan.library.domain.model.dict.DictItem;

/**
 * 图书状态 在图书状态上加上破寻和丢失
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
