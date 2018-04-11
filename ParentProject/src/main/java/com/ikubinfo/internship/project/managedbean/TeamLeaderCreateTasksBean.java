package com.ikubinfo.internship.project.managedbean;

import java.io.IOException;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import com.ikubinfo.internship.project.pojo.Project;
import com.ikubinfo.internship.project.pojo.Requirment;
import com.ikubinfo.internship.project.pojo.SearchTask;
import com.ikubinfo.internship.project.pojo.Task;
import com.ikubinfo.internship.project.pojo.Team;
import com.ikubinfo.internship.project.pojo.User;
import com.ikubinfo.internship.project.service.PriorityService;
import com.ikubinfo.internship.project.service.RequirmentService;
import com.ikubinfo.internship.project.service.StatusService;
import com.ikubinfo.internship.project.service.TaskService;
import com.ikubinfo.internship.project.service.UserService;
import com.ikubinfo.internship.project.utils.RedirectUtils;

@ManagedBean
@ViewScoped
public class TeamLeaderCreateTasksBean {
	private static final String NOT_FOUND = "/PageNotFound.xhtml";
	private int idRequirment;
	private List<Task> tasks;
	private Task task;
	private List<Requirment> requirments;
	private List<User> developers;
	private Project project;
	private Team team;
	private int userId;
	private Task toDelete;
	private Task toEdit = new Task();
	private Requirment currentRequirement;
	private String idFromURL;

	@ManagedProperty(value = "#{requirmentService}")
	private RequirmentService requirmentService;
	@ManagedProperty(value = "#{taskService}")
	private TaskService taskService;

	@ManagedProperty(value = "#{userService}")
	private UserService userService;
	@ManagedProperty(value = "#{userSessionBean}")
	private UserSessionBean userSessionBean;

	@PostConstruct
	public void init() {
		// String id =
		// FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("idreq");
		// idRequirment = Integer.parseInt(id);

		// tasks = taskService.requirmentTasks(idRequirment);
		task = new Task();
		project = userSessionBean.getCurrentProject();
		team = project.getTeam();
		developers = userService.getDevelopers(team);
		requirments = requirmentService.getProjectRequirements(project.getIdProject());
		
		toDelete = new Task();

	}

	public void getRequirements() throws IOException {

		try {
			idRequirment = Integer.parseInt(idFromURL);
			if (isAllowedToContinue()) {
				tasks = taskService.requirmentTasks(idRequirment);
				currentRequirement = requirmentService.getRequirmentById(idRequirment);

			} else {
				RedirectUtils.redirectTo(NOT_FOUND);
			}

		} catch (Exception ex) {
			RedirectUtils.redirectTo(NOT_FOUND);
		}

	}

	private boolean isAllowedToContinue() {
		return requirmentService.accessRequirement( project.getIdProject(),userSessionBean.getUserId() );

	}

	public void addTask() {
		if (task.getEndDate().after(task.getStartDate())) {
			task.setRequirment(currentRequirement);
			task.setValidity((byte) 1);
			task.setCreatedBy(userSessionBean.getUserId());

			taskService.addTask(task);
			tasks = taskService.requirmentTasks(idRequirment);
			FacesContext context = FacesContext.getCurrentInstance();

			context.addMessage(null, new FacesMessage("","Success" + "Task " + task.getNameTask() + " Added"));
		} else {
			FacesContext context = FacesContext.getCurrentInstance();

			context.addMessage(null, new FacesMessage("","!! End date should be after start date"));
		}

	}

	public void editTask() {
		if (toEdit.getEndDate().after(toEdit.getStartDate())) {
			toEdit.setRequirment(currentRequirement);
			toEdit.setValidity((byte) 1);
			toEdit.setCreatedBy(userId);

			taskService.editTask(toEdit);
			tasks = taskService.requirmentTasks(idRequirment);
			FacesContext context = FacesContext.getCurrentInstance();

			context.addMessage(null, new FacesMessage("","Success" + "Task " + toEdit.getNameTask() + " Edited"));
		} else {
			FacesContext context = FacesContext.getCurrentInstance();

			context.addMessage(null, new FacesMessage("","!! End date should be after start date"));
		}

	}

	public void removeTask() {
		if (toDelete.getStatus().getNameStatus().equals("Done")) {

			toDelete.setValidity((byte) 0);

			taskService.removeTask(toDelete);
			tasks = taskService.requirmentTasks(idRequirment);
			FacesContext context = FacesContext.getCurrentInstance();

			context.addMessage(null, new FacesMessage("Success", "Task " + toDelete.getNameTask() + " Deleted"));
		} else {
			FacesContext context = FacesContext.getCurrentInstance();

			context.addMessage(null, new FacesMessage("","Set status as DONE to delete task"));
		}
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

	public List<Task> getTasks() {
		return tasks;
	}

	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}

	public TaskService getTaskService() {
		return taskService;
	}

	public void setTaskService(TaskService taskService) {
		this.taskService = taskService;
	}

	public Task getTask() {
		return task;
	}

	public void setTask(Task task) {
		this.task = task;
	}

	public List<User> getDevelopers() {
		return developers;
	}

	public void setDevelopers(List<User> developers) {
		this.developers = developers;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public UserSessionBean getUserSessionBean() {
		return userSessionBean;
	}

	public void setUserSessionBean(UserSessionBean userSessionBean) {
		this.userSessionBean = userSessionBean;
	}

	public List<Requirment> getRequirments() {
		return requirments;
	}

	public void setRequirments(List<Requirment> requirments) {
		this.requirments = requirments;
	}

	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public Task getToDelete() {
		return toDelete;
	}

	public void setToDelete(Task toDelete) {
		this.toDelete = toDelete;
	}

	public Task getToEdit() {
		return toEdit;
	}

	public void setToEdit(Task toEdit) {
		this.toEdit = toEdit;
	}

	public Requirment getCurrentRequirement() {
		return currentRequirement;
	}

	public void setCurrentRequirement(Requirment currentRequirement) {
		this.currentRequirement = currentRequirement;
	}

	public String getIdFromURL() {
		return idFromURL;
	}

	public void setIdFromURL(String idFromURL) {
		this.idFromURL = idFromURL;
	}



}
