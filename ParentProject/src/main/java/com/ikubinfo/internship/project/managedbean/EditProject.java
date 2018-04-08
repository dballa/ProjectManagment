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
public class EditProject {

	private static final String NOT_FOUND = "/PageNotFound.xhtml";
	private static final String PROJECT_MANAGER = "/ProjectManager/ProjectManager.xhtml";
	private Project toEdit;
	private List<Team> teams = new ArrayList<Team>();
	private List<Status> status = new ArrayList<Status>();
	private String id;
	int toEditId;

	@ManagedProperty(value = "#{projectService}")
	private ProjectService projectService;
	@ManagedProperty(value = "#{teamService}")
	private TeamService teamService;
	@ManagedProperty(value = "#{userSessionBean}")
	private UserSessionBean userSessionBean;

	@PostConstruct
	public void init() {

		teams = teamService.allTeams();

	}

	public void allowedProject() throws IOException {

		try {
			toEditId = Integer.parseInt(id);
			if (isAllowedToContinue(toEditId)) {
				toEdit = projectService.getProjectById(toEditId);
			} else {
				RedirectUtils.redirectTo(NOT_FOUND);
			}

		} catch (Exception ex) {
			RedirectUtils.redirectTo(NOT_FOUND);
		}

	}

	private boolean isAllowedToContinue(int id) {
		return projectService.accessProject(userSessionBean.getUserId(), id)
				&& !projectService.getProjectById(id).getStatus().getNameStatus().equals("Waiting BA");

	}

	

	public void editProject() throws IOException {
		if (toEdit.getEndDate().after(toEdit.getStartDate())) {
			toEdit.setValidity((byte) 1);
			projectService.editProject(toEdit);
			RedirectUtils.redirectTo(PROJECT_MANAGER);
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null, new FacesMessage("Success project" + toEdit.getNameProject() + "Edited"));
		} else {
			FacesContext context = FacesContext.getCurrentInstance();

			context.addMessage(null, new FacesMessage("!! End date should be after start date"));
		}
	}

	public void redirectToPM() throws IOException {
		RedirectUtils.redirectTo(PROJECT_MANAGER);

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

	public void setStatus(List<Status> status) {
		this.status = status;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public UserSessionBean getUserSessionBean() {
		return userSessionBean;
	}

	public void setUserSessionBean(UserSessionBean userSessionBean) {
		this.userSessionBean = userSessionBean;
	}

	public int getToEditId() {
		return toEditId;
	}

	public void setToEditId(int toEditId) {
		this.toEditId = toEditId;
	}

}
