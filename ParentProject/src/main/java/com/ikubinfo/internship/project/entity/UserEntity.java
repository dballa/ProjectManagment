package com.ikubinfo.internship.project.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the user database table.
 * 
 */
@Entity
@Table(name="user")
@NamedQuery(name="UserEntity.findAll", query="SELECT u FROM UserEntity u")
public class UserEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idUser;

	private String email;

	private String nameUser;

	private String password;

	private byte validity;

	//bi-directional many-to-one association to Member
	@OneToMany(mappedBy="user")
	private List<MemberEntity> members;

	//bi-directional many-to-one association to Role
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="IdRole")
	private RoleEntity role;

	//bi-directional many-to-many association to Permission
	@OneToMany(mappedBy="assignedTo")
	
	private List<TaskEntity> tasks;
	public UserEntity() {
	}

	public int getIdUser() {
		return this.idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNameUser() {
		return this.nameUser;
	}

	public void setNameUser(String nameUser) {
		this.nameUser = nameUser;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
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
		member.setUser(this);

		return member;
	}

	public MemberEntity removeMember(MemberEntity member) {
		getMembers().remove(member);
		member.setUser(null);

		return member;
	}

	public RoleEntity getRole() {
		return this.role;
	}

	public void setRole(RoleEntity role) {
		this.role = role;
	}

	
}