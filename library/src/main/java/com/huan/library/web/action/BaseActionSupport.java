package com.huan.library.web.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.huan.library.util.FileOperate;
import com.huan.library.util.StringAndUTF8;
import com.huan.library.web.view.form.ExtJsonForm;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 
 * @author shuaizhichun
 * @time 2011-3-13 上午12:06:49
 */
public class BaseActionSupport extends ActionSupport implements ServletRequestAware,SessionAware {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected Map<String,Object> session;
	protected HttpServletRequest request;
	
	//=============文件上传用=============
	private File upfile;  
	private String upfileFileName;
	private String upfileContentType;

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


    public String uploadFile(){
    	try{
    		//上传文件
    		File dst = new File(this.getWebRoot() + "upload" + File.separator , upfileFileName);
    		FileOperate.copy(upfile, dst);
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
	
	public File getUpfile() {
		return upfile;
	}
	public void setUpfile(File upfile) {
		this.upfile = upfile;
	}
	public String getUpfileFileName() {
		return upfileFileName;
	}
	public void setUpfileFileName(String upfileFileName) {
		this.upfileFileName = upfileFileName;
	}
	public String getUpfileContentType() {
		return upfileContentType;
	}
	public void setUpfileContentType(String upfileContentType) {
		this.upfileContentType = upfileContentType;
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
}
