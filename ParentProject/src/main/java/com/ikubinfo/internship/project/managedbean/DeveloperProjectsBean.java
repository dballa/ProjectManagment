package com.ikubinfo.internship.project.managedbean;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import com.ikubinfo.internship.project.pojo.Project;
import com.ikubinfo.internship.project.pojo.Task;
import com.ikubinfo.internship.project.service.ProjectService;

@ManagedBean
@ViewScoped
public class DeveloperProjectsBean {

	private List<Project> projects = new ArrayList<Project>();
	private List<Project> filtredProjects = new ArrayList<Project>();
	private int userId;
	private int projectId;
	
	@ManagedProperty(value = "#{projectService}")
	private ProjectService projectService;

	@PostConstruct
	public void init() {
		FacesContext context = FacesContext.getCurrentInstance();
		userId = (int) context.getExternalContext().getSessionMap().get("userId");
		filtredProjects= projectService.tlProjects(userId);

	}

public String redirectToTasks() throws IOException {

		
		return "/Developer/DeveloperTasks.xhtml?faces-redirect=true&id=" + projectId;
	
}
	

	public List<Project> getProjects() {
		return projects;
	}

	public void setProjects(List<Project> projects) {
		this.projects = projects;
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

	public List<Project> getFiltredProjects() {
		return filtredProjects;
	}

	public void setFiltredProjects(List<Project> filtredProjects) {
		this.filtredProjects = filtredProjects;
	}

	public int getProjectId() {
		return projectId;
	}

	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}

}
