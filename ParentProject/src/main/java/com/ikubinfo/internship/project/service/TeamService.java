package com.ikubinfo.internship.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ikubinfo.internship.project.dao.TeamDao;
import com.ikubinfo.internship.project.dao.TeamInProjectException;
import com.ikubinfo.internship.project.pojo.Team;
import com.ikubinfo.internship.project.pojo.User;

@Service
public class TeamService {

	@Autowired
	private TeamDao teamDao;

	public List<Team> allTeams() {
		return teamDao.allTeams();

	}

	public void addTeam(Team team) {

		teamDao.addTeam(team);

	}

	public void removeTeam(Team team) throws TeamInProjectException {

		if (teamDao.tryEx(team) == true) {

			team.setValidity((byte) 0);
			teamDao.removeTeam(team);

		}

	}

	public List<User> teamInfo(Team team) {

		return teamDao.teamInfo(team);
	}

	public Team getTeamById(int id) {

		return teamDao.getTeamById(id);
	}
}
