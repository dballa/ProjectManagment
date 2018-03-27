package com.ikubinfo.internship.project.converter;

import com.ikubinfo.internship.project.entity.PermissionRoleEntity;
import com.ikubinfo.internship.project.pojo.PermissionRole;
import com.ikubinfo.internship.project.utils.ConverterInterface;

public class PermissionRoleConverter implements ConverterInterface<PermissionRole, PermissionRoleEntity> {

	PermissionRolePKConverter PERMISSIONROLEPK_CONVERTET = new PermissionRolePKConverter();
	RoleConverter ROLE_CONVERTER = new RoleConverter();
	PermissionConverter PERMISSION_CONVERTER = new PermissionConverter();

	@Override
	public PermissionRoleEntity fromPojoToEntity(PermissionRole pojo) {
		PermissionRoleEntity entity = new PermissionRoleEntity();
		entity.setValidity(pojo.getValidity());
		entity.setId(PERMISSIONROLEPK_CONVERTET.fromPojoToEntity(pojo.getId()));
		entity.setRole(ROLE_CONVERTER.fromPojoToEntity(pojo.getRole()));
		entity.setPermission(PERMISSION_CONVERTER.fromPojoToEntity(pojo.getPermission()));

		return entity;
	}

	@Override
	public PermissionRole fromEntityToPojo(PermissionRoleEntity entity) {
		PermissionRole pojo = new PermissionRole();
		pojo.setValidity(entity.getValidity());
		pojo.setPermission(PERMISSION_CONVERTER.fromEntityToPojo(entity.getPermission()));
		pojo.setId(PERMISSIONROLEPK_CONVERTET.fromEntityToPojo(entity.getId()));
		pojo.setRole(ROLE_CONVERTER.fromEntityToPojo(entity.getRole()));

		return pojo;
	}

}
