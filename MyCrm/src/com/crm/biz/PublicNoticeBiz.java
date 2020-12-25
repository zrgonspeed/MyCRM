package com.crm.biz;


import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.crm.dao.PublicNoticeDao;
import com.crm.info.PublicNotice;

@Transactional
@Service("publicNoticeBiz")
public class PublicNoticeBiz {
	/**
	 * publicNoticeDao
	 */
	private PublicNoticeDao publicNoticeDao;

	public void setPublicNoticeDao(PublicNoticeDao publicNoticeDao) {
		this.publicNoticeDao = publicNoticeDao;
	}
	/**
	 * ȫ��
	 * @return
	 */
	public List<PublicNotice> findAllNotice(){
		return publicNoticeDao.findAllNotice();
	}
	/**
	 * ���
	 * @param publicNotice
	 * @return
	 */
	public boolean addNotice(PublicNotice publicNotice){
		try {
			publicNotice.setNoticeTime(new Date());
			publicNotice.setViewNum(0);
			publicNoticeDao.save(publicNotice);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	/**
	 * ����
	 * @param id
	 * @return
	 */
	public PublicNotice findOneNotice(int id){
		return publicNoticeDao.get(id);
	}
	/**
	 * �޸�
	 * @param publicNotice
	 */
	public boolean updateNotice(PublicNotice publicNotice){
		PublicNotice old=publicNoticeDao.get(publicNotice.getId());
		old.setHrDepartment(publicNotice.getHrDepartment());
		old.setHrEmployee(publicNotice.getHrEmployee());
		old.setNoticeContent(publicNotice.getNoticeContent());
		old.setNoticeTitle(publicNotice.getNoticeTitle());
		try {
			publicNoticeDao.save(old);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	/**
	 * ɾ��
	 * @param id
	 * @return boolean 
	 */
	public boolean delNotice(int id) {
		try {
			publicNoticeDao.delete(id);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}
