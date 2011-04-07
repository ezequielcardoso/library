package com.huan.library.infrastructure.persistence;

import java.util.List;

import com.huan.library.domain.model.reader.ReaderCard;
import com.huan.library.web.view.ReaderCardView;

/**
 * 读者借阅证dao
 * @author huan
 * @time 2011-3-15 上午10:09:06
 */
public interface ReaderCardDao extends BaseDao<ReaderCard>{
   
	public List<ReaderCard> selectReaderCards(ReaderCardView readerCardView) throws Exception;
	
}
