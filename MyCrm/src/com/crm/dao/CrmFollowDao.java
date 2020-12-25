package com.crm.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.crm.info.CrmFollow;
import com.crm.vobj.CrmFollowVobj;
import com.haha.hibernate.HibernateDao;
/**
 * �ͻ�������
 * @author ��
 *
 */
@Repository("crmFollowDao")
public class CrmFollowDao  extends HibernateDao<CrmFollow, Integer >{

	public List<CrmFollow> findAllByCusId(int id) {
		return getSession().createCriteria(CrmFollow.class).add(Restrictions.eq("isdelete", 1)).add(Restrictions.eq("crmCustomer.id", id)).list();
	}

	public List<CrmFollow> findAllByWhere(CrmFollowVobj followvobj) {
		if(followvobj==null){
			return getSession().createCriteria(CrmFollow.class).add(Restrictions.eq("isdelete", 1)).list();
		}else{
			return createCriter(getSession(),followvobj).add(Restrictions.eq("isdelete", 1)).list();
		}
	}
	
	private Criteria createCriter(Session s, CrmFollowVobj cy) {
		Criteria c = s.createCriteria(CrmFollow.class);
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
			c.add(Restrictions.eq("hrEmployee.id", cy.getEmployeeId()));
		}
		if (cy.getStartfollowdate() != null) {
			//ǩ��ʱ�俪ʼ
			c.add(Restrictions.ge("followDate", cy.getStartfollowdate()));
		}
		if (cy.getEndfollowdate() != null) {
			//ǩ��ʱ�����
			c.add(Restrictions.le("followDate", cy.getEndfollowdate()));
		}
		if (cy.getFollowcontent() != null && cy.getFollowcontent().length() > 0) {
			// �������ݲ�Ϊ��
			c.add(Restrictions.ilike("follow", cy.getFollowcontent(), MatchMode.ANYWHERE));
		}
		if (cy.getFollowtype()!=null && cy.getFollowtype() > 0) {
			c.add(Restrictions.eq("paramSysparam.id", cy.getFollowtype()));
		}
		return c;
	}
	
	public List<CrmFollow> findTrashAll() {
		return getSession().createCriteria(CrmFollow.class).add(Restrictions.eq("isdelete", 0)).list();
	}
}
