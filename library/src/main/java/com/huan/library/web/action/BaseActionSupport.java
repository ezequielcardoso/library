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
import com.opensymphony.xwork2.ActionSupport;

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
    
    
    public String readFile() {//下载文件
        try {
    		request.getSession().setAttribute("deleteFileName", this.getWebRoot() + "upload" + File.separator + fileName);
        	fileStream = new FileInputStream(new File(this.getWebRoot() + "upload" + File.separator + fileName));
        	fileName = "attachment;filename=\"" + StringAndUTF8.toUtf8String(fileName) + "\"";
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


    public String writeFile(){
    	try{
    		//上传文件
    		File dst = new File(this.getWebRoot() + "upload" + File.separator , upfileFileName);
    		FileOperate.copy(upfile, dst);
    	} catch(Exception e){
    		e.printStackTrace();
    	}
		return SUCCESS;
    }
    
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}
	
	public String getWebRoot(){
		return request.getSession().getServletContext().getRealPath("/");
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
	
	

}
