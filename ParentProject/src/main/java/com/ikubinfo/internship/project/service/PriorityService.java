package com.ikubinfo.internship.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ikubinfo.internship.project.dao.PriorityDao;
import com.ikubinfo.internship.project.pojo.Priority;

@Service
public class PriorityService {

	@Autowired
	private PriorityDao priorityDao;

	public List<Priority> allPriority() {

		return priorityDao.allPriority();
	}
}
