package com.ikubinfo.internship.project.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the permissionrole database table.
 * 
 */
@Entity
@Table(name="permissionrole")
@NamedQuery(name="PermissionRoleEntity.findAll", query="SELECT p FROM PermissionRoleEntity p")
public class PermissionRoleEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private PermissionRolePKEntity id;
	private byte validity;

	//bi-directional many-to-one association to PermissionEntity
	@ManyToOne
	@JoinColumn(name="IdPermission")
	private PermissionEntity permission;
	
	@ManyToOne
	@JoinColumn(name="IdRole")
	private RoleEntity role;

	public PermissionRoleEntity() {
	}

	public PermissionRolePKEntity getId() {
		return this.id;
	}

	public void setId(PermissionRolePKEntity id) {
		this.id = id;
	}

	public PermissionEntity getPermission() {
		return this.permission;
	}

	public void setPermission(PermissionEntity permission) {
		this.permission = permission;
	}

	public byte getValidity() {
		return validity;
	}

	public void setValidity(byte validity) {
		this.validity = validity;
	}

	public RoleEntity getRole() {
		return role;
	}

	public void setRole(RoleEntity role) {
		this.role = role;
	}

}