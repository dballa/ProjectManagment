package com.ikubinfo.internship.project.converter;

import com.ikubinfo.internship.project.entity.PriorityEntity;
import com.ikubinfo.internship.project.pojo.Priority;
import com.ikubinfo.internship.project.utils.ConverterInterface;

public class PriorityConverter implements ConverterInterface<Priority, PriorityEntity> {

	@Override
	public PriorityEntity fromPojoToEntity(Priority pojo) {
		PriorityEntity entity = new PriorityEntity();
		entity.setIdPriority(pojo.getIdPriority());
		entity.setNamePriority(pojo.getNamePriority());
		entity.setValidity(pojo.getValidity());

		return entity;
	}

	@Override
	public Priority fromEntityToPojo(PriorityEntity entity) {
		Priority pojo = new Priority();

		pojo.setIdPriority(entity.getIdPriority());
		pojo.setNamePriority(entity.getNamePriority());
		pojo.setValidity(entity.getValidity());
		return pojo;
	}

}
