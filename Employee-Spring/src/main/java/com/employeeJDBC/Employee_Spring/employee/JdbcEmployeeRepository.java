package com.employeeJDBC.Employee_Spring.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class JdbcEmployeeRepository implements EmployeeRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int save(Employee employee) {
        return jdbcTemplate.update(
                "INSERT INTO employee (name, department) VALUES (?, ?)",
                employee.getName(), employee.getDepartment());
    }

    @Override
    public int update(Employee employee) {
        return jdbcTemplate.update(
                "UPDATE employee SET name = ?, department = ? WHERE id = ?",
                employee.getName(), employee.getDepartment(), employee.getId());
    }

    @Override
    public Employee findById(int id) {
        return jdbcTemplate.queryForObject(
                "SELECT * FROM employee WHERE id = ?",
                new Object[]{id},
                new EmployeeRowMapper());
    }

    @Override
    public int deleteById(int id) {
        return jdbcTemplate.update(
                "DELETE FROM employee WHERE id = ?",
                id);
    }

    @Override
    public List<Employee> findAll() {
        return jdbcTemplate.query("SELECT * FROM employee", new EmployeeRowMapper());
    }

    private static final class EmployeeRowMapper implements RowMapper<Employee> {
        @Override
        public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
            Employee employee = new Employee();
            employee.setId(rs.getInt("id"));
            employee.setName(rs.getString("name"));
            employee.setDepartment(rs.getString("department"));
            return employee;
        }
    }
}