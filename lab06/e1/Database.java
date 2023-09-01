package e1;

import java.util.Vector;

public class Database {
    // Data elements
    private Vector<Employee> employees; // Stores the employees

    public Database() {
        employees = new Vector<>();
    }

    public boolean addEmployee(Employee employee) {
        return employees.add(employee);
    }

    public void deleteEmployee(long emp_num) {
        for (Employee emp : employees) {
            if (emp.getEmpNum() == emp_num) {
                employees.remove(emp);
                break;
            }
        }
    }

    public Employee[] getAllEmployees() {
        Employee[] empArray = new Employee[employees.size()];
        employees.toArray(empArray);
        return empArray;
    }
}