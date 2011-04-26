package com.huan.library.web.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.lang.StringUtils;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.annotation.Autowired;

import com.huan.library.domain.model.book.Attachment;
import com.huan.library.domain.model.book.Book;
import com.huan.library.domain.model.rights.User;
import com.huan.library.domain.service.AttachService;
import com.huan.library.util.FileOperate;
import com.huan.library.util.ResponseUtils;
import com.huan.library.util.StringAndUTF8;
import com.huan.library.web.view.form.ExtJsonForm;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 
 * @author shuaizhichun
 * @time 2011-3-13 上午12:06:49
 */
public class BaseActionSupport extends ActionSupport implements ServletRequestAware,ServletResponseAware, SessionAware {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected Map<String,Object> session;
	protected HttpServletRequest request;
	protected HttpServletResponse response;
	
	@Autowired
	private AttachService attachService;
	
	public void setAttachService(AttachService attachService) {
		this.attachService = attachService;
	}

	//=============文件上传用=============
	private File file;  
	private String fileFileName;
	private String fileContentType;
	
	//=============批量上传===============
	private List<File> filelist = new ArrayList<File>();
	private List<String> filelistFileName = new ArrayList<String>();
	private List<String> filelistContentType = new ArrayList<String>();
	private Long bookId;
	
	//=============文件下载用==============
    // 文件名
    private String fileName;
    // 输出流Content Type
    public String contentType;
    // 文件输入流
    public InputStream fileStream;
    
    private ExtJsonForm efj = new ExtJsonForm();
    
    public String downloadFile() {//下载文件
        try {
        	//把要删除的文件设置到request中
    		request.setAttribute("deleteFileName", this.getWebRoot() + fileName);
        	fileStream = new FileInputStream(new File(this.getWebRoot() + fileName));
        	fileName = "attachment;filename=\"" + StringAndUTF8.toUtf8String(
        			fileName.substring(fileName.lastIndexOf(File.separator) + 1 )) + "\"";
            if (fileName.indexOf(".xls") != -1) {
                contentType = "application/vnd.ms-excel;charset=UTF-8";
            } else if (fileName.indexOf(".pdf") != -1) {
                contentType = "application/pdf;charset=ISO-8859-1";
            } else if (fileName.indexOf(".doc") != -1) {
                contentType = "application/msword;charset=UTF-8";
            } else if (fileName.indexOf(".xml") != -1) {
                contentType = "text/xml;charset=UTF-8";
            }
        } catch (Exception e) {
        	e.printStackTrace();
        }
        return SUCCESS;
    }


	/**
	 * 批量上传
	 * @return
	 */
    public String uploadFiles(){
    	try{
    		
			for(int i=0; i<filelist.size(); i++){
				//copy文件到服务器指定目录
				File file = filelist.get(i);
				File dst = new File(this.getWebRoot() + "upload" + File.separator , filelistFileName.get(i));
	    		FileOperate.copy(file, dst);
	    		//保存文件记录到数据库
	    		Attachment attach = new Attachment();
	    		attach.setAttachmentFileType(filelistFileName.get(i).substring(filelistFileName.get(i).lastIndexOf(".")));
	    		attach.setAttachmentName(filelistFileName.get(i));
	    		attach.setAttachmentSavePath("upload" + File.separator + filelistFileName.get(i));
	    		attach.setAttachmentSize(file.getTotalSpace());
	    		attach.setAttachmentUploadDate(new Date());
	    		User currUser = (User)session.get("currUser");
	    		attach.setAttachmentUploadMan(currUser.getUserName());
	    		Book book = new Book();
	    		book.setBookId(bookId);
	    		attach.setBook(book);
	    		attachService.save(attach);
	    		efj.setData(attach);
			}
			efj.setSuccess(true);
    		efj.setMsg("文件上传成功！");
			request.setAttribute("operateType", "文件上传");
			request.setAttribute("funcName", "上传附件");
			request.setAttribute("operateDescription", "上传附件 ,数量：" + filelist.size() + " 个 ");
		} catch(Exception e){
			e.printStackTrace();
			return "failure";
		}
		return Action.SUCCESS;
    }
    
    /**
	 * 批量上传
	 * @return
	 */
    public void uploadFilesByStream() {
		ExtJsonForm ejf = new ExtJsonForm();
		ejf.setSuccess(false);
		String uploadPath = request.getParameter("uploadPath");
		try{
			if(StringUtils.isNotBlank(uploadPath)){
				String path = request.getRealPath("");
				uploadPath = path + "\\" + uploadPath;//用于存放上传文件的目录
//				uploadPath = uploadPath.replace("\\", "/");
				File file = new File(uploadPath);
				if(!file.exists())file.mkdir();//目录不存在就创建
		        DiskFileItemFactory factory = new DiskFileItemFactory();  
		        factory.setSizeThreshold(4096);//设置缓冲区大小，这里是4kb
		        ServletFileUpload upload = new ServletFileUpload(factory);
		        List fileItems = upload.parseRequest(request);// 得到所有的文件：
		        Iterator i = fileItems.iterator();
		        while (i.hasNext()) {//依次处理每一个文件
		            FileItem fi = (FileItem) i.next();  
		            String oldFilePath = fi.getName();// 获得文件名，这个文件名包括路径：  
	//	            String fieldName = fi.getFieldName();
		            if (StringUtils.isNotBlank(oldFilePath)) {
		            	Timestamp now = new Timestamp((new java.util.Date()).getTime());
		            	SimpleDateFormat fmt = new SimpleDateFormat("yyyyMMddHHmmssSSSS");  
		            	String newFileName = fmt.format(now).toString().trim();
		            	String extfile = oldFilePath.substring(oldFilePath.lastIndexOf("."));//扩展名
		            	String filePath = uploadPath + newFileName + extfile;
		                fi.write(new File(filePath));
		                //文件信息入库
		              //保存文件记录到数据库
			    		Attachment attach = new Attachment();
			    		attach.setAttachmentFileType(file.getName().substring(file.getName().lastIndexOf(".")));
			    		attach.setAttachmentName(file.getName());
			    		attach.setAttachmentSavePath(uploadPath + File.separator + file.getName());
			    		attach.setAttachmentSize(file.getTotalSpace());
			    		attach.setAttachmentUploadDate(new Date());
			    		User currUser = (User)session.get("currUser");
			    		attach.setAttachmentUploadMan(currUser.getUserName());
			    		attachService.save(attach);
		                fi.delete();
		                fi = null;
		                ejf.setData(attach);
		            }  
		        }
		        fileItems = null;
		        upload = null;
		        factory = null;
		        ejf.setSuccess(true);
			}else{
				ejf.setMsg("文件分类不能为空或者文件保存路径不能为空");
			}
		} catch (Exception e) {
			ejf.setMsg("上传失败:" + e.getMessage());
			e.printStackTrace();
		}finally{
			JSONObject jsonObject = JSONObject.fromObject(ejf);
			ResponseUtils.outJsonObj(response, jsonObject);
		}
	}
    
    public String uploadFile(){
    	try{
    		//上传文件
    		File dst = new File(this.getWebRoot() + "upload" + File.separator , fileFileName);
    		FileOperate.copy(file, dst);
    		efj.setSuccess(true);
    		efj.setMsg("文件上传成功！");
    	} catch(Exception e){
    		e.printStackTrace();
    		efj.setSuccess(false);
    		efj.setMsg("文件上传失败，请重新上传！");
    	}
		return SUCCESS;
    }
    
    /**
	 * 取得webapp绝对路径
	 * @return
	 */
	public String getWebRoot(){
		return request.getSession().getServletContext().getRealPath("/");
	}
    
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}
	public void setServletResponse(HttpServletResponse response) {
		this.response = response;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getContentType() {
		return contentType;
	}
	public void setContentType(String contentType) {
		this.contentType = contentType;
	}
	public InputStream getFileStream() {
		return fileStream;
	}
	public void setFileStream(InputStream fileStream) {
		this.fileStream = fileStream;
	}
	public ExtJsonForm getEfj() {
		return efj;
	}
	public void setEfj(ExtJsonForm efj) {
		this.efj = efj;
	}

	public List<File> getFilelist() {
		return filelist;
	}

	public void setFilelist(List<File> filelist) {
		this.filelist = filelist;
	}

	public List<String> getFilelistFileName() {
		return filelistFileName;
	}

	public void setFilelistFileName(List<String> filelistFileName) {
		this.filelistFileName = filelistFileName;
	}

	public List<String> getFilelistContentType() {
		return filelistContentType;
	}

	public void setFilelistContentType(List<String> filelistContentType) {
		this.filelistContentType = filelistContentType;
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public String getFileFileName() {
		return fileFileName;
	}

	public void setFileFileName(String fileFileName) {
		this.fileFileName = fileFileName;
	}

	public String getFileContentType() {
		return fileContentType;
	}

	public void setFileContentType(String fileContentType) {
		this.fileContentType = fileContentType;
	}

	public AttachService getAttachService() {
		return attachService;
	}

	public Long getBookId() {
		return bookId;
	}

	public void setBookId(Long bookId) {
		this.bookId = bookId;
	}

}
