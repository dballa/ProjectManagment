package com.ikubinfo.internship.project.pojo;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.ikubinfo.internship.project.entity.PermissionEntity;
import com.ikubinfo.internship.project.entity.PermissionRolePKEntity;
import com.ikubinfo.internship.project.entity.RoleEntity;

public class PermissionRole {
	private PermissionRolePK id;
	private byte validity;

	
	private Permission permission;
	
	
	private Role role;

	public PermissionRole() {
	}

	public PermissionRolePK getId() {
		return this.id;
	}

	public void setId(PermissionRolePK id) {
		this.id = id;
	}

	public Permission getPermission() {
		return this.permission;
	}

	public void setPermission(Permission permission) {
		this.permission = permission;
	}

	public byte getValidity() {
		return validity;
	}

	public void setValidity(byte validity) {
		this.validity = validity;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
}
