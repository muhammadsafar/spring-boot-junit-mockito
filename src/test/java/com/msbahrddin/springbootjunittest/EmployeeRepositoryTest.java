package com.msbahrddin.springbootjunittest;

import java.util.ArrayList;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.msbahrddin.springbootjunittest.entity.Employee;
import com.msbahrddin.springbootjunittest.repository.EmployeeRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class EmployeeRepositoryTest {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Test
	@Disabled
	@Order(1)
	public void saveEmployeeTest() {

		Employee employee = new Employee();
		employee.setFirstName("Muhammad");
		employee.setLastName("Safar");
		employee.setEmail("muhammad.ict1487@gmail.com");
		employeeRepository.save(employee);

		// id > 0
		Assertions.assertThat(employee.getId()).isGreaterThan(0);

	}

	@Test
	@Order(2)
	void getEmployee() {
		Employee empl = employeeRepository.findById(2L).get();
		Assertions.assertThat(empl.getId()).isEqualTo(2L);
	}

	@Test
	@Order(3)
	void getListEmployee() {
		ArrayList<Employee> datas = new ArrayList<>();
		datas.addAll(employeeRepository.findAll());

		Assertions.assertThat(datas).isNotEmpty();

	}

	@Test
	@Order(4)
	void updateEmployeeTest() {
		Employee emp = employeeRepository.findById(2L).get();

		String emil_update = "muhammad@pln.co.id";

		emp.setEmail(emil_update);
		Employee emplUp = employeeRepository.save(emp);

		Assertions.assertThat(emplUp.getEmail()).isEqualTo(emil_update);

	}

	@Test
	@Order(4)
	void deleteEmployeeTest() {
		Employee emp = employeeRepository.findById(2L).get();

		employeeRepository.delete(emp);

		emp = null;

		Assertions.assertThat(emp).isNull();
	}

	@Test
	@Order(5)
	void itShouldFindEmployeeByEmail() {
		String email = "muhammad.ict1487@gmail.com";

		Employee emp = employeeRepository.findByEmail(email);
		Assertions.assertThat(emp.getEmail()).isEqualTo(email);
	}

}
