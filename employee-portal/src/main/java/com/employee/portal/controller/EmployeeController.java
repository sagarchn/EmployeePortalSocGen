package com.employee.portal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employee.portal.domain.Employee;
import com.employee.portal.service.EmployeeService;

@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("employee")
@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@GetMapping("all")
	public List<Employee> getAllEmployees() {
		return employeeService.getAllEmployees();
	}

	@PostMapping(value="add",consumes = "application/json")
	public Employee addEmployee(@RequestBody Employee e) {
		return employeeService.addEmployee(e);
	}

}
