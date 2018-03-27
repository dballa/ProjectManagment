package com.ikubinfo.internship.project.dao;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ikubinfo.internship.project.converter.PriorityConverter;
import com.ikubinfo.internship.project.entity.PriorityEntity;
import com.ikubinfo.internship.project.pojo.Priority;

@Repository
@Transactional
public class PriorityDao {

	@Autowired
	private SessionFactory sessionFactory;
	private PriorityConverter PRIORITY_CONVERTER = new PriorityConverter();

	public List<Priority> allPriority() {
		Session session = sessionFactory.getCurrentSession();
		Query<PriorityEntity> query = session.createQuery("from PriorityEntity where validity=1", PriorityEntity.class);
		List<PriorityEntity> priorityEntity = query.getResultList();
		List<Priority> priorityPojo = new ArrayList<Priority>();
		for (PriorityEntity pri : priorityEntity) {

			priorityPojo.add(PRIORITY_CONVERTER.fromEntityToPojo(pri));
		}
		return priorityPojo;
	}
}
