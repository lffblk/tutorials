package com.lffblk.tutorials.jpa.entities.advanced.joinedtable;

import com.google.common.base.MoreObjects;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

/**
 * Created by lffblk on 14.05.2017.
 */
@Entity
@PrimaryKeyJoinColumn(referencedColumnName = "id")
public class NonTeachingJoinedTableStaff extends JoinedTableStaff {
    private String areaExpertise;

    public NonTeachingJoinedTableStaff() {
        super();
    }

    public NonTeachingJoinedTableStaff(int id, String name) {
        super(id, name);
    }

    public String getAreaExpertise() {
        return areaExpertise;
    }

    public void setAreaExpertise(String areaExpertise) {
        this.areaExpertise = areaExpertise;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("staff", super.toString())
                .add("areaExpertise", areaExpertise)
                .toString();
    }
}
