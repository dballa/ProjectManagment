package com.ikubinfo.internship.project.dao;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ikubinfo.internship.project.converter.RequirmentConverter;
import com.ikubinfo.internship.project.entity.RequirmentEntity;
import com.ikubinfo.internship.project.pojo.Requirment;

@Repository
@Transactional
public class RequirmentDao {

	@Autowired
	private SessionFactory sessionFactory;

	private RequirmentConverter REQUIRMENT_CONVERTER = new RequirmentConverter();

	public List<Requirment> requirmentOfProject(int idProject) {
		Session session = sessionFactory.getCurrentSession();

		Query<RequirmentEntity> query = session.createQuery("from RequirmentEntity where project.idProject=?1",
				RequirmentEntity.class);
		query.setParameter(1, idProject);
		List<RequirmentEntity> reqOfProject = query.getResultList();
		List<Requirment> reqPojo = new ArrayList<Requirment>();
		for (RequirmentEntity req : reqOfProject) {

			reqPojo.add(REQUIRMENT_CONVERTER.fromEntityToPojo(req));
		}

		return reqPojo;

	}

	public void addRequirment(Requirment requirment) {
		Session session = sessionFactory.getCurrentSession();
		System.out.println(requirment);
		session.save(REQUIRMENT_CONVERTER.fromPojoToEntity(requirment));

	}

}
