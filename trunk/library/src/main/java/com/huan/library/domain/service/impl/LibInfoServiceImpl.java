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

	public LibInfo addOrModifyLibInfo(LibInfo libInfo) throws Exception {
		LibInfo libInfoCopy = new LibInfo();
		try {
			libInfoCopy = libInfoDao.saveOrUpdate(libInfo);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return libInfoCopy;
	}

	public LibInfo findLibInfoById(Long libInfoId) throws Exception {
		LibInfo libInfo = new LibInfo();
		try {
			libInfo = libInfoDao.selectById(libInfoId);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return libInfo;
	}

}
