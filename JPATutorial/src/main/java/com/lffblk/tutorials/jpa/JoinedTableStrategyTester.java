package com.lffblk.tutorials.jpa;

import com.lffblk.tutorials.jpa.entities.advanced.joinedtable.JoinedTableStaff;
import com.lffblk.tutorials.jpa.entities.advanced.singletable.SingleTableStaff;
import com.lffblk.tutorials.jpa.services.StaffService;

import java.util.List;

/**
 * Created by lffblk on 14.05.2017.
 */
public class JoinedTableStrategyTester {
    public static void main(String[] args) {
        StaffService staffService = StaffService.getInstance();

        staffService.createTeachingJoinedTableStaff("Gopal","MSc MEd","Maths");
        staffService.createTeachingJoinedTableStaff("Manisha", "BSc BEd", "English");

        staffService.createNonTeachingJoinedTableStaff("Satish", "Accounts");
        staffService.createNonTeachingJoinedTableStaff("Krishna", "Office Admin");

        List<JoinedTableStaff> allJoinedTableStaff = staffService.getAllJoinedTableStaff();
        System.out.println("Joined Table Staff:");
        allJoinedTableStaff.forEach(System.out::println);

        staffService.destroy();
    }
}
