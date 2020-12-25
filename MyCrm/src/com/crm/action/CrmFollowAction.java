package com.crm.action;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.crm.biz.CrmFollowBiz;
import com.crm.info.CrmFollow;
import com.crm.tools.Scopes;
import com.crm.tools.WebTools;
import com.crm.vobj.CrmFollowVobj;
import com.opensymphony.xwork2.ActionSupport;
@Scope("prototype")
@Controller("crmFollowAction")
public class CrmFollowAction extends ActionSupport {
	
	private CrmFollowBiz crmFollowBiz;
	private int id;
	
	public void setId(int id) {
		this.id = id;
	}
	public void setCrmFollowBiz(CrmFollowBiz crmFollowBiz) {
		this.crmFollowBiz = crmFollowBiz;
	}
	private CrmFollow follow;
	
	public CrmFollow getFollow() {
		return follow;
	}
	public void setFollow(CrmFollow follow) {
		this.follow = follow;
	}
	
	public String execute() {
		if (id < 1) {//�����������Ӻ���ת�� ָ��ID�ͻ� �ĸ���
			id=WebTools.follow_custid;
		}
		List<CrmFollow> follows = crmFollowBiz.findAllByCusId(id);
		Scopes.getRequestMap().put("follows",follows);
		Scopes.getRequestMap().put("customerid", id);
		return "findbycusid";
	}
	
	public String addFollow(){
		//���follow.id��null �Ǿ������
		if (follow.getId() == null || follow.getId() < 1) {
			crmFollowBiz.addFollow(follow);
		}else{//���������޸�
			crmFollowBiz.updateFollow(follow);
		}
		WebTools.follow_custid=follow.getCrmCustomer().getId();//������ӵ�ǰ�Ŀͻ� ID
		return "add";
	}
	public String delete(){
		crmFollowBiz.deleteFalse(follow.getId());
		WebTools.follow_custid=id;
		return "delete";
	}
	private CrmFollowVobj followvobj;
	
	public CrmFollowVobj getFollowvobj() {
		return followvobj;
	}
	
	public void setFollowvobj(CrmFollowVobj followvobj) {
		this.followvobj = followvobj;
	}
	
	public String findAll(){
		List<CrmFollow> follows = crmFollowBiz.findAllByWhere(followvobj);
		Scopes.getRequestMap().put("follows", follows);
		return "findall";
	}
	public String trashAll(){
		Scopes.getRequestMap().put("follows", crmFollowBiz.findTrashAll());
		return "trash";
	}
	public String trashAdd(){
		crmFollowBiz.doTrashAdd(id);
		return trashAll();
	}
	public String trashDel(){
		crmFollowBiz.deleteById(id);
		return trashAll();
	}
}