package com.lffblk.tutorials.jpa.entities.advanced.singletable;

import com.google.common.base.MoreObjects;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * Created by lffblk on 14.05.2017.
 */
@Entity
@DiscriminatorValue(value = "NS")
public class NonTeachingSingleTableStaff extends SingleTableStaff {
    private String areaExpertise;

    public NonTeachingSingleTableStaff() {
        super();
    }

    public NonTeachingSingleTableStaff(int id, String name) {
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
