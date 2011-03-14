package com.huan.library.infrastructure.persistence.impl;


import org.springframework.stereotype.Repository;

import com.huan.library.domain.model.book.Press;
import com.huan.library.infrastructure.persistence.generic.PressDao;
/**
 * 出版社持久化实现
 * @author huan
 * @time  2011-3-12 下午05:19:09
 */
@Repository("pressDao")
public class PressDaoImpl extends BaseDaoImpl<Press> implements PressDao{

   
}
