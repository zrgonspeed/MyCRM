package com.crm.biz;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.crm.biz.CrmContactBiz;
import com.crm.dao.CrmContactDao;
import com.crm.info.CrmContact;
import com.crm.vobj.CrmContactVobj;
@Transactional
@Service("crmContactBiz")
public class CrmContactBiz {
	
	private CrmContactDao crmContactDao;

	public void setCrmContactDao(CrmContactDao crmContactDao) {
		this.crmContactDao = crmContactDao;
	}
	/**
	 * ����id ��ɾ��
	 * @param id
	 * @return
	 */
	public boolean deleteById(int id) {
		try {
			crmContactDao.delete(id);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	/**
	 * ����
	 * @param customer
	 * @return
	 */
	public boolean update(CrmContact customer) {
			CrmContact c=crmContactDao.get(customer.getId());
			c.setCName(customer.getCName());
			c.setCSex(customer.getCSex());
			c.setCDepartment(customer.getCDepartment());
			c.setCPosition(customer.getCPosition());
			c.setCBirthday(customer.getCBirthday());
			c.setCTel(customer.getCTel());
			c.setCMob(customer.getCMob());
			c.setCEmail(customer.getCEmail());
			c.setCQq(customer.getCQq());
			c.setCHobby(customer.getCHobby());
			c.setCAddress(customer.getCAddress());
			c.setCRemarks(customer.getCRemarks());
			try {
				crmContactDao.save(c);
				return true;
			} catch (Exception e) {
				e.printStackTrace();
				return false;
			}
	}
	/**
	 * ��ɾ��
	 * @param id
	 * @return
	 */
	public boolean deleteFalse(int id) {
		CrmContact customer = crmContactDao.get(id);
		customer.setIsdelete(0);//0������ɾ��
		customer.setDeleteTime(new Timestamp(new Date().getTime()));
		try {
			crmContactDao.save(customer);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	/**
	 * ��ѯȫ������  ���ų�isdelete = 0
	 * @return
	 */
	public List<CrmContact> findAll() {
		List<CrmContact> list=crmContactDao.getAll();
		return list;
	}

	/**
	 * ������ѯ
	 * @param cy
	 * @return
	 */
	public List<CrmContact> findAllByWhere(CrmContactVobj cy) {
		return crmContactDao.findAllByWhere(cy);
	}

	/**
	 * ����
	 * @param id
	 * @return
	 */
	public CrmContact findOne(int id) {
		return crmContactDao.get(id);
	}

	/**
	 * ����
	 * @param contact
	 * @return
	 */
	public boolean add(CrmContact contact) {
		try {
			contact.setIsdelete(1);
			contact.setCCreatedate(new Date());
			//contact.setHrEmployee((HrEmployee)Scopes.getSessionMap().get("emp"));
			crmContactDao.save(contact);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public List<CrmContact> findTrashAll(){
		return crmContactDao.findTrashAll();
	}
	public boolean doTrashAdd(int id) {
		CrmContact customer = crmContactDao.get(id);
		customer.setIsdelete(1);//0������ɾ��
		customer.setDeleteTime(null);
		try {
			crmContactDao.save(customer);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}
