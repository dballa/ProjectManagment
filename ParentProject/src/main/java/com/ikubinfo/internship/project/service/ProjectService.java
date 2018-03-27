package com.ikubinfo.internship.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ikubinfo.internship.project.dao.ProjectDao;
import com.ikubinfo.internship.project.pojo.Project;
import com.ikubinfo.internship.project.pojo.User;

@Service
public class ProjectService {
	@Autowired
	private ProjectDao projectDao;

	public List<Project> allProjects(int id) {

		return projectDao.allProjects(id);

	}

	public void addProject(Project project) {

		projectDao.addProject(project);

	}

	public void removeProject(Project project) {

		projectDao.removeProject(project);

	}

	public Project getProjectById(int id) {

		return projectDao.getProjectById(id);
	}

	public void editProject(Project project) {

		projectDao.editProject(project);

	}

	public List<Project> baProjects(int id) {
		return projectDao.baProjects(id);
	}
	public List<Project>tlProjects(int id){
		
		return projectDao.tlProjects(id);
	}
}