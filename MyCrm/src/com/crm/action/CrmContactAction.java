package com.crm.action;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.crm.biz.CrmContactBiz;
import com.crm.info.CrmContact;
import com.crm.tools.Scopes;
import com.crm.tools.WebTools;
import com.crm.vobj.CrmContactVobj;
import com.opensymphony.xwork2.ActionSupport;
@Scope("prototype")
@Controller("crmContactAction")
public class CrmContactAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private CrmContactBiz crmContactBiz;
	private int id;
	private CrmContact contact;
	
	public CrmContact getContact() {
		return contact;
	}
	private CrmContactVobj contactvobj;
	public CrmContactVobj getContactvobj() {
		return contactvobj;
	}

	public void setContactvobj(CrmContactVobj contactvobj) {
		this.contactvobj = contactvobj;
	}

	public void setContact(CrmContact contact) {
		this.contact = contact;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public void setCrmContactBiz(CrmContactBiz crmContactBiz) {
		this.crmContactBiz = crmContactBiz;
	}
	
	public String execute() {
		List<CrmContact> list = crmContactBiz.findAllByWhere(contactvobj);
		Scopes.getRequestMap().put("listx", list);
		return SUCCESS;
	}
	
	/**
	 * 获取联系人总数
	 * @return
	 */
	public String ajaxGetContNum() {
		List<CrmContact> list = crmContactBiz.findAllByWhere(contactvobj);
		String data = WebTools.convertJson(list == null ? 0 : list.size());
		Scopes.getSessionMap().put("data", data);
		
		System.out.println("我的桌面:我的联系人数: " + data);
		return "ajax";
	}
	
	public String getList() {
		//CrmContactByWhere byWe=new CrmContactByWhere(crmCustomerName, cname, cqq, createdateStart, createdateEnd, cmob);
		//if (byWe.getcCreatedateEnd()==null&&byWe.getcCreatedateStart()==null&&byWe.getcMob()==null&&byWe.getCname()==null&&byWe.getCqq()==null&&byWe.getCrmCustomerName()==null) {
			//byWe=null;
		//}
		return SUCCESS;
	}

	public String update(){
		crmContactBiz.update(contact);
		return "update";
	}
	//删除
	public String del(){
		crmContactBiz.deleteFalse(id);
		return "delete";
	}

	
	public String findOne(){
		 CrmContact crmContact=crmContactBiz.findOne(id);
		 Scopes.getRequestMap().put("one",crmContact);
		 return "findone";
	}
	
	public String add(){
		crmContactBiz.add(contact);
		return "add";
	}
	
	public String trashAll(){
		Scopes.getRequestMap().put("listx", crmContactBiz.findTrashAll());
		return "trash";
	}
	
	public String trashAdd(){
		crmContactBiz.doTrashAdd(id);
		return trashAll();
	}
	
	public String trashDel(){
		crmContactBiz.deleteById(id);
		return trashAll();
	}
}