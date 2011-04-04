package com.huan.library.domain.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import com.huan.library.domain.model.dict.DictItem;
/**
 * 项目:租金/办卡/补卡/开户
 * @author huan
 * @time 2011-3-8  下午06:22:21
 */
@Entity
@DiscriminatorValue("Charge")
public class Charge extends DictItem{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public Charge(){
		super();
	}
}
