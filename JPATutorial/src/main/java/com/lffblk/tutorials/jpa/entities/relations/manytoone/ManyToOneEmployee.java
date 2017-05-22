package com.lffblk.tutorials.jpa.entities.relations.manytoone;

import com.google.common.base.MoreObjects;

import javax.persistence.*;

/**
 * Created by lffblk on 14.05.2017.
 */
@Entity
@Table (name = "MANY_TO_ONE_EMPLOYEE")
public class ManyToOneEmployee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private double salary;
    private String deg;

    @ManyToOne private ManyToOneDepartment department;

    public ManyToOneEmployee(int id, String name, double salary, String deg, ManyToOneDepartment department) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.deg = deg;
        this.department = department;
    }

    public ManyToOneEmployee() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getDeg() {
        return deg;
    }

    public void setDeg(String deg) {
        this.deg = deg;
    }

    public ManyToOneDepartment getDepartment() {
        return department;
    }

    public void setDepartment(ManyToOneDepartment department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("id", id)
                .add("name", name)
                .add("salary", salary)
                .add("deg", deg)
                .add("department", department)
                .toString();
    }
}
