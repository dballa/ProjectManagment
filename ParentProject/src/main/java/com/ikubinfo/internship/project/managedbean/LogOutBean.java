package com.ikubinfo.internship.project.managedbean;

import java.io.IOException;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@ViewScoped
public class LogOutBean {
	public void logout() {
		FacesContext context = FacesContext.getCurrentInstance();
		context.getExternalContext().invalidateSession();
		try {
			context.getExternalContext().redirect("/ProjectManagment/Login.xhtml");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
