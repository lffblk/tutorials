package com.lffblk.tutorials.jpa.entities.advanced.singletable;

import com.google.common.base.MoreObjects;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * Created by lffblk on 14.05.2017.
 */
@Entity
@DiscriminatorValue(value = "TS")
public class TeachingSingleTableStaff extends SingleTableStaff {
    private String qualification;
    private String subjectExpertise;

    public TeachingSingleTableStaff() {
        super();
    }

    public TeachingSingleTableStaff(int id, String name) {
        super(id, name);
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public String getSubjectExpertise() {
        return subjectExpertise;
    }

    public void setSubjectExpertise(String subjectExpertise) {
        this.subjectExpertise = subjectExpertise;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("staff", super.toString())
                .add("qualification", qualification)
                .add("subjectExpertise", subjectExpertise)
                .toString();
    }
}
