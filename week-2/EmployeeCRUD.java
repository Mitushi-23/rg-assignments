import java.util.ArrayList;
import java.util.List;

public class EmployeeCRUD {
    private List<Employee> employees = new ArrayList<>();

    // Create
    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    // Read
    public List<Employee> getEmployees() {
        return employees;
    }

    // Update
    public void updateEmployee(int id, String name, String department) {
        for (Employee emp : employees) {
            if (emp.getId() == id) {
                emp.setName(name);
                emp.setDepartment(department);
                break;
            }
        }
    }

    // Delete
    public void deleteEmployee(int id) {
        employees.removeIf(emp -> emp.getId() == id);
    }

    public static void main(String[] args) {
        EmployeeCRUD employeeCRUD = new EmployeeCRUD();
        Employee emp1 = new Employee(1, "John Doe", "Engineering");
        Employee emp2 = new Employee(2, "Jane Smith", "HR");

        // Create
        employeeCRUD.addEmployee(emp1);
        employeeCRUD.addEmployee(emp2);

        // Read
        System.out.println("Employees: " + employeeCRUD.getEmployees());

        // Update
        employeeCRUD.updateEmployee(1, "John Doe", "Marketing");
        System.out.println("Updated Employees: " + employeeCRUD.getEmployees());

        // Delete
        employeeCRUD.deleteEmployee(2);
        System.out.println("Employees after deletion: " + employeeCRUD.getEmployees());
    }
}
