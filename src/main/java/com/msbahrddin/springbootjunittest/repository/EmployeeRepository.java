package com.msbahrddin.springbootjunittest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.msbahrddin.springbootjunittest.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
	
	@Query(value = "select * from employee where email = ?1 ", nativeQuery = true)
	public Employee findByEmail(String email);
	
	public Employee selectByEmail(String email);
	
	public void simpanEmployee(Employee Employee);

}
