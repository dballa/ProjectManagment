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
import com.ikubinfo.internship.project.pojo.Task;

@Repository
@Transactional
public class TaskDao {

	@Autowired
	private SessionFactory sessionFactory;
	private TaskConverter TASK_CONVERTER = new TaskConverter();

	public List<Task> requirmentTasks(Requirment requirment) {
		Session session = sessionFactory.getCurrentSession();
		Query<TaskEntity> query = session.createQuery("from TaskEntity task where task.requirment.idRequirment=?1",
				TaskEntity.class);
		query.setParameter(1, requirment.getIdRequirment());
		List<TaskEntity> tasks = query.getResultList();
		List<Task> tasksPojo = new ArrayList<Task>();
		for (TaskEntity task : tasks) {

			tasksPojo.add(TASK_CONVERTER.fromEntityToPojo(task));
		}

		return tasksPojo;
	}
	
	public void addTask(Task task) {
		
		Session session=sessionFactory.getCurrentSession();
		session.save(TASK_CONVERTER.fromPojoToEntity(task));
		
	}

}
