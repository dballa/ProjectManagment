package com.ikubinfo.internship.project.converter;

import com.ikubinfo.internship.project.entity.TeamEntity;
import com.ikubinfo.internship.project.pojo.Team;
import com.ikubinfo.internship.project.utils.ConverterInterface;

public class TeamConverter implements ConverterInterface<Team, TeamEntity> {

	@Override
	public TeamEntity fromPojoToEntity(Team pojo) {

		TeamEntity entity = new TeamEntity();

		entity.setIdTeam(pojo.getIdTeam());
		entity.setNameTeam(pojo.getNameTeam());
		entity.setValidity(pojo.getValidity());

		return entity;
	}

	@Override
	public Team fromEntityToPojo(TeamEntity entity) {

		Team pojo = new Team();
		pojo.setIdTeam(entity.getIdTeam());
		pojo.setNameTeam(entity.getNameTeam());
		pojo.setValidity(entity.getValidity());

		return pojo;
	}

}