package com.huan.library.infrastructure.persistence.generic.impl;

import org.springframework.stereotype.Repository;

import com.huan.library.domain.model.dict.DictItem;
import com.huan.library.infrastructure.persistence.DictItemDao;
/**
 * 数据字典dao实现
 * @author huan
 * @time  2011-3-13 下午07:49:11
 */
@Repository("dictItemDao")
public class DictItemDaoImpl extends BaseDaoImpl<DictItem>  implements
		DictItemDao {

	
}
