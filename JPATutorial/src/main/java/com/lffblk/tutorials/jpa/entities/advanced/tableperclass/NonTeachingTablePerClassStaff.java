package com.lffblk.tutorials.jpa.entities.advanced.tableperclass;

import com.google.common.base.MoreObjects;

import javax.persistence.Entity;

/**
 * Created by lffblk on 14.05.2017.
 */
@Entity
public class NonTeachingTablePerClassStaff extends TablePerClassStaff {
    private String areaExpertise;

    public NonTeachingTablePerClassStaff() {
        super();
    }

    public NonTeachingTablePerClassStaff(int id, String name) {
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
