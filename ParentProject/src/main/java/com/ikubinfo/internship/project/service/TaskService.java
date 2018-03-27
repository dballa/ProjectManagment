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
	
	
	public List<Task> requirmentTasks(Requirment requirment){
		
		return taskDao.requirmentTasks(requirment);
	}

	
	public void addTask(Task task) {
		
		taskDao.addTask(task);
	}
}
