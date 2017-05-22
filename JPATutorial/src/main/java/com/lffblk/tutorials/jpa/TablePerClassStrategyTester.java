package com.lffblk.tutorials.jpa;

import com.lffblk.tutorials.jpa.entities.advanced.tableperclass.TablePerClassStaff;
import com.lffblk.tutorials.jpa.services.StaffService;

import java.util.List;

/**
 * Created by lffblk on 14.05.2017.
 */
public class TablePerClassStrategyTester {
    public static void main(String[] args) {
        StaffService staffService = StaffService.getInstance();

        staffService.createTeachingTablePerClassStaff("Gopal","MSc MEd","Maths");
        staffService.createTeachingTablePerClassStaff("Manisha", "BSc BEd", "English");

        staffService.createNonTeachingTablePerClassStaff("Satish", "Accounts");
        staffService.createNonTeachingTablePerClassStaff("Krishna", "Office Admin");

        List<TablePerClassStaff> allTablePerClassStaff = staffService.getAllTablePerClassStaff();
        System.out.println("Table per Class Staff:");
        allTablePerClassStaff.forEach(System.out::println);

        staffService.destroy();
    }
}
