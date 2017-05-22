package com.lffblk.tutorials.jpa;

import com.lffblk.tutorials.jpa.entities.relations.manytoone.ManyToOneDepartment;
import com.lffblk.tutorials.jpa.entities.relations.manytoone.ManyToOneEmployee;
import com.lffblk.tutorials.jpa.services.ManyToOneEmployeeService;

import java.util.List;

/**
 * Created by lffblk on 14.05.2017.
 */
public class ManyToOneRelationTester {
    public static void main(String[] args) {
        fillTables();
        ManyToOneEmployeeService employeeService = ManyToOneEmployeeService.getInstance();

        List<ManyToOneEmployee> allEmployees = employeeService.getAllEmployees();
        System.out.println("All employees: ");
        allEmployees.forEach(System.out::println);

        employeeService.destroy();
    }

    private static void fillTables() {
        ManyToOneEmployeeService employeeService = ManyToOneEmployeeService.getInstance();
        ManyToOneDepartment department = employeeService.createDepartment("Development");

        employeeService.createEmployee("Gopal", 40000, "Technical Manager", department);
        employeeService.createEmployee("Manisha", 40000, "Proof reader", department);
        employeeService.createEmployee("Masthanvali", 40000, "Technical Writer", department);
        employeeService.createEmployee("Satish", 30000, "Technical Writer", department);
        employeeService.createEmployee("Krishna", 30000, "Technical Writer", department);
        employeeService.createEmployee("Kiran", 35000, "Proof reader", department);
    }
}
