package com.employee.portal;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.employee.portal.domain.Employee;
import com.employee.portal.repository.EmployeeRepository;
import com.employee.portal.service.EmployeeService;
import com.employee.portal.service.EmployeeServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class EmployeePortalMockitoTest {

	@InjectMocks
	EmployeeService es=new EmployeeServiceImpl();
	
	@Mock
	EmployeeRepository e;
	
	@Test
	public void getAllRecords() {
		List<Employee>ess=new ArrayList<>();
		ess.add(new Employee());
		when(es.getAllEmployees()).thenReturn(ess);
		
		assertEquals(1, es.getAllEmployees().size());
	}
	
	
	
}
