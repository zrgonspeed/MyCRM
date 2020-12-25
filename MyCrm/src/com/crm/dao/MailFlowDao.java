package com.crm.dao;

import java.util.List;

import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.crm.info.HrEmployee;
import com.crm.info.MailFlow;
import com.crm.vobj.PageInfo;
import com.haha.hibernate.HibernateDao;

/**
 * Ա���ڲ��ʼ���
 * @author ��
 *
 */
@Repository("mailFlowDao")
public class MailFlowDao extends HibernateDao<MailFlow, Integer> {
	/**
	 * ���յ�ǰ�û���ѯ�������ʼ�
	 * @param employee
	 * @param info 
	 * @return
	 */
	public List<MailFlow> loadNewMail(HrEmployee employee, PageInfo info) {
		int recordcount = Integer.parseInt(getSession().createCriteria(MailFlow.class)
			.add(Restrictions.eq("isdelete", 1))
			.add(Restrictions.eq("isview",0))
			.add(Restrictions.eq("hrEmployeeByReceiveId.id", employee.getId()))
			.setProjection(Projections.rowCount()).uniqueResult().toString());
		info.setRecordCount(recordcount);
		info.computePageCount();
		return getSession().createCriteria(MailFlow.class)
				.add(Restrictions.eq("isdelete", 1))
				.add(Restrictions.eq("isview",0))
				.add(Restrictions.eq("hrEmployeeByReceiveId.id", employee.getId()))
				.setFirstResult(info.getStartRow()).setMaxResults(info.getPageSize()).list();
	}
	public int getNewMailCount(HrEmployee employee) {
		return Integer.parseInt(getSession().createCriteria(MailFlow.class)
				.add(Restrictions.eq("isdelete", 1))
				.add(Restrictions.eq("isview",0))
				.add(Restrictions.eq("hrEmployeeByReceiveId.id", employee.getId()))
				.setProjection(Projections.rowCount()).uniqueResult().toString());
	}
	/**
	 * ��ѯ��ǰ�û���ȫ���ʼ�
	 * @param employee
	 * @return
	 */
	public List<MailFlow> loadAllMail(HrEmployee employee,PageInfo info){
		int recordcount = Integer.parseInt(getSession().createCriteria(MailFlow.class)
			.add(Restrictions.eq("isdelete", 1))
			.add(Restrictions.eq("hrEmployeeByReceiveId.id", employee.getId()))
			.setProjection(Projections.rowCount()).uniqueResult().toString());
		info.setRecordCount(recordcount);
		info.computePageCount();
		return getSession().createCriteria(MailFlow.class)
				.add(Restrictions.eq("isdelete", 1))
				.add(Restrictions.eq("hrEmployeeByReceiveId.id", employee.getId()))
				.setFirstResult(info.getStartRow()).setMaxResults(info.getPageSize()).list();
	}
	/**
	 * ��ѯ��ǰ�û�����ɾ���ʼ�
	 * @param employee
	 * @return
	 */
	public List<MailFlow> loadTrashMail(HrEmployee employee,PageInfo info){
		int recordcount = Integer.parseInt(getSession().createCriteria(MailFlow.class)
				.add(Restrictions.eq("isdelete", 0))
				.add(Restrictions.eq("hrEmployeeByReceiveId.id", employee.getId()))
				.setProjection(Projections.rowCount()).uniqueResult().toString());
		info.setRecordCount(recordcount);
		info.computePageCount();
		return getSession().createCriteria(MailFlow.class)
				.add(Restrictions.eq("isdelete", 0))
				.add(Restrictions.eq("hrEmployeeByReceiveId.id", employee.getId()))
				.setFirstResult(info.getStartRow()).setMaxResults(info.getPageSize()).list();
	}
	/**
	 * ��ѯ��ǰ�û����Ǳ��ʼ�   id  52
	 * @param employee
	 * @return
	 */
	public List<MailFlow> loadStarMail(HrEmployee employee,PageInfo info){
		int recordcount = Integer.parseInt(getSession().createCriteria(MailFlow.class)
				.add(Restrictions.eq("isdelete", 1))
				.add(Restrictions.eq("paramSysparamByImportant.id", 52))
				.add(Restrictions.eq("hrEmployeeByReceiveId.id", employee.getId()))
				.setProjection(Projections.rowCount()).uniqueResult().toString());
		info.setRecordCount(recordcount);
		info.computePageCount();
		return getSession().createCriteria(MailFlow.class)
				.add(Restrictions.eq("isdelete", 1))
				.add(Restrictions.eq("paramSysparamByImportant.id", 52))
				.add(Restrictions.eq("hrEmployeeByReceiveId.id", employee.getId()))
				.setFirstResult(info.getStartRow()).setMaxResults(info.getPageSize()).list();
	}
	/**
	 * ��ѯ��ǰ�û��ķ����ʼ�
	 * @param employee
	 * @return
	 */
	public List<MailFlow> loadSendMail(HrEmployee employee,PageInfo info){
		int recordcount = Integer.parseInt(getSession().createCriteria(MailFlow.class)
				.add(Restrictions.eq("hrEmployeeBySenderId.id", employee.getId()))
				.setProjection(Projections.rowCount()).uniqueResult().toString());
		info.setRecordCount(recordcount);
		info.computePageCount();
		return getSession().createCriteria(MailFlow.class)
		.add(Restrictions.eq("hrEmployeeBySenderId.id", employee.getId()))
		.setFirstResult(info.getStartRow()).setMaxResults(info.getPageSize()).list();
	}
	/**
	 * ���������� ��ҳ��ѯ
	 * @param employee
	 * @param searchname
	 * @param info
	 * @return
	 */
	public List<MailFlow> findByMailTitle(HrEmployee employee,String searchname, PageInfo info) {
		int recordcount = Integer.parseInt(getSession().createCriteria(MailFlow.class)
				.add(Restrictions.eq("hrEmployeeByReceiveId.id", employee.getId()))
				.add(Restrictions.ilike("mailTitle", searchname,MatchMode.ANYWHERE))
				.setProjection(Projections.rowCount()).uniqueResult().toString());
		info.setRecordCount(recordcount);
		info.computePageCount();
		return getSession().createCriteria(MailFlow.class)
				.add(Restrictions.eq("hrEmployeeByReceiveId.id", employee.getId()))
				.add(Restrictions.ilike("mailTitle", searchname,MatchMode.ANYWHERE))
				.setFirstResult(info.getStartRow()).setMaxResults(info.getPageSize()).list();
	}
	public List<MailFlow> findTrashAll() {
		return getSession().createCriteria(MailFlow.class).add(Restrictions.eq("isdelete", 0)).list();
	}
	
}
