package com.lffblk.tutorials.jpa;

import com.google.common.collect.Sets;
import com.lffblk.tutorials.jpa.entities.relations.manytomany.Class;
import com.lffblk.tutorials.jpa.entities.relations.manytomany.Teacher;
import com.lffblk.tutorials.jpa.services.ClassService;

import java.util.List;
import java.util.Set;

/**
 * Created by lffblk on 14.05.2017.
 */
public class ManyToManyRelationTester {
    public static void main(String[] args) {
        fillTables();
        ClassService classService = ClassService.getInstance();

        List<Teacher> teachers = classService.getAllTeachers();
        System.out.println("All teachers: ");
        teachers.forEach(System.out::println);

        classService.destroy();
    }

    private static void fillTables() {
        ClassService classService = ClassService.getInstance();
        Set<Class> classes = Sets.newHashSet();

        classes.add(classService.createClass("1st"));
        classes.add(classService.createClass("2nd"));
        classes.add(classService.createClass("3rd"));

        classService.createTeacher("Satish","Java", classes);
        classService.createTeacher("Krishna","Adv Java", classes);
        classService.createTeacher("Masthanvali","DB2", classes);
    }
}
