package com.crm.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.crm.info.CrmReceive;
import com.crm.vobj.CrmReceiveVobj;
import com.haha.hibernate.HibernateDao;

/**
 * �ͻ��տ��
 * @author ��
 *
 */
@Repository("crmReceiveDao")
public class CrmReceiveDao extends HibernateDao<CrmReceive, Integer> {

	public List<CrmReceive> findAllByOrderId(int ordid) {
		return getSession().createCriteria(CrmReceive.class).add(Restrictions.eq("isdelete", 1)).add(Restrictions.eq("crmOrder.id", ordid)).list();
	}

	public List<CrmReceive> findAllByWhere(CrmReceiveVobj receivevobj) {
		if (receivevobj==null) {
			return getSession().createCriteria(CrmReceive.class).add(Restrictions.eq("isdelete", 1)).list();
		}
		return createCriter(getSession(),receivevobj).add(Restrictions.eq("isdelete", 1)).list();
	}

	private Criteria createCriter(Session s, CrmReceiveVobj cy) {
		Criteria c = s.createCriteria(CrmReceive.class);
		if (cy.getCustomerId() != null && cy.getCustomerId() > 0) {
			// ��˾��Ϊ��
			c.add(Restrictions.eq("crmCustomer.id", cy.getCustomerId()));
		}
		if (cy.getDepartmentId() != null && cy.getDepartmentId() > 0) {
			// ҵ���Ų�Ϊ��
			c.add(Restrictions.eq("hrDepartment.id", cy.getDepartmentId()));
		}
		if (cy.getEmployeeId() != null && cy.getEmployeeId() > 0) {
			// ҵ��Ա��Ϊ��
			c.add(Restrictions.eq("hrEmployeeByCEmpid.id", cy.getEmployeeId()));
		}
		if (cy.getStartdate() != null) {
			//ǩ��ʱ�俪ʼ
			c.add(Restrictions.ge("receiveDate", cy.getStartdate()));
		}
		if (cy.getEnddate() != null) {
			//ǩ��ʱ�����
			c.add(Restrictions.le("receiveDate", cy.getEnddate()));
		}
		if (cy.getNum() != null && cy.getNum().length() > 0) {
			// �������ݲ�Ϊ��
			c.add(Restrictions.ilike("receiveNum", cy.getNum(), MatchMode.ANYWHERE));
		}
		if (cy.getPaytype()!=null && cy.getPaytype() > 0) {
			c.add(Restrictions.eq("paramSysparamByReceiveTypeId.id", cy.getPaytype()));
		}
		return c;
	}
	
	public List<CrmReceive> findTrashAll() {
		return getSession().createCriteria(CrmReceive.class).add(Restrictions.eq("isdelete", 0)).list();
	}
	
}
