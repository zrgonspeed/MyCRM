package com.crm.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.crm.info.SysMenu;
import com.haha.hibernate.HibernateDao;
/**
 * ϵͳ�˵���
 * @author ��
 *
 */
@Repository("sysMenuDao")
public class SysMenuDao extends HibernateDao<SysMenu, Integer> {

	/**
	 * ��ȡ��ǰ�û���Ӧ��ɫȨ�������в˵�
	 * @param menuids
	 * @return
	 */
	public List<SysMenu> getMenuListByIds(String[] menuids) {
		List<SysMenu> sysMenus=new ArrayList<SysMenu>();
		SysMenu menu=new SysMenu();
		for (int i = 0; i < menuids.length; i++) {
			int id=Integer.parseInt(menuids[i]);
			menu=get(id);
			sysMenus.add(menu);
		}
		return sysMenus;
	}
}
