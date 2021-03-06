package com.bootcamp.RestFulWebServicePart1.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

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
}
