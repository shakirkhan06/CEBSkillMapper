package com.niit.CEBSkillMapperRestFEnd.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.niit.CEBSkillMapper.model.Employee;
import com.niit.CEBSkillMapper.service.EmployeeService;

@RestController
@RequestMapping("/api/emp")
@CrossOrigin(origins = "http://localhost:4200")
public class EmployeeRestController {

	@Autowired
	private EmployeeService employeeservice;

	@GetMapping
	public List<Employee> listAllEmployee() {
		List<Employee> emp = employeeservice.getAll();
		return emp;
	}

	@GetMapping("/{employeeid}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable("employeeid") int employeeid) {
		if (employeeservice.getEmployeebyId(employeeid) != null) {
			return new ResponseEntity<Employee>(employeeservice.getEmployeebyId(employeeid), HttpStatus.OK);
		} else {
			return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
		}
	}
	//@GetMapping("/del/{employeeid}")
	@DeleteMapping("/{employeeid}")
	public ResponseEntity<Void> deleteEmployeeById(@PathVariable("employeeid") int employeeid) {
		//if (employeeeervice.getEmployeebyId(employeeid) != null) {
		employeeservice.deleteService(employeeid);
			return new ResponseEntity<Void>(HttpStatus.OK);
	////	} else {
		//	return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		
	}
	@PostMapping
	public ResponseEntity<Void> addEmployee(@RequestBody Employee emp) {
		
			employeeservice.addservice(emp);
			return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
//@PutMapping("update/{employeeid}")
	@PutMapping
	public ResponseEntity<Void> updateEmployee(@RequestBody Employee emp) {
		
		if(employeeservice.getEmployeebyId(emp.getEmployeeid())!=null) {
			employeeservice.updateEmployee(emp);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		else {
			
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
	}
 }

	
	
