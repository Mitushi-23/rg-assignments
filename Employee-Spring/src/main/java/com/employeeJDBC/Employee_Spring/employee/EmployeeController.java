package com.employeeJDBC.Employee_Spring.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public Iterable<Employee> getAllEmployees()
    {
        return employeeService.findAll();
    }

    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable int id)
    {
        return employeeService.findById(id);
    }

    @PostMapping
    public int createEmployee(@RequestBody Employee employee)
    {
        return employeeService.save(employee);
    }

    @PutMapping("/{id}")
    public int updateEmployee(@PathVariable int id, @RequestBody Employee employee)
    {
        employee.setId(id);
        return employeeService.update(employee);
    }

    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable int id)
    {
         employeeService.deleteById(id);
    }
}
