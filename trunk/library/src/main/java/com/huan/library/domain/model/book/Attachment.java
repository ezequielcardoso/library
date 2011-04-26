package com.huan.library.domain.model.book;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


/**
 * 附件
 * @author huan
 * @time 2011-3-8  上午11:06:21
 */
@Entity
public class Attachment implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long attachmentId;//
	private String attachmentName;
	private String attachmentSavePath;
	private String attachmentFileType;
	private Long attachmentSize;
	private String attachmentUploadMan;
	private Date attachmentUploadDate;
	
	@ManyToOne(targetEntity=Book.class,fetch=FetchType.EAGER)
	@JoinColumn(name="bookId",referencedColumnName="bookId")
	private Book book;
	
	public Attachment(){
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

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

}
