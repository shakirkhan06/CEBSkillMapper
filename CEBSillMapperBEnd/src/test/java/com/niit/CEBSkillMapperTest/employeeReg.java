package com.niit.CEBSkillMapperTest;


import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.context.junit4.SpringRunner;

import com.niit.CEBSkillMapper.Config.ConfigFileProject;
import com.niit.CEBSkillMapper.Dao.EmployeeDao;
import com.niit.CEBSkillMapper.model.Employee;
import com.niit.CEBSkillMapper.service.EmployeeService;

@RunWith(SpringRunner.class)
@SpringJUnitConfig(classes=ConfigFileProject.class) 

public class employeeReg {

	@Autowired
	private EmployeeService empServices;
	
	private Employee emp;
	
	@Before
	public void setUp() throws Exception {
		
		emp=new Employee();
	}

	@After
	public void tearDown() throws Exception {
		
	}

	/*@Test(expected=Exception.class)
	public void AddEmployee()
	{
	  	
		emp.setEmployeeid(111);
	  	emp.setEmployeename(null);
	  	emp.setEmail("Sundar@gmail.com");
	  	emp.setPass("sundar123");
	  	emp.setAge(30);
	  	emp.setMobile("9994438292");
	  	emp.setGender("male");
	  	emp.setQualification("BCA");
		
	  //	assertEquals("Success",true,empServices.addservice(emp));
	  	assertEquals("Inserted Successfully",true,empServices.addservice(emp));
	}*/
	/*@Test
	public void AddEmployee1()
	{
		emp.setEmployeeid(111);
	  	emp.setEmployeename("Shakir");
	  	emp.setEmail("Shakir@gmail.com");
	  	emp.setPass("shakir123");
	  	emp.setAge(35);
	  	emp.setMobile("9500839240");
	  	emp.setGender("male");
	  	emp.setQualification("Msc");
		
	  //	assertEquals("Success",true,empServices.addservice(emp));
	  	assertEquals("Inserted Successfully",true,empServices.addservice(emp));
	}
	@Test
	public void deleteData()
	{
		assertEquals("Deleted",true,empServices.deleteService(102));
	}
	
	@Test
	public void updateEmployee() 
	{
		emp=empServices.getUpdateId(115);
		emp.setEmployeename("Kumar");
		
		assertEquals("Updated Successfully",true, empServices.updateEmployee(emp));
	}
	*/
	@Test
	public void getAllEmployeeTest()
	{
		List<Employee> employeeList = new ArrayList<Employee>();
		employeeList = empServices.getAll();
		
		System.out.println("Employee Name List = "+employeeList);
		assertEquals("Success", true, employeeList.size()!=0);
		
	}
}
