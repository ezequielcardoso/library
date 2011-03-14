package com.huan.library.domain.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huan.library.domain.model.reader.Reader;
import com.huan.library.domain.service.ReaderService;
import com.huan.library.infrastructure.persistence.ReaderDao;
/**
 * 读者业务层实现
 * @author huan
 * @time  2011-3-14 下午02:05:49
 */
@Service("readerService")
public class ReaderServiceImpl implements ReaderService {

	@Autowired
	private ReaderDao readerDao;
	
	public void setReaderDao(ReaderDao readerDao) {
		this.readerDao = readerDao;
	}

	public Reader addOrModifyReader(Reader reader) throws Exception {
		try {
			readerDao.saveOrUpdate(reader);
		} catch (Exception e) {
		  e.printStackTrace();
		}
		return null;
	}

	public List<Reader> findAllReaderes() throws Exception {
		List<Reader> readers = new ArrayList<Reader>();
		try {
			readers = readerDao.selectMaxTs();	
		} catch (Exception e) {
	        e.printStackTrace();
	        return null;
		}
		return readers;
	}

	public Reader findReaderById(int readerId) throws Exception {
		Reader reader = new Reader();
		try {
			reader = readerDao.get(readerId);
		} catch (Exception e) {
          e.printStackTrace();
          return null;
		}
		return reader;
	}

	public void removeReader(Reader reader) throws Exception {
	    try {
			readerDao.delete(reader);
		} catch (Exception e) {
		  e.printStackTrace();
		}
  	}

}
