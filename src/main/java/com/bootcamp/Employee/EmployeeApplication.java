package com.bootcamp.Employee;

import com.bootcamp.Employee.entities.Employee;
import com.bootcamp.Employee.service.EmployeeRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class EmployeeApplication {

	public static void main(String[] args) {
		ApplicationContext applicationContext =
				SpringApplication.run(EmployeeApplication.class, args);
/*
		EmployeeRepository employeeRepository=applicationContext.getBean(EmployeeRepository.class);
		employeeRepository.deleteEmployeeAboveAge(45);*/
	}

}
