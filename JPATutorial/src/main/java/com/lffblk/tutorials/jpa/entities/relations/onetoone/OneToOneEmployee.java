package com.lffblk.tutorials.jpa.entities.relations.onetoone;

import com.google.common.base.MoreObjects;

import javax.persistence.*;

/**
 * Created by lffblk on 14.05.2017.
 */
@Entity
@Table (name = "ONE_TO_ONE_EMPLOYEE")
public class OneToOneEmployee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private double salary;
    private String deg;

    @OneToOne private OneToOneDepartment department;

    public OneToOneEmployee(int id, String name, double salary, String deg, OneToOneDepartment department) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.deg = deg;
        this.department = department;
    }

    public OneToOneEmployee() {}

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

    public OneToOneDepartment getDepartment() {
        return department;
    }

    public void setDepartment(OneToOneDepartment department) {
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
