package com.bootcamp.Employee.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;

@Component
public class EmployeeDaoService {

    @Autowired
    public EmployeeRepository repository;

    //Display the first name, last name of all employees having salary greater than average salary ordered in ascending by their age and in descending by their salary.
    List<Object[]> findEmployeeService(){
        return repository.findEmployees();
    }


    //Update salary of all employees by a salary passed as a parameter whose existing salary is less than the average salary.
    @Transactional
    void updateLessThanAverage(){
        repository.updateSalaryLessThanAverage(repository.averageSalary(),
                repository.averageSalary());
    }

    //Delete all employees with minimum salary.
    @Transactional
    void deleteEmployeeService(){
        repository.deleteEmployees(repository.minimumAge());
    }

    ////Q:1Display the id, first name, age of all employees where last name ends with "singh"
    List<Object[]> findSinghEmployeesService(){
        return repository.findSinghEmployees();
    }

    //Q:2Delete all employees with age greater than 45(Should be passed as a parameter)
    @Transactional
    public void deleteEmployeeAboveAgeService(Integer age){
        repository.deleteEmployeeAboveAge(age);
    }

}
