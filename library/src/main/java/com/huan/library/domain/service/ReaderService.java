package com.huan.library.domain.service;

import java.util.List;

import com.huan.library.domain.model.reader.Reader;

/**
 * 读者业务层
 * @author huan
 * @time  2011-3-14 下午02:01:44
 */
public interface ReaderService {
	/**
	 * 增加或是修改读者
	 * @param reader
	 * @throws Exception
	 */
	public Reader addOrModifyReader(Reader reader) throws Exception;
	
	/**
	 * 删除读者
	 * @param reader
	 * @throws Exception
	 */
	public void removeReader(Reader reader) throws Exception;
	
	/**
	 * 根据Id查找Reader
	 * @param readerId
	 * @return
	 */
	public Reader findReaderById(int readerId) throws Exception;
	
	/**
	 * 查找所有的Reader
	 * @return
	 */
	public List<Reader> findAllReaderes() throws Exception;

}
