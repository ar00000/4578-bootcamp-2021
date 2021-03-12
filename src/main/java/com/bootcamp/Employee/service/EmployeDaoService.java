package com.bootcamp.Employee.service;

import com.bootcamp.Employee.Employee;
import com.bootcamp.Employee.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

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

    public Employee updateEmployee(long id,Employee employee){
        Optional<Employee> optionalEmployee = repository.findById(id);
        if(optionalEmployee.isEmpty())
            return null;
        else{
            Employee employee1 = optionalEmployee.get();
            employee1.setName(employee.getName());
            employee1.setLocation(employee.getLocation());
            employee1.setAge(employee.getAge());
            repository.save(employee1);
            return employee1;
        }
    }

    public Employee deleteEmployee(long id){
        if(!repository.existsById(id))
            return null;
        else{
            Employee employee = repository.findById(id).get();
            repository.deleteById(id);
            return employee;
        }
    }

    public Employee retrieveEmployee(long id){
        if(!repository.existsById(id))
            return null;
        Employee employee = repository.findById(id).get();
        return employee;
    }

    public long countEmployees(){
        return repository.count();
    }

    public List<Employee> pagingAndSortingOnEmployeesAge(int page,int pageSize){
        Pageable pageable = PageRequest.of(page,pageSize, Sort.Direction.ASC,"age");
        List<Employee> employeeList=repository.findAll(pageable).toList();
        return employeeList;
    }

    public List<Employee> findByNameEmployee(String name){
        return repository.findByName(name);
    }

    public List<Employee> findByStartWithAEmployee(){
        return repository.findByNameStartingWith("A");
    }

    public List<Employee> findByAgeBetweenEmployee(int startAge,int endAge){
        return repository.findByAgeBetween(startAge,endAge);
    }
}
