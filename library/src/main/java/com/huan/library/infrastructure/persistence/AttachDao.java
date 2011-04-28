package com.huan.library.infrastructure.persistence;

import java.util.List;

import com.huan.library.domain.model.book.Attachment;

public interface AttachDao extends BaseDao<Attachment>{
	
	public List<Attachment> getAttachmentsByBookId(Long bookId);

}
