package com.ikubinfo.internship.project.managedbean;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import com.ikubinfo.internship.project.pojo.Project;
import com.ikubinfo.internship.project.pojo.Status;
import com.ikubinfo.internship.project.pojo.Team;
import com.ikubinfo.internship.project.service.ProjectService;
import com.ikubinfo.internship.project.service.StatusService;
import com.ikubinfo.internship.project.service.TeamService;
import com.ikubinfo.internship.project.utils.RedirectUtils;

@ManagedBean
@ViewScoped
public class ProjectManagerBean {

	private List<Project> projects = new ArrayList<Project>();

	private Project project;
	private Project toDelete;
	private int toEditId;
	private List<Team> teams = new ArrayList<Team>();

	private Team team;
	private int createdBy;
	@ManagedProperty(value = "#{projectService}")
	private ProjectService projectService;
	@ManagedProperty(value = "#{teamService}")
	private TeamService teamService;
	@ManagedProperty(value="#{userSessionBean}")
	private UserSessionBean userSessionBean;
	@PostConstruct
	public void init() {

		project = new Project();
		teams = teamService.allTeams();

		toDelete = new Project();
		FacesContext context = FacesContext.getCurrentInstance();
		createdBy = (int) context.getExternalContext().getSessionMap().get("userId");
		projects = projectService.allProjects(createdBy);
	}

	public void allProjects() {

		projects = projectService.allProjects(createdBy);

	}

	public void redirectToProject() throws IOException {

		RedirectUtils.redirectTo("/ProjectManager/Project.xhtml?id=" + toEditId);
		

	}

	public void addProject() {
		if (project.getEndDate().after(project.getStartDate())) {
			project.setCreatedBy(userSessionBean.getUser());
			project.setValidity((byte) 1);
			projectService.addProject(project);
			projects = projectService.allProjects(createdBy);

			FacesContext context = FacesContext.getCurrentInstance();

			context.addMessage(null, new FacesMessage("Success  Project " + project.getNameProject() + " Added"));
		} else {
			FacesContext context = FacesContext.getCurrentInstance();

			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,"Warning","!! End date should be after start date"));
		}
	}

	public void removeProject() {
		if (toDelete.getStatus().getNameStatus().equals("Done")) {
			toDelete.setValidity((byte) 0);

			projectService.removeProject(toDelete);
			projects = projectService.allProjects(createdBy);
			FacesContext context = FacesContext.getCurrentInstance();

			context.addMessage(null, new FacesMessage("Success Project " + toDelete.getNameProject() + " Deleted"));
		} else {
			FacesContext context = FacesContext.getCurrentInstance();

			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,"Warning","Set status as Done to delete a project"));

		}
	}

	

	

	public ProjectService getProjectService() {
		return projectService;
	}

	public void setProjectService(ProjectService projectService) {
		this.projectService = projectService;
	}

	public List<Project> getProjects() {
		return projects;
	}

	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
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

	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}

	public Project getToDelete() {
		return toDelete;
	}

	public void setToDelete(Project toDelete) {
		this.toDelete = toDelete;
	}

	public int getToEditId() {
		return toEditId;
	}

	public void setToEditId(int toEditId) {
		this.toEditId = toEditId;
	}

	public int getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(int createdBy) {
		this.createdBy = createdBy;
	}

	public UserSessionBean getUserSessionBean() {
		return userSessionBean;
	}

	public void setUserSessionBean(UserSessionBean userSessionBean) {
		this.userSessionBean = userSessionBean;
	}

}
