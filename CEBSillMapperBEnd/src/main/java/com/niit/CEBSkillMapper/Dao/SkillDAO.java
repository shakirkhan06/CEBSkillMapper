package com.niit.CEBSkillMapper.Dao;

import java.util.List;

import com.niit.CEBSkillMapper.model.Skills;



public interface SkillDAO {
	public boolean add(Skills skill);
	public boolean deleteSkill(int employeeid);
	public boolean update(Skills employee);	
	public Skills getUpdateId(int employeeid);
	public Skills getEmployeebyId(int employeeid);
	List<Skills> getAllSkills();// view list of all record
	//List<Skills> SearchSkills(String keywords);
}
