package com.lffblk.tutorials.jpa.entities.relations.onetomany;

import com.google.common.base.MoreObjects;

import javax.persistence.*;
import java.util.List;

/**
 * Created by lffblk on 14.05.2017.
 */
@Entity
@Table(name = "ONE_TO_MANY_DEPARTMENT")
public class OneToManyDepartment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;

    @OneToMany(targetEntity = OneToManyEmployee.class)
    private List employeelist;

    public OneToManyDepartment() {}

    public OneToManyDepartment(int id, String name) {
        this.id = id;
        this.name = name;
    }

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

    public List getEmployeelist() {
        return employeelist;
    }

    public void setEmployeelist(List employeelist) {
        this.employeelist = employeelist;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("id", id)
                .add("name", name)
                .add("employees", employeelist)
                .toString();
    }
}
