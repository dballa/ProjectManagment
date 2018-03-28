package com.ikubinfo.internship.project.managedbean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

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
	private List<Status> statusList = new ArrayList<Status>();
	private List<Status> filtredStatus = new ArrayList<Status>();
	@ManagedProperty(value = "#{taskService}")
	private TaskService taskService;
	@ManagedProperty(value = "#{commonDataBean}")
	private CommonDataBean commonDataBean;

	@PostConstruct
	public void init() {
		FacesContext context = FacesContext.getCurrentInstance();
		idUser = (int) context.getExternalContext().getSessionMap().get("userId");
		String id = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("id");
		idProject = Integer.parseInt(id);
		tasks = taskService.getTasksOfDeveloper(idProject, idUser);
		filtredStatus();

	}
	
	public void editTask() {
		taskService.editTask(selectedTask);
		
	}

	public List<Status> filtredStatus() {
		statusList = commonDataBean.getStatusList();

		for (Status status : statusList) {

			if (!"Waiting BA".equals(status.getNameStatus())) {

				filtredStatus.add(status);
			}
		}
		return filtredStatus;
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

	public List<Status> getStatusList() {
		return statusList;
	}

	public List<Status> getFiltredStatus() {
		return filtredStatus;
	}

	public CommonDataBean getCommonDataBean() {
		return commonDataBean;
	}

	public void setStatusList(List<Status> statusList) {
		this.statusList = statusList;
	}

	public void setFiltredStatus(List<Status> filtredStatus) {
		this.filtredStatus = filtredStatus;
	}

	public void setCommonDataBean(CommonDataBean commonDataBean) {
		this.commonDataBean = commonDataBean;
	}
}
