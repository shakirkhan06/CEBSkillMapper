package com.niit.CEBSkillMapperFEnd.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.niit.CEBSkillMapper.model.Employee;
import com.niit.CEBSkillMapper.service.EmployeeService;

@Controller
public class EmployeeController {

	@Autowired
	private EmployeeService serveobj;

	private Employee employees;// model

	@GetMapping("/")
	public String addEmployee(Model model) {
		model.addAttribute("employees", new Employee());
		model.addAttribute("list", serveobj.getAll());
		return "employee";// viewpage
	}

	@PostMapping("/employee/add") // view page mapping
	public String addBook(@ModelAttribute("employees") Employee employees)// model
	{

		if (employees.getEmployeeid() != 0) {
			serveobj.addservice(employees);
		}

		return "redirect:/"; // to redirect to root element which calls mapping "/ "
	}

	@GetMapping("/remove/{employeeid}")
	public String removeEmloyee(@PathVariable("employeeid") int employeeid)
	{

		serveobj.deleteService(employeeid);
		return "redirect:/";
	}

	@PostMapping("/employee/modify") // view page mapping
	public String modifyEmployee(@ModelAttribute("employees") Employee employees)// model
	{

		if (employees.getEmployeeid() != 0) {
			serveobj.updateEmployee(employees);
		}

		return "redirect:/"; // to redirect to root element which calls mapping "/ "
	}

	@GetMapping("/edit/{employeeid}")
	public String editEmployee(@PathVariable("employeeid") int id, Model model) {
		model.addAttribute("employees", serveobj.getEmployeebyId(id));
		//model.addAttribute("employees", serveobj.getAll());
		return "employeeList";
	}

}
