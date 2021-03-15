package com.bootcamp.EmployeeSalary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EmployeeService {
    @Autowired
    public EmployeeRepository repository;

    public void createEmployee(Employee emp){
        Employee employee=new Employee();

        employee.setId(emp.getId());
        employee.setFirstName(emp.getFirstName());
        employee.setLastName(emp.getLastName());
        employee.setAge(emp.getAge());

        Salary salary= new Salary();
        salary.setBasicSalary(emp.getSalary().getBasicSalary());
        salary.setBonusSalary(emp.getSalary().getBonusSalary());
        salary.setSpecialAllowanceSalary(emp.getSalary().getSpecialAllowanceSalary());
        salary.setTaxAmount(emp.getSalary().getTaxAmount());

        employee.setSalary(salary);
        repository.save(employee);

        System.out.println(emp.getSalary().toString());


    }
}
