package com.niit.CEBSkillMapper.service;

import java.util.List;

import com.niit.CEBSkillMapper.model.Profile;



public interface ProfileService {
	boolean add(Profile profile);
	boolean delete(int EmployeeId);
	boolean update(Profile profile);
	boolean profileApproval(Profile profile );
	Profile findProfile(int EmployeeId);
	List<Profile> PendingForApproval();
	List<Profile> ListAllProfiles();
}
