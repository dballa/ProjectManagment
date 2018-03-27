package com.ikubinfo.internship.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ikubinfo.internship.project.dao.UserDao;
import com.ikubinfo.internship.project.pojo.Team;
import com.ikubinfo.internship.project.pojo.User;

@Service
public class UserService {

	@Autowired
	private UserDao userDao;

	public List<User> allUsers() {

		return userDao.allUsers();

	}
	
	public List<User> devToAsignTask (Team team){
		
		return userDao.devToAsignTask(team);
		
	}
	
}
