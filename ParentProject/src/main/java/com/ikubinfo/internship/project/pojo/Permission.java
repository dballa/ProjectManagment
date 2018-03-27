package com.ikubinfo.internship.project.pojo;

import java.util.List;

import javax.persistence.OneToMany;

import com.ikubinfo.internship.project.entity.PermissionRoleEntity;

public class Permission {
	private int idPermission;

	private String namePermission;

	private int validity;

	
	private List<PermissionRole> permissionroles;

	public Permission() {
	}

	public int getIdPermission() {
		return this.idPermission;
	}

	public void setIdPermission(int idPermission) {
		this.idPermission = idPermission;
	}

	public String getNamePermission() {
		return this.namePermission;
	}

	public void setNamePermission(String namePermission) {
		this.namePermission = namePermission;
	}

	public int getValidity() {
		return this.validity;
	}

	public void setValidity(int validity) {
		this.validity = validity;
	}

	public List<PermissionRole> getPermissionroles() {
		return this.permissionroles;
	}

	public void setPermissionroles(List<PermissionRole> permissionroles) {
		this.permissionroles = permissionroles;
	}

	public PermissionRole addPermissionrole(PermissionRole permissionrole) {
		getPermissionroles().add(permissionrole);
	//	permissionrole.setPermission(this);

		return permissionrole;
	}

	public PermissionRole removePermissionrole(PermissionRole permissionrole) {
		getPermissionroles().remove(permissionrole);
	//	permissionrole.setPermission(null);

		return permissionrole;
	}

	
}
