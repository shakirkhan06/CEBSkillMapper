package com.niit.CEBSkillMapper.Dao;

import org.springframework.stereotype.Repository;

import com.niit.CEBSkillMapper.model.Employee;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("employeedao")
@Transactional
public class EmployeeDaoImpls implements EmployeeDao
{
	@Autowired
    private SessionFactory sessionFact;
	
	
	private boolean b = true;
	public boolean addEmployee(Employee emp) 
	{
		sessionFact.getCurrentSession().save(emp);
		return true;
	}


	public boolean deleteEmployee(int employeeid) 
	{
		Employee emp=getEmployeebyId(employeeid);
		if(emp!=null)
		{
			sessionFact.getCurrentSession().delete(emp);
				return true;
		}
		else
			return false;
	}

	@Override
	public Employee getEmployeebyId(int employeeid)
	{
		
		return sessionFact.getCurrentSession().get(Employee.class, employeeid);
		
	}


	@Override
	public boolean updateEmployee(Employee employee) {
		
       sessionFact.getCurrentSession().update(employee);
		
		return true;
	
	}

	
	


	@Override
	public Employee getUpdateId(int employeeid) 
	{
		// TODO Auto-generated method stub
				return sessionFact.getCurrentSession().get(Employee.class, employeeid);
		
	}


	@Override
	public List<Employee> getAll() {
		
		return (List<Employee>) sessionFact.getCurrentSession().createCriteria(Employee.class).list();
		
	}
	
	

	

	
}
