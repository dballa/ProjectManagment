package com.ikubinfo.internship.project.utils;

public enum StatesEnum {
	BA_STATUS("Waiting BA"),
	IN_PROGRESS_STATUS("In Progress"),
	ASSIGNED_STATUS("Assigned"),
	DONE_STATUS("Done");
	private String str;
	StatesEnum(String constantStr){
		this.str=constantStr;
	}
	public String getStr() {
		return str;
	}
}
