package com.ikubinfo.internship.project.converter;

import com.ikubinfo.internship.project.entity.MemberEntity;
import com.ikubinfo.internship.project.entity.ProjectEntity;
import com.ikubinfo.internship.project.entity.RequirmentEntity;
import com.ikubinfo.internship.project.pojo.Member;
import com.ikubinfo.internship.project.pojo.Project;
import com.ikubinfo.internship.project.pojo.Requirment;
import com.ikubinfo.internship.project.utils.ConverterInterface;

public class ProjectConverter implements ConverterInterface<Project, ProjectEntity> {
	private StatusConverter STATUS_CONVERTER = new StatusConverter();
	private TeamConverter TEAM_CONVERTER = new TeamConverter();

	@Override
	public ProjectEntity fromPojoToEntity(Project pojo) {
		ProjectEntity entity = new ProjectEntity();
		entity.setClient(pojo.getClient());
		entity.setCreatedBy(pojo.getCreatedBy());
		entity.setDescription(pojo.getDescription());
		entity.setEndDate(pojo.getEndDate());
		entity.setIdProject(pojo.getIdProject());
		entity.setNameProject(pojo.getNameProject());
		entity.setStartDate(pojo.getStartDate());
		entity.setStatus(STATUS_CONVERTER.fromPojoToEntity(pojo.getStatus()));
		entity.setTeam(TEAM_CONVERTER.fromPojoToEntity(pojo.getTeam()));
		entity.setValidity(pojo.getValidity());

		return entity;
	}

	@Override
	public Project fromEntityToPojo(ProjectEntity entity) {
		Project pojo = new Project();

		pojo.setClient(entity.getClient());
		pojo.setCreatedBy(entity.getCreatedBy());
		pojo.setDescription(entity.getDescription());
		pojo.setEndDate(entity.getEndDate());
		pojo.setIdProject(entity.getIdProject());
		pojo.setNameProject(entity.getNameProject());
		pojo.setStartDate(entity.getStartDate());
		pojo.setStatus(STATUS_CONVERTER.fromEntityToPojo(entity.getStatus()));
		pojo.setTeam(TEAM_CONVERTER.fromEntityToPojo(entity.getTeam()));
		pojo.setValidity(pojo.getValidity());

		return pojo;
	}

}
