package com.ikubinfo.internship.project.managedbean;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import com.ikubinfo.internship.project.pojo.Project;
import com.ikubinfo.internship.project.pojo.Requirment;

import com.ikubinfo.internship.project.service.RequirmentService;
import com.mysql.fabric.xmlrpc.base.Array;

@ManagedBean
@ViewScoped
public class TlReqBean {
	private List<Requirment> requirments=new ArrayList<Requirment>();
	private int idProject;
	private Project project;
	private int requirmentId;
	@ManagedProperty(value = "#{requirmentService}")
	private RequirmentService requirmentService;

	@PostConstruct
	public void init() {
		String id = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("id");
		idProject = Integer.parseInt(id);

		requirments = requirmentService.requirmentOfProject(idProject);

	}

	public void redirectToTaskCreate() throws IOException {

		FacesContext fContext = FacesContext.getCurrentInstance();
		ExternalContext extContext = fContext.getExternalContext();
		extContext.redirect(extContext.getRequestContextPath() + "/TlCreateTasks.xhtml?idreq=" + requirmentId);
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

}
