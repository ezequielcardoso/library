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
	 * @throws Exception
	 */
	public ReaderType addOrModifyReaderType(ReaderType readerType) throws Exception;
	
	/**
	 * 删除读者类别
	 * @param readerType
	 * @throws Exception
	 */
	public void removeReaderType(ReaderType readerType) throws Exception;
	
	/**
	 * 根据Id查找readerType
	 * @param readerTypeId
	 * @return
	 */
	public ReaderType findReaderTypeById(int readerTypeId) throws Exception;
	
	/**
	 * 查找所有的readerType
	 * @return
	 * @throws Exception
	 */
	public List<ReaderType> findAllReaderTypes() throws Exception;
	
	/**
	 * 查找所有的readerType
	 * @return
	 * @throws Exception
	 */
	public List<ReaderType> findReaderTypes(ReaderTypeView readerTypeView) throws Exception;

	public String exportExcel(String rootDir, ReaderTypeView readerTypeView) throws Exception;



}
