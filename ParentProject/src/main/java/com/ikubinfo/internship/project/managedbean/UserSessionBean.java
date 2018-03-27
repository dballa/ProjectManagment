package com.ikubinfo.internship.project.managedbean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import com.ikubinfo.internship.project.pojo.Permission;

@ManagedBean
@SessionScoped
public class UserSessionBean {
	private String userName;
	private List<Permission> userPermission = new ArrayList<Permission>();

	@PostConstruct
	public void init() {
		FacesContext context = FacesContext.getCurrentInstance();
		userName = (String) context.getExternalContext().getSessionMap().get("userName");
		userPermission = (List<Permission>) context.getExternalContext().getSessionMap().get("userPermissions");
		System.out.println(userPermission);
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

	public void setUserPermission(List<Permission> userPermission) {
		this.userPermission = userPermission;
	}
}
