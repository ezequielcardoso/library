package com.huan.library.web.action;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.huan.library.domain.model.book.Attachment;
import com.huan.library.domain.service.AttachService;
import com.huan.library.util.DateFormatUtil;
import com.huan.library.web.view.AttachView;
import com.huan.library.web.view.grid.ExtGridLoad;
import com.opensymphony.xwork2.Action;
@Controller("attachAction")
public class AttachAction extends BaseActionSupport {
	
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Autowired
	private AttachService attachService;
	
	private ExtGridLoad extGridLoad = new ExtGridLoad(); // 对应result的extGridLoad
	

	private AttachView attachView;
    	
	public String findByBookId(){
		try {
			List<Attachment> attachs = attachService.findByBookId(attachView.getBookId());
			List<AttachView> views = new ArrayList<AttachView>();
			this.convetToView(attachs, views);
			extGridLoad.setRoot(views);
//			extGridLoad.setTotalProperty(attachView.getTotalCount());	
		} catch (Exception e) {
		   e.printStackTrace();
		   return Action.ERROR;
		}
		
		return Action.SUCCESS;
	}

	private void convetToView(List<Attachment> attachs, List<AttachView> views) {
		for(Attachment attach : attachs){
			AttachView view = new AttachView();
			view.setAttachmentId(attach.getAttachmentId());
			if(attach.getAttachmentName()!=null && !"".equals(attach.getAttachmentName())){
				view.setAttachmentName(attach.getAttachmentName());
			}
			if(attach.getAttachmentFileType()!=null &&!"".equals(attach.getAttachmentFileType())){
				view.setAttachmentFileType(attach.getAttachmentFileType());
			}
			if(attach.getAttachmentSize()!=null){
				view.setAttachmentSize(attach.getAttachmentSize());
			}
			if(attach.getAttachmentUploadDate()!=null){
				String attachmentUploadDate = DateFormatUtil.format(attach.getAttachmentUploadDate(), "yyyy-MM-dd");
				view.setAttachmentUploadDate(DateFormatUtil.convertToDate(attachmentUploadDate));
			}
			if(attach.getAttachmentUploadMan()!=null && !"".equals(attach.getAttachmentUploadMan())){
				view.setAttachmentUploadMan(attach.getAttachmentUploadMan());
			}
			if(attach.getAttachmentSavePath()!=null && !"".equals(attach.getAttachmentSavePath())){
				view.setAttachmentSavePath(attach.getAttachmentSavePath());
			}
			views.add(view);
		}
		
	}

	public ExtGridLoad getExtGridLoad() {
		return extGridLoad;
	}

	public void setExtGridLoad(ExtGridLoad extGridLoad) {
		this.extGridLoad = extGridLoad;
	}

	public AttachView getAttachView() {
		return attachView;
	}

	public void setAttachView(AttachView attachView) {
		this.attachView = attachView;
	}

	
	
}
