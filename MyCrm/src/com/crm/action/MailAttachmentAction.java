package com.crm.action;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.crm.biz.MailAttachmentBiz;
import com.crm.tools.Scopes;
import com.opensymphony.xwork2.ActionSupport;

@Scope("prototype")
@Controller
public class MailAttachmentAction extends ActionSupport {
	
	private MailAttachmentBiz mailAttachmentBiz;

	public void setMailAttachmentBiz(MailAttachmentBiz mailAttachmentBiz) {
		this.mailAttachmentBiz = mailAttachmentBiz;
	}
	private File uploadify;//�ϴ��ļ�file����  
	private String uploadifyFileName;//�ϴ��ļ���  
	private String uploadifyContentType;//�ϴ��ļ�����  
	private String description;//�ϴ��ļ�������  
	private String uploadDir;//�����ϴ��ļ���Ŀ¼,�����webӦ�ó���ĸ�·��,��struts.xml�ļ�������  
	private String downFileName;

	public String getDownFileName() {
		return downFileName;
	}

	public void setDownFileName(String downFileName) {
		this.downFileName = downFileName;
	}

	public String execute() {
		String newFileName=null;  
		//�õ���ǰʱ�俪ʼ���ŵĺ�����,�������������Ϊ�ϴ��ļ��µ��ļ���  
		long now=new Date().getTime();
		DateFormat df=new SimpleDateFormat("yyyyMMddHHmmss");
		String currentDateTime=df.format(new Date()); 
		//�õ������ϴ��ļ�����ʵ·��  
		String path=ServletActionContext.getServletContext().getRealPath(uploadDir);  
		File dir=new File(path);  
		//������Ŀ¼������,�򴴽���
		if (!dir.exists()) {
		    dir.mkdir();
		}  
		int index=uploadifyFileName.lastIndexOf(".");  
		
		//�ж��ϴ��ļ��Ƿ�����չ��,��ʱ�����Ϊ�µ��ļ���
		if (index!=-1) {  
		    newFileName=currentDateTime+Long.valueOf(now)+uploadifyFileName.substring(index);  
		}else {  
		    newFileName=currentDateTime+Long.valueOf(now);
		}  
		BufferedOutputStream bos=null;  
		BufferedInputStream bis=null;  
		  
		//��ȡ��������ʱĿ¼�µ��ϴ��ļ�,д�뵽�µ��ļ���  
		String data="";
		try {  
		    FileInputStream fis=new FileInputStream(uploadify);  
		    bis=new BufferedInputStream(fis);
		      
		    FileOutputStream fos=new FileOutputStream(new File(dir,newFileName));  
		    bos=new BufferedOutputStream(fos);  
		      
		    byte [] buf=new byte[4096];  
		    int len=-1;  
		    while ((len=bis.read(buf))!=-1) {  
		        bos.write(buf,0,len);  
		    }
		    String realPath="mail_atta!down?downFileName="+newFileName;
		    //�������ݿ�
		    data = mailAttachmentBiz.addAttachment(newFileName,uploadifyFileName,realPath);
		} catch (FileNotFoundException e) {  
		    e.printStackTrace();
		} catch (IOException e) {
		    e.printStackTrace();
		}finally{  
		    if (null!=bis) {
		        try {
		            bis.close();  
		        } catch (IOException e) {  
		            e.printStackTrace();  
		        }  
		    }  
		    if (null!=bos) {  
		        try {  
		            bos.close();  
		        } catch (IOException e) {  
		            e.printStackTrace();  
		        }  
		    }  
		}
	    Scopes.getRequestMap().put("data", data);
	    return "ajax";
	}
	
	private InputStream inputStream;
	public InputStream getInputStream() throws FileNotFoundException {
		String path=ServletActionContext.getServletContext().getRealPath("/main_pages/mailUploadFiles");
		return new BufferedInputStream(new FileInputStream(path+"\\"+getDownFileName()));
	}
	
	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}

	public String down(){
		return SUCCESS;
	}
	
	public File getUploadify() {
		return uploadify;
	}
	public void setUploadify(File uploadify) {
		this.uploadify = uploadify;
	}
	public String getUploadifyFileName() {
		return uploadifyFileName;
	}
	public void setUploadifyFileName(String uploadifyFileName) {
		this.uploadifyFileName = uploadifyFileName;
	}
	public String getUploadifyContentType() {
		return uploadifyContentType;
	}
	public void setUploadifyContentType(String uploadifyContentType) {
		this.uploadifyContentType = uploadifyContentType;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getUploadDir() {
		return uploadDir;
	}
	public void setUploadDir(String uploadDir) {
		this.uploadDir = uploadDir;
	}
	
}