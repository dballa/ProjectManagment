package com.ikubinfo.internship.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ikubinfo.internship.project.dao.StatusDao;
import com.ikubinfo.internship.project.pojo.Status;

@Service
public class StatusService {
	@Autowired
	private StatusDao statusDao;

	public List<Status> allStatus() {

		return statusDao.allStatus();

	}
}
