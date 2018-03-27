package com.ikubinfo.internship.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ikubinfo.internship.project.dao.LoginDao;
import com.ikubinfo.internship.project.entity.PermissionEntity;
import com.ikubinfo.internship.project.pojo.User;

@Service
public class LoginService {

	@Autowired
	private LoginDao loginDao;

	public User login(User user) {

		return loginDao.login(user);

	}

	public List<PermissionEntity> findPermissions(User user) {

		return loginDao.findPermissions(user);
	}
}
