package com.ikubinfo.internship.project.pojo;

import java.util.Date;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.ikubinfo.internship.project.entity.PriorityEntity;
import com.ikubinfo.internship.project.entity.RequirmentEntity;
import com.ikubinfo.internship.project.entity.StatusEntity;

public class Task {
	private int idTask;

	private User assignedTo;

	private int createdBy;

	private String description;
	
	private boolean checkEndDate;
	
	private Date endDate;

	private String nameTask;

	
	private Date startDate;

	private byte validity;

	
	private Priority priority;

	
	private Status status;

	
	private Requirment requirment;

	

	public int getIdTask() {
		return this.idTask;
	}

	public void setIdTask(int idTask) {
		this.idTask = idTask;
	}

	

	public int getCreatedBy() {
		return this.createdBy;
	}

	public void setCreatedBy(int createdBy) {
		this.createdBy = createdBy;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getEndDate() {
		return this.endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getNameTask() {
		return this.nameTask;
	}

	public void setNameTask(String nameTask) {
		this.nameTask = nameTask;
	}

	public Date getStartDate() {
		return this.startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public byte getValidity() {
		return this.validity;
	}

	public void setValidity(byte validity) {
		this.validity = validity;
	}

	public Priority getPriority() {
		return this.priority;
	}

	public void setPriority(Priority priority) {
		this.priority = priority;
	}

	public Status getStatus() {
		return this.status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Requirment getRequirment() {
		return this.requirment;
	}

	public void setRequirment(Requirment requirment) {
		this.requirment = requirment;
	}

	

	@Override
	public String toString() {
		return "Task [idTask=" + idTask + ", assignedTo=" + assignedTo + ", createdBy=" + createdBy + ", description="
				+ description + ", endDate=" + endDate + ", nameTask=" + nameTask + ", startDate=" + startDate
				+ ", validity=" + validity + ", priority=" + priority + ", status=" + status + ", requirment="
				+ requirment + "]";
	}

	public User getAssignedTo() {
		return assignedTo;
	}

	public boolean isCheckEndDate() {
		Date todayDate=new Date();
		
			return todayDate.after(endDate)&&!"Done".equals(status.getNameStatus());
	}

	public void setCheckEndDate(boolean checkEndDate) {
		this.checkEndDate = checkEndDate;
	}

	public void setAssignedTo(User assignedTo) {
		this.assignedTo = assignedTo;
	}


}
