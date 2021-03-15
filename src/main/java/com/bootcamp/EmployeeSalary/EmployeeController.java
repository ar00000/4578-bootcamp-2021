package com.bootcamp.EmployeeSalary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {
    @Autowired
    public EmployeeService service;

    @PostMapping("/employees")
    public void createEmployeeRequest(@RequestBody Employee employee){
        service.createEmployee(employee);
    }
}
