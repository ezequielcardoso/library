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
	 * @
	 */
	public ReaderUnits save(ReaderUnits unit) ;
	
	/**
	 * 
	 * @param unit
	 * @
	 */
	public void remove(ReaderUnits unit) ;
	
    /**
     * 
     * @param unitId
     * @return
     * @
     */
	public ReaderUnits getById(Long unitId) ;
	
	/**
	 * 
	 * @param pUnitId
	 * @return
	 * @
	 */
	public List<ReaderUnits> getChildrenByPid(Long pUnitId) ;
}
