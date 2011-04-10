package com.huan.library.web.action;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.huan.library.domain.model.reader.Reader;
import com.huan.library.domain.service.ReaderService;
import com.huan.library.web.view.ReaderView;
import com.huan.library.web.view.form.ExtJsonForm;
import com.huan.library.web.view.grid.ExtGridLoad;
import com.opensymphony.xwork2.Action;

/**
 * 读者显示层
 * @author huan
 * @time 2011-3-14 下午02:23:03
 */
@Controller("readerAction")
public class ReaderAction extends BaseActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Autowired
	private ReaderService readerService;

	private Reader reader = new Reader();
	private ReaderView readerView = new ReaderView();
	private ExtJsonForm extJsonForm =new ExtJsonForm();
	private ExtGridLoad extGridLoad = new ExtGridLoad();
	
	private Integer start;
	private Integer limit;

	/**
	 * 显示读者维护主页面
	 * @return
	 */
	public String readerMain() {
		return Action.SUCCESS;
	}
    /**
     * 查找所有的读者
     * @return
     */
	public String findReaders(){
		List<Reader> readers = new ArrayList<Reader>(); 
		try {
		   readerView.setStart(start);
		   readerView.setLimit(limit);
		   readers = readerService.findReaders(readerView);
		   extGridLoad.setRoot(this.convertToView(readers));
		   extGridLoad.setTotalProperty(readerView.getTotalCount());
		} catch (Exception e) {
		   e.printStackTrace();
		   return Action.ERROR;
		}
		return Action.SUCCESS;
	}
	
	/**
	 * 显示增加读者
	 * 
	 * @return
	 */
	public String showSaveReader() {
		return "showSaveReader";
	}

	/**
	 * 增加读者
	 * 
	 * @return
	 */
	public String saveReader() {
		try {
			readerService.addOrModifyReader(reader);
		} catch (Exception e) {
			e.printStackTrace();
			return Action.ERROR;
		}
		return Action.SUCCESS;
	}

	/**
	 * 显示修改读者
	 * 
	 * @return
	 */
	public String showModifyReader() {
		return "showModifyReader";
	}

	/**
	 * 修改读者
	 * @return
	 */
	public String modifyReader() {
		try {
			readerService.addOrModifyReader(reader);
		} catch (Exception e) {
			e.printStackTrace();
			return Action.ERROR;
		}
		return Action.SUCCESS;
	}
	
	public List<ReaderView> convertToView(List<Reader> readers){
		List<ReaderView> readerViews = new ArrayList<ReaderView>();
		for(Reader reader:readers){
			ReaderView readerView = new ReaderView();
			readerView.setId(reader.getId());
			if(reader.getCardNo()!=null&&!"".equals(reader.getCardNo())){
				readerView.setCardNo(reader.getCardNo());
			}
			if(reader.getPassword()!=null&&!"".equals(reader.getPassword())){
				readerView.setPassword(reader.getPassword());
			}
			if(reader.getBarCode()!=null&&!"".equals(reader.getBarCode())){
				readerView.setBarCode(reader.getBarCode());
			}
			if(reader.getReaderName()!=null&&!"".equals(reader.getReaderName())){
				readerView.setReaderName(reader.getReaderName());
			}
			if(reader.getBirthday()!=null&&!"".equals(reader.getBirthday())){
				readerView.setBirthday(reader.getBirthday());
			}
			if(reader.getSex()!=null&&!"".equals(reader.getSex())){
				readerView.setSex(reader.getSex());
			}
			if(reader.getLeftMoney()!=null&&!"".equals(reader.getLeftMoney())){
				readerView.setLeftMoney(reader.getLeftMoney());
			}
			if(reader.getEmail()!=null&&!"".equals(reader.getEmail())){
				readerView.setEmail(reader.getEmail());
			}
			if(reader.getContactTel()!=null&&!"".equals(reader.getContactTel())){
				readerView.setContactTel(reader.getContactTel());
			}
			if(reader.getEntyDate()!=null&&!"".equals(reader.getEntyDate())){
				readerView.setEntyDate(reader.getEntyDate());
			}
			if(reader.getEffectiveDate()!=null&&!"".equals(reader.getEffectiveDate())){
				readerView.setEffectiveDate(reader.getEffectiveDate());
			}
			if(reader.getReaderPic()!=null&&!"".equals(reader.getReaderPic())){
				readerView.setReaderPic(reader.getReaderPic());
			}
			if(reader.getSpell()!=null&&!"".equals(reader.getSpell())){
				readerView.setSpell(reader.getSpell());
			}
			if(reader.getReaderDesc()!=null&&!"".equals(reader.getReaderDesc())){
				readerView.setReaderDesc(reader.getReaderDesc());
			}
			if(reader.getReaderUnits()!=null){
				readerView.setUnitId(reader.getReaderUnits().getUnitId());
				readerView.setUnitCode(reader.getReaderUnits().getUnitcode());
				readerView.setUnitName(reader.getReaderUnits().getUnitName());
			}
			if(reader.getCertificate()!=null){
				readerView.setCertificateId(reader.getCertificate().getItemId());
				readerView.setCertificateCode(reader.getCertificate().getItemCode());
				readerView.setCertificateName(reader.getCertificate().getItemName());
			}
			if(reader.getCertificateNo()!=null&&!"".equals(reader.getCertificateNo())){
				readerView.setCertificateNo(reader.getCertificateNo());
			}
			if(reader.getReaderType()!=null){
				readerView.setReaderTypeId(reader.getReaderType().getId());
				readerView.setReaderCateCode(reader.getReaderType().getReaderCateCode());
				readerView.setReaderCateName(reader.getReaderType().getReaderCateName());
			}
			if(reader.getCardState()!=null){
				readerView.setCardStateId(reader.getCardState().getItemId());
				readerView.setCardStateCode(reader.getCardState().getItemCode());
				readerView.setCardStateName(reader.getCardState().getItemName());
			}
			readerViews.add(readerView);
		}
		return readerViews;
	}

	/**
	 * @return the readerView
	 */
	public ReaderView getReaderView() {
		return readerView;
	}

	/**
	 * @param readerView the readerView to set
	 */
	public void setReaderView(ReaderView readerView) {
		this.readerView = readerView;
	}

	/**
	 * @return the extJsonForm
	 */
	public ExtJsonForm getExtJsonForm() {
		return extJsonForm;
	}

	
	public void setExtJsonForm(ExtJsonForm extJsonForm) {
		this.extJsonForm = extJsonForm;
	}
	public Reader getReader() {
		return reader;
	}

	public void setReader(Reader reader) {
		this.reader = reader;
	}

	public void setReaderService(ReaderService readerService) {
		this.readerService = readerService;
	}
	/**
	 * @return the extGridLoad
	 */
	public ExtGridLoad getExtGridLoad() {
		return extGridLoad;
	}

	/**
	 * @param extGridLoad the extGridLoad to set
	 */
	public void setExtGridLoad(ExtGridLoad extGridLoad) {
		this.extGridLoad = extGridLoad;
	}

	/**
	 * @return the start
	 */
	public Integer getStart() {
		return start;
	}

	/**
	 * @param start the start to set
	 */
	public void setStart(Integer start) {
		this.start = start;
	}

	/**
	 * @return the limit
	 */
	public Integer getLimit() {
		return limit;
	}

	/**
	 * @param limit the limit to set
	 */
	public void setLimit(Integer limit) {
		this.limit = limit;
	}
	
	
	
	
	

}
