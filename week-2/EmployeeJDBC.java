import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeJDBC {

    private static final String URL = "jdbc:mysql://localhost:3306/your_database";
    private static final String USER = "your_username";
    private static final String PASSWORD = "your_password";

    // Create
    public void addEmployee(Employee employee) {
        String query = "INSERT INTO employees (id, name, department) VALUES (?, ?, ?)";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setInt(1, employee.getId());
            pstmt.setString(2, employee.getName());
            pstmt.setString(3, employee.getDepartment());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Read
    public List<Employee> getEmployees() {
        List<Employee> employees = new ArrayList<>();
        String query = "SELECT * FROM employees";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String department = rs.getString("department");
                employees.add(new Employee(id, name, department));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employees;
    }

    // Update
    public void updateEmployee(int id, String name, String department) {
        String query = "UPDATE employees SET name = ?, department = ? WHERE id = ?";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setString(1, name);
            pstmt.setString(2, department);
            pstmt.setInt(3, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Delete
    public void deleteEmployee(int id) {
        String query = "DELETE FROM employees WHERE id = ?";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        EmployeeJDBC employeeJDBC = new EmployeeJDBC();
        Employee emp1 = new Employee(1, "John Doe", "Engineering");
        Employee emp2 = new Employee(2, "Jane Smith", "HR");

        // Create
        employeeJDBC.addEmployee(emp1);
        employeeJDBC.addEmployee(emp2);

        // Read
        System.out.println("Employees: " + employeeJDBC.getEmployees());

        // Update
        employeeJDBC.updateEmployee(1, "John Doe", "Marketing");
        System.out.println("Updated Employees: " + employeeJDBC.getEmployees());

        // Delete
        employeeJDBC.deleteEmployee(2);
        System.out.println("Employees after deletion: " + employeeJDBC.getEmployees());
    }
}
