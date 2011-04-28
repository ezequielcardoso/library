package com.huan.library.infrastructure.persistence;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.huan.library.domain.model.book.Attachment;
import com.huan.library.infrastructure.persistence.impl.BaseDaoImpl;

@Repository("attachDao")
public class AttachDaoImpl extends BaseDaoImpl<Attachment> implements AttachDao {

	public List<Attachment> getAttachmentsByBookId(Long bookId) {
		List<Attachment> attachments = new ArrayList<Attachment>();
		String hql = " from Attachment att left join fetch att.book where att.book.bookId = ? ";
		attachments = (List<Attachment>)getHibernateTemplate().find(hql, bookId);
		return attachments;
	}

}
