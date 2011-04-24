package com.huan.library.domain.service;

import java.util.List;

import com.huan.library.domain.model.reader.ReaderType;
import com.huan.library.web.view.ReaderTypeView;

/**
 * 读者类别service
 * @author huan
 * @time 2011-3-15 上午10:46:58
 */
public interface ReaderTypeService {
	/**
	 * 增加或是修改读者类别
	 * @param readerType
	 * @return
	 * @
	 */
	public ReaderType addOrModifyReaderType(ReaderType readerType) ;
	
	/**
	 * 删除读者类别
	 * @param readerType
	 * @
	 */
	public void removeReaderType(ReaderType readerType) ;
	
	/**
	 * 根据Id查找readerType
	 * @param readerTypeId
	 * @return
	 */
	public ReaderType findReaderTypeById(Long readerTypeId) ;
	
	/**
	 * 查找所有的readerType
	 * @return
	 * @
	 */
	public List<ReaderType> findAllReaderTypes() ;
	
	/**
	 * 查找所有的readerType
	 * @return
	 * @
	 */
	public List<ReaderType> findReaderTypes(ReaderTypeView readerTypeView) ;

	public String exportExcel(String rootDir, ReaderTypeView readerTypeView) ;



}
