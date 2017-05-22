package com.lffblk.tutorials.jpa.entities.relations.manytomany;

import com.google.common.base.MoreObjects;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by lffblk on 14.05.2017.
 */
@Entity
public class Class {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;

    @ManyToMany(targetEntity = Teacher.class)
    private Set teachers;

    public Class() {}

    public Class(int id, String name, Set teachers) {
        this.id = id;
        this.name = name;
        this.teachers = teachers;
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

    public Set getTeachers() {
        return teachers;
    }

    public void setTeachers(Set teachers) {
        this.teachers = teachers;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("id", id)
                .add("name", name)
                .add("teachers", teachers)
                .toString();
    }
}
