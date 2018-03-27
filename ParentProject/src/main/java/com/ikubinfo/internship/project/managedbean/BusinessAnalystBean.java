package com.ikubinfo.internship.project.managedbean;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import com.ikubinfo.internship.project.pojo.Project;
import com.ikubinfo.internship.project.pojo.Requirment;
import com.ikubinfo.internship.project.pojo.Status;
import com.ikubinfo.internship.project.service.ProjectService;
import com.ikubinfo.internship.project.service.StatusService;

@ManagedBean
public class BusinessAnalystBean {

	private List<Project> projects = new ArrayList<Project>();
	private List<Status> status = new ArrayList<Status>();
	private List<Requirment> requirments = new ArrayList<Requirment>();
	private Requirment requirment;
	private Project project;
	private int projectId;
	private int userId;
	@ManagedProperty(value = "#{projectService}")
	private ProjectService projectService;
	@ManagedProperty(value = "#{statusService}")
	private StatusService statusService;

	@PostConstruct
	public void init() {
		FacesContext context = FacesContext.getCurrentInstance();
		userId = (int) context.getExternalContext().getSessionMap().get("userId");
		projects = projectService.baProjects(userId);

	}

	public void redirectToRequirement() throws IOException {

		FacesContext fContext = FacesContext.getCurrentInstance();
		ExternalContext extContext = fContext.getExternalContext();
		extContext.redirect(extContext.getRequestContextPath() + "/ProjectRequirements.xhtml?id=" + projectId);

	}

	public List<Project> getProjects() {
		return projects;
	}

	public List<Status> getStatus() {
		return status;
	}

	public Requirment getRequirment() {
		return requirment;
	}

	public Project getProject() {
		return project;
	}

	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}

	public void setStatus(List<Status> status) {
		this.status = status;
	}

	public void setRequirment(Requirment requirment) {
		this.requirment = requirment;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public ProjectService getProjectService() {
		return projectService;
	}

	public void setProjectService(ProjectService projectService) {
		this.projectService = projectService;
	}

	public StatusService getStatusService() {
		return statusService;
	}

	public void setStatusService(StatusService statusService) {
		this.statusService = statusService;
	}

	public List<Requirment> getRequirments() {
		return requirments;
	}

	public void setRequirments(List<Requirment> requirments) {
		this.requirments = requirments;
	}

	public int getProjectId() {
		return projectId;
	}

	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

}
