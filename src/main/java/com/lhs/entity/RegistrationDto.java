package com.lhs.entity;

import java.util.ArrayList;
import java.util.List;
import com.lhs.entity.*;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;


public class RegistrationDto {
	@NotEmpty(message = "firstname should be there")
	private String firstname;

	private String lastname;
	@NotEmpty(message = "username should be there")
	private String username;
	@Size(min = 8, message = "u must enter min 8 characters.....")
	private String password;

	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public long getMobileno() {
		return mobileno;
	}
	public void setMobileno(long mobileno) {
		this.mobileno = mobileno;
	}
	private String dob;

	private String gender;
	private long mobileno;
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	List<Roles> role=  new ArrayList<>();
	
	public List<Roles> getRole() {
		return role;
	}
	public void setRole(List<Roles> role) {
		this.role = role;
	}
	public String getRolen() {
		return rolen;
	}
	public void setRolen(String rolen) {
		this.rolen = rolen;
	}
	private String rolen;

	
}
