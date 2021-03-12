package com.bootcamp.Employee.controller;

import com.bootcamp.Employee.Employee;
import com.bootcamp.Employee.controller.exception.EmployeeNotFoundException;
import com.bootcamp.Employee.service.EmployeDaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class EmployeeController {
    @Autowired
    public EmployeDaoService service;

    @PostMapping("/employee")
    public void createEmployeeRequest(@RequestBody Employee employee){
        service.addEmployee(employee);
    }

    @PutMapping("/employee/{id}")
    public Employee updateEmployeeRequest(@PathVariable long id,@RequestBody Employee employee){
        Employee employee1 = service.updateEmployee(id,employee);
        return employee1;
    }

    @DeleteMapping("/employee/{id}")
    public Employee deleteEmployeeRequest(@PathVariable long id){
        return service.deleteEmployee(id);
    }

    @GetMapping("/employee/{id}")
    public Employee retrieveEmployeeRequest(@PathVariable long id){
        Employee employee = service.retrieveEmployee(id);
        if(employee==null)
            throw new EmployeeNotFoundException("Employee not exist");
        return employee;
    }

}
