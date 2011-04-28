package com.huan.library.domain.service;

import java.util.List;

import com.huan.library.domain.model.book.Attachment;

public interface AttachService {

	public Attachment save(Attachment attach);
	
	public List<Attachment> findByBookId(Long bookId);
	
}
