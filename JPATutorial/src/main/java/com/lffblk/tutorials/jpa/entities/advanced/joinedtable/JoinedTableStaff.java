package com.lffblk.tutorials.jpa.entities.advanced.joinedtable;

import com.google.common.base.MoreObjects;

import javax.persistence.*;

/**
 * Created by lffblk on 14.05.2017.
 */
@Entity
@Table(name = "JOINED_TABLE_STAFF")
@Inheritance(strategy = InheritanceType.JOINED)
public class JoinedTableStaff {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;

    public JoinedTableStaff() {}

    public JoinedTableStaff(int id, String name) {
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
