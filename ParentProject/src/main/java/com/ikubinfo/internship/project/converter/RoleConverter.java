package com.ikubinfo.internship.project.converter;

import com.ikubinfo.internship.project.entity.RoleEntity;
import com.ikubinfo.internship.project.entity.UserEntity;
import com.ikubinfo.internship.project.pojo.Role;
import com.ikubinfo.internship.project.pojo.User;
import com.ikubinfo.internship.project.utils.ConverterInterface;

public class RoleConverter implements ConverterInterface<Role, RoleEntity> {

	@Override
	public RoleEntity fromPojoToEntity(Role pojo) {
		RoleEntity entity = new RoleEntity();
		entity.setIdRole(pojo.getIdRole());
		entity.setDescription(pojo.getDescription());
		entity.setNameRole(pojo.getNameRole());
		entity.setValidity(pojo.getValidity());

		return entity;
	}

	@Override
	public Role fromEntityToPojo(RoleEntity entity) {
		Role pojo = new Role();
		pojo.setIdRole(entity.getIdRole());
		pojo.setDescription(entity.getDescription());
		pojo.setNameRole(entity.getNameRole());
		pojo.setValidity(entity.getValidity());

		return pojo;
	}

}
