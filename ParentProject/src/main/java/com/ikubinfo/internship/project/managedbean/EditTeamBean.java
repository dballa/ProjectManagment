package com.ikubinfo.internship.project.managedbean;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.model.DualListModel;

import com.ikubinfo.internship.project.pojo.Member;
import com.ikubinfo.internship.project.pojo.MemberPK;
import com.ikubinfo.internship.project.pojo.Team;
import com.ikubinfo.internship.project.pojo.User;
import com.ikubinfo.internship.project.service.TeamService;
import com.ikubinfo.internship.project.service.UserService;
import com.ikubinfo.internship.project.utils.RedirectUtils;

@ManagedBean
@ViewScoped
public class EditTeamBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Team toEdit;
	private static final String NOT_FOUND = "/PageNotFound.xhtml";
	private static final String TO_TEAMS="/ProjectManager/Team.xhtml";
	private int toEditId;
	private List<User> notMembersOfThisTeam;
	private List<User> membersOfTeam;
	private String id;

	private DualListModel<User> members;

	@ManagedProperty(value = "#{userService}")
	private UserService userService;
	@ManagedProperty(value = "#{teamService}")
	private TeamService teamService;

	@PostConstruct
	public void init() {

		
	}
	
	
	
	public void allowedTeam() throws IOException {

		try {
			toEditId = Integer.parseInt(id);
			if (isAllowedToContinue(toEditId)) {
			
				toEdit = teamService.getTeamById(toEditId);
				membersOfTeam = teamService.teamInfo(toEdit);
				notMembersOfThisTeam = teamService.notMembersOfThisTeam(toEdit);
				members = new DualListModel<User>(notMembersOfThisTeam, membersOfTeam);
			} else {
				RedirectUtils.redirectTo(NOT_FOUND);
			}

		} catch (Exception ex) {
			RedirectUtils.redirectTo(NOT_FOUND);
		}

	}
	
	private boolean isAllowedToContinue(int id) {
		return teamService.accessTeam(id);

	}

	

	public void editTeam() throws IOException {

		toEdit.getMembers().clear();
		
		if (checkTargetList()) {
		
		
		for (User user : members.getTarget()) {

			Member member = new Member();
			member.setUser(user);

			member.setTeam(toEdit);
			MemberPK memberPk = new MemberPK();
			memberPk.setIdTeam(toEditId);
			memberPk.setMember(user.getIdUser());
			member.setId(memberPk);
			member.setValidity((byte) 1);
			toEdit.getMembers().add(member);

		}
		teamService.deleteMembersOfTeam(toEdit);
		teamService.editTeam(toEdit);
		
		RedirectUtils.redirectTo(TO_TEAMS);
		}
		else {
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null, new FacesMessage("Error, Team should have 1 Project Manager,1 Team Leader and 1 Business Analyst"));
		}
	}
	public boolean checkTargetList() {
		int pm=0;
		int tl=0;
		int ba=0;
		for(User user: members.getTarget()) {
			if (user.getRole().getNameRole().equals("Project Manager")) {
				pm++;
			}
			if (user.getRole().getNameRole().equals("Team Leader")) {
				tl++;
			}
			if(user.getRole().getNameRole().equals("Business Analyst")) {
				ba++;
			}
			
		}
		if(pm==1&&tl==1&&ba==1) {
			return true;
		}
		else return false;
	}
	
	public void redirectToTeams() throws IOException {
		RedirectUtils.redirectTo(TO_TEAMS);
	}
	

	public Team getToEdit() {
		return toEdit;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setToEdit(Team toEdit) {
		this.toEdit = toEdit;
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

	public List<User> getNotMembersOfThisTeam() {
		return notMembersOfThisTeam;
	}

	public List<User> getMembersOfTeam() {
		return membersOfTeam;
	}

	public void setNotMembersOfThisTeam(List<User> notMembersOfThisTeam) {
		this.notMembersOfThisTeam = notMembersOfThisTeam;
	}

	public void setMembersOfTeam(List<User> membersOfTeam) {
		this.membersOfTeam = membersOfTeam;
	}

	public DualListModel<User> getMembers() {
		return members;
	}

	public void setMembers(DualListModel<User> members) {
		this.members = members;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}
