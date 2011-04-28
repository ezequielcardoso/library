package com.huan.library.domain.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huan.library.domain.model.book.Attachment;
import com.huan.library.domain.service.AttachService;
import com.huan.library.infrastructure.persistence.AttachDao;

@Service("attachService")
public class AttachServiceImpl implements AttachService {

	@Autowired
	private AttachDao attachDao;
	
	public void setAttachDao(AttachDao attachDao) {
		this.attachDao = attachDao;
	}

	public Attachment save(Attachment attach) {
		return attachDao.saveOrUpdate(attach);
	}

	public List<Attachment> findByBookId(Long bookId) {
		return attachDao.getAttachmentsByBookId(bookId);
	}

}
