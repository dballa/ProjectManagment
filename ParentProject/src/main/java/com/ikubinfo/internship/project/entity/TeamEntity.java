package com.ikubinfo.internship.project.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the team database table.
 * 
 */
@Entity
@Table(name="team")

@NamedQuery(name="TeamEntity.findAll", query="SELECT t FROM TeamEntity t")
public class TeamEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idTeam;

	private String nameTeam;

	private byte validity;

	//bi-directional many-to-one association to Member
	@OneToMany(mappedBy="team")
	private List<MemberEntity> members;

	//bi-directional many-to-one association to Project
	@OneToMany(mappedBy="team")
	private List<ProjectEntity> projects;

	public TeamEntity() {
	}

	public int getIdTeam() {
		return this.idTeam;
	}

	public void setIdTeam(int idTeam) {
		this.idTeam = idTeam;
	}

	public String getNameTeam() {
		return this.nameTeam;
	}

	public void setNameTeam(String nameTeam) {
		this.nameTeam = nameTeam;
	}

	public byte getValidity() {
		return this.validity;
	}

	public void setValidity(byte validity) {
		this.validity = validity;
	}

	public List<MemberEntity> getMembers() {
		return this.members;
	}

	public void setMembers(List<MemberEntity> members) {
		this.members = members;
	}

	public MemberEntity addMember(MemberEntity member) {
		getMembers().add(member);
		member.setTeam(this);

		return member;
	}

	public MemberEntity removeMember(MemberEntity member) {
		getMembers().remove(member);
		member.setTeam(null);

		return member;
	}

	public List<ProjectEntity> getProjects() {
		return this.projects;
	}

	public void setProjects(List<ProjectEntity> projects) {
		this.projects = projects;
	}

	public ProjectEntity addProject(ProjectEntity project) {
		getProjects().add(project);
		project.setTeam(this);

		return project;
	}

	public ProjectEntity removeProject(ProjectEntity project) {
		getProjects().remove(project);
		project.setTeam(null);

		return project;
	}

	@Override
	public String toString() {
		return "TeamEntity [idTeam=" + idTeam + ", nameTeam=" + nameTeam + ", validity=" + validity + ", members="
				+ members + ", projects=" + projects + "]";
	}

	

}