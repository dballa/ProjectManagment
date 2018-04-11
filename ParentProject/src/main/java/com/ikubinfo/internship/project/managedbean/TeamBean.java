package com.ikubinfo.internship.project.managedbean;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import com.ikubinfo.internship.project.pojo.Team;
import com.ikubinfo.internship.project.pojo.User;
import com.ikubinfo.internship.project.service.TeamService;
import com.ikubinfo.internship.project.utils.RedirectUtils;

@ManagedBean
@ViewScoped
public class TeamBean {
	private Team team;
	private List<Team> teams = new ArrayList<Team>();
	private Team toDelete;
	private Team teamInfo;
	private List<User> teamMembers = new ArrayList<User>();
	private int toEditId;
	private static String TEAM = "/ProjectManager/EditTeam.xhtml?id=";
	@ManagedProperty(value = "#{projectManager}")
	private ProjectManagerBean projectManagerBean;
	@ManagedProperty(value = "#{teamService}")
	private TeamService teamService;

	@PostConstruct
	public void init() {

		team = new Team();
		teams = teamService.allTeams();
		teamInfo = new Team();
	}

	public void addTeam() {

		team.setValidity((byte) 1);
		teamService.addTeam(team);
		teams = teamService.allTeams();
		FacesContext context = FacesContext.getCurrentInstance();

		context.addMessage(null, new FacesMessage("Success", "Team" + team.getNameTeam() + " Added"));

	}

	public void removeTeam() {
		System.out.println(toDelete);
		System.out.println(teamService.isTeamWithoutProject(toDelete) + "ne bean");
		if (teamService.isTeamWithoutProject(toDelete)) {

			teamService.removeTeam(toDelete);

			teams = teamService.allTeams();
			FacesContext context = FacesContext.getCurrentInstance();

			context.addMessage(null, new FacesMessage("Success Team" + toDelete.getNameTeam() + " Deleted"));
		} else {
			FacesContext context = FacesContext.getCurrentInstance();

			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning",
					"Team is working on a project on a Project"));
		}
	}

	public void findTeamInfo() {
		teamMembers = new ArrayList<User>();
		teamMembers = teamService.teamInfo(teamInfo);
		System.out.println(teamInfo.getIdTeam());
		System.out.println(teamMembers);

	}

	public void redirectToEdit() throws IOException {
		RedirectUtils.redirectTo(TEAM + toEditId);

	}

	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}

	public ProjectManagerBean getProjectManagerBean() {
		return projectManagerBean;
	}

	public void setProjectManagerBean(ProjectManagerBean projectManagerBean) {
		this.projectManagerBean = projectManagerBean;
	}

	public TeamService getTeamService() {
		return teamService;
	}

	public void setTeamService(TeamService teamService) {
		this.teamService = teamService;
	}

	public List<Team> getTeams() {
		return teams;
	}

	public void setTeams(List<Team> teams) {
		this.teams = teams;
	}

	public Team getToDelete() {
		return toDelete;
	}

	public void setToDelete(Team toDelete) {
		this.toDelete = toDelete;
	}

	public Team getTeamInfo() {
		return teamInfo;
	}

	public void setTeamInfo(Team teamInfo) {
		this.teamInfo = teamInfo;
	}

	public List<User> getTeamMembers() {
		return teamMembers;
	}

	public void setTeamMembers(List<User> teamMembers) {
		this.teamMembers = teamMembers;
	}

	public int getToEditId() {
		return toEditId;
	}

	public void setToEditId(int toEditId) {
		this.toEditId = toEditId;
	}

}
