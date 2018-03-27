package com.ikubinfo.internship.project.converter;

import com.ikubinfo.internship.project.entity.StatusEntity;
import com.ikubinfo.internship.project.pojo.Status;
import com.ikubinfo.internship.project.utils.ConverterInterface;

public class StatusConverter implements ConverterInterface<Status, StatusEntity> {

	@Override
	public StatusEntity fromPojoToEntity(Status pojo) {
		StatusEntity entity = new StatusEntity();
		entity.setIdStatus(pojo.getIdStatus());
		entity.setNameStatus(pojo.getNameStatus());
		entity.setValidity(pojo.getValidity());

		return entity;
	}

	@Override
	public Status fromEntityToPojo(StatusEntity entity) {
		Status pojo = new Status();
		pojo.setIdStatus(entity.getIdStatus());
		pojo.setNameStatus(entity.getNameStatus());
		pojo.setValidity(entity.getValidity());
		return pojo;
	}

}
