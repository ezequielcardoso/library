package com.huan.library.web.action;

import com.huan.library.web.view.AttachView;
import com.huan.library.web.view.grid.ExtGridLoad;
import com.opensymphony.xwork2.Action;

public class AttachAction extends BaseActionSupport {
	
	
//	private AttachService attachService;
	
	private ExtGridLoad extGridLoad = new ExtGridLoad(); // 对应result的extGridLoad
	
	private AttachView attachView;
	
	public String findByBookId(){
//		List<Attachment> attachs = attachService.findByBookId(attachView.getBookId());
//		List<AttachView> views
//		this.convetToView(attachs, views);
//		extGridLoad.setRoot(views);
//		extGridLoad.setTotalProperty(view.size());
		return Action.SUCCESS;
	}

}
