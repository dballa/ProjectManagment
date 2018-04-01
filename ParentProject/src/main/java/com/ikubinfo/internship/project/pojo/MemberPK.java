package com.ikubinfo.internship.project.pojo;

public class MemberPK {
	private int idTeam;

	
	private int member;

	public MemberPK() {
	}
	public int getIdTeam() {
		return this.idTeam;
	}
	public void setIdTeam(int idTeam) {
		this.idTeam = idTeam;
	}
	public int getMember() {
		return this.member;
	}
	public void setMember(int member) {
		this.member = member;
	}
	@Override
	public String toString() {
		return "MemberPK [idTeam=" + idTeam + "]";
	}
}
