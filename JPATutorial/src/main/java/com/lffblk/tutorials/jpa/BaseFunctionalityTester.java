package com.lffblk.tutorials.jpa;

import com.lffblk.tutorials.jpa.entities.Employee;
import com.lffblk.tutorials.jpa.services.EmployeeService;

import java.util.List;

/**
 * Created by lffblk on 13.05.2017.
 */
public class BaseFunctionalityTester {
    public static void main(String[] args) {
        fillEmployeeTable();
        int i = 0;
        EmployeeService employeeService = EmployeeService.getInstance();
        List<String> employeeNames = employeeService.getEmployeeNames();
        System.out.println("Employees: " + employeeNames);
        System.out.println("\nMax salary: " + employeeService.getMaxSalary());

        System.out.println("\nEmployees with salary between 35000 and 40000:");
        List<Employee> employeesBySalary = employeeService.getEmployeesWithSalaryBounds(35000, 40000);
        employeesBySalary.forEach(System.out::println);

        System.out.println("\nEmployees which names start with 'M':");
        List<Employee> employeesByName = employeeService.getEmployeesByNameLike("M%");
        employeesByName.forEach(System.out::println);

        System.out.println("\nEmployees with deg is 'Proof reader':");
        List<Employee> employeesByDeg = employeeService.getEmployeesByDeg("Proof reader");
        employeesByDeg.forEach(System.out::println);

        System.out.println("\nAll employees by criteria:");
        List<Employee> allEmployees = employeeService.getAllEmployees();
        allEmployees.forEach(System.out::println);

        employeeService.destroy();
    }

    private static void fillEmployeeTable() {
        EmployeeService employeeService = EmployeeService.getInstance();
        employeeService.createEmployee("Gopal", 40000, "Technical Manager");
        employeeService.createEmployee("Manisha", 40000, "Proof reader");
        employeeService.createEmployee("Masthanvali", 40000, "Technical Writer");
        employeeService.createEmployee("Satish", 30000, "Technical Writer");
        employeeService.createEmployee("Krishna", 30000, "Technical Writer");
        employeeService.createEmployee("Kiran", 35000, "Proof reader");
    }
}
