package com.huan.library.domain.service;

import com.huan.library.domain.model.LibInfo;


/**
 * 图书馆信息service
 * @author huan
 * @author 2011-3-15 下午02:31:49
 */
public interface LibInfoService {
	
	/**
	 * 保存或是修改
	 * @param libInfo
	 * @return
	 * @throws Exception
	 */
	public LibInfo save(LibInfo libInfo) throws Exception;
	
	
    /**
     * 根据id查找LibInfo
     * @param libInfoId
     * @return
     * @throws Exception
     */
	public LibInfo findById(Long libInfoId) throws Exception;
	

}
