package com.ikubinfo.internship.project.converter;

import com.ikubinfo.internship.project.entity.MemberEntity;
import com.ikubinfo.internship.project.entity.PermissionEntity;
import com.ikubinfo.internship.project.entity.PermissionRoleEntity;
import com.ikubinfo.internship.project.pojo.Member;
import com.ikubinfo.internship.project.pojo.Permission;
import com.ikubinfo.internship.project.pojo.PermissionRole;
import com.ikubinfo.internship.project.utils.ConverterInterface;

public class PermissionConverter implements ConverterInterface<Permission, PermissionEntity> {
	PermissionRoleConverter PERMISSIONROLE_CONVERTER = new PermissionRoleConverter();

	@Override
	public PermissionEntity fromPojoToEntity(Permission pojo) {
		PermissionEntity entity = new PermissionEntity();
		entity.setNamePermission(pojo.getNamePermission());
		entity.setValidity(pojo.getValidity());
		entity.setIdPermission(pojo.getIdPermission());

		return entity;
	}

	@Override
	public Permission fromEntityToPojo(PermissionEntity entity) {
		Permission pojo = new Permission();
		pojo.setIdPermission(entity.getIdPermission());
		pojo.setNamePermission(entity.getNamePermission());
		pojo.setValidity(entity.getValidity());

		return pojo;
	}

}
