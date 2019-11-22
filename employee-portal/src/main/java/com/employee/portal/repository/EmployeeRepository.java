package com.employee.portal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.employee.portal.domain.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

//	@Query(value = "SELECT * FROM employee ORDER BY first_name", nativeQuery = true)
//	public List<Employee> findAll();
	
	public List<Employee> findAllByOrderByFirstNameAsc();

}
