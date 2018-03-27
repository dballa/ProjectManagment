package com.ikubinfo.internship.project.managedbean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.context.ExternalContext;

import com.ikubinfo.internship.project.pojo.Team;
import com.ikubinfo.internship.project.pojo.User;
import com.ikubinfo.internship.project.service.TeamService;
import com.ikubinfo.internship.project.service.UserService;

@ManagedBean
@ViewScoped
public class EditTeamBean {
	private Team toEdit;
	private List<User> userPm = new ArrayList<User>();
	private List<User> userTl = new ArrayList<User>();
	private List<User> userDev = new ArrayList<User>();
	private List<User> allUser = new ArrayList<User>();
	private List<User> userBa = new ArrayList<User>();

	private List<User> selectedDev = new ArrayList<User>();
	private int toEditId;
	@ManagedProperty(value = "#{userService}")
	private UserService userService;
	@ManagedProperty(value = "#{teamService}")
	private TeamService teamService;

	@PostConstruct
	public void init() {
		String id = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("id");

		toEditId = Integer.parseInt(id);
		System.out.println(toEditId);
		toEdit = teamService.getTeamById(toEditId);
		allUser = userService.allUsers();

		for (User user : allUser) {
			if (user.getRole().getNameRole().equals("Project Manager")) {

				userPm.add(user);
			} else if (user.getRole().getNameRole().equals("Team Lider")) {
				userTl.add(user);
			} else if (user.getRole().getNameRole().equals("Developer")) {
				userDev.add(user);
			} else if (user.getRole().getNameRole().equals("Business Analyst")) {
				userBa.add(user);
			}

		}

		System.out.println(userPm);
		System.out.println(userDev);
		System.out.println(userBa);
		System.out.println(userTl);
	}

	public Team getToEdit() {
		return toEdit;
	}

	public List<User> getUserPm() {
		return userPm;
	}

	public List<User> getUserTl() {
		return userTl;
	}

	public List<User> getUserDev() {
		return userDev;
	}

	public List<User> getAllUser() {
		return allUser;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setToEdit(Team toEdit) {
		this.toEdit = toEdit;
	}

	public void setUserPm(List<User> userPm) {
		this.userPm = userPm;
	}

	public void setUserTl(List<User> userTl) {
		this.userTl = userTl;
	}

	public void setUserDev(List<User> userDev) {
		this.userDev = userDev;
	}

	public void setAllUser(List<User> allUser) {
		this.allUser = allUser;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public TeamService getTeamService() {
		return teamService;
	}

	public void setTeamService(TeamService teamService) {
		this.teamService = teamService;
	}

	public int getToEditId() {
		return toEditId;
	}

	public void setToEditId(int toEditId) {
		this.toEditId = toEditId;
	}

	public List<User> getUserBa() {
		return userBa;
	}

	public void setUserBa(List<User> userBa) {
		this.userBa = userBa;
	}

	public List<User> getSelectedDev() {
		return selectedDev;
	}

	public void setSelectedDev(List<User> selectedDev) {
		this.selectedDev = selectedDev;
	}

}
