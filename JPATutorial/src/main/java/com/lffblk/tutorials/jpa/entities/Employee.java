package com.lffblk.tutorials.jpa.entities;

import com.google.common.base.MoreObjects;

import javax.persistence.*;

/**
 * Created by lffblk on 13.05.2017.
 */
@Entity
@Table
@NamedQuery(query = "SELECT e FROM ManyToOneEmployee e where e.deg = :deg",
            name = "find employee by deg")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private double salary;
    private String deg;

    public Employee(int id, String name, double salary, String deg) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.deg = deg;
    }

    public Employee() {}

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

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("id", id)
                .add("name", name)
                .add("salary", salary)
                .add("deg", deg)
                .toString();
    }
}
