package com.lffblk.tutorials.jpa;

import com.lffblk.tutorials.jpa.entities.relations.onetoone.OneToOneDepartment;
import com.lffblk.tutorials.jpa.entities.relations.onetoone.OneToOneEmployee;
import com.lffblk.tutorials.jpa.services.OneToOneEmployeeService;

import java.util.List;

/**
 * Created by lffblk on 14.05.2017.
 */
public class OneToOneRelationTester {
    public static void main(String[] args) {
        fillTables();
        OneToOneEmployeeService employeeService = OneToOneEmployeeService.getInstance();

        List<OneToOneEmployee> allEmployees = employeeService.getAllEmployees();
        System.out.println("All employees: ");
        allEmployees.forEach(System.out::println);

        employeeService.destroy();
    }

    private static void fillTables() {
        OneToOneEmployeeService employeeService = OneToOneEmployeeService.getInstance();
        OneToOneDepartment department = employeeService.createDepartment("Development");

        employeeService.createEmployee("Gopal", 40000, "Technical Manager", department);
        employeeService.createEmployee("Manisha", 40000, "Proof reader", department);
        employeeService.createEmployee("Masthanvali", 40000, "Technical Writer", department);
        employeeService.createEmployee("Satish", 30000, "Technical Writer", department);
        employeeService.createEmployee("Krishna", 30000, "Technical Writer", department);
        employeeService.createEmployee("Kiran", 35000, "Proof reader", department);
    }
}
