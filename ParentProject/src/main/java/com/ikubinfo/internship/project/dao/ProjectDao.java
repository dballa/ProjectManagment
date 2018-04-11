package com.ikubinfo.internship.project.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.NoResultException;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ikubinfo.internship.project.converter.ProjectConverter;
import com.ikubinfo.internship.project.entity.ProjectEntity;
import com.ikubinfo.internship.project.pojo.Project;
import com.ikubinfo.internship.project.utils.StatesEnum;

@Repository
@Transactional
public class ProjectDao {

	@Autowired
	private SessionFactory sessionFactory;
	private ProjectConverter PROJECT_CONVERTER = new ProjectConverter();

	public List<Project> allProjects(int id) {
		Session session=sessionFactory.getCurrentSession();
		Query<ProjectEntity> query = session
				.createQuery("select proj from ProjectEntity  proj  join proj.team.members  mem where mem.user.idUser=?1 and proj.validity=1 ", ProjectEntity.class);
		query.setParameter(1, id);
		
		List<ProjectEntity> projects = query.list();

		List<Project> projectsPojo = new ArrayList<Project>();
		for (ProjectEntity project : projects) {

			projectsPojo.add(PROJECT_CONVERTER.fromEntityToPojo(project));
		}

		return projectsPojo;

	}

	public void addProject(Project project) {

		Session session = sessionFactory.getCurrentSession();
		session.save(PROJECT_CONVERTER.fromPojoToEntity(project));

	}

	public void removeProject(Project project) {

		Session session = sessionFactory.getCurrentSession();
		session.merge(PROJECT_CONVERTER.fromPojoToEntity(project));
	}

	public Project getProjectById(int id) {

		Session session = sessionFactory.getCurrentSession();

		ProjectEntity found = session.find(ProjectEntity.class, id);
		return PROJECT_CONVERTER.fromEntityToPojo(found);
	}

	public void editProject(Project project) {

		Session session = sessionFactory.getCurrentSession();

		session.merge(PROJECT_CONVERTER.fromPojoToEntity(project));

	}

	public List<Project> baProjects(int id) {
		Session session = sessionFactory.getCurrentSession();
		Query<ProjectEntity> query = session.createQuery

		("select proj from ProjectEntity  proj  join proj.team.members  mem where mem.user.idUser=?1 and proj.status.nameStatus=?2 and proj.validity=1",
				ProjectEntity.class);
		query.setParameter(1, id);
		query.setParameter(2, StatesEnum.BA_STATUS.getStr());
		List<ProjectEntity> baProjects = query.getResultList();
		System.out.println(baProjects);
		List<Project> baProjectsPojo = new ArrayList<Project>();
		for (ProjectEntity project : baProjects) {
			baProjectsPojo.add(PROJECT_CONVERTER.fromEntityToPojo(project));
		}
		return baProjectsPojo;

	}

	public List<Project> tlProjects(int id) {
		Session session = sessionFactory.getCurrentSession();
		Query<ProjectEntity> query = session.createQuery

		("select proj from ProjectEntity  proj  join proj.team.members  mem where mem.user.idUser=?1 and proj.validity=1",
				ProjectEntity.class);
		query.setParameter(1, id);

		List<ProjectEntity> tlProjects = query.getResultList();

		List<Project> tlProjectsPojo = new ArrayList<Project>();
		for (ProjectEntity project : tlProjects) {
			tlProjectsPojo.add(PROJECT_CONVERTER.fromEntityToPojo(project));
		}
		return tlProjectsPojo;

	}



	
	public boolean accessProject(int idUser, int idProject) {
		Session session = sessionFactory.getCurrentSession();
		Query<ProjectEntity> query = session.createQuery

		("select proj from ProjectEntity  proj  join proj.team.members  mem where mem.user.idUser=?1 and proj.validity=1 and proj.idProject=?2",
				ProjectEntity.class);
		query.setParameter(1, idUser);
		query.setParameter(2, idProject);
		try {
			 query.getSingleResult();
			 return true;
		} catch (NoResultException e) {
			return false;
		}


	}
}
