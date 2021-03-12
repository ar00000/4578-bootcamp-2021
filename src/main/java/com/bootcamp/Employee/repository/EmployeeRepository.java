package com.bootcamp.Employee.repository;

import com.bootcamp.Employee.Employee;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface EmployeeRepository extends PagingAndSortingRepository<Employee, Long> {
}
