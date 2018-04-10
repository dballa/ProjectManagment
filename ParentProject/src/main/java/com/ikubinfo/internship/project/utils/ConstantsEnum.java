package com.ikubinfo.internship.project.utils;

public enum ConstantsEnum {
	BA_STATUS("Waiting BA");

	private String str;
	ConstantsEnum(String constantStr){
		this.str=constantStr;
	}
	public String getStr() {
		return str;
	}
}
