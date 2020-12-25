package com.crm.biz;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.crm.dao.SysAppDao;
import com.crm.info.SysApp;
@Transactional
@Service("sysAppBiz")
public class SysAppBiz  {
	private SysAppDao sysAppDao;
	
	public void setSysAppDao(SysAppDao sysAppDao) {
		this.sysAppDao = sysAppDao;
	}
	/**
	 * ���ҳ�����߰�ťӦ��
	 * @return
	 */
	public List<SysApp> findLeftApp() {	
		return sysAppDao.findBy("appOrder", 1);
	}
	/**
	 * ���ҳ���ұ߰�ťӦ��
	 * @return
	 */
	public List<SysApp> findRightApp() {
		return sysAppDao.findBy("appOrder", 0);
	}
}
