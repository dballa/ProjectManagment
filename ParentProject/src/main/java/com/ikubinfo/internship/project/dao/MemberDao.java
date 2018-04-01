package com.ikubinfo.internship.project.dao;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.ikubinfo.internship.project.converter.MemberConverter;
import com.ikubinfo.internship.project.pojo.Member;

@Repository
@Transactional
public class MemberDao {
	private SessionFactory sessionFactory;
	private MemberConverter MEMBER_CONVERTER=new MemberConverter();
	
	public void addMember(Member member) {
		
//	Session session=	sessionFactory.getCurrentSession();
//	session.save(MEMBER_CONVERTER.fromPojoToEntity(member));
	}
}
