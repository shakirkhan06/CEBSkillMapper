package com.niit.CEBSkillMapper.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name="ProfileMaster")
public class Profile {
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Id
	private int profileId;
	private int employeeId;	
	private String qualification;
	private String supervisorname;
	private int profileviews;
	private int profilestatus;
	
	public Profile() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getProfileId() {
		return profileId;
	}
	public void setProfileId(int profileId) {
		this.profileId = profileId;
	}
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public String getQualification() {
		return qualification;
	}
	public void setQualification(String qualification) {
		this.qualification = qualification;
	}
	public String getSupervisorname() {
		return supervisorname;
	}
	public void setSupervisorname(String supervisorname) {
		this.supervisorname = supervisorname;
	}
	public int getProfileviews() {
		return profileviews;
	}
	public void setProfileviews(int profileviews) {
		this.profileviews = profileviews;
	}
	public int getProfilestatus() {
		return profilestatus;
	}
	public void setProfilestatus(int profilestatus) {
		this.profilestatus = profilestatus;
	}
	public Profile(int profileId, int employeeId, String qualification,
			String supervisorname, int profileviews, int profilestatus) {
		super();
		this.profileId = profileId;
		this.employeeId = employeeId;
		this.qualification = qualification;
		this.supervisorname = supervisorname;
		this.profileviews = profileviews;
		this.profilestatus = profilestatus;
	}
	
	

}
