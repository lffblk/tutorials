package com.lffblk.tutorials.jpa.entities.advanced.tableperclass;

import com.google.common.base.MoreObjects;

import javax.persistence.*;

/**
 * Created by lffblk on 14.05.2017.
 */
@Entity
@Table(name = "TABLE_PER_CLASS_STAFF")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class TablePerClassStaff {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;

    public TablePerClassStaff() {}

    public TablePerClassStaff(int id, String name) {
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
