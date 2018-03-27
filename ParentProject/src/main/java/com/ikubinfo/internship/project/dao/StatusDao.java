package com.ikubinfo.internship.project.dao;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ikubinfo.internship.project.converter.StatusConverter;
import com.ikubinfo.internship.project.entity.StatusEntity;
import com.ikubinfo.internship.project.pojo.Status;

@Repository
@Transactional
public class StatusDao {
	@Autowired
	private SessionFactory sessionFactory;
	private StatusConverter STATUS_CONVERTER = new StatusConverter();

	public List<Status> allStatus() {

		Query<StatusEntity> query = sessionFactory.getCurrentSession().createQuery("from StatusEntity where validity=1",
				StatusEntity.class);

		List<StatusEntity> statusList = query.list();

		List<Status> statusPojo = new ArrayList<Status>();
		for (StatusEntity status : statusList) {

			statusPojo.add(STATUS_CONVERTER.fromEntityToPojo(status));
		}

		return statusPojo;

	}

}
