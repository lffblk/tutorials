package com.lffblk.tutorials.jpa.entities.advanced.joinedtable;

import com.google.common.base.MoreObjects;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

/**
 * Created by lffblk on 14.05.2017.
 */
@Entity
@PrimaryKeyJoinColumn(referencedColumnName = "id")
public class TeachingJoinedTableStaff extends JoinedTableStaff {
    private String qualification;
    private String subjectExpertise;

    public TeachingJoinedTableStaff() {
        super();
    }

    public TeachingJoinedTableStaff(int id, String name) {
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
