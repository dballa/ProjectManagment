package com.ikubinfo.internship.project.pojo;

public class Member {
	private MemberPK id;

	private byte validity;

	
	private Team team;

	
	private User user;

	public Member() {
	}

	public MemberPK getId() {
		return this.id;
	}

	public void setId(MemberPK id) {
		this.id = id;
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

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Member [id=" + id + ", validity=" + validity + ",  user=" + user + "]";
	}




}

