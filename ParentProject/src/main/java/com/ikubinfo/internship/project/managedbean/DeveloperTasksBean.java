package com.ikubinfo.internship.project.managedbean;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import com.ikubinfo.internship.project.pojo.SearchTask;
import com.ikubinfo.internship.project.pojo.Status;
import com.ikubinfo.internship.project.pojo.Task;
import com.ikubinfo.internship.project.service.ProjectService;
import com.ikubinfo.internship.project.service.TaskService;
import com.ikubinfo.internship.project.utils.StatesEnum;
import com.ikubinfo.internship.project.utils.RedirectUtils;

@ManagedBean
@ViewScoped
public class DeveloperTasksBean {

	private List<Task> tasks;
	private int idProject;
	private int idUser;
	private Task selectedTask;
	private SearchTask filter;
	private String id;
	private static final String NOT_FOUND = "/PageNotFound.xhtml";

	@ManagedProperty(value = "#{taskService}")
	private TaskService taskService;
	@ManagedProperty(value = "#{userSessionBean}")
	private UserSessionBean userSessionBean;
	@ManagedProperty(value = "#{projectService}")
	private ProjectService projectService;
	

	@PostConstruct
	public void init() {
		
	}
	
	public void getTask() throws IOException {

		try {
			idProject = Integer.parseInt(id);
			if (isAllowedToContinue(idProject)) {

				filter=new SearchTask();
				
				tasks=taskService.searchTask(filter, userSessionBean.getUserId(), idProject);
			} else {
				RedirectUtils.redirectTo(NOT_FOUND);
			}

		} catch (Exception ex) {
			RedirectUtils.redirectTo(NOT_FOUND);
		}

	}

	
	
	
	private boolean isAllowedToContinue(int id) {
		return projectService.accessProject(userSessionBean.getUserId(), id)
				&& !projectService.getProjectById(id).getStatus().getNameStatus().equals(StatesEnum.BA_STATUS.getStr());
	}

	
	public void editTask() {
		taskService.editTask(selectedTask);
		FacesContext context = FacesContext.getCurrentInstance();

		context.addMessage(null, new FacesMessage("Success Task  "+selectedTask.getNameTask()+"  Edited"));
	}

	public void searchTask(){
	
	tasks=taskService.searchTask(filter, userSessionBean.getUserId(), idProject);
		
		
		
	}

	public int getIdProject() {
		return idProject;
	}

	public void setIdProject(int idProject) {
		this.idProject = idProject;
	}

	public List<Task> getTasks() {
		return tasks;
	}

	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}

	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public TaskService getTaskService() {
		return taskService;
	}

	public void setTaskService(TaskService taskService) {
		this.taskService = taskService;
	}

	public Task getSelectedTask() {
		return selectedTask;
	}

	public void setSelectedTask(Task selectedTask) {
		this.selectedTask = selectedTask;
	}

	public SearchTask getFilter() {
		return filter;
	}

	public void setFilter(SearchTask filter) {
		this.filter = filter;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public UserSessionBean getUserSessionBean() {
		return userSessionBean;
	}

	public ProjectService getProjectService() {
		return projectService;
	}

	public void setUserSessionBean(UserSessionBean userSessionBean) {
		this.userSessionBean = userSessionBean;
	}

	public void setProjectService(ProjectService projectService) {
		this.projectService = projectService;
	}



	


}
