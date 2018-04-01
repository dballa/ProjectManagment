package com.ikubinfo.internship.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ikubinfo.internship.project.dao.MemberDao;
import com.ikubinfo.internship.project.dao.TeamDao;

import com.ikubinfo.internship.project.pojo.Member;
import com.ikubinfo.internship.project.pojo.MemberPK;
import com.ikubinfo.internship.project.pojo.Team;
import com.ikubinfo.internship.project.pojo.User;

@Service
public class TeamService {

	@Autowired
	private TeamDao teamDao;
	@Autowired
	private MemberDao memberDao;
	public List<Team> allTeams() {
		return teamDao.allTeams();

	}

	public void addTeam(Team team) {

		teamDao.addTeam(team);

	}

	public void removeTeam(Team team)  {

	

			team.setValidity((byte) 0);
			teamDao.removeTeam(team);

		
		

	}
	

public void editTeam(User user,Team team,Member member,MemberPK memberPk) {
	memberPk.setIdTeam(team.getIdTeam());
	memberPk.setMember(user.getIdUser());
	member.setTeam(team);
		member.setUser(user);
		member.setId(memberPk);
		
		team.getMembers().add(member);
	
	
		teamDao.editTeam(team);
	}

	public List<User> teamInfo(Team team) {

		return teamDao.teamInfo(team);
	}

	public Team getTeamById(int id) {

		return teamDao.getTeamById(id);
	}
}
