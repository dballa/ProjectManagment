package com.ikubinfo.internship.project.pojo;

import java.util.ArrayList;
import java.util.List;

import com.ikubinfo.internship.project.entity.PermissionEntity;
import com.ikubinfo.internship.project.entity.RoleEntity;

public class User {

	private static final long serialVersionUID = 1L;

	private int idUser;

	private String email;

	private String nameUser;

	private String password;

	private byte validity;

	private List<Member> members = new ArrayList<>();

	private Role role;

	private List<Permission> permissions;

	public User() {
	}

	@Override
	public String toString() {
		return "User [idUser=" + idUser + ", email=" + email + ", nameUser=" + nameUser + ", password=" + password
				+ ", validity=" + validity + ", members=" + members + ", role=" + role + ", permissions=" + permissions
				+ "]";
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

	public List<Member> getMembers() {
		return this.members;
	}

	public void setMembers(List<Member> members) {
		this.members = members;
	}

	public Role getRole() {
		return this.role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public List<Permission> getPermissions() {
		return this.permissions;
	}

	public void setPermissions(List<Permission> permissions) {
		this.permissions = permissions;
	}
}
