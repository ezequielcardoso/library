package com.huan.library.domain.model.dict;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * 附件名称dvd/vcd/cd/src...
 * @author huan
 * @time 2011-3-8  上午11:06:21
 */
@Entity
@DiscriminatorValue("Attachment")
public class Attachment extends DictItem {

	private static final long serialVersionUID = 1L;

	public Attachment(){
		super();
	}

}
