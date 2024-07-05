package com.employeeJDBC.Employee_Spring.employee;


//import com.example.employeespring.model.Employee;
import java.util.List;

public interface EmployeeRepository {
    int save(Employee employee);
    int update(Employee employee);
    Employee findById(int id);
    int deleteById(int id);
    List<Employee> findAll();
}
