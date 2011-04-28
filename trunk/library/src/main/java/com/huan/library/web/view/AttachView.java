package com.huan.library.web.view;

import java.io.Serializable;
import java.util.Date;

import com.huan.library.web.view.grid.ExtGridPost;

public class AttachView extends ExtGridPost implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long attachmentId;//
	private String attachmentName;
	private String attachmentSavePath;
	private String attachmentFileType;
	private Long attachmentSize;
	private String attachmentUploadMan;
	private Date attachmentUploadDate;
	
	
	private Long bookId;
	
	public AttachView(){
		super();
	}


	public Long getAttachmentId() {
		return attachmentId;
	}


	public void setAttachmentId(Long attachmentId) {
		this.attachmentId = attachmentId;
	}


	public String getAttachmentName() {
		return attachmentName;
	}


	public void setAttachmentName(String attachmentName) {
		this.attachmentName = attachmentName;
	}


	public String getAttachmentSavePath() {
		return attachmentSavePath;
	}


	public void setAttachmentSavePath(String attachmentSavePath) {
		this.attachmentSavePath = attachmentSavePath;
	}


	public String getAttachmentFileType() {
		return attachmentFileType;
	}


	public void setAttachmentFileType(String attachmentFileType) {
		this.attachmentFileType = attachmentFileType;
	}


	public Long getAttachmentSize() {
		return attachmentSize;
	}


	public void setAttachmentSize(Long attachmentSize) {
		this.attachmentSize = attachmentSize;
	}


	public String getAttachmentUploadMan() {
		return attachmentUploadMan;
	}


	public void setAttachmentUploadMan(String attachmentUploadMan) {
		this.attachmentUploadMan = attachmentUploadMan;
	}

   
	public Date getAttachmentUploadDate() {
		return attachmentUploadDate;
	}


	public void setAttachmentUploadDate(Date attachmentUploadDate) {
		this.attachmentUploadDate = attachmentUploadDate;
	}


	public Long getBookId() {
		return bookId;
	}

	public void setBookId(Long bookId) {
		this.bookId = bookId;
	}
	
	
	
	

}
