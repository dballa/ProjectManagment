package com.ikubinfo.internship.project.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the task database table.
 * 
 */
@Entity
@Table(name="task")
@NamedQuery(name="TaskEntity.findAll", query="SELECT t FROM TaskEntity t")
public class TaskEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idTask;

	

	private int createdBy;

	private String description;

	@Temporal(TemporalType.DATE)
	private Date endDate;

	private String nameTask;

	@Temporal(TemporalType.DATE)
	private Date startDate;

	private byte validity;

	//bi-directional many-to-one association to Priority
	@ManyToOne
	@JoinColumn(name="IdPriority")
	private PriorityEntity priority;

	@ManyToOne
	@JoinColumn(name="AssignedTo")
	private UserEntity assignedTo;
	
	//bi-directional many-to-one association to Status
	@ManyToOne
	@JoinColumn(name="IdStatus")
	private StatusEntity status;

	//bi-directional many-to-one association to Requirment
	@ManyToOne
	@JoinColumn(name="IdRequirment")
	private RequirmentEntity requirment;

	public TaskEntity() {
	}

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

	public PriorityEntity getPriority() {
		return this.priority;
	}

	public void setPriority(PriorityEntity priority) {
		this.priority = priority;
	}

	public StatusEntity getStatus() {
		return this.status;
	}

	public void setStatus(StatusEntity status) {
		this.status = status;
	}

	public RequirmentEntity getRequirment() {
		return this.requirment;
	}

	public void setRequirment(RequirmentEntity requirment) {
		this.requirment = requirment;
	}

	public UserEntity getAssignedTo() {
		return assignedTo;
	}

	public void setAssignedTo(UserEntity assignedTo) {
		this.assignedTo = assignedTo;
	}

}