package com.ikubinfo.internship.project.pojo;

import java.util.ArrayList;
import java.util.List;



public class Requirment {
	
	private int idRequirment;

	private String description;

	private String nameRequirment;

	private byte validity;

	private String type="REQ";
	
	private Status status;

	
	private Priority priority;

	
	private Project project;

	
	private List<Task> tasks=new ArrayList<Task>() ;

	

	public int getIdRequirment() {
		return this.idRequirment;
	}

	public void setIdRequirment(int idRequirment) {
		this.idRequirment = idRequirment;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getNameRequirment() {
		return this.nameRequirment;
	}

	public void setNameRequirment(String nameRequirment) {
		this.nameRequirment = nameRequirment;
	}

	public byte getValidity() {
		return this.validity;
	}

	public void setValidity(byte validity) {
		this.validity = validity;
	}

	public Status getStatus() {
		return this.status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Priority getPriority() {
		return this.priority;
	}

	public void setPriority(Priority priority) {
		this.priority = priority;
	}

	public Project getProject() {
		return this.project;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public List<Task> getTasks() {
		return this.tasks;
	}

	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}





	@Override
	public String toString() {
		return "Requirment [idRequirment=" + idRequirment + ", description=" + description + ", nameRequirment="
				+ nameRequirment + ", validity=" + validity + ", status=" + status + ", priority=" + priority
				+ ", project=" + project + ", tasks=" + tasks + "]";
	}


}
