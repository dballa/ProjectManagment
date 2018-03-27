package com.ikubinfo.internship.project.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the requirment database table.
 * 
 */
@Entity
@Table(name="requirment")
@NamedQuery(name="RequirmentEntity.findAll", query="SELECT r FROM RequirmentEntity r")
public class RequirmentEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idRequirment;

	private String description;

	private String nameRequirment;

	private byte validity;

	//bi-directional many-to-one association to Status
	@ManyToOne
	@JoinColumn(name="IdStatus")
	private StatusEntity status;

	//bi-directional many-to-one association to Priority
	@ManyToOne
	@JoinColumn(name="IdPriority")
	private PriorityEntity priority;

	//bi-directional many-to-one association to Project
	@ManyToOne
	@JoinColumn(name="IdProject")
	private ProjectEntity project;

	//bi-directional many-to-one association to Task
	@OneToMany(mappedBy="requirment")
	private List<TaskEntity> tasks;

	public RequirmentEntity() {
	}

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

	public StatusEntity getStatus() {
		return this.status;
	}

	public void setStatus(StatusEntity status) {
		this.status = status;
	}

	public PriorityEntity getPriority() {
		return this.priority;
	}

	public void setPriority(PriorityEntity priority) {
		this.priority = priority;
	}

	public ProjectEntity getProject() {
		return this.project;
	}

	public void setProject(ProjectEntity project) {
		this.project = project;
	}

	public List<TaskEntity> getTasks() {
		return this.tasks;
	}

	public void setTasks(List<TaskEntity> tasks) {
		this.tasks = tasks;
	}

	public TaskEntity addTask(TaskEntity task) {
		getTasks().add(task);
		task.setRequirment(this);

		return task;
	}

	public TaskEntity removeTask(TaskEntity task) {
		getTasks().remove(task);
		task.setRequirment(null);

		return task;
	}

}