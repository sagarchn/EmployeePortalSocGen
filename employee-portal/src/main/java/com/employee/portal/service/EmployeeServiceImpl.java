package com.employee.portal.service;

import java.util.List;
import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.portal.domain.Employee;
import com.employee.portal.exception.EmployeeException;
import com.employee.portal.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	private static final Logger LOG = LoggerFactory.getLogger(EmployeeServiceImpl.class);

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public List<Employee> getAllEmployees() {
		try {
			LOG.info("returning all employees!");
			return employeeRepository.findAllByOrderByFirstNameAsc();
		} catch (Exception e) {
			LOG.error("Error while fetching employees : {}", e.getMessage());
			throw new EmployeeException(e.getMessage());
		}
	}

	@Override
	public Employee addEmployee(Employee emp) {
		try {
			LOG.info("Saving new employee {}!", emp);
			Objects.requireNonNull(emp, "Employee cannot be null!");
			emp.validate();
			return employeeRepository.save(emp);
		} catch (Exception e) {
			LOG.error("Error while saving new Employee : {}", e.getMessage());
			throw new EmployeeException(e.getMessage());
		}
	}

}
