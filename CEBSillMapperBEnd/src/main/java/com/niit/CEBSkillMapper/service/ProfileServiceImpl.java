package com.niit.CEBSkillMapper.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.niit.CEBSkillMapper.Dao.ProfileDAO;
import com.niit.CEBSkillMapper.model.Profile;


@Service
public class ProfileServiceImpl implements ProfileService {

	@Autowired
	ProfileDAO profileDAO;
	
	@Override
	public boolean add(Profile profile) {
			profileDAO.add(profile);
			return true;
		}	

	@Override
	public boolean delete(int empid) {
		Profile p=findProfile(empid);
		profileDAO.delete(empid);
		
		return true;
	}

	@Override
	public boolean update(Profile profile) {
		profileDAO.update(profile);
		return true;
	}

	@Override
	public boolean profileApproval(Profile profile) 
	{
		profileDAO.profileApproval(profile);
		return true;
	}

	@Override
	public Profile findProfile(int employeeID) {
		return profileDAO.findProfile(employeeID);
	}


	@Override
	public List<Profile> PendingForApproval() {
		return profileDAO.PendingForApproval();
	}


	@Override
	public List<Profile> ListAllProfiles() {
		return profileDAO.getAllProfiles();
	}

}
