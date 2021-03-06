package com.bootcamp.RestFulWebServicePart1.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeResource {

    @Autowired
    public EmployeeDaoService service;

    @GetMapping(path = "/employees")
    public List<Employee> showEmployees(){
        return service.showAllEmployee();
    }

    @GetMapping("/employees/{id}")
    public Employee getOneEmployee(@PathVariable int id){
        return service.findEmployee(id);
    }

    @PostMapping("/employees")
    public void createEmployee(@RequestBody Employee employee){
        Employee savedEmployee = service.addEmployee(employee);
    }
}
