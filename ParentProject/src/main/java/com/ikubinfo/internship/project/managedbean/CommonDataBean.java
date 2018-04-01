package com.ikubinfo.internship.project.managedbean;

import java.util.ArrayList;
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
	
	private List<Status> statusList = new ArrayList<Status>();
	private List<Priority> priorityList= new  ArrayList<Priority>(); 
	private List<Status> filtredStatus=new ArrayList<Status>();
	@ManagedProperty(value="#{statusService}")
	private StatusService statusService;
	@ManagedProperty(value="#{priorityService}")
	private PriorityService priorityService;
	@PostConstruct
	public void init() {
		statusList=statusService.allStatus();
		priorityList=priorityService.allPriority();
		filtredStatus();
	}
	
	public List<Status> filtredStatus() {
		List<Status>	statusList = statusService.allStatus();

			for (Status status : statusList) {

				if (!"Waiting BA".equals(status.getNameStatus())) {

					filtredStatus.add(status);
				}
			}
			return filtredStatus;
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

	public List<Status> getFiltredStatus() {
		return filtredStatus;
	}

	public void setFiltredStatus(List<Status> filtredStatus) {
		this.filtredStatus = filtredStatus;
	}
}
