package com.ikubinfo.internship.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ikubinfo.internship.project.dao.TaskDao;
import com.ikubinfo.internship.project.pojo.Requirment;
import com.ikubinfo.internship.project.pojo.Task;

@Service
public class TaskService {

	@Autowired
	private TaskDao taskDao;
	
	
	public List<Task> requirmentTasks(int idReq){
		
		return taskDao.requirmentTasks(idReq);
	}

	
	public void addTask(Task task) {
		
		taskDao.addTask(task);
	}
	public void removeTask(Task task) {
		
		taskDao.removeTask(task);
		
	}
	public void editTask(Task task) {
		taskDao.editTask(task);
	}
	
	public List<Task> getTasksOfDeveloper(int idProject,int idUser){
		
	return taskDao.getTasksOfDeveloper(idProject, idUser);
	}
}
