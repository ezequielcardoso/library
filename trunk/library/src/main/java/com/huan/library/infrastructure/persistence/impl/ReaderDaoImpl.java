package com.huan.library.infrastructure.persistence.impl;


import org.springframework.stereotype.Repository;

import com.huan.library.domain.model.reader.Reader;
import com.huan.library.infrastructure.persistence.ReaderDao;

/**
 * 读者持久化实现
 * @author huan
 * @time  2011-3-14 下午01:04:36
 */
@Repository("readerDao")
public class ReaderDaoImpl extends BaseDaoImpl<Reader> implements ReaderDao {


}
