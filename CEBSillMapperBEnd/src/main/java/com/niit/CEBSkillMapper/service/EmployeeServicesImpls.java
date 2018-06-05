package com.niit.CEBSkillMapper.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.niit.CEBSkillMapper.Dao.EmployeeDao;
import com.niit.CEBSkillMapper.model.Employee;


@Service
public class EmployeeServicesImpls implements EmployeeService
{
 
	@Autowired
	private EmployeeDao employeedao;
	
	public boolean addservice(Employee emp) {
		
		return (employeedao.addEmployee(emp));	
			
		
	}

	@Override
	public boolean deleteService(int employeeid) {

		
			return (employeedao.deleteEmployee(employeeid));
		
	}

	

	

	@Override
	public boolean updateEmployee(Employee employeeid) {
		
		return(employeedao.updateEmployee(employeeid));
		
	}

	@Override
	public Employee getUpdateId(int employeeid) 
	{
	   return(employeedao.getUpdateId(employeeid));
		
	}

	@Override
	public List<Employee> getAll() {
		
		return(employeedao.getAll());
		
	}

	@Override
	public Employee getEmployeebyId(int employeeid) 
	{
		 return(employeedao.getEmployeebyId(employeeid));
	}
	

	

	

	

	

}
