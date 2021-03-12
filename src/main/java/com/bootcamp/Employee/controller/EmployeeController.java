package com.bootcamp.Employee.controller;

import com.bootcamp.Employee.Employee;
import com.bootcamp.Employee.service.EmployeDaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {
    @Autowired
    public EmployeDaoService service;

    @PostMapping("/employee")
    public void createEmployee(@RequestBody Employee employee){
        service.addEmployee(employee);
    }
}
