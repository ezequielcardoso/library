package com.huan.library.domain.service;

import java.util.List;

import com.huan.library.domain.model.reader.ReaderUnits;

/**
 * 读者单位
 * @author huan
 * @time 2011-4-10 下午07:31:21
 */
public interface ReaderUnitsService {
	/**
	 * 
	 * @param readerUnits
	 * @return
	 * @throws Exception
	 */
	public ReaderUnits save(ReaderUnits unit) throws Exception;
	
	/**
	 * 
	 * @param unit
	 * @throws Exception
	 */
	public void remove(ReaderUnits unit) throws Exception;
	
    /**
     * 
     * @param unitId
     * @return
     * @throws Exception
     */
	public ReaderUnits getById(Long unitId) throws Exception;
	
	/**
	 * 
	 * @param pUnitId
	 * @return
	 * @throws Exception
	 */
	public List<ReaderUnits> getChildrenByPid(Long pUnitId) throws Exception;
}
