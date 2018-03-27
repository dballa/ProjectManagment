package com.ikubinfo.internship.project.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the permissionrole database table.
 * 
 */
@Embeddable
public class PermissionRolePKEntity implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(insertable=false, updatable=false)
	private int idRole;

	@Column(insertable=false, updatable=false)
	private int idPermission;

	public PermissionRolePKEntity() {
	}
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

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof PermissionRolePKEntity)) {
			return false;
		}
		PermissionRolePKEntity castOther = (PermissionRolePKEntity)other;
		return 
			(this.idRole == castOther.idRole)
			&& (this.idPermission == castOther.idPermission);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.idRole;
		hash = hash * prime + this.idPermission;
		
		return hash;
	}
}