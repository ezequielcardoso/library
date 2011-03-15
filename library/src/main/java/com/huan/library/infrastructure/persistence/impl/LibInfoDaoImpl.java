package com.huan.library.infrastructure.persistence.impl;


import org.springframework.stereotype.Repository;

import com.huan.library.domain.model.LibInfo;
import com.huan.library.infrastructure.persistence.LibInfoDao;
/**
 * 图书馆信息dao实现
 * @author huan
 * @author 2011-3-15 下午02:30:57
 */
@Repository("libInfoDao")
public class LibInfoDaoImpl extends BaseDaoImpl<LibInfo> implements LibInfoDao {
 
}
