package com.huan.library.infrastructure.persistence.impl;

import org.springframework.stereotype.Repository;

import com.huan.library.domain.model.reader.ReaderCard;
import com.huan.library.infrastructure.persistence.ReaderCardDao;
/**
 * 读者借阅证dao实现
 * @author huan
 * @time 2011-3-15 上午10:10:33
 */
@Repository("readerCardDao")
public class ReaderCardDaoImpl extends BaseDaoImpl<ReaderCard> implements ReaderCardDao {


}
