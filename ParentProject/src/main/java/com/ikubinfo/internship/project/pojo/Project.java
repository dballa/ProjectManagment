package com.ikubinfo.internship.project.pojo;

import java.util.Date;
import java.util.List;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.ikubinfo.internship.project.entity.RequirmentEntity;
import com.ikubinfo.internship.project.entity.StatusEntity;
import com.ikubinfo.internship.project.entity.TeamEntity;

public class Project {
	private int idProject;

	private String client;

	private int createdBy;

	private String description;

	
	private Date endDate;

	private String nameProject;

	
	private Date startDate;

	private byte validity;

	
	private Team team;

	
	private Status status;

	private boolean disabled;


	public boolean isDisabled() {
		return "Waiting BA".equals(status.getNameStatus());
	}

	public void setDisabled(boolean disabled) {
		this.disabled = disabled;
	}

	private List<Requirment> requirments;

	public Project() {
	}

	public int getIdProject() {
		return this.idProject;
	}

	public void setIdProject(int idProject) {
		this.idProject = idProject;
	}

	public String getClient() {
		return this.client;
	}

	public void setClient(String client) {
		this.client = client;
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

	public String getNameProject() {
		return this.nameProject;
	}

	public void setNameProject(String nameProject) {
		this.nameProject = nameProject;
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

	public Team getTeam() {
		return this.team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}

	public Status getStatus() {
		return this.status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public List<Requirment> getRequirments() {
		return this.requirments;
	}

	public void setRequirments(List<Requirment> requirments) {
		this.requirments = requirments;
	}

	public Requirment addRequirment(Requirment requirment) {
		getRequirments().add(requirment);
	//	requirment.setProject(this);

		return requirment;
	}

	public Requirment removeRequirment(Requirment requirment) {
		getRequirments().remove(requirment);
		//requirment.setProject(null);

		return requirment;
	}

	@Override
	public String toString() {
		return "Project [idProject=" + idProject + ", client=" + client+ ", createdBy=" + createdBy
				+ ", description=" + description + ", endDate=" + endDate + ", nameProject=" + nameProject
				+ ", startDate=" + startDate + ", validity=" + validity + ", team=" + team + ", status=" + status
				+ ", requirments=" + requirments + "]";
	}
}
