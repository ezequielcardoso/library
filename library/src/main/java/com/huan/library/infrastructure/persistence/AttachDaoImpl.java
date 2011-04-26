package com.huan.library.infrastructure.persistence;

import org.springframework.stereotype.Repository;

import com.huan.library.domain.model.book.Attachment;
import com.huan.library.infrastructure.persistence.impl.BaseDaoImpl;

@Repository("attachDao")
public class AttachDaoImpl extends BaseDaoImpl<Attachment> implements AttachDao {

}
