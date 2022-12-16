package com.msbahrddin.springbootjunittest.service;

import org.springframework.stereotype.Service;

import com.msbahrddin.springbootjunittest.entity.Employee;
import com.msbahrddin.springbootjunittest.repository.EmployeeRepository;

@Service
public class EmployeeService {

	private EmployeeRepository employeeRepository;

	public EmployeeService(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}

	public Employee getEmployee(String email) {
		Employee emp = employeeRepository.selectByEmail(email);
		return emp;
	}

	public Employee saveEmployee(Employee emp) {
		employeeRepository.simpanEmployee(emp);
		return emp;

	}

}
