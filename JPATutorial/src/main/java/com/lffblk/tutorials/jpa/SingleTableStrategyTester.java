package com.lffblk.tutorials.jpa;

import com.lffblk.tutorials.jpa.entities.advanced.singletable.SingleTableStaff;
import com.lffblk.tutorials.jpa.services.StaffService;

import java.util.List;

/**
 * Created by lffblk on 14.05.2017.
 */
public class SingleTableStrategyTester {
    public static void main(String[] args) {
        StaffService staffService = StaffService.getInstance();

        staffService.createTeachingSingleTableStaff("Gopal","MSc MEd","Maths");
        staffService.createTeachingSingleTableStaff("Manisha", "BSc BEd", "English");

        staffService.createNonTeachingSingleTableStaff("Satish", "Accounts");
        staffService.createNonTeachingSingleTableStaff("Krishna", "Office Admin");

        List<SingleTableStaff> allSingleTableStaff = staffService.getAllSingleTableStaff();
        System.out.println("Single Table Staff:");
        allSingleTableStaff.forEach(System.out::println);

        staffService.destroy();
    }
}
