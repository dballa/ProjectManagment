package com.ikubinfo.internship.project.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the status database table.
 * 
 */
@Entity
@Table(name="status")
@NamedQuery(name="StatusEntity.findAll", query="SELECT s FROM StatusEntity s")
public class StatusEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idStatus;

	private String nameStatus;

	private byte validity;



	public StatusEntity() {
	}

	public int getIdStatus() {
		return this.idStatus;
	}

	public void setIdStatus(int idStatus) {
		this.idStatus = idStatus;
	}

	public String getNameStatus() {
		return this.nameStatus;
	}

	public void setNameStatus(String nameStatus) {
		this.nameStatus = nameStatus;
	}

	public byte getValidity() {
		return this.validity;
	}

	public void setValidity(byte validity) {
		this.validity = validity;
	}

	
	

	

	

	

	

}