package com.ikubinfo.internship.project.dao;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ikubinfo.internship.project.converter.TaskConverter;
import com.ikubinfo.internship.project.entity.TaskEntity;
import com.ikubinfo.internship.project.pojo.Requirment;
import com.ikubinfo.internship.project.pojo.SearchTask;
import com.ikubinfo.internship.project.pojo.Task;

@Repository
@Transactional
public class TaskDao {

	@Autowired
	private SessionFactory sessionFactory;
	private TaskConverter TASK_CONVERTER = new TaskConverter();

	public List<Task> requirmentTasks(int idReq) {
		Session session = sessionFactory.getCurrentSession();
		Query<TaskEntity> query = session.createQuery(
				"from TaskEntity task where task.requirment.idRequirment=?1 and task.validity=1", TaskEntity.class);
		query.setParameter(1, idReq);
		List<TaskEntity> tasks = query.getResultList();
		List<Task> tasksPojo = new ArrayList<Task>();
		for (TaskEntity task : tasks) {

			tasksPojo.add(TASK_CONVERTER.fromEntityToPojo(task));
		}

		return tasksPojo;
	}

	public void addTask(Task task) {

		Session session = sessionFactory.getCurrentSession();
		session.save(TASK_CONVERTER.fromPojoToEntity(task));

	}

	public void removeTask(Task task) {

		Session session = sessionFactory.getCurrentSession();
		session.merge(TASK_CONVERTER.fromPojoToEntity(task));
	}

	public void editTask(Task task) {
		Session session = sessionFactory.getCurrentSession();
		session.merge(TASK_CONVERTER.fromPojoToEntity(task));

	}

	public List<Task> getTasksOfDeveloper(int idProject, int idUser) {
		Session session = sessionFactory.getCurrentSession();
		Query<TaskEntity> query = session.createQuery(
				"from TaskEntity task where task.requirment.project.idProject=?1 and task.assignedTo.idUser=?2 and task.validity=1 ",
				TaskEntity.class);
		query.setParameter(1, idProject);
		query.setParameter(2, idUser);
		List<TaskEntity> tasks = query.getResultList();
		List<Task> taskPojo = new ArrayList<Task>();
		for (TaskEntity task : tasks) {

			taskPojo.add(TASK_CONVERTER.fromEntityToPojo(task));
		}

		return taskPojo;
	}

	public List<Task> searchTask(SearchTask filter, int idProject, int idUser) {

		System.out.println(filter);
		Session session = sessionFactory.getCurrentSession();

		String queryString = "select task from TaskEntity task where task.requirment.project.idProject=?1 and task.assignedTo.idUser=?2 and task.validity=1 ";

		if (filter.getName() != null && !filter.getName().equals("")) {

			queryString = queryString.concat(" and lower(task.nameTask) like lower(?3) ");
		}

		if (filter.getDescription() != null && !filter.getDescription().equals("")) {

			queryString = queryString.concat(" and lower(task.description) like lower (?4) ");

		}

		Query<TaskEntity> query = session.createQuery(queryString, TaskEntity.class);

		query.setParameter(1, idProject);
		query.setParameter(2, idUser);
		if (filter.getName() != null && !filter.getName().equals("")) {

			query.setParameter(3, "%" + filter.getName() + "%");
		}

		if (filter.getDescription() != null && !filter.getDescription().equals("")) {

			query.setParameter(4, "%" + filter.getDescription() + "%");

		}

		List<TaskEntity> listOfEntity = query.getResultList();
		
		List<Task> toReturn = new ArrayList<Task>();
		for (TaskEntity task : listOfEntity) {

			toReturn.add(TASK_CONVERTER.fromEntityToPojo(task));
		}
		System.out.println(toReturn);
		return toReturn;
	}

}
