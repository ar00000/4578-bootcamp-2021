package com.bootcamp.RestFulWebServicePart1.employee;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Component
public class EmployeeDaoService {

    public static List<Employee> employeeList = new ArrayList<>();
    public static int employeeCounter = 3;

    static {
        employeeList.add(new Employee(1,"John",30));
        employeeList.add(new Employee(2,"Dena",25));
        employeeList.add(new Employee(3,"Draco",28));
    }

    public List<Employee> showAllEmployee(){
        return employeeList;
    }

    public Employee addEmployee(Employee employee){
        if(employee.getId()==null){
            employee.setId(++employeeCounter);
        }
        employeeList.add(employee);
        return employee;
    }

    public Employee findEmployee(int id){
        for (Employee employee: employeeList){
            if(id==employee.getId())
                return employee;
        }
        return null;
    }

    public Employee deleteEmployee(int id){
        Iterator<Employee> iterator = employeeList.iterator();
        while (iterator.hasNext()){
            Employee employee = iterator.next();
            if(employee.getId()==id){
                iterator.remove();
                return employee;
            }
        }
        return null;
    }

    public Employee updateEmployee(int id,Employee employee){
        Iterator<Employee> iterator = employeeList.iterator();
        while (iterator.hasNext()){
            Employee emp = iterator.next();
            if(employee.getId()==id){
                employeeList.set(employeeList.indexOf(emp),employee);
                return emp;
            }
        }
        return null;
    }
}
