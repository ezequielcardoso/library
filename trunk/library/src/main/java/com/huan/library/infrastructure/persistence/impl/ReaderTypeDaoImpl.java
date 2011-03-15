package com.huan.library.infrastructure.persistence.impl;


import org.springframework.stereotype.Repository;

import com.huan.library.domain.model.reader.ReaderType;
import com.huan.library.infrastructure.persistence.ReaderTypeDao;
/**
 * 读者类别dao实现
 * @author huan
 * @time 2011-3-15 上午10:45:57
 */
@Repository("readerTypeDao")
public class ReaderTypeDaoImpl extends BaseDaoImpl<ReaderType> implements ReaderTypeDao {

}
