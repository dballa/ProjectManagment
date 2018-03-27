package com.ikubinfo.internship.project.pojo;

import javax.persistence.Column;

public class PermissionRolePK {
	
	private int idRole;

	
	private int idPermission;

	
	public int getIdRole() {
		return this.idRole;
	}
	public void setIdRole(int idRole) {
		this.idRole = idRole;
	}
	public int getIdPermission() {
		return this.idPermission;
	}
	public void setIdPermission(int idPermission) {
		this.idPermission = idPermission;
	}
}
