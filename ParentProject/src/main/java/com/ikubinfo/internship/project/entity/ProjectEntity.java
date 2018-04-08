package com.ikubinfo.internship.project.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;




/**
 * The persistent class for the project database table.
 * 
 */
@Entity
@Table(name="project")

@NamedQuery(name="ProjectEntity.findAll", query="SELECT p FROM ProjectEntity p")
public class ProjectEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idProject;

	private String client;
	@OneToOne
	@JoinColumn(name="CreatedBy")
	private UserEntity createdBy;

	private String description;

	@Temporal(TemporalType.DATE)
	private Date endDate;

	private String nameProject;

	@Temporal(TemporalType.DATE)
	private Date startDate;

	private byte validity;

	//bi-directional many-to-one association to Team
	@ManyToOne
	@JoinColumn(name="IdTeam")
	private TeamEntity team;

	//bi-directional many-to-one association to Status
	@ManyToOne
	@JoinColumn(name="IdStatus")
	private StatusEntity status;

	//bi-directional many-to-one association to Requirment
	@OneToMany(mappedBy="project")
	private List<RequirmentEntity> requirments;

	public ProjectEntity() {
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

	public TeamEntity getTeam() {
		return this.team;
	}

	public void setTeam(TeamEntity team) {
		this.team = team;
	}

	public StatusEntity getStatus() {
		return this.status;
	}

	public void setStatus(StatusEntity status) {
		this.status = status;
	}

	public List<RequirmentEntity> getRequirments() {
		return this.requirments;
	}

	public void setRequirments(List<RequirmentEntity> requirments) {
		this.requirments = requirments;
	}

	public RequirmentEntity addRequirment(RequirmentEntity requirment) {
		getRequirments().add(requirment);
		requirment.setProject(this);

		return requirment;
	}

	public RequirmentEntity removeRequirment(RequirmentEntity requirment) {
		getRequirments().remove(requirment);
		requirment.setProject(null);

		return requirment;
	}

	public UserEntity getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(UserEntity createdBy) {
		this.createdBy = createdBy;
	}

	


}