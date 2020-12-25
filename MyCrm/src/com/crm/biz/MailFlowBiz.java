package com.crm.biz;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.crm.dao.MailFlowDao;
import com.crm.info.HrEmployee;
import com.crm.info.MailFlow;
import com.crm.info.ParamSysparam;
import com.crm.tools.Scopes;
import com.crm.vobj.PageInfo;

@Transactional
@Service("mailFlowBiz")
public class MailFlowBiz {
	private MailFlowDao mailFlowDao;
	
	public void setMailFlowDao(MailFlowDao mailFlowDao) {
		this.mailFlowDao = mailFlowDao;
	}
	private MailAttachmentBiz mailAttachmentBiz;

	public void setMailAttachmentBiz(MailAttachmentBiz mailAttachmentBiz) {
		this.mailAttachmentBiz = mailAttachmentBiz;
	}

	/**
	 * ���յ�ǰ�û���ѯ�������ʼ�
	 * @param info 
	 * @return
	 */
	public List<MailFlow> loadNewMail(PageInfo info) {
		HrEmployee employee =(HrEmployee)Scopes.getSessionMap().get("emp");
		return mailFlowDao.loadNewMail(employee,info);
	}

	public int getNewMail() {
		HrEmployee employee =(HrEmployee)Scopes.getSessionMap().get("emp");
		return mailFlowDao.getNewMailCount(employee);
	}
	/**
	 * ��ѯ��ǰ�û���ȫ���ʼ�
	 * @return
	 */
	public List<MailFlow> loadAllMail(PageInfo pi){
		HrEmployee employee =(HrEmployee)Scopes.getSessionMap().get("emp");
		return mailFlowDao.loadAllMail(employee,pi);
	}
	/**
	 * ��ѯ��ǰ�û�����ɾ���ʼ�
	 * @return
	 */
	public List<MailFlow> loadTrashMail(PageInfo pi){
		HrEmployee employee =(HrEmployee)Scopes.getSessionMap().get("emp");
		return mailFlowDao.loadTrashMail(employee,pi);
	}
	/**
	 * ��ѯ��ǰ�û����Ǳ��ʼ�   id  52
	 * @return
	 */
	public List<MailFlow> loadStarMail(PageInfo pi){
		HrEmployee employee =(HrEmployee)Scopes.getSessionMap().get("emp");
		return mailFlowDao.loadStarMail(employee,pi);
	}
	/**
	 * ��ѯ��ǰ�û��ķ����ʼ�
	 * @return
	 */
	public List<MailFlow> loadSendMail(PageInfo pi){
		HrEmployee employee =(HrEmployee)Scopes.getSessionMap().get("emp");
		return mailFlowDao.loadSendMail(employee,pi);
	}
	public int[] addMail(MailFlow mailflow, String emps) {
		try {
			String[] all=emps.split(",");
			int[] empid=new int[all.length];
			HrEmployee currentemp=new HrEmployee();
			HrEmployee employee=(HrEmployee) Scopes.getSessionMap().get("emp");
			int[] flows=new int[all.length];
			for (int i = 0; i < all.length; i++) {
				empid[i]=Integer.parseInt(all[i]);
				MailFlow flow=new MailFlow();
				flow.setHrEmployeeBySenderId(employee);
				
				currentemp.setId(empid[i]);
				flow.setHrEmployeeByReceiveId(currentemp);
				flow.setIsdelete(1);
				flow.setIsview(0);
				flow.setMailContent(mailflow.getMailContent());
				flow.setMailTitle(mailflow.getMailTitle());
				flow.setSenderTime(new Timestamp(new Date().getTime()));
				mailFlowDao.save(flow);
				flows[i] = flow.getId();
			}
			return flows;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	/**
	 * ����
	 * @param id
	 * @return
	 */
	public MailFlow findOne(int id) {
		return mailFlowDao.get(id);
	}
	/**
	 * ��ɾ��
	 * @param id
	 * @return
	 */
	public boolean delFalse(int id) {
		MailFlow flow = mailFlowDao.get(id);
		flow.setDeleteTime(new Date());
		flow.setIsdelete(0);
		try {
			mailFlowDao.save(flow);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	/**
	 * ɾ��
	 * @param id
	 * @return
	 */
	public boolean delete(int id) {
		try {
			//ɾ���ʼ�ǰ ɾ��������
			mailAttachmentBiz.deleteChildAttach(id);
			mailFlowDao.delete(id);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	/**
	 * ���õ�ǰ״̬Ϊ�Ѷ�
	 * @param id
	 * @return
	 */
	public boolean setIsView(int id){
		MailFlow flow = mailFlowDao.get(id);
		HrEmployee employee =(HrEmployee)Scopes.getSessionMap().get("emp");
		try {
			if (flow.getHrEmployeeByReceiveId().getId().equals(employee.getId())) {
				flow.setIsview(1);
				flow.setViewTime(new Timestamp(new Date().getTime()));
				mailFlowDao.save(flow);	
			}
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	/**
	 * ����Ϊ�Ǳ��ʼ�
	 * @param id
	 * @return
	 */
	public boolean setStar(int id){
		MailFlow flow = mailFlowDao.get(id);
		if (flow.getParamSysparamByImportant()==null) {
			ParamSysparam p2=new ParamSysparam();
			p2.setId(52);
			flow.setParamSysparamByImportant(p2);
		}else{
			flow.setParamSysparamByImportant(null);
		}
		try {
			mailFlowDao.save(flow);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public List<MailFlow> findBymailTitle(String searchname, PageInfo info) {
		HrEmployee employee =(HrEmployee)Scopes.getSessionMap().get("emp");
		return mailFlowDao.findByMailTitle(employee,searchname,info);
	}
	
	public List<MailFlow> findTrashAll(){
		return mailFlowDao.findTrashAll();
	}
}
