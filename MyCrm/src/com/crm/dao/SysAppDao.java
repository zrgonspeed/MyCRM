package com.crm.dao;

import org.springframework.stereotype.Repository;

import com.crm.info.SysApp;
import com.haha.hibernate.HibernateDao;
/**
 * ϵͳӦ��ģ��
 * @author ��
 *
 */
@Repository("sysAppDao")
public class SysAppDao extends HibernateDao<SysApp, Integer> {
	
}
