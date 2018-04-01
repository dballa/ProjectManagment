package com.ikubinfo.internship.project.managedbean;

import java.io.IOException;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import com.ikubinfo.internship.project.pojo.Project;
import com.ikubinfo.internship.project.service.ProjectService;

@ManagedBean
@ViewScoped
public class TeamLeaderBean {
	private List<Project> tlProjects;
	private int userId;
	private int projectId;
	@ManagedProperty(value = "#{projectService}")
	private ProjectService projectService;

	@PostConstruct
	public void init() {
		FacesContext context = FacesContext.getCurrentInstance();
		userId = (int) context.getExternalContext().getSessionMap().get("userId");
		tlProjects = projectService.tlProjects(userId);
	}

	
	
	
	public String redirectToTasks() throws IOException {

		
		return "/TeamLeader/TlRequirments.xhtml?faces-redirect=true&id=" + projectId;
		
	}

	public List<Project> getTlProjects() {
		return tlProjects;
	}

	public void setTlProjects(List<Project> tlProjects) {
		this.tlProjects = tlProjects;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public ProjectService getProjectService() {
		return projectService;
	}

	public void setProjectService(ProjectService projectService) {
		this.projectService = projectService;
	}

	public int getProjectId() {
		return projectId;
	}

	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}
}
