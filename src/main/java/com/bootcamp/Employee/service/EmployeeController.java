package com.bootcamp.Employee.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {
    @Autowired
    public EmployeeDaoService service;

    @GetMapping("/employees")
    public List<Object[]> findEmployeeRequest(){
        return service.findEmployeeService();
    }

    @GetMapping("/employees/update")
    public void updateEmployeesAverageSalary(){
        service.updateLessThanAverage();
    }

    @DeleteMapping("/employees/del/min")
    public void deleteEmployeeRequest(){
        service.deleteEmployeeService();
    }

    @GetMapping("/employees/singh")
    public List<Object[]> findSinghEmployees(){
        return service.findSinghEmployeesService();
    }
    @DeleteMapping("/employees/age/{age}")
    public void deleteEmployeeAboveAgeRequest(@PathVariable Integer age){
        service.deleteEmployeeAboveAgeService(age);
    }
}
