package com.employee.portal;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.employee.portal.domain.Employee;
import com.employee.portal.exception.EmployeeException;
import com.employee.portal.service.EmployeeService;

@RunWith(SpringRunner.class)
@SpringBootTest
class EmployeePortalApplicationTests {

	@Autowired
	EmployeeService es;

	@Test
	public void checkRecords() {
		assertEquals(2, es.getAllEmployees().size());
	}

	@Test(expected = EmployeeException.class)
	public void addEmployeeTest() {
		assertEquals(2, es.addEmployee(new Employee()));
	}

}
