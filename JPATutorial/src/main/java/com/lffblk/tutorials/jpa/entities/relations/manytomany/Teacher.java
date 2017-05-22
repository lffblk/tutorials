package com.lffblk.tutorials.jpa.entities.relations.manytomany;

import com.google.common.base.MoreObjects;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by lffblk on 14.05.2017.
 */
@Entity
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private String subject;

    @ManyToMany(targetEntity = Class.class)
    private Set classes;

    public Teacher() {}

    public Teacher(int id, String name, String subject, Set classes) {
        this.id = id;
        this.name = name;
        this.subject = subject;
        this.classes = classes;
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

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public Set getClasses() {
        return classes;
    }

    public void setClasses(Set classes) {
        this.classes = classes;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("id", id)
                .add("name", name)
                .add("subject", subject)
                .add("classes", classes)
                .toString();
    }
}
