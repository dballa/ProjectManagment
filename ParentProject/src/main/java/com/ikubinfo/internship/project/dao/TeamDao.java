package com.ikubinfo.internship.project.dao;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ikubinfo.internship.project.converter.TeamConverter;
import com.ikubinfo.internship.project.converter.UserConverter;
import com.ikubinfo.internship.project.entity.ProjectEntity;
import com.ikubinfo.internship.project.entity.TeamEntity;
import com.ikubinfo.internship.project.entity.UserEntity;
import com.ikubinfo.internship.project.pojo.Member;
import com.ikubinfo.internship.project.pojo.Team;
import com.ikubinfo.internship.project.pojo.User;

@Repository
@Transactional
public class TeamDao {
	@Autowired
	private SessionFactory sessionFactory;
	private TeamConverter TEAM_CONVERTER = new TeamConverter();
	private UserConverter USER_CONVERTER = new UserConverter();

	public List<Team> allTeams() {

		Query<TeamEntity> query = sessionFactory.getCurrentSession().createQuery("from TeamEntity where validity=1",
				TeamEntity.class);

		List<TeamEntity> teams = query.list();
		System.out.println(teams);
		List<Team> teamsPojo = new ArrayList<Team>();
		for (TeamEntity team : teams) {

			teamsPojo.add(TEAM_CONVERTER.fromEntityToPojo(team));
		}

		return teamsPojo;

	}

	public void addTeam(Team team) {
		Session session = sessionFactory.getCurrentSession();
		session.save(TEAM_CONVERTER.fromPojoToEntity(team));

	}

//	public boolean tryEx(Team team) throws TeamInProjectException {
//
//		Session session=sessionFactory.getCurrentSession();
//		Query<ProjectEntity>query=session.createQuery("from ProjectEntity proj where proj.validity=1 and proj.team.idTeam=?1 ",ProjectEntity.class);
//		query.setParameter(1, team.getIdTeam());
//		List<ProjectEntity>project=query.getResultList();
//		
//		
//		if (project !=null) {
//			throw new TeamInProjectException("This Team has a project");
//			
//		}
//		else	return false;
//		
//	}

	public void removeTeam(Team team) {
		Session session = sessionFactory.getCurrentSession();
		session.merge(TEAM_CONVERTER.fromPojoToEntity(team));

	}

	public List<User> teamInfo(Team team) {

		Session session = sessionFactory.getCurrentSession();
		Query<UserEntity> query = session.createQuery(
				"select members.user from MemberEntity members where members.team.idTeam=?1 and members.validity=1", UserEntity.class);
		query.setParameter(1, team.getIdTeam());
		List<UserEntity> users = query.list();

		List<User> usersPojo = new ArrayList<User>();
		for (UserEntity user : users) {

			usersPojo.add(USER_CONVERTER.fromEntityToPojo(user));
		}
		return usersPojo;

	}

	public Team getTeamById(int id) {

		Session session = sessionFactory.getCurrentSession();

		TeamEntity found = session.find(TeamEntity.class, id);
		return TEAM_CONVERTER.fromEntityToPojo(found);
	}

	public void editTeam(Team team) {
		Session session = sessionFactory.getCurrentSession();
		System.out.println(team);
	session.merge(TEAM_CONVERTER.fromPojoToEntity(team));
		
	}
}
