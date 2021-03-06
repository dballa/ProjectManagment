package com.ikubinfo.internship.project.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.NoResultException;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ikubinfo.internship.project.converter.MemberConverter;
import com.ikubinfo.internship.project.converter.TeamConverter;
import com.ikubinfo.internship.project.converter.UserConverter;
import com.ikubinfo.internship.project.entity.MemberEntity;
import com.ikubinfo.internship.project.entity.ProjectEntity;
import com.ikubinfo.internship.project.entity.TeamEntity;
import com.ikubinfo.internship.project.entity.UserEntity;
import com.ikubinfo.internship.project.pojo.Member;
import com.ikubinfo.internship.project.pojo.Team;
import com.ikubinfo.internship.project.pojo.User;
import com.ikubinfo.internship.project.utils.StatesEnum;

@Repository
@Transactional
public class TeamDao {
	@Autowired
	private SessionFactory sessionFactory;
	private TeamConverter TEAM_CONVERTER = new TeamConverter();
	private UserConverter USER_CONVERTER = new UserConverter();
	private MemberConverter MEMBER_CONVERTER = new MemberConverter();

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

	 public boolean isTeamWithoutProject(Team team) {
	
	 Session session=sessionFactory.getCurrentSession();
	 Query<ProjectEntity>query=session.createQuery("select proj from ProjectEntity proj where proj.team.idTeam=?1  and proj.validity=1 and proj.status.nameStatus!=?2",ProjectEntity.class);
	 query.setParameter(1, team.getIdTeam());
	 query.setParameter(2, StatesEnum.DONE_STATUS.getStr());
	 List<ProjectEntity>project=query.getResultList();
	System.out.println(project);
	
	 if (project.isEmpty()) {
	 return true;
	
	 }
	 else return false;
	
	 }

	public void removeTeam(Team team) {
		Session session = sessionFactory.getCurrentSession();
		session.merge(TEAM_CONVERTER.fromPojoToEntity(team));

	}

	public List<User> teamInfo(Team team) {

		Session session = sessionFactory.getCurrentSession();
		Query<UserEntity> query = session.createQuery(
				"select members.user from MemberEntity members where members.team.idTeam=?1 and members.validity=1",
				UserEntity.class);
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
		session.update(TEAM_CONVERTER.fromPojoToEntity(team));

	}

	public List<User> notMembersOfThisTeam(Team team) {
		Session session = sessionFactory.getCurrentSession();
		Query<UserEntity> query = session.createQuery(
			//	"select members.user from MemberEntity members where members.team.idTeam!=?1 and members.validity=1",
			//	"select user from UserEntity user join user.members mem join mem.team.projects pro where pro.team.idTeam!=?1  and user.validity=1 ",
				"from UserEntity where validity=1",
				UserEntity.class);
	//	query.setParameter(1, team.getIdTeam());

		List<UserEntity> membersFound = query.getResultList();

		List<User> members = new ArrayList<>();
		for (UserEntity memeber : membersFound) {
			members.add(USER_CONVERTER.fromEntityToPojo(memeber));
		}
		return members;
	}
	
	public void deleteMembersOfTeam(Team team) {
		
		Session session = sessionFactory.getCurrentSession();
		Query query=session.createQuery("delete from MemberEntity mem where mem.team.idTeam=?1");
		query.setParameter(1, team.getIdTeam());
		query.executeUpdate();

	
	}
	public boolean accessTeam(int idTeam) {
		Session session = sessionFactory.getCurrentSession();
		Query<TeamEntity> query = session.createQuery

		("select team from TeamEntity team where team.idTeam=?1 and validity=1 ",
				TeamEntity.class);
		query.setParameter(1, idTeam);
		
		try {
			 query.getSingleResult();
			 return true;
		} catch (NoResultException e) {
			return false;
		}


	}
}
