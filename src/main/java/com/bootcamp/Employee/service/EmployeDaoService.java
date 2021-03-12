package com.bootcamp.Employee.service;

import com.bootcamp.Employee.Employee;
import com.bootcamp.Employee.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EmployeDaoService {
    @Autowired
    public EmployeeRepository repository;
    public static Long idCounter=0l;

    public void addEmployee(Employee newEmployee){
        Employee employee = new Employee();
        if(newEmployee.getId()==null)
            employee.setId(++idCounter);
        else
            employee.setId(newEmployee.getId());
        employee.setName(newEmployee.getName());
        employee.setAge(newEmployee.getAge());
        employee.setLocation(newEmployee.getLocation());
        repository.save(employee);
    }
}
