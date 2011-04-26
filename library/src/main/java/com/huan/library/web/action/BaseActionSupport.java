package com.huan.library.web.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.huan.library.util.FileOperate;
import com.huan.library.util.PropertiesUtil;
import com.huan.library.util.StringAndUTF8;
import com.huan.library.web.view.form.ExtJsonForm;
import com.opensymphony.xwork2.Action;
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
	private String pieceid;
	
	//=============文件上传用=============
	private File upfile;  
	private String upfileFileName;
	private String upfileContentType;
	private String thingType;
	
	//批量山传
	private String realThingArr[];
	private List<File> filelist = new ArrayList<File>();
	private List<String> filelistFileName = new ArrayList<String>();
	private List<String> filelistContentType = new ArrayList<String>();
	

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
	 * 实物文件上传,包括图片图像类（thingType=1），视频音频类（thingType=2）
	 */
    public String uploadRealFile(){
    	Integer[] ids = new Integer[50];
    	try{
			if(!"".equals(thingType) && thingType.equalsIgnoreCase("1")){
				for(int i=0; i<filelist.size(); i++){
					File imgFile = filelist.get(i);
					//取得实物存放路径
					String localRealThingPath = PropertiesUtil.getProperty("localRealThingPath");
					//上传文件
					String dir = localRealThingPath + File.separator + pieceid + File.separator + "image";
					FileOperate.newFolder(localRealThingPath);
					FileOperate.newFolder(localRealThingPath + File.separator + pieceid);
					FileOperate.newFolder(dir);
					File dst = new File(dir, filelistFileName.get(i));
					FileOperate.copy(imgFile, dst);
					ids[i]= i;
				}
				efj.setSuccess(true);
	    		efj.setMsg("文件上传成功！");
	    		efj.setData(ids);
				request.setAttribute("operateType", "上传");
				request.setAttribute("funcName", "上传图片");
				request.setAttribute("operateDescription", "上传图片 ,数量：" + filelist.size() + " 个 ");
			} else if(!"".equals(thingType) && thingType.equalsIgnoreCase("2")){
				for(int i=0; i<filelist.size(); i++){
					File imgFile = filelist.get(i);
					//取得实物存放路径
					String localRealThingPath = PropertiesUtil.getProperty("localRealThingPath");
					//上传文件
					String dir = localRealThingPath + File.separator + pieceid + File.separator + "vedio";
					FileOperate.newFolder(localRealThingPath);
					FileOperate.newFolder(localRealThingPath + File.separator + pieceid);
					FileOperate.newFolder(dir);
					File dst = new File(dir, filelistFileName.get(i));
					FileOperate.copy(imgFile, dst);
					ids[i]= i;
				}
				efj.setSuccess(true);
	    		efj.setMsg("文件上传成功！");
	    		efj.setData(ids);
				request.setAttribute("operateType", "上传");
				request.setAttribute("funcName", "上传视频");
				request.setAttribute("operateDescription", "上传频 ,数量：" + filelist.size() + " 个 ");
			} 
		} catch(Exception e){
			e.printStackTrace();
			return "failure";
		}
		return Action.SUCCESS;
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
