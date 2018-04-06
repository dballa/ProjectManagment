package com.ikubinfo.internship.project.pojo;

public class SearchTask {
	private String name;
	private String description;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "SearchTask [name=" + name + ", description=" + description + "]";
	}
	
}
