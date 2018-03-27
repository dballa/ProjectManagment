package com.ikubinfo.internship.project.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the members database table.
 * 
 */
@Embeddable
public class MemberPKEntity implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(insertable=false, updatable=false)
	private int idTeam;

	@Column(insertable=false, updatable=false)
	private int member;

	public MemberPKEntity() {
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

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof MemberPKEntity)) {
			return false;
		}
		MemberPKEntity castOther = (MemberPKEntity)other;
		return 
			(this.idTeam == castOther.idTeam)
			&& (this.member == castOther.member);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.idTeam;
		hash = hash * prime + this.member;
		
		return hash;
	}
}