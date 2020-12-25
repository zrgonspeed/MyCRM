package com.crm.biz;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.crm.dao.SysMenuDao;
import com.crm.info.SysMenu;
import com.crm.info.SysRole;
import com.crm.vobj.SysMenuVobj;

@Transactional
@Service("sysMenuBiz")
public class SysMenuBiz {
	private SysMenuDao sysMenuDao;
	
	public void setSysMenuDao(SysMenuDao sysMenuDao) {
		this.sysMenuDao = sysMenuDao;
	}

	public List<SysMenuVobj> findShowMenusByRole(SysRole sysRole) {
		//���յ�ǰȨ���²˵���
		List<SysMenuVobj> list=new ArrayList<SysMenuVobj>();
		//��ȡȨ����Id����
		String[] sysid = sysRole.getChildmenus().split(",");
		
		for (String id : sysid) {
			try {
				SysMenu menu = sysMenuDao.get(Integer.parseInt(id));
				if (menu!=null) {
					list.add(convertVobj(menu));
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		SysMenuVobj vobj=null;
		List<SysMenuVobj> vobjs=new ArrayList<SysMenuVobj>();
		for (SysMenuVobj me : list) {
			//��id����0�Ķ��Ǹ��ڵ�
			if (me.getParentid().equals(0)) {
				
				vobj= me;
				int pkid = me.getMenuId();//��ȡ�����ڵ������id
				
				for (SysMenuVobj chime : list) {
					//��������ڵ��parent id ���� �ϼ��� ����PK id
					if (chime.getParentid().equals(pkid)) {
						SysMenuVobj two = chime;
						int pkthree = chime.getMenuId(); //��ȡ�������ڵ�� PK
						
						for (SysMenuVobj threeme : list) {
							//��������ڵ�parent id ���� ���� �ڵ� PK��id
							if (threeme.getParentid().equals(pkthree)) {
								two.sysMenus.add(threeme);
							}
						}
						vobj.sysMenus.add(two);
					}
				}
				vobjs.add(vobj);
			}
		}
		return vobjs;
	}
	
	private SysMenuVobj convertVobj(SysMenu menu){
		SysMenuVobj vobj=new SysMenuVobj();
		if (menu!=null) {
			vobj.setMenuIcon(menu.getMenuIcon());
			vobj.setMenuId(menu.getMenuId());
			vobj.setMenuName(menu.getMenuName());
			vobj.setMenuUrl(menu.getMenuUrl());
			vobj.setParentid(menu.getParentid());
		}
		return vobj;
	}
	
	public List<SysMenuVobj> findAllTree(){
		//���յ�ǰȨ���²˵���
		List<SysMenuVobj> list=new ArrayList<SysMenuVobj>();
		List<SysMenu> menus=sysMenuDao.getAll();
		System.out.println(menus);
		for (SysMenu menu : menus) {
			list.add(convertVobj(menu));
		}
		SysMenuVobj vobj=null;
		List<SysMenuVobj> vobjs=new ArrayList<SysMenuVobj>();
		
		for (SysMenuVobj me : list) {
			//��id����0�Ķ��Ǹ��ڵ�
			if (me.getParentid().equals(0)) {
				
				vobj= me;
				int pkid = me.getMenuId();//��ȡ�����ڵ������id
				
				for (SysMenuVobj chime : list) {
					//��������ڵ��parent id ���� �ϼ��� ����PK id
					if (chime.getParentid().equals(pkid)) {
						SysMenuVobj two = chime;
						int pkthree = chime.getMenuId(); //��ȡ�������ڵ�� PK
						
						for (SysMenuVobj threeme : list) {
							//��������ڵ�parent id ���� ���� �ڵ� PK��id
							if (threeme.getParentid().equals(pkthree)) {
								two.sysMenus.add(threeme);
							}
						}
						vobj.sysMenus.add(two);
					}
				}
				vobjs.add(vobj);
			}
		}
		return vobjs;
	}
}
