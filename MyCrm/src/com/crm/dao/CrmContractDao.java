package com.crm.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.crm.info.CrmContract;
import com.crm.vobj.CrmContractVobj;
import com.haha.hibernate.HibernateDao;

/**
 * ��ͬ��
 * @author ��
 * 
 */
@Repository("crmContractDao")
public class CrmContractDao extends HibernateDao<CrmContract, Integer> {
	
	public List<CrmContract> findAllByWhere(CrmContractVobj cy) {
		if (cy==null) {
			return getSession().createCriteria(CrmContract.class).add(Restrictions.eq("isdelete", 1)).list();
		}
		Criteria cri = createCriter(this.getSession(), cy);
		return cri.add(Restrictions.eq("isdelete", 1)).list();
	}
	
	private Criteria createCriter(Session s, CrmContractVobj cy) {
		Criteria c = s.createCriteria(CrmContract.class);
		if (cy.getCustomerId() != null && cy.getCustomerId() > 0) {
			// ��˾��Ϊ��
			c.add(Restrictions.eq("crmCustomer.id", cy.getCustomerId()));
		}
		if (cy.getDepartmentId() != null && cy.getDepartmentId() > 0) {
			// ҵ���Ų�Ϊ��
			c.add(Restrictions.eq("hrDepartmentByOurContractorDepid.id", cy.getDepartmentId()));
		}
		if (cy.getEmployeeId() != null && cy.getEmployeeId() > 0) {
			// ҵ��Ա��Ϊ��
			c.add(Restrictions.eq("hrEmployeeByOurContractorId.id", cy.getEmployeeId()));
		}
		if (cy.getStartSigndate() != null) {
			//ǩ��ʱ�俪ʼ
			c.add(Restrictions.ge("signDate", cy.getStartSigndate()));
		}
		if (cy.getEndSigndate() != null) {
			//ǩ��ʱ�����
			c.add(Restrictions.le("signDate", cy.getEndSigndate()));
		}
		if (cy.getContractName() != null && cy.getContractName().length() > 0) {
			// ��ͬ����Ϊ��
			c.add(Restrictions.ilike("contractName", cy.getContractName(), MatchMode.ANYWHERE));
		}
		return c;
	}
	
	public List<CrmContract> findTrashAll(){
		return getSession().createCriteria(CrmContract.class).add(Restrictions.eq("isdelete", 0)).list();
	}
}
