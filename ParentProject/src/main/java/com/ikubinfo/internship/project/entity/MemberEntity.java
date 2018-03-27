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
	@ManyToOne
	@JoinColumn(name="IdTeam")
	private TeamEntity team;

	//bi-directional many-to-one association to User
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

}