package com.huan.library.infrastructure.persistence;


import java.util.List;

import com.huan.library.domain.model.reader.Reader;
import com.huan.library.web.view.ReaderView;

/**
 * 读者持久化
 * @author huan
 * @time  2011-3-14 下午01:00:45
 */
public interface ReaderDao extends BaseDao<Reader>{
	
	
	public List<Reader> selectReaders(ReaderView readerView) ;
	
	public Reader selectByBarCode(String barCode) ;
	
	public Reader selectById(Long readerId) ;
	
	
	public void insertReaders(List<Reader> readers) ;
	
	
	
}
