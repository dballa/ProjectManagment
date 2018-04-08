package com.ikubinfo.internship.project.managedbean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import com.ikubinfo.internship.project.pojo.Permission;
import com.ikubinfo.internship.project.pojo.Project;
import com.ikubinfo.internship.project.pojo.User;

@ManagedBean
@SessionScoped
public class UserSessionBean {
	private String userName;
	private List<Permission> userPermission = new ArrayList<Permission>();
	private Project currentProject;
	private int userId;
	private User user;
	@PostConstruct
	public void init() {
		FacesContext context = FacesContext.getCurrentInstance();
		userName = (String) context.getExternalContext().getSessionMap().get("userName");
		userPermission = (List<Permission>) context.getExternalContext().getSessionMap().get("userPermissions");
		userId=(int) context.getExternalContext().getSessionMap().get("userId");
		user=(User) context.getExternalContext().getSessionMap().get("user");
		
	}

	public String getUserName() {
		return userName;
	}

	public List<Permission> getUserPermission() {
		return userPermission;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Project getCurrentProject() {
		return currentProject;
	}

	public void setCurrentProject(Project currentProject) {
		this.currentProject = currentProject;
	}

	public void setUserPermission(List<Permission> userPermission) {
		this.userPermission = userPermission;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
