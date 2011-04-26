package com.huan.library.web.action;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.huan.library.domain.model.reader.CardState;
import com.huan.library.domain.model.reader.Reader;
import com.huan.library.domain.service.ReaderService;
import com.huan.library.util.DateFormatUtil;
import com.huan.library.util.StringUtils;
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
	
	public String findReaderByBarCode(){
		try {
//			reader = readerService.findReaderByBarCode(readerView.getCardNo());	
		} catch (Exception e) {
		  e.printStackTrace();	
		  return Action.ERROR;
		}
		return Action.SUCCESS;
	}
	
	public String getReaderByCardNo(){
		List<Reader> readers = new ArrayList<Reader>(); 
		try {
		   readers = readerService.findReaders(readerView);
		   if(readers.size()>0){
			   reader = readers.listIterator().next();
		   } else {
			   reader = null;
		   }
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
	 * @return
	 */
	public String save() {
		try {
			this.formatReader(reader);
			String ignore[] = StringUtils.getIgnore(reader);
			if(reader.getId()!=null){
				Reader oldReader = readerService.findReaderById(reader.getId());
				if(ignore!=null && ignore.length>0){
					BeanUtils.copyProperties(reader, oldReader, ignore);
					this.formatReader(oldReader);
					if(reader.getReaderUnits()!=null && reader.getReaderUnits().getUnitId()!=null){
						oldReader.setReaderUnits(reader.getReaderUnits());
					}
					reader = oldReader;
				}
			}
			reader = readerService.addOrModifyReader(reader);
			extJsonForm.setSuccess(true);
			extJsonForm.setData(reader);
			extJsonForm.setMsg("保存成功");
			request.setAttribute("operateType", "保存");
			request.setAttribute("funcName", "增加或者修改读者");
			request.setAttribute("operateDescription", "增加或者修改了读者ID为：" + reader.getId() + 
					"、名字为：" + reader.getReaderName() + " 读者");
		} catch (Exception e) {
			e.printStackTrace();
			extJsonForm.setSuccess(false);
			extJsonForm.setData(null);
			extJsonForm.setMsg("保存失败");
			return Action.ERROR;
		}
		return Action.SUCCESS;
	}
	
	/**
	 * 借阅证挂失
	 * @return
	 */
	public String cardLost(){
		try {
			Reader reader = readerService.findReaderByBarCode(readerView.getBarCode());
			
			CardState cardState = new CardState();
			cardState.setItemId(readerView.getCardStateId());
			reader.setCardState(cardState);
			
			reader = readerService.addOrModifyReader(reader);
			extJsonForm.setSuccess(true);
			extJsonForm.setData(reader);
			extJsonForm.setMsg("挂失成功");
			request.setAttribute("operateType", "挂失");
			request.setAttribute("funcName", "挂失或是解除挂失");
			request.setAttribute("operateDescription", "挂失或是解除挂失的读者ID为：" + reader.getId() + 
					", 名字为：" + reader.getReaderName()+ " 读者");
		} catch (Exception e) {
			e.printStackTrace();
			extJsonForm.setSuccess(false);
			extJsonForm.setData(null);
			extJsonForm.setMsg("挂失失败");
			return Action.ERROR;
		}
		return Action.SUCCESS;
	}
	
	public void formatReader(Reader reader){
		if(reader.getCardState()!=null && reader.getCardState().getItemId()!=null && !"".equals(reader.getCardState().getItemId())){
			reader.setCardState(reader.getCardState());
		} else {
			reader.setCardState(null);
		}
		if(reader.getCertificate()!=null && reader.getCertificate().getItemId()!=null && !"".equals(reader.getCertificate().getItemId())){
			reader.setCertificate(reader.getCertificate());
		} else {
			reader.setCertificate(null);
		}
		if(reader.getReaderType()!=null && reader.getReaderType().getId()!=null 
				&& !"".equals(reader.getReaderType().getId())
				&& reader.getReaderType().getId()!=0
		){
			reader.setReaderType(reader.getReaderType());
		} else {
			reader.setReaderType(null);
		}
		if(reader.getReaderUnits()!=null && reader.getReaderUnits().getUnitId()!=null 
				&& !"".equals(reader.getReaderUnits().getUnitId())
				&& reader.getReaderUnits().getUnitId()!=0
		){
			reader.setReaderUnits(reader.getReaderUnits());
		} else {
			reader.setReaderUnits(null);
		}
	}
	
	/**
	 * 删除读者
	 * @return
	 */
	public String remove(){
		try {
			reader.setId(readerView.getId());
//			reader = readerService.findReaderById(readerView.getId());
			readerService.removeReader(reader);
			extJsonForm.setSuccess(true);
			extJsonForm.setMsg("删除成功");
			extJsonForm.setData(reader);
			request.setAttribute("operateType", "删除");
			request.setAttribute("funcName", "删除读者");
			request.setAttribute("operateDescription", "删除读者的ID为：" + reader.getId()+ " 读者");
		} catch (Exception e) {
          e.printStackTrace();
          extJsonForm.setSuccess(false);
          extJsonForm.setMsg("删除失败");
          extJsonForm.setData(null);
          return Action.ERROR;
		}
		return Action.SUCCESS;
	}

	/**
	 * 导出读者信息Excel exportReaderBorrowedExcel
	 * @return
	 */
	public String exportExcel(){
   	    try {
   	    	String rootDir = this.getWebRoot();
   	    	String fileName = readerService.exportExcel(rootDir,readerView);
   	    	extJsonForm.setData(fileName);
   	    	extJsonForm.setSuccess(true);
   	    	extJsonForm.setMsg("导出成功");
		} catch (Exception e) {
			extJsonForm.setData("");
   	    	extJsonForm.setSuccess(false);
   	    	extJsonForm.setMsg("导出失败");
			return Action.ERROR;
		}
		return Action.SUCCESS;
	}
	
	/**
	 * 读者借阅信息导出Excel
	 * @return
	 */
	public String exportReaderBorrowedExcel(){
   	    try {
   	    	String rootDir = this.getWebRoot();
   	    	String fileName = readerService.exportReaderBorrowedExcel(rootDir,readerView);
   	    	extJsonForm.setData(fileName);
   	    	extJsonForm.setSuccess(true);
   	    	extJsonForm.setMsg("导出成功");
		} catch (Exception e) {
			extJsonForm.setData("");
   	    	extJsonForm.setSuccess(false);
   	    	extJsonForm.setMsg("导出失败");
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
				readerView.setBirthday(DateFormatUtil.format(reader.getBirthday(), "yyyy-MM-dd"));
			}
			if(reader.getSex()!=null&&!"".equals(reader.getSex())){
				readerView.setSex(reader.getSex());
			}
			if(reader.getLeftMoney()!=null&&!"".equals(reader.getLeftMoney())){
				readerView.setLeftMoney(reader.getLeftMoney());
			}
			if(reader.getBorrowedQuantiy()!=null && !"".equals(reader.getBorrowedQuantiy())){
			   readerView.setBorrowedQuantiy(reader.getBorrowedQuantiy());	
			}
			if(reader.getTotalBQuantity()!=null && !"".equals(reader.getTotalBQuantity())){
				readerView.setTotalBQuantity(reader.getTotalBQuantity());
			}
			if(reader.getEmail()!=null&&!"".equals(reader.getEmail())){
				readerView.setEmail(reader.getEmail());
			}
			if(reader.getContactTel()!=null&&!"".equals(reader.getContactTel())){
				readerView.setContactTel(reader.getContactTel());
			}
			if(reader.getEntyDate()!=null&&!"".equals(reader.getEntyDate())){
				readerView.setEntyDate(DateFormatUtil.format(reader.getEntyDate(), "yyyy-MM-dd"));
			}
			if(reader.getEffectiveDate()!=null&&!"".equals(reader.getEffectiveDate())){
				readerView.setEffectiveDate(DateFormatUtil.format(reader.getEffectiveDate(),"yyyy-MM-dd"));
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
		    	readerView.setUnitName(reader.getReaderUnits().getUnitName());
		    }
			if(reader.getCertificate()!=null){
				readerView.setCertificateId(reader.getCertificate().getItemId());
				readerView.setCertificateCode(reader.getCertificate().getItemCode());
				readerView.setCertificateName(reader.getCertificate().getItemName());
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
