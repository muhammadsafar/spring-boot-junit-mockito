package com.msbahrddin.springbootjunittest.mocking;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.Extensions;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.msbahrddin.springbootjunittest.entity.Employee;
import com.msbahrddin.springbootjunittest.repository.EmployeeRepository;
import com.msbahrddin.springbootjunittest.service.EmployeeService;

@Extensions({ @ExtendWith(MockitoExtension.class) })
public class MockitoJPA {

	@Mock
	private EmployeeRepository employeeRepository;

	private EmployeeService employeeService;

	@BeforeEach
	void setup() {
		employeeService = new EmployeeService(employeeRepository);
	}

	@Test
	void testEmployeeNotFound() {
		String email = "muhammad.ict1487@gmail.com";

		Mockito.when(employeeRepository.selectByEmail(email))
				.thenReturn(new Employee(1, "Muhammad Safar", "Baharuddin", email));

		Employee emMock = employeeService.getEmployee(email);

		Assertions.assertNotNull(emMock);
		assertThat(emMock.getFirstName()).isEqualTo("Muhammad Safar");

	}
	
	@Test
	@DisplayName("test create employee")
	void saveEmployeeTest() {
		
		Employee emlm = employeeService.saveEmployee(new Employee(1, "Abdullah", "Syakir", "abdullah.syakir@mail.com"));
		
		Assertions.assertEquals("Abdullah", emlm.getFirstName());
		Assertions.assertEquals(1, emlm.getId());
		assertThat(emlm.getId()).isGreaterThan(0);
		
		Mockito.verify(employeeRepository, Mockito.times(1)).simpanEmployee(emlm);
		
		
	}

}
