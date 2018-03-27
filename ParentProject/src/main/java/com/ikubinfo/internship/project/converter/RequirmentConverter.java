package com.ikubinfo.internship.project.converter;

import com.ikubinfo.internship.project.entity.RequirmentEntity;
import com.ikubinfo.internship.project.entity.TaskEntity;
import com.ikubinfo.internship.project.pojo.Requirment;
import com.ikubinfo.internship.project.pojo.Task;
import com.ikubinfo.internship.project.utils.ConverterInterface;

public class RequirmentConverter implements ConverterInterface<Requirment, RequirmentEntity> {
	private PriorityConverter PRIORITY_CONVERTER = new PriorityConverter();
	private ProjectConverter PROJECT_CONVERTER = new ProjectConverter();
	private StatusConverter STATUS_CONVERTER = new StatusConverter();
//	private TaskConverter TASK_CONVERTER=new TaskConverter();

	@Override
	public RequirmentEntity fromPojoToEntity(Requirment pojo) {
		RequirmentEntity entity = new RequirmentEntity();
		entity.setDescription(pojo.getDescription());
		entity.setIdRequirment(pojo.getIdRequirment());
		entity.setNameRequirment(pojo.getNameRequirment());
		entity.setValidity(pojo.getValidity());
		entity.setPriority(PRIORITY_CONVERTER.fromPojoToEntity(pojo.getPriority()));
		entity.setProject(PROJECT_CONVERTER.fromPojoToEntity(pojo.getProject()));
		entity.setStatus(STATUS_CONVERTER.fromPojoToEntity(pojo.getStatus()));
		
//		 for(Task task:pojo.getTasks()) {
//
//		 entity.getTasks().add(TASK_CONVERTER.fromPojoToEntity(task));
//
//		 }

		return entity;
	}

	@Override
	public Requirment fromEntityToPojo(RequirmentEntity entity) {
		Requirment pojo = new Requirment();

		pojo.setDescription(entity.getDescription());
		pojo.setIdRequirment(entity.getIdRequirment());
		pojo.setNameRequirment(entity.getNameRequirment());
		pojo.setValidity(entity.getValidity());
		pojo.setPriority(PRIORITY_CONVERTER.fromEntityToPojo(entity.getPriority()));
		pojo.setProject(PROJECT_CONVERTER.fromEntityToPojo(entity.getProject()));
		pojo.setStatus(STATUS_CONVERTER.fromEntityToPojo(entity.getStatus()));
//		 for(TaskEntity task:entity.getTasks()) {
//
//		 pojo.getTasks().add(TASK_CONVERTER.fromEntityToPojo(task));
//
//		 }

		return pojo;
	}

}
