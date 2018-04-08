package com.ikubinfo.internship.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ikubinfo.internship.project.dao.RequirmentDao;
import com.ikubinfo.internship.project.pojo.Requirment;

@Service
public class RequirmentService {
//List<Requirment> req=new ArrayList<Requirment>();
	@Autowired
	private RequirmentDao requirmentDao;

	public List<Requirment> getProjectRequirements(int idProject) {

		return requirmentDao.getProjectRequirements(idProject);
	}

	public void addRequirment(Requirment requirment) {

		requirmentDao.addRequirment(requirment);
	}
	
	public Requirment getRequirmentById(int id) {
		
		return requirmentDao.getRequirementById(id);
	}
	public void removeRequirment(Requirment requirment) {
		
		requirmentDao.removeRequirement(requirment);
	}
	public void editRequirment(Requirment requirment) {
		
		requirmentDao.editRequirment(requirment);
	}
	public boolean accessRequirement(int idProject,int idUser) {
		return requirmentDao.accessRequirement(idUser, idProject);
	}
}
