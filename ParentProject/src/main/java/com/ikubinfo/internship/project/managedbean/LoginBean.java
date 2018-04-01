package com.ikubinfo.internship.project.managedbean;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import com.ikubinfo.internship.project.entity.PermissionEntity;
import com.ikubinfo.internship.project.pojo.User;
import com.ikubinfo.internship.project.service.LoginService;

@ManagedBean
@RequestScoped
public class LoginBean {

	private User user;

	private List<PermissionEntity> permissionList;

	@ManagedProperty(value = "#{loginService}")
	private LoginService loginService;

	@PostConstruct
	public void init() {
		user = new User();
		// foundUser=new User();
		permissionList = new ArrayList<PermissionEntity>();
	}

	public void login() throws IOException {

		user = loginService.login(user);

		FacesContext context = FacesContext.getCurrentInstance();

		if (user == null) {

			context.addMessage(null, new FacesMessage("Wrong Email or Password"));
		}

		else {
			context.getExternalContext().getSessionMap().put("userId", user.getIdUser());
			context.getExternalContext().getSessionMap().put("userName", user.getNameUser());
			context.getExternalContext().getSessionMap().put("userRole", user.getRole().getNameRole());
			context.getExternalContext().getSessionMap().put("userPermissions", loginService.findPermissions(user));

			if (user.getRole().getNameRole().equals("Project Manager")) {

				context.getExternalContext().redirect("ProjectManager/ProjectManager.xhtml");
			} else if (user.getRole().getNameRole().equals("Team Leader")) {

				context.getExternalContext().redirect("TeamLeader/TeamLeader.xhtml");
			} else if (user.getRole().getNameRole().equals("Developer")) {

				context.getExternalContext().redirect("Developer/Developer.xhtml");
			} else if (user.getRole().getNameRole().equals("Business Analyst")) {

				context.getExternalContext().redirect("BusinessAnalyst/BusinessAnalyst.xhtml");
			}

		}

	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public LoginService getLoginService() {
		return loginService;
	}

	public void setLoginService(LoginService loginService) {
		this.loginService = loginService;
	}

	public User getFoundUser() {
		return user;
	}

	public void setFoundUser(User foundUser) {
		this.user = foundUser;
	}

	public List<PermissionEntity> getPermissionList() {
		return permissionList;
	}

	public void setPermissionList(List<PermissionEntity> permissionList) {
		this.permissionList = permissionList;
	}
}