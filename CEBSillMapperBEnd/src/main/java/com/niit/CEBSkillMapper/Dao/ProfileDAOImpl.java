package com.niit.CEBSkillMapper.Dao;

import java.util.List;
import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.CEBSkillMapper.model.Profile;

@Repository("profileDAO")
@Transactional
public class ProfileDAOImpl implements ProfileDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override	
	public boolean add(Profile profile) {
		sessionFactory.getCurrentSession().save(profile);
		return true;
	}

	@Override
	public boolean delete(int empId) {
		sessionFactory.getCurrentSession().delete(empId);
		return true;
	}

	@Override
	public boolean update(Profile profile) {
		sessionFactory.getCurrentSession().update(profile);
		return true;
	}

	@Override
	public boolean profileApproval(Profile profile) {
		profile.setProfilestatus(1);
		sessionFactory.getCurrentSession().update(profile);
		return true;
	}

	
	@Override
	public List<Profile> getAllProfiles() {
		return sessionFactory.getCurrentSession().createQuery("from ProfileMaster").list();
	}

	
	//working
	@Override
	public Profile findProfile(int employeeId) {
			Profile p= (Profile)sessionFactory.getCurrentSession()
				.createQuery("from ProfileMaster where employeeId="+employeeId).uniqueResult();	
			p.setProfileviews(p.getProfileviews()+1);
			return p;
	}

	@Override
	public List<Profile> PendingForApproval() {
		return sessionFactory.getCurrentSession().createQuery("from ProfileMaster where profileSelected=0").list();
	}

	
	@Override
	public List<Profile> ListAllProfiles() {
		return sessionFactory.getCurrentSession().createQuery("from ProfileMaster").list();
	}


}
