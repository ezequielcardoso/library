package com.huan.library.domain.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huan.library.domain.model.reader.ReaderType;
import com.huan.library.domain.service.ReaderTypeService;
import com.huan.library.infrastructure.persistence.ReaderTypeDao;

/**
 * 读者类别service实现
 * @author huan
 * @time 2011-3-15 上午10:50:35
 */
@Service("readerTypeService")
public class ReaderTypeServiceImpl implements ReaderTypeService {

	@Autowired
	private ReaderTypeDao readerTypeDao;

	public void setReaderTypeDao(ReaderTypeDao readerTypeDao) {
		this.readerTypeDao = readerTypeDao;
	}

	public ReaderType addOrModifyReaderType(ReaderType readerType)
			throws Exception {
		ReaderType readertTypeCopy = new ReaderType();
		try {
			readertTypeCopy = readerTypeDao.saveOrUpdate(readerType);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return readertTypeCopy;
	}

	public void removeReaderType(ReaderType readerType) throws Exception {
		try {
			readerTypeDao.delete(readerType);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public ReaderType findReaderTypeById(int readerTypeId) throws Exception {
		ReaderType readerType = new ReaderType(); 
		try {
			readerType = readerTypeDao.selectById(readerTypeId);
		} catch (Exception e) {
		  e.printStackTrace();
		  return null;
		}
		return readerType;
	}

	public List<ReaderType> findAllReaderTypes() throws Exception {
		List<ReaderType> readerTypes = new ArrayList<ReaderType>();
		try {
			readerTypes = readerTypeDao.selectSmallTs();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return readerTypes;
	}

}
