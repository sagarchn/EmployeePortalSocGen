package com.employee.portal.service;

import java.util.List;

import com.employee.portal.domain.Employee;

public interface EmployeeService {

	/**
	 * method to get all employees
	 * 
	 * @return List of employees
	 * @author sagar
	 */
	List<Employee> getAllEmployees();

	/**
	 * method to add new employee
	 * 
	 * @param e
	 * @return Employee
	 * 
	 * @author sagar
	 */
	Employee addEmployee(Employee e);

}
