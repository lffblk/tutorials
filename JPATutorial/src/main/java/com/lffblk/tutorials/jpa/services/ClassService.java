package com.lffblk.tutorials.jpa.services;

import com.lffblk.tutorials.jpa.entities.relations.manytomany.Class;
import com.lffblk.tutorials.jpa.entities.relations.manytomany.Teacher;

import javax.persistence.Query;
import java.util.List;
import java.util.Set;

/**
 * Created by lffblk on 14.05.2017.
 */
public class ClassService extends BaseService {

    public Class createClass(String name) {
        entityManager.getTransaction().begin();

        Class clazz = new Class();
        clazz.setName(name);
        entityManager.persist(clazz);

        entityManager.getTransaction().commit();
        return clazz;
    }

    public Teacher createTeacher(String name, String subject, Set<Class> classes) {
        entityManager.getTransaction().begin();

        Teacher teacher = new Teacher();
        teacher.setName(name);
        teacher.setSubject(subject);
        teacher.setClasses(classes);
        entityManager.persist(teacher);

        entityManager.getTransaction().commit();
        return teacher;
    }

    public List<Teacher> getAllTeachers() {
        Query query = entityManager.createQuery("SELECT e FROM Teacher e ORDER BY e.name ASC");
        return query.getResultList();
    }

    public static ClassService getInstance() {
        if (instance == null) {
            instance = new ClassService();
        }
        return (ClassService) instance;
    }

    @Override
    void clearTable() {
        entityManager.getTransaction().begin();

        // clear table
        Query query = entityManager.createQuery("DELETE FROM Class e");
        query.executeUpdate();

        query = entityManager.createQuery("DELETE FROM Teacher e");
        query.executeUpdate();

        entityManager.getTransaction().commit();
    }
}
