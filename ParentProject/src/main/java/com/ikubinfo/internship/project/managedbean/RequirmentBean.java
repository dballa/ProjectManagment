package com.ikubinfo.internship.project.managedbean;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import com.ikubinfo.internship.project.pojo.Priority;
import com.ikubinfo.internship.project.pojo.Project;
import com.ikubinfo.internship.project.pojo.Requirment;
import com.ikubinfo.internship.project.pojo.Status;
import com.ikubinfo.internship.project.pojo.Task;
import com.ikubinfo.internship.project.service.PriorityService;
import com.ikubinfo.internship.project.service.ProjectService;
import com.ikubinfo.internship.project.service.RequirmentService;
import com.ikubinfo.internship.project.service.StatusService;
import com.ikubinfo.internship.project.service.TaskService;

@ManagedBean
@ViewScoped
public class RequirmentBean {

	private List<Requirment> requirements = new ArrayList<Requirment>();
	private List<Status> status = new ArrayList<Status>();
	private List<Priority> priority = new ArrayList<Priority>();
	private int idProject;
	private Requirment requirment;
	private Project project = new Project();
	
	private Requirment showTasks;
	private List<Task> requirmentTasks=new ArrayList<Task>();

	@ManagedProperty(value = "#{requirmentService}")
	private RequirmentService requirmentService;
	@ManagedProperty(value = "#{statusService}")
	private StatusService statusService;
	@ManagedProperty(value = "#{priorityService}")
	private PriorityService priorityService;
	@ManagedProperty(value = "#{projectService}")
	private ProjectService projectService;
	@ManagedProperty(value = "#{taskService}")
	private TaskService taskService;

	@PostConstruct
	public void init() {
		String id = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("id");
		idProject = Integer.parseInt(id);
		requirements = requirmentService.getProjectRequirements(idProject);
		status = statusService.allStatus();
		priority = priorityService.allPriority();
		project = projectService.getProjectById(idProject);
		requirment = new Requirment();
		showTasks=new Requirment();
		
		
	}

	public void addRequirment() {
		requirment.setValidity((byte) 1);
		requirment.setProject(project);
		requirmentService.addRequirment(requirment);
		requirements = requirmentService.getProjectRequirements(idProject);
	}
	public void getListRequirmentTasks(){
		System.out.println(showTasks.getIdRequirment());
		requirmentTasks=new ArrayList<Task>();
		requirmentTasks= taskService.requirmentTasks(showTasks.getIdRequirment());	
		System.out.println(requirmentTasks);
		
	}

	public void changeProjectStatus() throws IOException {
		
		projectService.editProject(project);
		FacesContext context = FacesContext.getCurrentInstance();
		context.getExternalContext().redirect("BusinessAnalyst.xhtml");
	}
	
	public List<Requirment> getRequrements() {
		return requirements;
	}

	public void setRequrements(List<Requirment> requrements) {
		this.requirements = requrements;
	}

	public List<Status> getStatus() {
		return status;
	}

	public void setStatus(List<Status> status) {
		this.status = status;
	}

	public List<Priority> getPriority() {
		return priority;
	}

	public void setPriority(List<Priority> priority) {
		this.priority = priority;
	}

	public RequirmentService getRequirmentService() {
		return requirmentService;
	}

	public void setRequirmentService(RequirmentService requirmentService) {
		this.requirmentService = requirmentService;
	}

	public List<Requirment> getRequirements() {
		return requirements;
	}

	public void setRequirements(List<Requirment> requirements) {
		this.requirements = requirements;
	}

	public int getIdProject() {
		return idProject;
	}

	public void setIdProject(int idProject) {
		this.idProject = idProject;
	}

	public Requirment getRequirment() {
		return requirment;
	}

	public void setRequirment(Requirment requirment) {
		this.requirment = requirment;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
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

	public ProjectService getProjectService() {
		return projectService;
	}

	public void setProjectService(ProjectService projectService) {
		this.projectService = projectService;
	}




	public TaskService getTaskService() {
		return taskService;
	}

	public void setTaskService(TaskService taskService) {
		this.taskService = taskService;
	}

	public Requirment getShowTasks() {
		return showTasks;
	}

	public void setShowTasks(Requirment showTasks) {
		this.showTasks = showTasks;
	}

	
	public List<Task> getRequirmentTasks() {
		return requirmentTasks;
	}

	public void setRequirmentTasks(List<Task> requirmentTasks) {
		this.requirmentTasks = requirmentTasks;
	}
}
