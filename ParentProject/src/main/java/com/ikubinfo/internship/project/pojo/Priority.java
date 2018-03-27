package com.ikubinfo.internship.project.pojo;

import com.ikubinfo.internship.project.entity.PriorityEntity;
import com.ikubinfo.internship.project.utils.ConverterInterface;

public class Priority  {

	private int idPriority;

	private String namePriority;

	private byte validity;

	public int getIdPriority() {
		return idPriority;
	}

	public void setIdPriority(int idPriority) {
		this.idPriority = idPriority;
	}

	public String getNamePriority() {
		return namePriority;
	}

	public void setNamePriority(String namePriority) {
		this.namePriority = namePriority;
	}

	public byte getValidity() {
		return validity;
	}

	public void setValidity(byte validity) {
		this.validity = validity;
	}

	@Override
	public String toString() {
		return "Priority [idPriority=" + idPriority + ", namePriority=" + namePriority + ", validity=" + validity + "]";
	}

}
