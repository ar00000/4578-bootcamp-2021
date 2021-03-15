package com.bootcamp.Employee.service;

import com.bootcamp.Employee.entities.Employee;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface EmployeeRepository extends CrudRepository<Employee,Long> {
    //Display the first name, last name of all employees having salary greater than average salary ordered in ascending by their age and in descending by their salary.
    @Query("   SELECT firstName, lastName\n" +
            "    FROM Employee\n" +
            "    WHERE salary >(SELECT AVG(salary) FROM Employee)\n" +
            "    ORDER BY salary DESC, age")
    List<Object[]> findEmployees();


    @Query("select avg(salary) from Employee")
    Double averageSalary();

    //Update salary of all employees by a salary passed as a parameter whose existing salary is less than the average salary.
    @Modifying
    @Transactional
    @Query(value = "UPDATE Employee SET salary=:salary WHERE salary<:averageSalary")
    void updateSalaryLessThanAverage(@Param("salary")Double salary,@Param("averageSalary")Double averageSalary);

    @Query("select min(age) from Employee")
    Integer minimumAge();

    //Delete all employees with minimum salary.
    @Modifying
    @Transactional
    @Query("delete Employee where age=:minAge")
    void deleteEmployees(@Param("minAge")Integer age);

    //Q:1Display the id, first name, age of all employees where last name ends with "singh"
    @Query(value = "select id,firstName,age from Employee where lastName like '%Singh'",nativeQuery = true)
    List<Object[]> findSinghEmployees();

    //Q:2Delete all employees with age greater than 45(Should be passed as a parameter)
    @Modifying
    @Query(value = "delete from Employee where age>:age",nativeQuery = true)
    void deleteEmployeeAboveAge(@Param("age") Integer age);

}
