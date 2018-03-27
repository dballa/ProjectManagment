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

@ManagedBean
@ViewScoped
public class ProjectManagerBean {

	private List<Project> projects = new ArrayList<Project>();

	private Project project;
	private Project toDelete;
	private int toEditId;
	private List<Team> teams = new ArrayList<Team>();
	private List<Status> status = new ArrayList<Status>();
	private Team team;
	private int createdBy;
	@ManagedProperty(value = "#{projectService}")
	private ProjectService projectService;
	@ManagedProperty(value = "#{teamService}")
	private TeamService teamService;
	@ManagedProperty(value = "#{statusService}")
	private StatusService statusService;

	@PostConstruct
	public void init() {

		
		project = new Project();
		teams = teamService.allTeams();
		status = statusService.allStatus();
		toDelete = new Project();
		FacesContext context = FacesContext.getCurrentInstance();
		createdBy =   (int) context.getExternalContext().getSessionMap().get("userId");
		projects = projectService.allProjects(createdBy);
	}

	public void allProjects() {

		projects = projectService.allProjects(createdBy);

	}

	public void redirectToProject() throws IOException {

		FacesContext fContext = FacesContext.getCurrentInstance();
		ExternalContext extContext = fContext.getExternalContext();
		extContext.redirect(extContext.getRequestContextPath() + "/Project.xhtml?id=" + toEditId);

	}

	public void addProject() {

		project.setCreatedBy(createdBy);
		project.setValidity((byte) 1);
		projectService.addProject(project);
		projects = projectService.allProjects(createdBy);

		FacesContext context = FacesContext.getCurrentInstance();

		context.addMessage(null, new FacesMessage("Success", "Project " + project.getNameProject() + " Added"));

	}

	public void removeProject() {
		toDelete.setValidity((byte) 0);

		projectService.removeProject(toDelete);
		projects = projectService.allProjects(createdBy);
		FacesContext context = FacesContext.getCurrentInstance();

		context.addMessage(null, new FacesMessage("Success", "Project " + toDelete.getNameProject() + " Deleted"));
	}

	public void test() {
		FacesContext context = FacesContext.getCurrentInstance();
		System.out.println(context.getExternalContext().getSessionMap().get("userPermissions"));
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

	public List<Status> getStatus() {
		return status;
	}

	public void setStatus(List<Status> status) {
		this.status = status;
	}

	public StatusService getStatusService() {
		return statusService;
	}

	public void setStatusService(StatusService statusService) {
		this.statusService = statusService;
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

}
