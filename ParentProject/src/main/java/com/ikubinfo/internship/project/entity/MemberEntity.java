package com.ikubinfo.internship.project.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the members database table.
 * 
 */
@Entity 
@Table(name="members")
@NamedQuery(name="MemberEntity.findAll", query="SELECT m FROM MemberEntity m")
public class MemberEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private MemberPKEntity id;
	
	private byte validity;

	//bi-directional many-to-one association to Team
	@MapsId("idTeam") 
	@ManyToOne
	@JoinColumn(name="IdTeam")
	private TeamEntity team;

	//bi-directional many-to-one association to User
	@MapsId("member") 
	@ManyToOne
	@JoinColumn(name="Member")
	private UserEntity user;

	public MemberEntity() {
	}

	public MemberPKEntity getId() {
		return this.id;
	}

	public void setId(MemberPKEntity id) {
		this.id = id;
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

	public UserEntity getUser() {
		return this.user;
	}

	public void setUser(UserEntity user) {
		this.user = user;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((team == null) ? 0 : team.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
		result = prime * result + validity;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MemberEntity other = (MemberEntity) obj;
		if (team == null) {
			if (other.team != null)
				return false;
		} else if (!team.equals(other.team))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		if (validity != other.validity)
			return false;
		return true;
	}

}