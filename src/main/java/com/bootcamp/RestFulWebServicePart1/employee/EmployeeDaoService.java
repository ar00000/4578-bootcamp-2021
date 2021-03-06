package com.bootcamp.RestFulWebServicePart1.employee;

import java.util.ArrayList;
import java.util.List;

public class EmployeeDaoService {

    public static List<Employee> employeeList = new ArrayList<>();
    public static int employeeCounter = 0;

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
}
