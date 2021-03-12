package com.bootcamp.Employee.repository;

import com.bootcamp.Employee.Employee;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {
}
