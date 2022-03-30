package com.lhs.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Roles {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String rolename;

//	@ManyToOne(cascade = CascadeType.MERGE)
//	List<RegistrationEntity> registerentity;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRolename() {
		return rolename;
	}

	public void setRolename(String rolename) {
		this.rolename = rolename;
	}
//
//	public List<RegistrationEntity> getRegisterentity() {
//		return registerentity;
//	}
//
//	public void setRegisterentity(List<RegistrationEntity> registerentity) {
//		this.registerentity = registerentity;
//	}

}
