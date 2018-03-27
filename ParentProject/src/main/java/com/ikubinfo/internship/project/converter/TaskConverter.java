package com.ikubinfo.internship.project.converter;

import com.ikubinfo.internship.project.entity.TaskEntity;
import com.ikubinfo.internship.project.entity.UserEntity;
import com.ikubinfo.internship.project.pojo.Task;
import com.ikubinfo.internship.project.utils.ConverterInterface;

public class TaskConverter implements ConverterInterface<Task, TaskEntity> {

	PriorityConverter PRIORITY_CONVERTER = new PriorityConverter();
	RequirmentConverter REQUIRMENT_CONVERTER = new RequirmentConverter();
	StatusConverter STATUS_CONVERTER = new StatusConverter();
	UserConverter USER_CONVERTER=new UserConverter();
	@Override
	public TaskEntity fromPojoToEntity(Task pojo) {
		TaskEntity entity = new TaskEntity();
		
		entity.setCreatedBy(pojo.getCreatedBy());
		entity.setDescription(pojo.getDescription());
		entity.setEndDate(pojo.getEndDate());
		entity.setIdTask(pojo.getIdTask());
		entity.setNameTask(pojo.getNameTask());
		entity.setStartDate(pojo.getStartDate());
		entity.setValidity(pojo.getValidity());
		entity.setPriority(PRIORITY_CONVERTER.fromPojoToEntity(pojo.getPriority()));
		entity.setRequirment(REQUIRMENT_CONVERTER.fromPojoToEntity(pojo.getRequirment()));
		entity.setStatus(STATUS_CONVERTER.fromPojoToEntity(pojo.getStatus()));
		entity.setAssignedTo(USER_CONVERTER.fromPojoToEntity(pojo.getAssignedTo()));
		return entity;
	}

	@Override
	public Task fromEntityToPojo(TaskEntity entity) {
		Task pojo = new Task();
		pojo.setAssignedTo(USER_CONVERTER.fromEntityToPojo(entity.getAssignedTo()));
		pojo.setCreatedBy(entity.getCreatedBy());
		pojo.setDescription(entity.getDescription());
		pojo.setEndDate(entity.getEndDate());
		pojo.setIdTask(entity.getIdTask());
		pojo.setNameTask(entity.getNameTask());
		pojo.setStartDate(entity.getStartDate());
		pojo.setValidity(entity.getValidity());
		pojo.setPriority(PRIORITY_CONVERTER.fromEntityToPojo(entity.getPriority()));
		pojo.setRequirment(REQUIRMENT_CONVERTER.fromEntityToPojo(entity.getRequirment()));
		pojo.setStatus(STATUS_CONVERTER.fromEntityToPojo(entity.getStatus()));
		return pojo;
	}

}
