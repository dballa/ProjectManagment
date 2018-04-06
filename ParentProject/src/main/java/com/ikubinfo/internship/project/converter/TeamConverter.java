package com.ikubinfo.internship.project.converter;

import com.ikubinfo.internship.project.entity.MemberEntity;
import com.ikubinfo.internship.project.entity.TeamEntity;
import com.ikubinfo.internship.project.pojo.Member;
import com.ikubinfo.internship.project.pojo.Team;
import com.ikubinfo.internship.project.utils.ConverterInterface;

public class TeamConverter implements ConverterInterface<Team, TeamEntity> {
	private Member1Converter MEMBER_CONVERTER = new Member1Converter();

	@Override
	public TeamEntity fromPojoToEntity(Team pojo) {

		TeamEntity entity = new TeamEntity();

		entity.setIdTeam(pojo.getIdTeam());
		entity.setNameTeam(pojo.getNameTeam());
		entity.setValidity(pojo.getValidity());
		for (Member mem : pojo.getMembers()) {

			entity.addMember(MEMBER_CONVERTER.fromPojoToEntity(mem));
		}
		
		return entity;
	}

	@Override
	public Team fromEntityToPojo(TeamEntity entity) {

		Team pojo = new Team();
		pojo.setIdTeam(entity.getIdTeam());
		pojo.setNameTeam(entity.getNameTeam());
		pojo.setValidity(entity.getValidity());
		for (MemberEntity mem : entity.getMembers()) {

			pojo.getMembers().add(MEMBER_CONVERTER.fromEntityToPojo(mem));
		}
		
		return pojo;
	}

}
