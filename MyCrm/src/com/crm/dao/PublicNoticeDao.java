package com.crm.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.crm.info.PublicNotice;
import com.haha.hibernate.HibernateDao;

/**
 * ���������
 * @author ��
 *
 */
@Repository("publicNoticeDao")
public class PublicNoticeDao  extends HibernateDao<PublicNotice, Integer>{

	public List<PublicNotice> findAllNotice() {
		List<PublicNotice> list = this.getSession().createCriteria(PublicNotice.class).list();
		return list;
	}
}
