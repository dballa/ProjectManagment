package com.ikubinfo.internship.project.service;

import java.util.ArrayList;
import java.util.List;

import org.primefaces.model.DefaultTreeNode;
import org.primefaces.model.TreeNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ikubinfo.internship.project.dao.RequirmentDao;
import com.ikubinfo.internship.project.pojo.Requirment;

@Service
public class RequirmentService {
//List<Requirment> req=new ArrayList<Requirment>();
	@Autowired
	private RequirmentDao requirmentDao;

	public List<Requirment> requirmentOfProject(int idProject) {

		return requirmentDao.requirmentOfProject(idProject);
	}

	public void addRequirment(Requirment requirment) {

		requirmentDao.addRequirment(requirment);
	}
	
	
	
}
