package com.ikubinfo.internship.project.pojo;

import java.util.List;

import javax.persistence.OneToMany;

import com.ikubinfo.internship.project.entity.ProjectEntity;
import com.ikubinfo.internship.project.entity.RequirmentEntity;
import com.ikubinfo.internship.project.entity.TaskEntity;

public class Status {

	private int idStatus;

	private String nameStatus;

	private byte validity;

	
	private List<Project> projects;

	
	private List<Requirment> requirments;

	
	private List<Task> tasks;

	public Status() {
	}

	public int getIdStatus() {
		return this.idStatus;
	}

	public void setIdStatus(int idStatus) {
		this.idStatus = idStatus;
	}

	public String getNameStatus() {
		return this.nameStatus;
	}

	public void setNameStatus(String nameStatus) {
		this.nameStatus = nameStatus;
	}

	public byte getValidity() {
		return this.validity;
	}

	public void setValidity(byte validity) {
		this.validity = validity;
	}

	public List<Project> getProjects() {
		return this.projects;
	}

	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}

	public Project addProject(Project project) {
		getProjects().add(project);
		project.setStatus(this);

		return project;
	}

	public Project  removeProject(Project project) {
		getProjects().remove(project);
		project.setStatus(null);

		return project;
	}

	public List<Requirment > getRequirments() {
		return this.requirments;
	}

	public void setRequirments(List<Requirment > requirments) {
		this.requirments = requirments;
	}

	public Requirment  addRequirment(Requirment requirment) {
		getRequirments().add(requirment);
	//	requirment.setStatus(this);

		return requirment;
	}

	public Requirment removeRequirment(Requirment requirment) {
		getRequirments().remove(requirment);
	//	requirment.setStatus(null);

		return requirment;
	}

	public List<Task > getTasks() {
		return this.tasks;
	}

	public void setTasks(List<Task > tasks) {
		this.tasks = tasks;
	}

	public Task  addTask(Task  task) {
		getTasks().add(task);
	//	task.setStatus(this);

		return task;
	}

	public Task removeTask(Task task) {
		getTasks().remove(task);
	//	task.setStatus(null);

		return task;
	}

	@Override
	public String toString() {
		return "Status [idStatus=" + idStatus + ", nameStatus=" + nameStatus + ", validity=" + validity + ", projects="
				+ projects + ", requirments=" + requirments + ", tasks=" + tasks + "]";
	}
	
	
	
}

