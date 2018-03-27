package com.ikubinfo.internship.project.converter;

import com.ikubinfo.internship.project.entity.MemberEntity;
import com.ikubinfo.internship.project.entity.UserEntity;
import com.ikubinfo.internship.project.pojo.Member;
import com.ikubinfo.internship.project.pojo.User;
import com.ikubinfo.internship.project.utils.ConverterInterface;

public class UserConverter implements ConverterInterface<User, UserEntity> {

	// private MemberConverter MEMBER_CONVETER=new MemberConverter();
	private RoleConverter ROLE_CONVERTER = new RoleConverter();

	@Override
	public UserEntity fromPojoToEntity(User pojo) {
		UserEntity entity = new UserEntity();

		entity.setIdUser(pojo.getIdUser());
		entity.setEmail(pojo.getEmail());
		entity.setNameUser(pojo.getNameUser());
		entity.setPassword(pojo.getPassword());
		entity.setValidity(pojo.getValidity());
		entity.setRole(ROLE_CONVERTER.fromPojoToEntity(pojo.getRole()));

		return entity;
	}

	@Override
	public User fromEntityToPojo(UserEntity entity) {

		User pojo = new User();

		pojo.setIdUser(entity.getIdUser());
		pojo.setEmail(entity.getEmail());
		pojo.setNameUser(entity.getNameUser());
		pojo.setPassword(entity.getPassword());
		pojo.setValidity(entity.getValidity());
		pojo.setRole(ROLE_CONVERTER.fromEntityToPojo(entity.getRole()));

		return pojo;
	}

}
