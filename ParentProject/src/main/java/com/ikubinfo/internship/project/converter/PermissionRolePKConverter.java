package com.ikubinfo.internship.project.converter;

import com.ikubinfo.internship.project.entity.PermissionRolePKEntity;
import com.ikubinfo.internship.project.pojo.PermissionRolePK;
import com.ikubinfo.internship.project.utils.ConverterInterface;

public class PermissionRolePKConverter implements ConverterInterface<PermissionRolePK, PermissionRolePKEntity> {

	@Override
	public PermissionRolePKEntity fromPojoToEntity(PermissionRolePK pojo) {
		PermissionRolePKEntity entity = new PermissionRolePKEntity();
		entity.setIdPermission(pojo.getIdPermission());
		entity.setIdRole(pojo.getIdRole());

		return entity;
	}

	@Override
	public PermissionRolePK fromEntityToPojo(PermissionRolePKEntity entity) {
		PermissionRolePK pojo = new PermissionRolePK();
		pojo.setIdPermission(entity.getIdPermission());
		pojo.setIdRole(entity.getIdRole());
		return pojo;
	}

}
