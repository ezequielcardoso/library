package com.huan.library.domain.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huan.library.domain.model.LibInfo;
import com.huan.library.domain.service.LibInfoService;
import com.huan.library.infrastructure.persistence.LibInfoDao;
/**
 * 图书馆信息service实现
 * @author huan
 * @author 2011-3-15 下午02:35:05
 */
@Service("libInfoService")
public class LibInfoServiceImpl implements LibInfoService {

	@Autowired
	private LibInfoDao libInfoDao;
	
	public void setLibInfoDao(LibInfoDao libInfoDao) {
		this.libInfoDao = libInfoDao;
	}

	public LibInfo save(LibInfo libInfo)  {
		return libInfoDao.saveOrUpdate(libInfo);
	}

	public LibInfo findById(Long libInfoId)  {
		return libInfoDao.selectById(libInfoId);
	}

}
