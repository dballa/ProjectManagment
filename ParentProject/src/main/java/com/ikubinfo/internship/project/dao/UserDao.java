package com.ikubinfo.internship.project.dao;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ikubinfo.internship.project.converter.UserConverter;
import com.ikubinfo.internship.project.entity.UserEntity;
import com.ikubinfo.internship.project.pojo.Team;
import com.ikubinfo.internship.project.pojo.User;

@Repository
@Transactional
public class UserDao {
	@Autowired
	private SessionFactory sessionFactory;

	private UserConverter USER_CONVERTER = new UserConverter();

	public List<User> allUsers() {

		Session session = sessionFactory.getCurrentSession();
		Query<UserEntity> query = session.createQuery("from UserEntity where validity=1", UserEntity.class);
		List<UserEntity> users = query.list();
		List<User> userPojo = new ArrayList<User>();
		for (UserEntity user : users) {

			userPojo.add(USER_CONVERTER.fromEntityToPojo(user));
		}

		return userPojo;
	}
	
	public List<User>getDevelopers(Team team){
		
		Session session=sessionFactory.getCurrentSession();
		Query<UserEntity> query=session.createQuery("select us from UserEntity us join us.members usmem where usmem.team.idTeam=?1 and us.role.nameRole=?2 and us.validity=1",UserEntity.class);
		query.setParameter(1, team.getIdTeam());
		query.setParameter(2, "Developer");
		List<UserEntity> users =query.getResultList();
		List<User> usersPojo=new ArrayList<User>();
		for(UserEntity user:users) {
			
			usersPojo.add(USER_CONVERTER.fromEntityToPojo(user));
		}
		
		return usersPojo;
		
	}
}
