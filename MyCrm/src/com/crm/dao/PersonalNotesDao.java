package com.crm.dao;

import org.springframework.stereotype.Repository;

import com.crm.info.PersonalNotes;
import com.haha.hibernate.HibernateDao;

/**
 * 个人便签表
 * @author 凯
 *
 */
@Repository("personalNotesDao")
public class PersonalNotesDao extends HibernateDao<PersonalNotes, Integer>{
	
}
