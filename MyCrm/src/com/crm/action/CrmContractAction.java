package com.crm.action;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.crm.biz.CrmContractBiz;
import com.crm.info.CrmContract;
import com.crm.tools.Scopes;
import com.crm.vobj.CrmContractVobj;
import com.opensymphony.xwork2.ActionSupport;

@Scope("prototype")
@Controller("crmContractAction")
public class CrmContractAction extends ActionSupport {

	private CrmContractBiz crmContractBiz;

	public void setcrmContractBiz(CrmContractBiz crmContractBiz) {
		this.crmContractBiz = crmContractBiz;
	}
	//�����޸� ���
	private CrmContract contract;
	public CrmContract getContract() {
		return contract;
	}

	public void setContract(CrmContract contract) {
		this.contract = contract;
	}
	//����������ѯ
	private CrmContractVobj contractvobj;

	public CrmContractVobj getContractvobj() {
		return contractvobj;
	}

	public void setContractvobj(CrmContractVobj contractvobj) {
		this.contractvobj = contractvobj;
	}

	/**
	 * @return SUCCESS
	 */
	public String execute() {
		List<CrmContract> list = crmContractBiz.findAllByWhere(contractvobj);
		Scopes.getRequestMap().put("a", list);
		Scopes.getRequestMap().put("vobj", contractvobj);
		return SUCCESS;
	}
	
	private int id;
	public void setId(int id) {
		this.id = id;
	}
	
	/**
	 * @return
	 */
	public String findOne() {
		CrmContract c = crmContractBiz.findOne(id);
		Scopes.getRequestMap().put("one", c);
		return "findone";

	}

	public String update() {
		crmContractBiz.update(contract);
		/*if (a) {
			Scopes.getRequestMap().put("data", "success");
		} else {
			Scopes.getRequestMap().put("data", "failed");
		}*/
		return "update";
	}

	/**
	 * Ԥɾ�� �쳣����������������� biz ������ ʹaction ���ּ�� ����������
	 * 
	 * @return
	 */
	public String del() {
		crmContractBiz.deleteFalse(id);
		return "delete";

	}

	public String add() {
		crmContractBiz.add(contract);
		return "add";
	}
	
	public String trashAll(){
		Scopes.getRequestMap().put("a",crmContractBiz.findTrashAll());
		return "trash";
	}
	
	public String trashAdd(){
		crmContractBiz.doTrashAll(id);
		return trashAll();
	}
	public String trashDel(){
		crmContractBiz.deleteById(id);
		return trashAll();
	}
}