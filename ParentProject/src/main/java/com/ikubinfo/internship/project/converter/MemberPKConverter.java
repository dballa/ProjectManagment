package com.ikubinfo.internship.project.converter;

import com.ikubinfo.internship.project.entity.MemberPKEntity;
import com.ikubinfo.internship.project.pojo.MemberPK;
import com.ikubinfo.internship.project.utils.ConverterInterface;

public class MemberPKConverter implements ConverterInterface<MemberPK, MemberPKEntity> {

	@Override
	public MemberPKEntity fromPojoToEntity(MemberPK pojo) {
		MemberPKEntity entity = new MemberPKEntity();


		return entity;
	}

	@Override
	public MemberPK fromEntityToPojo(MemberPKEntity entity) {
		MemberPK pojo = new MemberPK();


		return pojo;
	}

}
