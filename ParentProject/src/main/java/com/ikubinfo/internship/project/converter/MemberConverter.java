package com.ikubinfo.internship.project.converter;

import com.ikubinfo.internship.project.entity.MemberEntity;
import com.ikubinfo.internship.project.pojo.Member;
import com.ikubinfo.internship.project.utils.ConverterInterface;

public class MemberConverter implements ConverterInterface<Member, MemberEntity> {
	private MemberPKConverter MEMBERPK_CONVERTER = new MemberPKConverter();
	private UserConverter USER_CONVERTER = new UserConverter();
	private TeamConverter TEAM_CONVERTER = new TeamConverter();

	@Override
	public MemberEntity fromPojoToEntity(Member pojo) {
		MemberEntity entity = new MemberEntity();
		entity.setValidity(pojo.getValidity());
		entity.setId(MEMBERPK_CONVERTER.fromPojoToEntity(pojo.getId()));
		entity.setUser(USER_CONVERTER.fromPojoToEntity(pojo.getUser()));
		entity.setTeam(TEAM_CONVERTER.fromPojoToEntity(pojo.getTeam()));

		return entity;
	}

	@Override
	public Member fromEntityToPojo(MemberEntity entity) {
		Member pojo = new Member();
		pojo.setValidity(entity.getValidity());
		pojo.setId(MEMBERPK_CONVERTER.fromEntityToPojo(entity.getId()));
		pojo.setUser(USER_CONVERTER.fromEntityToPojo(entity.getUser()));
		pojo.setTeam(TEAM_CONVERTER.fromEntityToPojo(entity.getTeam()));

		return pojo;
	}

}
