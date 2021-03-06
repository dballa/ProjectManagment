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
import com.ikubinfo.internship.project.utils.StatesEnum;
import com.ikubinfo.internship.project.utils.RedirectUtils;

@ManagedBean
@ViewScoped
public class RequirmentBean {

	private List<Requirment> requirements = new ArrayList<Requirment>();
	private List<Status> status = new ArrayList<Status>();
	private List<Priority> priority = new ArrayList<Priority>();
	private int idProject;
	private Requirment requirment;
	private Project project = new Project();
	private static final String BUSINESS_ANALYST = "/BusinessAnalyst/BusinessAnalyst.xhtml";
	private static final String NOT_FOUND = "/PageNotFound.xhtml";
	private Requirment showTasks;
	private List<Task> requirmentTasks = new ArrayList<Task>();
	private Requirment toDelete;
	private Requirment toEdit = new Requirment();
	private String id;

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
	@ManagedProperty(value = "#{userSessionBean}")
	private UserSessionBean userSessionBean;

	@PostConstruct
	public void init() {

		status = statusService.allStatus();
		priority = priorityService.allPriority();

		requirment = new Requirment();
		showTasks = new Requirment();

		toDelete = new Requirment();

	}

	public void getProjects() throws IOException {

		try {
			idProject = Integer.parseInt(id);
			if (isAllowedToContinue(idProject)) {

				requirements = requirmentService.getProjectRequirements(idProject);
				project = projectService.getProjectById(idProject);
			} else {
				RedirectUtils.redirectTo(NOT_FOUND);
			}

		} catch (Exception ex) {
			RedirectUtils.redirectTo(NOT_FOUND);
		}

	}

	private boolean isAllowedToContinue(int id) {
		return projectService.accessProject(userSessionBean.getUserId(), id)
				&& projectService.getProjectById(id).getStatus().getNameStatus().equals(StatesEnum.BA_STATUS.getStr());

	}

	public void addRequirment() {
		requirment.setValidity((byte) 1);
		requirment.setProject(project);
		requirmentService.addRequirment(requirment);
		requirements = requirmentService.getProjectRequirements(idProject);
		FacesContext context = FacesContext.getCurrentInstance();

		context.addMessage(null, new FacesMessage("Success Requirement" + requirment.getNameRequirment() + "Added"));
	}

	public void getListRequirmentTasks() {
		System.out.println(showTasks.getIdRequirment());
		requirmentTasks = new ArrayList<Task>();
		requirmentTasks = taskService.requirmentTasks(showTasks.getIdRequirment());
		System.out.println(requirmentTasks);

	}

	public void changeProjectStatus() throws IOException {

		projectService.editProject(project);
		RedirectUtils.redirectTo(BUSINESS_ANALYST);

	}

	public void removeRequirment() {
		System.out.println(toDelete);
		if (toDelete.getStatus().getNameStatus().equals("Done")) {

			toDelete.setValidity((byte) 0);
			requirmentService.removeRequirment(toDelete);
			requirements = requirmentService.getProjectRequirements(idProject);

			FacesContext context = FacesContext.getCurrentInstance();

			context.addMessage(null,
					new FacesMessage("","Success Requirement " + toDelete.getNameRequirment() + "  Deleted"));
		} else {

			FacesContext context = FacesContext.getCurrentInstance();

			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,"Warning","!! Set Status as Done to delete Requirement"));
		}
	}

	public void editRequirment() {

		toEdit.setValidity((byte) 1);
		toEdit.setProject(project);
		requirmentService.editRequirment(toEdit);
		requirements = requirmentService.getProjectRequirements(idProject);
		FacesContext context = FacesContext.getCurrentInstance();

		context.addMessage(null, new FacesMessage("","Success Requirment" + toEdit.getNameRequirment() + "Edited"));
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

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public Requirment getToDelete() {
		return toDelete;
	}

	public void setToDelete(Requirment toDelete) {
		this.toDelete = toDelete;
	}

	public Requirment getToEdit() {
		return toEdit;
	}

	public void setToEdit(Requirment toEdit) {
		this.toEdit = toEdit;
	}

	public UserSessionBean getUserSessionBean() {
		return userSessionBean;
	}

	public void setUserSessionBean(UserSessionBean userSessionBean) {
		this.userSessionBean = userSessionBean;
	}

}
