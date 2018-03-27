package com.ikubinfo.internship.project.pojo;

import java.util.List;

import javax.persistence.OneToMany;

import com.ikubinfo.internship.project.entity.UserEntity;

public class Role {
	private int idRole;

	private String description;

	private String nameRole;

	private byte validity;


	private List<User> users;

	public Role() {
	}

	public int getIdRole() {
		return this.idRole;
	}

	public void setIdRole(int idRole) {
		this.idRole = idRole;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getNameRole() {
		return this.nameRole;
	}

	public void setNameRole(String nameRole) {
		this.nameRole = nameRole;
	}

	public byte getValidity() {
		return this.validity;
	}

	public void setValidity(byte validity) {
		this.validity = validity;
	}

	public List<User> getUsers() {
		return this.users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public User addUser(User user) {
		getUsers().add(user);
//		user.setRole(this);

		return user;
	}

	public User removeUser(User user) {
		getUsers().remove(user);
		user.setRole(null);

		return user;
	}

	@Override
	public String toString() {
		return "RoleEntity [idRole=" + idRole + ", description=" + description + ", nameRole=" + nameRole
				+ ", validity=" + validity + ", users=" + users + "]";
	}
}
