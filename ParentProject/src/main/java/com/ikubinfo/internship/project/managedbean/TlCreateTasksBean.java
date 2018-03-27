package com.ikubinfo.internship.project.managedbean;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import com.ikubinfo.internship.project.service.RequirmentService;

@ManagedBean
@ViewScoped
public class TlCreateTasksBean {
private int idRequirment;

@ManagedProperty(value="#{requirmentService}")
private RequirmentService requirmentService;
@PostConstruct
public void init() {
	String id = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("idreq");
	idRequirment = Integer.parseInt(id);
	System.out.println(idRequirment);
	
}
public int getIdRequirment() {
	return idRequirment;
}
public void setIdRequirment(int idRequirment) {
	this.idRequirment = idRequirment;
}
public RequirmentService getRequirmentService() {
	return requirmentService;
}
public void setRequirmentService(RequirmentService requirmentService) {
	this.requirmentService = requirmentService;
}



}
