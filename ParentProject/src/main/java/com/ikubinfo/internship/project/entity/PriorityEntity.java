package com.ikubinfo.internship.project.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the priority database table.
 * 
 */
@Entity
@Table(name="priority")
@NamedQuery(name="PriorityEntity.findAll", query="SELECT p FROM PriorityEntity p")
public class PriorityEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idPriority;

	private String namePriority;

	private byte validity;

	

	public PriorityEntity() {
	}

	public int getIdPriority() {
		return this.idPriority;
	}

	public void setIdPriority(int idPriority) {
		this.idPriority = idPriority;
	}

	public String getNamePriority() {
		return this.namePriority;
	}

	public void setNamePriority(String namePriority) {
		this.namePriority = namePriority;
	}

	public byte getValidity() {
		return this.validity;
	}

	public void setValidity(byte validity) {
		this.validity = validity;
	}

	

	

}