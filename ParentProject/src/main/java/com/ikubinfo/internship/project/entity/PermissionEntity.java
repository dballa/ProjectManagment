package com.ikubinfo.internship.project.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the permission database table.
 * 
 */
@Entity
@Table(name="permission")
@NamedQuery(name="PermissionEntity.findAll", query="SELECT p FROM PermissionEntity p")
public class PermissionEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idPermission;

	private String namePermission;

	private int validity;

	//bi-directional many-to-one association to PermissionroleEntity
	@OneToMany(mappedBy="permission")
	private List<PermissionRoleEntity> permissionroles;

	public PermissionEntity() {
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

	public List<PermissionRoleEntity> getPermissionroles() {
		return this.permissionroles;
	}

	public void setPermissionroles(List<PermissionRoleEntity> permissionroles) {
		this.permissionroles = permissionroles;
	}

	public PermissionRoleEntity addPermissionrole(PermissionRoleEntity permissionrole) {
		getPermissionroles().add(permissionrole);
		permissionrole.setPermission(this);

		return permissionrole;
	}

	public PermissionRoleEntity removePermissionrole(PermissionRoleEntity permissionrole) {
		getPermissionroles().remove(permissionrole);
		permissionrole.setPermission(null);

		return permissionrole;
	}

	@Override
	public String toString() {
		return "PermissionEntity [idPermission=" + idPermission + ", namePermission=" + namePermission + ", validity="
				+ validity + ", permissionroles=" + permissionroles + "]";
	}

}