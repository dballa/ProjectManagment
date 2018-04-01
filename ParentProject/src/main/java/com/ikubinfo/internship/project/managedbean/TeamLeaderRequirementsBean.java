package com.ikubinfo.internship.project.managedbean;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import com.ikubinfo.internship.project.pojo.Project;
import com.ikubinfo.internship.project.pojo.Requirment;
import com.ikubinfo.internship.project.service.ProjectService;
import com.ikubinfo.internship.project.service.RequirmentService;
/*
 * ishte tlReqBean
 */
@ManagedBean(name="tlReqBean")
@ViewScoped
public class TeamLeaderRequirementsBean {
	private List<Requirment> requirments = new ArrayList<Requirment>();
	private int idProject;
	private Project project;
	private int requirmentId;
	@ManagedProperty(value = "#{requirmentService}")
	private RequirmentService requirmentService;
	@ManagedProperty(value = "#{projectService}")
	private ProjectService projectService;
	
	@ManagedProperty(value="#{userSessionBean}")
	private UserSessionBean userSessionBean;

	@PostConstruct
	public void init() {

		String id = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("id");
		System.out.println(id);
		idProject = Integer.parseInt(id);

		System.out.println(idProject);
		requirments = requirmentService.getProjectRequirements(idProject);
		project = projectService.getProjectById(idProject);
	}

	public String redirectToTaskCreate() throws IOException {
		userSessionBean.setCurrentProject(project);
		System.out.println("requirmentId: " + requirmentId);
		return "/TeamLeader/TlCreateTasks.xhtml?faces-redirect=true&idreq=" + requirmentId;
	}

	public List<Requirment> getRequirments() {
		return requirments;
	}

	public void setRequirments(List<Requirment> requirments) {
		this.requirments = requirments;
	}

	public int getIdProject() {
		return idProject;
	}

	public void setIdProject(int idProject) {
		this.idProject = idProject;
	}

	public RequirmentService getRequirmentService() {
		return requirmentService;
	}

	public void setRequirmentService(RequirmentService requirmentService) {
		this.requirmentService = requirmentService;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public int getRequirmentId() {
		return requirmentId;
	}

	public void setRequirmentId(int requirmentId) {
		this.requirmentId = requirmentId;
	}

	public ProjectService getProjectService() {
		return projectService;
	}

	public void setProjectService(ProjectService projectService) {
		this.projectService = projectService;
	}

	public UserSessionBean getUserSessionBean() {
		return userSessionBean;
	}

	public void setUserSessionBean(UserSessionBean userSessionBean) {
		this.userSessionBean = userSessionBean;
	}

}
