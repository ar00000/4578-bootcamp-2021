package com.bootcamp.Employee.repository;

import com.bootcamp.Employee.Employee;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface EmployeeRepository extends PagingAndSortingRepository<Employee, Long> {
    List<Employee> findByName(String name);
    List<Employee> findByNameStartingWith(String regex);

}
