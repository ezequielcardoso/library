package com.huan.library.infrastructure.persistence;

import java.util.List;

import com.huan.library.domain.model.reader.ReaderType;
import com.huan.library.web.view.ReaderTypeView;
/**
 * 读者类别dao
 * @author huan
 * @time 2011-3-15 上午10:44:44
 */
public interface ReaderTypeDao extends BaseDao<ReaderType> {
    
	//查询所有的读者类型
	public List<ReaderType> selectReaderTypes(ReaderTypeView readerTypeView) ;
	
	//批量导入读者类型
	public void insertReaderTypeBatch(List<ReaderType> readerTypes) ;
	
}
