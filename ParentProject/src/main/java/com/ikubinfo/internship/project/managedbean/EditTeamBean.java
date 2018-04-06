package com.ikubinfo.internship.project.managedbean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import com.ikubinfo.internship.project.pojo.Member;
import com.ikubinfo.internship.project.pojo.MemberPK;
import com.ikubinfo.internship.project.pojo.Team;
import com.ikubinfo.internship.project.pojo.User;
import com.ikubinfo.internship.project.service.TeamService;
import com.ikubinfo.internship.project.service.UserService;

@ManagedBean
@ViewScoped
public class EditTeamBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Team toEdit;
	private List<User> userPm = new ArrayList<User>();
	private List<User> userTl = new ArrayList<User>();
	private List<User> userDev = new ArrayList<User>();
	private List<User> allUser = new ArrayList<User>();
	private List<User> userBa = new ArrayList<User>();
	private List<User> selectedDev = new ArrayList<User>();
	private int toEditId;
	private User projectManager;
	private User businessAnalyst;
	private User teamLeader;
	private Member member = new Member();
	private MemberPK memberPk = new MemberPK();

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
			} else if (user.getRole().getNameRole().equals("Team Leader")) {
				userTl.add(user);
			} else if (user.getRole().getNameRole().equals("Developer")) {
				userDev.add(user);
			} else if (user.getRole().getNameRole().equals("Business Analyst")) {
				userBa.add(user);
			}

		}

	}

	public void editTeam() {

		teamService.editTeam(projectManager, toEdit, member, memberPk);
		

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

	public User getProjectManager() {
		return projectManager;
	}

	public User getBusinessAnalyst() {
		return businessAnalyst;
	}

	public User getTeamLeader() {
		return teamLeader;
	}

	public void setProjectManager(User projectManager) {
		this.projectManager = projectManager;
	}

	public void setBusinessAnalyst(User businessAnalyst) {
		this.businessAnalyst = businessAnalyst;
	}

	public void setTeamLeader(User teamLeader) {
		this.teamLeader = teamLeader;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public MemberPK getMemberPk() {
		return memberPk;
	}

	public void setMemberPk(MemberPK memberPk) {
		this.memberPk = memberPk;
	}

}
