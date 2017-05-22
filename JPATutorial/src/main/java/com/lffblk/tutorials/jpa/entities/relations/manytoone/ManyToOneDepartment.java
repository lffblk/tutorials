package com.lffblk.tutorials.jpa.entities.relations.manytoone;

import com.google.common.base.MoreObjects;

import javax.persistence.*;

/**
 * Created by lffblk on 14.05.2017.
 */
@Entity
@Table(name = "MANY_TO_ONE_DEPARTMENT")
public class ManyToOneDepartment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;

    public ManyToOneDepartment() {}

    public ManyToOneDepartment(int id, String name) {
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

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("id", id)
                .add("name", name)
                .toString();
    }
}
