package com.lffblk.tutorials.jpa.entities.relations.onetoone;

import com.google.common.base.MoreObjects;
import com.lffblk.tutorials.jpa.entities.relations.onetomany.OneToManyEmployee;

import javax.persistence.*;
import java.util.List;

/**
 * Created by lffblk on 14.05.2017.
 */
@Entity
@Table (name = "ONE_TO_ONE_DEPARTMENT")
public class OneToOneDepartment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;

    public OneToOneDepartment() {}

    public OneToOneDepartment(int id, String name) {
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
