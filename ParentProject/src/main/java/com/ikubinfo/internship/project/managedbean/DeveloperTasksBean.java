package com.ikubinfo.internship.project.managedbean;

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
import com.ikubinfo.internship.project.service.TaskService;

@ManagedBean
@ViewScoped
public class DeveloperTasksBean {

	private List<Task> tasks;
	private int idProject;
	private int idUser;
	private Task selectedTask;
	private SearchTask filter;

	@ManagedProperty(value = "#{taskService}")
	private TaskService taskService;
	

	@PostConstruct
	public void init() {
		FacesContext context = FacesContext.getCurrentInstance();
		idUser = (int) context.getExternalContext().getSessionMap().get("userId");
		String id = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("id");
		idProject = Integer.parseInt(id);
		filter=new SearchTask();
	
		tasks=taskService.searchTask(filter, idUser, idProject);
	}
	
	public void editTask() {
		taskService.editTask(selectedTask);
		FacesContext context = FacesContext.getCurrentInstance();

		context.addMessage(null, new FacesMessage("Success Task"+selectedTask.getNameTask()+"  Edited"));
	}

	public void searchTask(){
	
	tasks=taskService.searchTask(filter, idUser, idProject);
		
		
		
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



	


}
