package com.ikubinfo.internship.project.managedbean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import com.ikubinfo.internship.project.pojo.Priority;
import com.ikubinfo.internship.project.pojo.Status;
import com.ikubinfo.internship.project.service.PriorityService;
import com.ikubinfo.internship.project.service.StatusService;

@ManagedBean
@ApplicationScoped
public class CommonDataBean {
	
	private List<Status> statusList;
	private List<Priority> priorityList;
	
	@ManagedProperty(value="#{statusService}")
	private StatusService statusService;
	@ManagedProperty(value="#{priorityService}")
	private PriorityService priorityService;
	@PostConstruct
	public void init() {
		statusList=statusService.allStatus();
		priorityList=priorityService.allPriority();
	}
	public List<Status> getStatusList() {
		return statusList;
	}
	public void setStatusList(List<Status> statusList) {
		this.statusList = statusList;
	}
	public List<Priority> getPriorityList() {
		return priorityList;
	}
	public void setPriorityList(List<Priority> priorityList) {
		this.priorityList = priorityList;
	}
	public StatusService getStatusService() {
		return statusService;
	}
	public void setStatusService(StatusService statusService) {
		this.statusService = statusService;
	}
	public PriorityService getPriorityService() {
		return priorityService;
	}
	public void setPriorityService(PriorityService priorityService) {
		this.priorityService = priorityService;
	}
}
