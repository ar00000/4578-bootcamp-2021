package com.bootcamp.RestFulWebServicePart1.employee;

import com.bootcamp.RestFulWebServicePart1.employee.EmployeeNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
        Employee employee = service.findEmployee(id);
        if(employee==null)
            throw new EmployeeNotFoundException("id-"+id);
        return employee;
    }

    @DeleteMapping("/employees/{id}")
    public void deleteOneEmployee(@PathVariable int id){
        Employee employee = service.deleteEmployee(id);
        if(employee==null)
            throw new EmployeeNotFoundException("id-"+id);
    }

    @PutMapping("/employees/{id}")
    public void updateOneEmployee(@PathVariable int id,@RequestBody Employee employee){
        Employee emp = service.updateEmployee(id,employee);
        if(emp==null)
            throw new EmployeeNotFoundException("id-"+id);
    }

    @PostMapping("/employees")
    public void createEmployee(@Valid @RequestBody Employee employee){
        Employee savedEmployee = service.addEmployee(employee);
    }
}
