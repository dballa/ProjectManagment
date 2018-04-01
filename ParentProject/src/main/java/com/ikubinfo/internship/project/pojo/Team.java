package com.ikubinfo.internship.project.pojo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.OneToMany;



public class Team {

	private int idTeam;

	private String nameTeam;

	private byte validity;

	
	private List<Member> members= new ArrayList<Member>();

	
	private List<Project> projects;

	public Team() {
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

	public List<Member> getMembers() {
		return this.members;
	}

	public void setMembers(List<Member> members) {
		this.members = members;
	}

	public Member  addMember(Member  member) {
		getMembers().add(member);
		member.setTeam(this);

		return member;
	}

	public Member  removeMember(Member  member) {
		getMembers().remove(member);
		member.setTeam(null);

		return member;
	}

	public List<Project > getProjects() {
		return this.projects;
	}

	public void setProjects(List<Project > projects) {
		this.projects = projects;
	}

	public Project  addProject(Project  project) {
		getProjects().add(project);
		project.setTeam(this);

		return project;
	}

	public Project  removeProject(Project  project) {
		getProjects().remove(project);
		project.setTeam(null);

		return project;
	}

	@Override
	public String toString() {
		return "Team [idTeam=" + idTeam + ", nameTeam=" + nameTeam + ", validity=" + validity + ", members=" + members
				+ ", projects=" + projects + "]";
	}

	

	
}
