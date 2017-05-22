package com.lffblk.tutorials.jpa;
import com.google.common.collect.Lists;
import com.lffblk.tutorials.jpa.entities.relations.onetomany.OneToManyDepartment;
import com.lffblk.tutorials.jpa.entities.relations.onetomany.OneToManyEmployee;
import com.lffblk.tutorials.jpa.services.ManyToOneEmployeeService;
import com.lffblk.tutorials.jpa.services.OneToManyEmployeeService;

import java.util.List;

/**
 * Created by lffblk on 14.05.2017.
 */
public class OneToManyRelationTester {
    public static void main(String[] args) {
        fillTables();
        OneToManyEmployeeService employeeService = OneToManyEmployeeService.getInstance();

        List<OneToManyDepartment> allDepatments = employeeService.getAllDepartments();
        System.out.println("All departments: ");
        allDepatments.forEach(System.out::println);

        employeeService.destroy();
    }

    private static void fillTables() {
        OneToManyEmployeeService employeeService = OneToManyEmployeeService.getInstance();
        List<OneToManyEmployee> employees = Lists.newArrayList();

        employees.add(employeeService.createEmployee("Gopal", 40000, "Technical Manager"));
        employees.add(employeeService.createEmployee("Manisha", 40000, "Proof reader"));
        employees.add(employeeService.createEmployee("Masthanvali", 40000, "Technical Writer"));
        employees.add(employeeService.createEmployee("Satish", 30000, "Technical Writer"));
        employees.add(employeeService.createEmployee("Krishna", 30000, "Technical Writer"));
        employees.add(employeeService.createEmployee("Kiran", 35000, "Proof reader"));

        employeeService.createDepartment("Development", employees);
    }

}
