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
public class EditProject {

	private Project toEdit;
	private List<Team> teams = new ArrayList<Team>();
	private List<Status> status = new ArrayList<Status>();

	@ManagedProperty(value = "#{projectService}")
	private ProjectService projectService;
	@ManagedProperty(value = "#{teamService}")
	private TeamService teamService;
	@ManagedProperty(value = "#{statusService}")
	private StatusService statusService;

	@PostConstruct
	public void init() {
		String id = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("id");
		int toEditId = Integer.parseInt(id);
		toEdit = projectService.getProjectById(toEditId);
		teams = teamService.allTeams();
		status = statusService.allStatus();
		
	}

	public void editProject() throws IOException {
		if(toEdit.getEndDate().after(toEdit.getStartDate()) ) {
		toEdit.setValidity((byte) 1);
		projectService.editProject(toEdit);
		FacesContext fContext = FacesContext.getCurrentInstance();
		ExternalContext extContext = fContext.getExternalContext();
		extContext.redirect(extContext.getRequestContextPath() + "/ProjectManager/ProjectManager.xhtml");
		}
		else {
			FacesContext context = FacesContext.getCurrentInstance();

			context.addMessage(null, new FacesMessage("!! End date should be after start date"));
		}
	}
	
	public void redirectToPM() throws IOException {
		FacesContext fContext = FacesContext.getCurrentInstance();
		ExternalContext extContext = fContext.getExternalContext();
		extContext.redirect(extContext.getRequestContextPath() + "/ProjectManager/ProjectManager.xhtml");
		
	}

	public Project getToEdit() {
		return toEdit;
	}

	public void setToEdit(Project toEdit) {
		this.toEdit = toEdit;
	}

	public ProjectService getProjectService() {
		return projectService;
	}

	public void setProjectService(ProjectService projectService) {
		this.projectService = projectService;
	}

	public List<Team> getTeams() {
		return teams;
	}

	public TeamService getTeamService() {
		return teamService;
	}

	public void setTeams(List<Team> teams) {
		this.teams = teams;
	}

	public void setTeamService(TeamService teamService) {
		this.teamService = teamService;
	}

	public List<Status> getStatus() {
		return status;
	}

	public StatusService getStatusService() {
		return statusService;
	}

	public void setStatus(List<Status> status) {
		this.status = status;
	}

	public void setStatusService(StatusService statusService) {
		this.statusService = statusService;
	}

}
